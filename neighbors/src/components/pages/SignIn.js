import React from 'react'
import SignInBox from '../reusable/SignInBox'

function SignIn(props) {
  return (
    <SignInBox user={props.user} setUser={props.setUser} />
  )
}

export default SignIn