import React from 'react'
import Header from '../reusable/Header'

function Home(props) {
  return (
      <h1>
        Hello Neighbors {props.user.name}
      </h1>
    
  )
}

export default Home