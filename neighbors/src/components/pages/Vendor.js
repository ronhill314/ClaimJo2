import React from 'react'
import VendorBox from '../reusable/VendorBox'

function Vendor(props) {
  return (
    <VendorBox user ={props.user} setUser={props.setUser} />
  )
}

export default Vendor