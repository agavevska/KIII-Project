import React from 'react';
import {Grid} from "@mui/material";
import ReservationCard from "../ReservationCard/ReservationCard.jsx";

const ReservationsGrid = ({reservations, onStart, onEnd, onCancel}) => {
    return (
        <Grid container spacing={{xs: 2, md: 3}}>
            {reservations.map((reservation) => (
                <Grid key={reservation.id} size={{xs: 12, sm: 6, md: 4, lg: 3}} display="flex">
                    <ReservationCard reservation={reservation} onStart={onStart} onEnd={onEnd} onCancel={onCancel}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default ReservationsGrid;