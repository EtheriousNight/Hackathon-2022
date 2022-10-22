import axios from "axios";

export const callEvents = (street:String) => {
    return axios.post("/getEvents/" + street)
}