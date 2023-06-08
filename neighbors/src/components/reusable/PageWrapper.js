import React from 'react'
import Header from './Header'

function PageWrapper(props) {
  return (
    <div className='flex-col container'>
      <Header user={props.user} setUser={props.setUser} vendor={props.vendor} setVendor={props.setVendor}/>
      <div className='flex-row main-content'>
        {props.children}
      </div>
    </div>
  )
}

export default PageWrapper