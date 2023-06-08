import axios from 'axios';
import React from 'react'
import { useNavigate } from 'react-router';


function VendorBox(props) {

    const navigator = useNavigate()

    const changeHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempVendor = { ...props.vendor };
        tempVendor[name] = value;
        props.setVendor(tempVendor)
    }

    const submitHandler = () => {
        axios.post("http://localhost:8080/vendor/signUp", props.vendor)
        .then((response) => {
            localStorage.setItem("emailCookie", response.data.email)
            props.setVendor(response.data)
            navigator("/")
        })
        .catch((e) => {
            console.log(e)
        })
    }

    return (
        <div className='sign-up-box flex-col'>
            <h1 className='h1'>Vendor Registration</h1>
            <div className='flex-row flex-col'>
            <div className='form-input-container'>
                    <div>Name</div>
                    <input name="name" type="name" value={props.vendor.name} className='form-input' onChange={changeHandler} />
                </div>
                <div className='form-input-container'>
                    <div>Email</div>
                    <input name="email" type="email" value={props.vendor.email} className='form-input' onChange={changeHandler} />
                </div>
                <div className='form-input-container'>
                    <div>Location</div>
                    <input name="location" type="location" value={props.vendor.location} className='form-input' onChange={changeHandler} />
                </div>
                <div className='form-input-container'>
                    <div>Company Name</div>
                    <input name="companyName" type="text" value={props.vendor.companyName} className='form-input' onChange={changeHandler} />
                </div>
                <div className='form-input-container'>
                    <div>Password</div>
                    <input name="password" type="password" value={props.vendor.password} className='form-input' onChange={changeHandler} />
                </div>
            </div>
            <button class="button-53" role="button" onClick={submitHandler} >Submit!!</button>
        </div>
    )
}

export default VendorBox