import React, {useState} from 'react';
import InfoIcon from '@mui/icons-material/Info';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import {Card, CardContent, Typography, CardActions, Button, Box} from '@mui/material';
import {useNavigate} from "react-router";
import EditRoomDialog from "../EditRoomDialog/EditRoomDialog.jsx";
import DeleteRoomDialog from "../DeleteRoomDialog/DeleteRoomDialog.jsx";

const RoomCard = ({room, onEdit, onDelete}) => {
    const navigate = useNavigate();

    const [editCarDialogOpen, setEditCarDialogOpen] = useState(false);
    const [deleteCarDialogOpen, setDeleteCarDialogOpen] = useState(false);

    return (
        <>
            <Card
                sx={{
                    borderRadius: 2,
                    p: 1,
                    flexGrow: 1,
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "space-between"
                }}
                className="card"
                data-id={room.id}
            >
                <CardContent sx={{pb: 0}}>
                    <Typography gutterBottom variant="h5" component="div" className="room-code">
                        {room.code}
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{mb: 1.5}}  className="room-floor">
                        Floor: {room.floor}
                    </Typography>
                    <Box display="flex" justifyContent="space-between" alignItems="center">
                        <Typography variant="body1" sx={{fontWeight: 'bold'}} className="room-price">
                            ${room.price}
                        </Typography>
                        <Typography variant="body2" color={room.available ? 'success.main' : 'error.main'} className="room-available">
                            {room.available ? 'Available' : 'Unavailable'}
                        </Typography>
                    </Box>
                </CardContent>
                <CardActions sx={{justifyContent: "space-between"}}>
                    <Button
                        size="small"
                        color="info"
                        startIcon={<InfoIcon/>}
                        onClick={() => navigate(`/rooms/${room.id}`)}
                        className="info-item"
                    >
                        Info
                    </Button>
                    <Box>
                        <Button
                            size="small"
                            color="warning"
                            startIcon={<EditIcon/>}
                            sx={{mr: "0.25rem"}}
                            onClick={() => setEditCarDialogOpen(true)}
                            className="edit-item"
                        >
                            Edit
                        </Button>
                        <Button
                            size="small"
                            color="error"
                            startIcon={<DeleteIcon/>}
                            onClick={() => setDeleteCarDialogOpen(true)}
                            className="delete-item"
                        >
                            Delete
                        </Button>
                    </Box>
                </CardActions>
            </Card>
            <EditRoomDialog
                open={editCarDialogOpen}
                onClose={() => setEditCarDialogOpen(false)}
                onEdit={onEdit}
                room={room}
            />
            <DeleteRoomDialog
                open={deleteCarDialogOpen}
                onClose={() => setDeleteCarDialogOpen(false)}
                onDelete={onDelete}
                room={room}
            />
        </>
    );
};

export default RoomCard;