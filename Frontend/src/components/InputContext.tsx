import {createContext, ReactNode, useContext, useState} from "react";

export interface InputContextInterface{
    street: string,
    setStreet: (street: string) => void,
    district: string,
    setDistrict: (district: string) => void,
    city: string,
    setCity: (city: string) => void,
    location:number,
    setLocation: (location: number) => void
}

const SampleContext: InputContextInterface = {
    street: "",
    setStreet: () => {
    },
    district: "",
    setDistrict: () => {},
    city: "",
    setCity: () => {},
    location: 0,
    setLocation: () => {}
}

export const InputContext = createContext<InputContextInterface>(SampleContext)

export const useInputContext = () => useContext(InputContext)

interface InputContextProviderProps{
    readonly children: ReactNode
}

export const InputContextProvider = (props: InputContextProviderProps) => {
    const [street, setStreet] = useState<string>("");
    const [district, setDistrict] = useState<string>("");
    const [city, setCity] = useState<string>("");
    const [location, setLocation] = useState<number>(0)

    const inputContext: InputContextInterface = {
        street: street,
        setStreet: setStreet,
        district:district,
        setDistrict,
        city:city,
        setCity:setCity,
        location:location,
        setLocation:setLocation
    }
    return(
        <InputContext.Provider value={inputContext}>
            {props.children}
        </InputContext.Provider>
    )
}