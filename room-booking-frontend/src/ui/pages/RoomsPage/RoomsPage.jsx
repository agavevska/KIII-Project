import React, {useState} from 'react';
import {Box, Button, CircularProgress, ToggleButton, ToggleButtonGroup} from "@mui/material";
import "./RoomsPage.css";
import AddRoomDialog from "../../components/rooms/AddRoomDialog/AddRoomDialog.jsx";
import useRooms from "../../../hooks/useRooms.js";
import RoomsGrid from "../../components/rooms/RoomsGrid/RoomsGrid.jsx";

const RoomsPage = () => {
    // TODO: Implement this.

    const {rooms, loading, onAdd, onEdit, onDelete} = useRooms();

    const [addCarDialogOpen, setAddCarDialogOpen] = useState(false);

    return (
        <>
            <Box className="rooms-box">
                <Box sx={{display: "flex", justifyContent: "space-between", mb: 2}}>
                    <ToggleButtonGroup
                        exclusive
                    >
                        <ToggleButton className="all-rooms" value="all" size="small">All</ToggleButton>
                        <ToggleButton className="available-rooms" value="available" size="small">Available</ToggleButton>
                        <ToggleButton className="unavailable-rooms" value="unavailable" size="small">Unavailable</ToggleButton>
                    </ToggleButtonGroup>
                    <Button
                        variant="contained"
                        color="primary"
                        onClick={() => setAddCarDialogOpen(true)}
                        className="add-item"
                    >
                        Add Car
                    </Button>
                </Box>
                {loading && <Box className="progress-box"><CircularProgress/></Box>}
                {!loading && <RoomsGrid rooms={rooms} onEdit={onEdit} onDelete={onDelete}/>}
            </Box>
            <AddRoomDialog
                open={addCarDialogOpen}
                onClose={() => setAddCarDialogOpen(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default RoomsPage;