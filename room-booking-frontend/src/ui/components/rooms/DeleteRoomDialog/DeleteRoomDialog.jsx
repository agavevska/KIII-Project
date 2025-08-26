import React from 'react';
import {Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle} from "@mui/material";

const DeleteRoomDialog = ({open, onClose, onDelete, room}) => {
    const handleSubmit = () => {
        onDelete(room.id);
        onClose();
    };


    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Delete Room</DialogTitle>
            <DialogContent>
                <DialogContentText>
                    Are you sure you want to delete <strong>{room.code}</strong>? This action cannot be undone.
                </DialogContentText>
                <DialogActions>
                    <Button onClick={onClose}>Cancel</Button>
                    <Button color="error" variant="contained" className="submit-btn" onClick={handleSubmit}>Delete</Button>
                </DialogActions>
            </DialogContent>
        </Dialog>
    );
};

export default DeleteRoomDialog;