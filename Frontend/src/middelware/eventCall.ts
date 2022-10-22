import axios from "axios";


interface Location{
    street: string
    district: string
    town: string
    countryDistrict: string
}


interface Event{
    eventID: string
    name: string
    start: string
    end: string
    duration?: string
    location: Location
}
export interface ListOfEvents{
    content: Event[]
}



export const callEvents = (street:String) => {
    return axios.post("/getEvents/" + street)
}