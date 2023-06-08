import React from 'react'
import VendorBox from '../reusable/VendorBox'

function Vendor(props) {
  return (
    <VendorBox vendor ={props.vendor} setVendor={props.setVendor} />
  )
}

export default Vendor