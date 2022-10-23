<script lang="ts">
    import EventListElement from "./EventListElement.svelte";
</script>

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
        <EventListElement name="Baustelle" street="Schlesische Straße" start="10.2022" end="01.2023"/>
        <EventListElement name="Baustelle" street="Schlesische Straße" start="10.2022" end="01.2023"/>
        <EventListElement name="Baustelle" street="Schlesische Straße" start="10.2022" end="01.2023"/>
        <EventListElement name="Baustelle" street="Schlesische Straße" start="10.2022" end="01.2023"/>
        <EventListElement name="Baustelle" street="Schlesische Straße" start="10.2022" end="01.2023"/>
    </tbody>
</table>

<style>

</style>