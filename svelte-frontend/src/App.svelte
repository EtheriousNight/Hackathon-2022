<script lang="ts">
    import EventList from "./lib/EventList.svelte";
    import SearchBar from "./lib/SearchBar.svelte";
</script>

<main>
    <div class="row">
        <div class="col s1" />
        <div class="col s10">
            <SearchBar />
        </div>
        <div class="col s1" />
    </div>
    
</main>

<style>
    .row {
        margin-top: 25px;
    }
</style>