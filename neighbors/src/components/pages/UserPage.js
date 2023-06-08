import React, { useState, useEffect } from "react";
import axios from "axios";
import '../../css/userPage.css'

const UserPage = (props) => {
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);
  const [events, setEvents] = useState([]);
  const [savedEvents, setSavedEvents] = useState([]);

  useEffect(() => {
    axios.get("/products").then(response => {
      setProducts(response.data);
    });

    axios.get("/events").then(response => {
      setEvents(response.data);
    });
  }, []);

  const handleAddToCart = product => {
    // Add the selected product to the cart
    setCart([...cart, product]);
  };

  const handleSaveEvent = eventId => {
    // Save the selected event to the user's calendar
    setSavedEvents([...savedEvents, eventId]);
  };

  return (
    <div className="flex row flex-col user-box">
      {props.user ? (
        <div>
          <h2>Products</h2>
          <ul>
            {products.map(product => (
              <li key={product.id}>
                {product.name} - {product.price} - {product.quantity}{" "}
                <button onClick={() => handleAddToCart(product)}>Add to Cart</button>
              </li>
            ))}
          </ul>

          <h2>Cart</h2>
          <ul>
            {cart.map(product => (
              <li key={product.id}>
                {product.name} - {product.price}
              </li>
            ))}
          </ul>

          <h2>Events</h2>
          <ul>
            {events.map(event => (
              <li key={event.id}>
                {event.name} - {event.date} - {event.location}{" "}
                <button onClick={() => handleSaveEvent(event.id)}>Save Event</button>
              </li>
            ))}
          </ul>

          <h2>Saved Events</h2>
          <ul>
            {savedEvents.map(eventId => (
              <li key={eventId}>
                {events.find(event => event.id === eventId)?.name} -{" "}
                {events.find(event => event.id === eventId)?.date} -{" "}
                {events.find(event => event.id === eventId)?.location}
              </li>
            ))}
          </ul>
        </div>
      ) : (
        <p>You must be logged in to view this page.</p>
      )}
    </div>
  );
};

export default UserPage;
