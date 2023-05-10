
import React from 'react'
import { useNavigate } from 'react-router'

import '../../css/header.css'



function Header(props) {

  const navigator = useNavigate()
  const signOut = () => {
    localStorage.removeItem("emailCookie")
    props.setUser({
     
  })
    navigator("/")
  }

  const renderHeader = () => {
    console.log(props.user)

    const email = localStorage.getItem("emailCookie")

    if (email !== null){
      return (
        <div className='flex-row header'>
          <div className='third-width'>
            <a href="/"><img className='logo' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIUFPLdUlYaFE0ExYbLRGiPuODUy7vmaHSvQ&usqp=CAU" /></a>
          </div>
          <div className='third-width justify-center'>
            <a className='header-link' href="/aboutNeighbors">About Neighbors</a>
            <a className='header-link' href="/">Home</a>
            <a className='header-link' href="/vendor">Become A Vendor </a>
            <a className='header-link' href="/events">Events</a>
            <a href="/cart" className='header-link'>
              <div className='cart-items-count'>{}</div>
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
            <a href="/"><img className='logo justify-left' src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIUFPLdUlYaFE0ExYbLRGiPuODUy7vmaHSvQ&usqp=CAU" /></a>
          </div>
          <div className='third-width justify-center '>
            <a className='header-link' href="/aboutNeighbors">About Neighbors</a>
            <a className='header-link' href="/sign-up">Join the Community</a>
            <a className='header-link' href="/">Home</a>
            <a className='header-link' href="/vendor">Become A Vendor </a>
            <a className='header-link' href="/events">Events</a>
          </div>
          <div className='third-width justify-right'>
          <a className='header-link headline' href="/sign-in">Sign In</a>
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