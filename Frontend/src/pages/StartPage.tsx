import {Button, TextField} from "@mui/material";
import {EventTable} from "../components/EventTable";
import {useInputContext} from "../components/InputContext";

export const StartPage = () => {

    const inputContext = useInputContext()
    const onSubmitStreet = () => inputContext.setLocation(1)
    const onSubmitDistrict = () => inputContext.setLocation(2)
    const onSubmitCity = () => inputContext.setLocation(3)
    return (
        <div>
            <TextField
                required
                id="outlined-required"
                label="Required"
                placeholder={"street name"}
                onChange={(e: any) => inputContext.setStreet(e.target.value)}
            />
            <Button
                variant={"contained"}
                onClick={onSubmitStreet}
            >
                submit
            </Button>
            <TextField
                required
                id="outlined-required"
                label="Required"
                placeholder={"district name"}
                onChange={(e: any) => inputContext.setDistrict(e.target.value)}
            />
            <Button
                variant={"contained"}
                onClick={onSubmitDistrict}
            >
                submit
            </Button>
            <TextField
                required
                id="outlined-required"
                label="Required"
                placeholder={"city name"}
                onChange={(e: any) => inputContext.setCity(e.target.value)}
            />
            <Button
                variant={"contained"}
                onClick={onSubmitCity}
            >
                submit
            </Button>
            <br/>
            <EventTable/>
        </div>
    )
}