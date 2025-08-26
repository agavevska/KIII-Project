import React, {useState} from 'react';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    FormControl,
    InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";
import useWorkspace from "../../../../hooks/useWorkspace.js";

const initialFormData = {
    "code": "",
    "workspaceId": "",
    "floor": "",
    "price": ""
};


const AddRoomDialog = ({open, onClose, onAdd}) => {
    const workspaces = useWorkspace();

    const [formData, setFormData] = useState(initialFormData);

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onAdd(formData);
        setFormData(initialFormData);
        onClose();
    };


    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Add Room</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Code"
                    name="code"
                    type="text"
                    value={formData.code}
                    onChange={handleChange}

                    fullWidth
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Workspace</InputLabel>
                    <Select
                        name="workspaceId"
                        label="Workspace"
                        variant="outlined"
                        className="workspace-select"
                        value={formData.workspaceId}
                        onChange={handleChange}

                        MenuProps={{PaperProps: {style: {maxHeight: 200}}}}>
                        {workspaces.map((workspace) => (
                            <MenuItem
                                key={workspace.id}
                                value={workspace.id}
                                className="workspace-option"
                            >
                                {workspace.name}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <TextField
                    margin="dense"
                    label="Floor"
                    name="floor"
                    type="number"
                    value={formData.floor}
                    onChange={handleChange}

                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Price"
                    name="price"
                    type="number"
                    value={formData.price}
                    onChange={handleChange}

                    fullWidth
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button variant="contained" color="primary" className="submit-btn" onClick={handleSubmit}>Add</Button>
            </DialogActions>
        </Dialog>
    );
};

export default AddRoomDialog;