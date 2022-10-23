<script lang="ts">

    import * as API from "./api/events";
    import EventListElement from "./EventListElement.svelte";

    let addressInput;
    let eventData: API.Event[] = [];

    async function getCityEvents() {
        const data = await API.getCityEvents(addressInput);
        eventData = data;
    }

    async function getCityDistrictEvents() {
        eventData = await API.getCityDistrictEvents(addressInput);
    }

    async function getStreetEvents() {
        const data = await API.getStreetEvents(addressInput);
        eventData = data;
    }

    async function getCountyEvents() {
        eventData = await API.getCountyEvents(addressInput);
    }

</script>

<div>
    <div class="row">
        <div class="input-field col s12">
            <input bind:value={addressInput} id="searchInput" class="validate" type="text">
            <label for="searchInput">Adresse</label>
        </div>
    </div>
    <div class="row">
        <div class="col s12">
            <a on:click={getStreetEvents} class="waves-effect waves-light btn" href="#">
                <i class="fa-solid fa-magnifying-glass"></i>
                <span>Straßen Suche</span>
            </a>
            <a on:click={getCityDistrictEvents} class="waves-effect waves-light btn" href="#">
                <i class="fa-solid fa-map-location-dot"></i>
                <span>Stadtteil Suche</span>
            </a>
            <a on:click={getCityEvents} class="waves-effect waves-light btn" href="#">
                <i class="fa-solid fa-city"></i>
                <span>Stadt Suche</span>
            </a>
            <a on:click="{getCountyEvents}" class="waves-effect waves-light btn" href="#">
                <i class="fa-solid fa-city"></i>
                <span>Landkreis Suche</span>
            </a>
        </div>
    </div>
    <table id="eventTable">
        <thead>
            <tr>
                <th>Name</th>
                <th>Straße</th>
                <th>Start</th>
                <th>Ende</th>
            </tr>
        </thead>
        <tbody>
            {#each eventData as event }
                <EventListElement name="{event.name}" street="{event.location.street}" start="{event.start}" end="{event.ending}" />
            {/each}
        </tbody>
    </table>
</div>

<style>

</style>