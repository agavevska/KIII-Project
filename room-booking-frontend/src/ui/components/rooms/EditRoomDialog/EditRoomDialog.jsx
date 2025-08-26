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

const EditRoomDialog = ({open, onClose, onEdit, room}) => {
    const workspaces = useWorkspace();

    const [formData, setFormData] = useState( {
        "code": room.code,
        "workspaceId": room.workspaceId,
        "floor": room.floor,
        "price": room.price
    });

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData({...formData, [name]: value});
    };

    const handleSubmit = () => {
        onEdit(room.id,formData);
        setFormData(formData)
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Edit Room</DialogTitle>
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
                        value={formData.workspaceId}
                        onChange={handleChange}
                        className="workspace-select">
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
                <Button variant="contained" color="warning" className="submit-btn" onClick={handleSubmit}>Edit</Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditRoomDialog;