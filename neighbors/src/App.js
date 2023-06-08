import './App.css';
import PageWrapper from './components/reusable/PageWrapper';
import { Route, Routes } from 'react-router';
import Home from '../src/components/pages/Home';
import { useState } from 'react';
import axios from 'axios';
import Cart from '../src/components/pages/Cart'
import SignIn from '../src/components/pages/SignIn'
import SignUp from '../src/components/pages/SignUp'
import { useEffect } from 'react'
import AboutNeighbors from './components/pages/AboutNeighbors';
import Vendor from './components/pages/Vendor';
import Events from './components/pages/Events';
import VendorPage from './components/pages/VendorPage';
import UserPage from './components/pages/UserPage';

function App() {
  const [user, setUser] = useState({
    email: "",
    password: ""
  })

  const [updateUser, setUpdateUser] = useState({})

  useEffect(() => {
    const email = localStorage.getItem("emailCookie")

    if (email !== null) {

      axios.get(`http://localhost:8080/user/findUserByEmail/${email}`)
        .then((response) => {
          setUser(response.data)
        })
        .catch((e) => {
          console.log(e)
        })
    }
  }, [updateUser])

  const [vendor, setVendor] = useState({
    email: "",
    password: "",
    
  })

  const [updateVendor, setUpdateVendor] = useState({})

  useEffect(() => {
    const email = localStorage.getItem("emailCookie")

    if (email !== null) {

      axios.get(`http://localhost:8080/vendor/findUserByEmail/${email}`)
        .then((response) => {
          setUser(response.data)
        })
        .catch((e) => {
          console.log(e)
        })
    }
  }, [updateVendor])


  return (
    <PageWrapper
      user={user}
      setUser={setUser}

      vendor={vendor}
      setVendor={setVendor}
    >
      <Routes>
        <Route path="/" element={<Home user={user} />} />
        <Route path="/sign-in" element={<SignIn user={user} setUser={setUser} vendor={vendor} setVendor={setVendor}/>} />
        <Route path="/sign-up" element={<SignUp user={user} setUser={setUser} vendor={vendor} setVendor={setVendor} />} />
        <Route path="/aboutNeighbors" element={<AboutNeighbors user={user} setUser={setUser} vendor={vendor} setVendor={setVendor} />} />
        <Route path="/vendor" element={<Vendor vendor={vendor} setVendor={setVendor} />} />
        <Route path="/events" element={<Events user={user} setUser={setUser} vendor={vendor} setVendor={setVendor}/>} />
        <Route path="/cart" element={<Cart user={user} setUser={setUser} setUpdateUser={setUpdateUser} />} />
        <Route path='/VendorPage' element={<VendorPage vendor={vendor} setVendor={setVendor} />} /> 
        <Route path='/UserPage' element={<UserPage  user={user} setUser={setUser}/>} /> 
      </Routes>
    </PageWrapper>
  )
}

export default App;
