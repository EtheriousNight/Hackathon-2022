import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {SingleEvent, useGetCityEvents, useGetStreetEvents} from "../middelware/eventQuery";
import {useInputContext} from "./InputContext";

const inputContext = useInputContext()
const {data: streetEvents} = useGetStreetEvents(inputContext.street)
const {data: districtEvents} = useGetStreetEvents(inputContext.district)
const {data: cityEvents} = useGetCityEvents(inputContext.city)

export function EventTable() {

    return (
        <TableContainer component={Paper}>
            <Table sx={{minWidth: 650}} size="small" aria-label="a dense table">
                <TableHead>
                    <TableRow>
                        <TableCell>ID</TableCell>
                        <TableCell align="right">Start</TableCell>
                        <TableCell align="right">End</TableCell>
                        <TableCell align="right">Name</TableCell>
                        <TableCell align="right">Ort</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    <InputBody/>
                </TableBody>
            </Table>
        </TableContainer>
    );
}


const InputBody = () =>{
    switch (inputContext.location){
        case 1:{
            return(
                <div>
                    {streetEvents.content.map((event: SingleEvent) => (
                        <TableRow
                            key={event.eventID}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {event.eventID}
                            </TableCell>
                            <TableCell align="right">{event.start}</TableCell>
                            <TableCell align="right">{event.end}</TableCell>
                            <TableCell align="right">{event.name}</TableCell>
                            <TableCell align="right">{event.location.street}</TableCell>
                        </TableRow>
                    ))}
                </div>
            )
        }
        case 2:{
            return(
                <div>
                    {districtEvents.content.map((event: SingleEvent) => (
                        <TableRow
                            key={event.eventID}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {event.eventID}
                            </TableCell>
                            <TableCell align="right">{event.start}</TableCell>
                            <TableCell align="right">{event.end}</TableCell>
                            <TableCell align="right">{event.name}</TableCell>
                            <TableCell align="right">{event.location.street}</TableCell>
                        </TableRow>
                    ))}
                </div>
            )
        }
        case 3:{
            return(
                <div>
                    {cityEvents.content.map((event: SingleEvent) => (
                        <TableRow
                            key={event.eventID}
                            sx={{'&:last-child td, &:last-child th': {border: 0}}}
                        >
                            <TableCell component="th" scope="row">
                                {event.eventID}
                            </TableCell>
                            <TableCell align="right">{event.start}</TableCell>
                            <TableCell align="right">{event.end}</TableCell>
                            <TableCell align="right">{event.name}</TableCell>
                            <TableCell align="right">{event.location.street}</TableCell>
                        </TableRow>
                    ))}
                </div>
            )
        }
        default:
            return <div></div>
}}