import {useEffect, useState} from "react";
import workspaceRepository from "../repository/workspaceRepository.js";

const useWorkspace = () => {
    const [workspace, setWorkspace] = useState([]);

    useEffect(() => {
        workspaceRepository
            .findAll()
            .then((response) => setWorkspace(response.data))
            .catch((error) => console.log(error));
    }, []);

    return workspace;
};

export default useWorkspace;