import axiosInstance from "../axios/axios.js";

const roomRepository = {
    findAll: async (availabilityFilter = "all") => {
        if (availabilityFilter === "all")
            return await axiosInstance.get("/rooms");
        return await  axiosInstance.get("/rooms", {
            params: {
                available: availabilityFilter === "available"
            },
        });
    },
    findByIdWithDetails: async (id) => {
        return await axiosInstance.get(`/rooms/${id}/details`);
    },
    add: async (data) => {
        return await axiosInstance.post("/rooms/add", data);
    },
    edit: async (id, data) => {
        return await axiosInstance.put(`/rooms/${id}/edit`, data);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/rooms/${id}/delete`);
    },
    reserve: async (id) => {
        return await axiosInstance.post(`/rooms/${id}/reserve`);
    },
};

export default roomRepository;