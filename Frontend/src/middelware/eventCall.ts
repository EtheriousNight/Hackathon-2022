import axios from "axios";

export const callGetStreetEvents = (street:string) => axios.get("/get/street/" + street)
export const callGetDistrictEvents = (district: string) => axios.get("")
export const callGetCityEvents = (city: string) => axios.get("")