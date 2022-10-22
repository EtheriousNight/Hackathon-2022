import axios from "axios";



interface Location{
    street: string
    district: string
    town: string
    county?: string
}


export interface SingleEvent {
    eventID: string
    name: string
    start: string
    end: string
    duration?: string
    location: Location
}
export interface ListOfEvents{
    content: SingleEvent[]
}



export const callEvents = () => {
    return axios.get("")
        .then(res => console.log(res.data))

}