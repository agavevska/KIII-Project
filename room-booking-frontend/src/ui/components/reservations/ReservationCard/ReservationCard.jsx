import React from 'react';
import { Card, CardContent, Typography, CardActions, Button, Box } from '@mui/material';

const ReservationCard = ({reservation, onStart, onEnd, onCancel}) => {
    return (
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
            data-id={reservation.id}
        >
            <CardContent sx={{ pb: 0 }}>
                <Typography gutterBottom variant="h5" component="div">
                    {reservation.room.code}
                </Typography>
                <Typography variant="body2" color="text.secondary" sx={{ mb: 1.5 }}>
                    {reservation.room.workspace.name} (Floor: {reservation.room.floor})
                </Typography>
                <Typography variant="body2" sx={{ mb: 0.5 }}>
                    <strong>Start:</strong> {reservation.startTime ? new Date(reservation.startTime).toLocaleString() : "Not yet started"}
                </Typography>
                <Typography variant="body2" sx={{ mb: 0.5 }}>
                    <strong>End:</strong> {reservation.endTime ? new Date(reservation.endTime).toLocaleString() : "Not yet ended"}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    <strong>Status:</strong> <span className="reservation-status">{reservation.status}</span>
                </Typography>
            </CardContent>
            <CardActions sx={{ justifyContent: "space-between" }}>
                <Button
                    size="small"
                    variant="outlined"
                    color="error"
                    className="cancel-item"
                    disabled={reservation.status === "ACTIVE" || reservation.status === "COMPLETED" || reservation.status === "CANCELED"}
                >
                    Cancel
                </Button>
                <Box>
                    <Button
                        size="small"
                        variant="outlined"
                        color="primary"
                        sx={{ mr: "0.25rem" }}
                        className="start-item"
                        disabled={reservation.status === "ACTIVE" || reservation.status === "COMPLETED" || reservation.status === "CANCELED"}
                    >
                        Start
                    </Button>
                    <Button
                        size="small"
                        variant="outlined"
                        color="primary"
                        className="end-item"
                        disabled={reservation.status === "RESERVED" || reservation.status === "COMPLETED" || reservation.status === "CANCELED"}
                    >
                        End
                    </Button>
                </Box>
            </CardActions>
        </Card>
    );
};

export default ReservationCard;
