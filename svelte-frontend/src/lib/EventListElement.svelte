<script lang="ts">

    export let name: string;
    export let street: string;
    export let start: string;
    export let end: string;

</script>

<tr>
    <td>{name}</td>
    <td>{street}</td>
    <td>{start}</td>
    <td>{end}</td>
    <td>
        <a class="waves-effect waves-light btn" href="#" name="Weitere Infos">
            <i class="fa-solid fa-arrow-right"></i>
        </a>
    </td>
</tr>

<style>

</style>