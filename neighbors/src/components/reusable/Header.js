
import React from 'react'
import { useNavigate } from 'react-router'

import '../../css/header.css'



function Header(props) {

  const navigator = useNavigate
  const signOut = () => {
    localStorage.removeItem("emailCookie")
    props.setUser({
      email: "",
      password:""
  })
    navigator("/")
  }

  const renderHeader = () => {

    if (props.user !== undefined) {
      return (
        <div className='flex-row header'>
          <div className='third-width'>
            <a href="/"><img className='logo' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIUFPLdUlYaFE0ExYbLRGiPuODUy7vmaHSvQ&usqp=CAU" /></a>
          </div>
          <div className='third-width justify-center'>
            <a className='header-link' href="/">Home</a>
            <a href="/cart" className='header-link'>
              <div className='cart-items-count'>{props.user.cart.itemsInCart.length}</div>
            </a>
            <div className='header-link' onClick={signOut}>Sign Out</div>
          </div>
          <div className='third-width justify-right'>
          </div>
        </div>
      )
    } else {
      return (
        <div className='flex-row header'>
          <div className='third-width'>
            <a href="/"><img className='logo' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIUFPLdUlYaFE0ExYbLRGiPuODUy7vmaHSvQ&usqp=CAU" /></a>
          </div>
          <div className='third-width justify-center'>
            <a className='header-link' href="/sign-up">Join the Community</a>
            <a className='header-link' href="/">Home</a>
            <a className='header-link' href="/sign-in">Sign In</a>
          </div>
          <div className='third-width justify-right'>
            <a className='header-link' href="/specials"></a>
          </div>
        </div>
      )
    }

  }

  return (
    renderHeader()
  )
}

export default Header