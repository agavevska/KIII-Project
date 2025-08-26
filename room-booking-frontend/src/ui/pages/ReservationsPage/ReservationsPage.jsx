import React from 'react';
import {Box, CircularProgress} from "@mui/material";
import "./ReservationsPage.css";
import useReservations from "../../../hooks/useReservations.js";
import ReservationsGrid from "../../components/reservations/ReservationsGrid/ReservationsGrid.jsx";

const ReservationsPage = () => {
    const {reservations, loading, onStart, onEnd, onCancel} = useReservations();

    return (
        <>
            <Box className="reservations-box">
                {loading && <Box className="progress-box"><CircularProgress/></Box>}
                {!loading && <ReservationsGrid reservations={reservations} onStart={onStart} onEnd={onEnd} onCancel={onCancel}/>}
            </Box>
        </>
    );
};

export default ReservationsPage;