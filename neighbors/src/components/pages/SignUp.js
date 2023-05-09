import React from 'react'
import SignUpBox from '../reusable/SignUpBox'
import '../../css/sign-up.css'

function SignUp(props) {
  return (
    <SignUpBox user={props.user} setUser={props.setUser} />
  )
}

export default SignUp