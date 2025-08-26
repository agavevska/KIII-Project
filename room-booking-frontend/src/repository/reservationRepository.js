import axiosInstance from "../axios/axios.js";

const reservationRepository = {
    findAllWithDetails: async () => {
        return await axiosInstance.get("/reservations");
    },
    start: async (id) => {
        return await axiosInstance.put(`/reservations/${id}/start`);
    },
    end: async (id) => {
        return await axiosInstance.put(`/reservations/${id}/end`);
    },
    cancel: async (id) => {
        return await axiosInstance.put(`/reservations/${id}/cancel`);
    },
};

export default reservationRepository;