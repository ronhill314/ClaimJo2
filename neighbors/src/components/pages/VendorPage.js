import React, { useState } from 'react';
import axios from 'axios';
import '../../css/vendorPage.css'

const VendorPage = () => {
  const [eventName, setEventName] = useState('');
  const [eventDate, setEventDate] = useState('');
  const [eventVendor, setEventVendor] = useState('');
  const [eventLocation, setEventLocation] = useState('');
  const [eventAddress, setEventAddress] = useState('');

  const [productName, setProductName] = useState('');
  const [productPrice, setProductPrice] = useState(0);
  const [productQuantity, setProductQuantity] = useState(0);
  const [productDescription, setProductDescription] = useState('');
  const [productImage, setProductImage] = useState('');

  const handleCreateEvent = async () => {
    const newEvent = {
      name: eventName,
      date: eventDate,
      vendor: eventVendor,
      location: eventLocation,
      address: eventAddress,
    };
    try {
      const response = await axios.post('/api/events', newEvent);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleCreateProduct = async () => {
    const newProduct = {
      name: productName,
      price: productPrice,
      quantity: productQuantity,
      description: productDescription,
      image: productImage,
    };
    try {
      const response = await axios.post('/api/products', newProduct);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className='flex-row flex-col vendor-box'>
      <h1>Create Event</h1>
      <div>
        <label>Event Name:</label>
        <input type="text" value={eventName} onChange={e => setEventName(e.target.value)} />
      </div>
      <div>
        <label>Event Date:</label>
        <input type="text" value={eventDate} onChange={e => setEventDate(e.target.value)} />
      </div>
      <div>
        <label>Vendor:</label>
        <input type="text" value={eventVendor} onChange={e => setEventVendor(e.target.value)} />
      </div>
      <div>
        <label>Location:</label>
        <input type="text" value={eventLocation} onChange={e => setEventLocation(e.target.value)} />
      </div>
      <div>
        <label>Address:</label>
        <input type="text" value={eventAddress} onChange={e => setEventAddress(e.target.value)} />
      </div>
      <button onClick={handleCreateEvent}>Create Event</button>

      <h1>Create Product</h1>
      <div>
        <label>Product Name:</label>
        <input type="text" value={productName} onChange={e => setProductName(e.target.value)} />
      </div>
      <div>
        <label>Price:</label>
        <input type="number" value={productPrice} onChange={e => setProductPrice(e.target.value)} />
      </div>
      <div>
        <label>Quantity:</label>
        <input type="number" value={productQuantity} onChange={e => setProductQuantity(e.target.value)} />
      </div>
      <div>
        <label>Description:</label>
        <input type="text" value={productDescription} onChange={e => setProductDescription(e.target.value)} />
      </div>
      <div>
        <label>Image URL:</label>
        <input type="text" value={productImage} onChange={e => setProductImage(e.target.value)} />
    </div>
    <button onClick={handleCreateProduct}>Create Product</button>
  </div>
  );
};

export default VendorPage;