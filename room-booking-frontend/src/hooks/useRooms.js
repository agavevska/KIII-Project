import {useCallback, useEffect, useState} from "react";
import roomRepository from "../repository/roomRepository.js";

const initialState = {
    rooms: [],
    loading: true,
};

const useRooms = () => {
    const [state, setState] = useState(initialState);

    const fetch = useCallback(() => {
        setState(initialState);
        roomRepository
            .findAll()
            .then((response) => {
                setState({
                    rooms: response.data,
                    loading: false,
                });
            })
            .catch((error) => console.log(error));
    }, []);

    // TODO: Implement this.
    const onAdd = useCallback((data) => {
        roomRepository
            .add(data)
            .then(() => fetch())
            .catch((error) => console.log(error));
    },[fetch]);

    // TODO: Implement this.
    const onEdit = useCallback((id, data) => {
        roomRepository
            .edit(id,data)
            .then(() => fetch())
            .catch((error) => console.log(error));
    },[fetch])

    // TODO: Implement this.
    const onDelete = useCallback((id) => {
        roomRepository
            .delete(id)
            .then(() => fetch())
            .catch((error) => console.log(error));
    },[fetch])

    // const onFilter = useCallback((available) => {
    //     roomRepository
    //         .findAll(available)
    //         .then((response) => setState({
    //             rooms: response.data,
    //             loading: false
    //         }))
    //         .catch((error) => console.log(error));
    // },[])

    useEffect(() => {
        fetch();
    }, [fetch]);


    return {...state, onAdd, onEdit, onDelete};
};

export default useRooms;