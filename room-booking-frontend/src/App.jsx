import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router";
import Register from "./ui/components/auth/Register/Register.jsx";
import Login from "./ui/components/auth/Login/Login.jsx";
import Layout from "./ui/components/layout/Layout/Layout.jsx";
import HomePage from "./ui/pages/HomePage/HomePage.jsx";
import ProtectedRoute from "./ui/components/routing/ProtectedRoute/ProtectedRoute.jsx";
import RoomsPage from "./ui/pages/RoomsPage/RoomsPage.jsx";
import RoomDetails from "./ui/components/rooms/RoomDetails/RoomDetails.jsx";
import ReservationsPage from "./ui/pages/ReservationsPage/ReservationsPage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/register" element={<Register/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/" element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                    <Route element={<ProtectedRoute/>}>
                        <Route path="rooms" element={<RoomsPage/>}/>
                        <Route path="rooms/:id" element={<RoomDetails/>}/>
                        <Route path="/reservations" element={<ReservationsPage/>}/>
                    </Route>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;