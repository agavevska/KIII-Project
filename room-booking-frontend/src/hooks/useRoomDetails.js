import {useCallback, useEffect, useState} from "react";
import roomRepository from "../repository/roomRepository.js";

const useRoomDetails = (id) => {
    const [room, setRoom] = useState(null);

    // TODO: Implement this.
    const fetch = useCallback(() => {
        roomRepository
            .findByIdWithDetails(id)
            .then((response) => {
                setRoom(response.data)
            })
            .catch((error) => console.log(error));
    },[id])

    useEffect(() => {
        // TODO: Implement this.
        roomRepository
            .findByIdWithDetails(id)
            .then((response) => setRoom(response.data))
            .catch((error) => console.log(error));

    }, [id]);

    return {room, fetch};
};

export default useRoomDetails;