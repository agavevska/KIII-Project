import axiosInstance from "../axios/axios.js";

const workspaceRepository = {
    findAll: async () => {
        return await axiosInstance.get("/workspaces");
    },
};

export default workspaceRepository;