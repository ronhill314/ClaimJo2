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

function App() {
  const [user, setUser] = useState ({
    email: "",
    password: ""
  })

  const [updateUser, setUpdateUser] = useState({})

  useEffect (() => {
    const email = localStorage.getItem("emailCookie")

    axios.get(`http://localhost:8080/user/findUserByEmail/${email}`)
      .then((response) => {
        setUser(response.data)
      })
      .catch((e) => {
        console.log(e)
      })
  }, [updateUser])

  return (
    <PageWrapper
      user={user}
      setUser={setUser}
      >
      <Routes>
      <Route path="/" element={<Home user={user} />} />
        <Route path="/sign-in" element={<SignIn user={user} setUser={setUser} />} />
        <Route path="/sign-up" element={<SignUp user={user} setUser={setUser} />} />
        <Route path="/cart" element={<Cart user={user} setUser={setUser} setUpdateUser={setUpdateUser} />} />
      </Routes>
    </PageWrapper>
  )
}

export default App;
