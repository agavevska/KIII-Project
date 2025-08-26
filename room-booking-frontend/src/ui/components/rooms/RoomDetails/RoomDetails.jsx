import React from 'react';
import {useNavigate, useParams} from "react-router";
import {
    Box,
    Button,
    CircularProgress,
    Typography,
    Paper,
    Stack,
    Breadcrumbs,
    Link
} from "@mui/material";
import {
    ArrowBack, Cancel, CheckCircle
} from "@mui/icons-material";
import useRoomDetails from "../../../../hooks/useRoomDetails.js";
import roomRepository from "../../../../repository/roomRepository.js";

const RoomDetails = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const {room, fetch} = useRoomDetails(id);

    if (!room)
        return <Box className="progress-box"><CircularProgress/></Box>;

    const reserve = () => {
        roomRepository
            .reserve(id)
            .then(() => fetch())
            .catch((error) => console.log(error));
    };

    return (
        <Box width={750} mx="auto" mt={3}>
            <Breadcrumbs aria-label="breadcrumb" sx={{mb: 3}}>
                <Link
                    underline="hover"
                    color="inherit"
                    href="#"
                    onClick={(e) => {
                        e.preventDefault();
                        navigate("/rooms");
                    }}
                >
                    Rooms
                </Link>
                <Typography color="text.primary">{room.code}</Typography>
            </Breadcrumbs>

            <Paper elevation={2} sx={{p: 4, borderRadius: 4}}>
                <Stack spacing={3}>
                    <Typography variant="h4" fontWeight={600} className="room-code">
                        {room.code}
                    </Typography>

                    <Stack direction="column" spacing={1}>
                        <Typography variant="body1">
                            <strong className="workspace-name">{room.workspace.name}</strong> - Floor: <strong className="room-floor">{room.floor}</strong>
                        </Typography>

                        <Typography variant="body1">
                            <strong className="workspace-description">{room.workspace.description}</strong>
                        </Typography>
                    </Stack>

                    <Typography variant="h4" color="primary.main" fontWeight={750} className="room-price">
                        ${room.price} per day
                    </Typography>

                    <Box display="flex" alignItems="center">
                        {room.available ? <CheckCircle color="success" sx={{mr: 1}}/> :
                            <Cancel color="error" sx={{mr: 1}}/>}
                        <Typography variant="body1" color={room.available ? "success.main" : "error.main"}
                        className={room.available ? "available" : "not-available"}>
                            <strong className="room-available">{room.available ? "Available" : "Unavailable"}</strong>
                        </Typography>
                    </Box>

                    <Stack direction="row" justifyContent="space-between" spacing={2} mt={2}>
                        <Button
                            variant="contained"
                            color="primary"
                            className="reserve-btn"
                            disabled={!room.available}
                            onClick={reserve}
                        >
                            {room.available ? "Reserve Now" : "Unavailable"}
                        </Button>
                        <Button
                            variant="outlined"
                            startIcon={<ArrowBack/>}
                            onClick={() => navigate("/rooms")}
                        >
                            Back to Rooms
                        </Button>
                    </Stack>
                </Stack>
            </Paper>
        </Box>
    );
};

export default RoomDetails;
