import {Button, TextField} from "@mui/material";
import {useState} from "react";
import {callEvents, ListOfEvents, SingleEvent} from "../middelware/eventCall";

export const StartPage = () => {
    const [street, setStreet] = useState<string>("");
    const [name, setName] = useState<string>("");
    const [eventList, setEventList] = useState<SingleEvent>()

    const event:SingleEvent = {
        eventID: "1",
        name: "Straßenreinigung",
        start: "a",
        end: "b",
        duration: "a-b",
        location: {
            street: "Bahnhofstraße",
            district: "Innenstadt",
            town: "Görlitz",
            county: "Landkreis Görlitz"
        }
    }

    const events: ListOfEvents = {
        content:[
            event,
            event
        ]

    }

    const onSubmit = () => {
        setName(street)
        setEventList(event)

    }

    return (
        <div>
            <TextField
                required
                id="outlined-required"
                label="Required"
                placeholder={"street name"}
                onChange={(e: any) => setStreet(e.target.value)}
            />
            <Button
                variant={"contained"}
                onClick={onSubmit}
            >
                submit
            </Button>
            <br/>
            <pre>
               <code >
                {JSON.stringify(events)}
            </code>
            </pre>
        </div>
    )
}