import {useCallback, useEffect, useState} from "react";
import reservationRepository from "../repository/reservationRepository.js";

const initialState = {
    reservations: [],
    loading: true,
};

const useReservations = () => {
    const [state, setState] = useState(initialState);

    const fetch = useCallback(() => {
        setState(initialState);
        reservationRepository
            .findAllWithDetails()
            .then((response) => setState({
                reservations: response.data,
                loading: false,
            }))
            .catch((error) => console.log(error));
    }, []);

    // TODO: Implement this.
    const onStart = () => {};

    // TODO: Implement this.
    const onEnd = () => {};

    // TODO: Implement this.
    const onCancel = () => {};

    useEffect(() => {
        fetch();
    }, [fetch]);

    return {...state, onStart, onEnd, onCancel};
};

export default useReservations;