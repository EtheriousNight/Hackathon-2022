<script lang="ts">

    import * as API from "./api/events";

    let addressInput;

    async function getEvents() {
        const data = await API.getCityEvents(addressInput);
        console.log(data);
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
            <button on:click={getEvents} class="waves-effect waves-light btn" type="submit" name="action">
                <i class="fa-solid fa-magnifying-glass"></i>
                <span>Suche</span>
            </button>
            <a class="waves-effect waves-light btn" href="#">
                <i class="fa-solid fa-map-location-dot"></i>
                <span>Reichweite</span>
            </a>
            <a class="waves-effect waves-light btn" href="#">
                <i class="fa-solid fa-city"></i>
                <span>Stadtteil</span>
            </a>
        </div>
    </div>
</div>

<style>

</style>