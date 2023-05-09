import React, { useState } from 'react'
import Header from '../reusable/Header'
import "../css/sign-up.css"
import SignUpBox from './SignUpBox'

function Signup(props) {

    return (
                <SignUpBox user={props.user} setUser={props.setUser} />
    )
}

export default Signup

// to import axios type npm i axios