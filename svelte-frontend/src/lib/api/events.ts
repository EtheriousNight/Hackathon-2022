export type Event = {
    name: string,
    start: string,
    ending: string,
    location_id: bigint
}

async function getRequest(urlAddition, street): Promise<Event[]> {
    const url = "http://localhost:8089/api/v1/get/" + urlAddition + "/" + street;
    let response = await fetch(url, {
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        }
    });

    if (response.ok) {
        const events: Event[] = await response.json();
        return events;
    }
}

export async function getStreetEvents(street: string): Promise<Event[]> {
    return await getRequest("street", street);
}

export async function getCityDistrictEvents(street: string): Promise<Event[]> {
    return await getRequest("cityDistrict", street);
}

export async function getCityEvents(street: string): Promise<Event[]> {
    return await getRequest("city", street);
}

export async function getCountyEvents(street: string): Promise<Event[]> {
    return await getRequest("county", street);
}