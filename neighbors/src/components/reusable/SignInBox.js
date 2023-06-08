import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router';

function SignInBox(props) {
  const [isVendor, setIsVendor] = useState(false);
  const navigator = useNavigate();

  const changeHandler = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    const tempUser = { ...props.user };
    tempUser[name] = value;
    props.setUser(tempUser);
  };

  const check = (event) => {
    setIsVendor(event.target.checked);
  };

  const submitHandler = () => {
    if (isVendor) { 
      console.log(props.vendor)
      axios
        .post('http://localhost:8080/vendor/signIn', props.user)
        .then((response) => {
          localStorage.setItem('emailCookie', response.data.email);
          props.setVendor(response.data);
          props.setUser({})
          navigator('/VendorPage');
        })
        .catch((e) => {
          console.log(e);
        });
    } else {
      axios
        .post('http://localhost:8080/user/signIn', props.user)
        .then((response) => {
          localStorage.setItem('emailCookie', response.data.email);
          props.setUser(response.data);
          navigator('/UserPage');
        })
        .catch((e) => {
          console.log(e);
        });
    }
  };

  return (
    <div className="sign-up-box flex-col">
      <h1 className="h1">Sign In Neighbor</h1>
      <div className="flex-row">
        <div className="form-input-container">
          <div>Email</div>
          <input
            name="email"
            type="email"
            value={props.user.email}
            className="form-input"
            onChange={changeHandler}
          />
        </div>
        <div className="form-input-container">
          <div>Password</div>
          <input
            name="password"
            type="password"
            value={props.user.password}
            className="form-input"
            onChange={changeHandler}
          />
        </div>
      </div>
      <div className="form-input-container">
        <div>
          <input
            type="checkbox"
            name="isVendor"
            id="isVendor"
            checked={isVendor}
            onChange={check}
          />
          <label htmlFor="isVendor"> Are you a vendor?</label>
        </div>
      </div>
      <button className="button-53" onClick={submitHandler}>
        Submit!!
      </button>
    </div>
  );
}

export default SignInBox;
