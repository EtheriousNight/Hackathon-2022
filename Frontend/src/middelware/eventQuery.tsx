import {useQuery} from "react-query";
import {callGetStreetEvents} from "./eventCall";

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

export const useGetStreetEvents = (street: string) => {
    return useQuery(street, () => callGetStreetEvents(street)
        .then(({data}) => Promise.resolve(data)),{
        retry: 1
    })
}

export const useGetDistrictEvents = (street: string) => {
    return useQuery(street, () => callGetStreetEvents(street)
        .then(({data}) => Promise.resolve(data)),{
        retry: 1
    })
}

export const useGetCityEvents = (street: string) => {
    return useQuery(street, () => callGetStreetEvents(street)
        .then(({data}) => Promise.resolve(data)),{
        retry: 1
    })
}