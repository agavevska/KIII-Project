import React from 'react';
import {Link} from "react-router";
import {AppBar, Box, Button, Toolbar, Typography} from "@mui/material";
import "./Header.css";
import AuthenticationToggle from "../../auth/AuthenticationToggle/AuthenticationToggle.jsx";

const pages = [
    {"path": "/", "name": "home"},
    {"path": "/rooms", "name": "rooms"},
    {"path": "/reservations", "name": "reservations"},
];

const Header = () => {
    return (
        <Box>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6" component="div" sx={{mr: 3}}>
                        Car Rental
                    </Typography>
                    <Box sx={{flexGrow: 1, display: "flex"}}>
                        {pages.map((page) => (
                            <Link key={page.name} to={page.path}>
                                <Button
                                    sx={{my: 2, color: "white", display: "block", textDecoration: "none"}}
                                >
                                    {page.name}
                                </Button>
                            </Link>
                        ))}
                    </Box>
                    <AuthenticationToggle/>
                </Toolbar>
            </AppBar>
        </Box>
    );
};

export default Header;