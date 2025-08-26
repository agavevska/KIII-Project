import React from 'react';
import {Grid} from "@mui/material";
import RoomCard from "../RoomCard/RoomCard.jsx";

const RoomsGrid = ({rooms, onEdit, onDelete}) => {
    return (
        <Grid container spacing={{xs: 2, md: 3}}>
            {rooms.map((room) => (
                <Grid key={room.id} size={{xs: 12, sm: 6, md: 4, lg: 3}} display="flex">
                    <RoomCard room={room} onEdit={onEdit} onDelete={onDelete}/>
                </Grid>
            ))}
        </Grid>
    );
};

export default RoomsGrid;