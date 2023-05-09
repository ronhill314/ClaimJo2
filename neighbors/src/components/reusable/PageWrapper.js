import React from 'react'
import Header from './Header'

function PageWrapper(props) {
  return (
    <div className='flex-col container'>
      <Header />
      <div className='flex-row main-content'>
        {props.children}
      </div>
    </div>
  )
}

export default PageWrapper