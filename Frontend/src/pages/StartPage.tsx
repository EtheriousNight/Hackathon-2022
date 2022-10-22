import {Button, TextField} from "@mui/material";
import {useState} from "react";

export const StartPage = () => {
    const [street, setStreet] = useState<string>("");
    const [name, setName] = useState<string>("");

    const onSubmit = () => setName(street);

    return (
        <div>
            <TextField
                required
                id="outlined-required"
                label="Required"
                defaultValue={street}
                onChange={(e: any) => setStreet(e.target.value)}
            />
            <Button
                variant={"contained"}
                onClick={onSubmit}
            >
                submit
            </Button>
            {name}
        </div>
    )
}