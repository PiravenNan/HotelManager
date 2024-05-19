import { useEffect, useState, createContext } from "react";
import LogInForm from "../components/LogInForm";


const HotelManagerContainer = () => {
    return (
        <>
        <h2>Log-in here:</h2>
            <LogInForm/>
        </>
    );
}

export default HotelManagerContainer;