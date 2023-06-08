import '../../css/events.css'
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const EventScheduler = () => {
  const [eventList, setEventList] = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [newEventName, setNewEventName] = useState('');
  const [newEventDate, setNewEventDate] = useState('');
  const [newVendorName, setNewVendorName] = useState('');
  const [newEventLocation, setNewEventLocation] = useState('');
  const [newEventAddress, setNewEventAddress] = useState('');
  const [showMap, setShowMap] = useState(false);
  const [filterMonth, setFilterMonth] = useState('');
  const [filterCity, setFilterCity] = useState('');
  const [filterState, setFilterState] = useState('');

  useEffect(() => {
    const fetchEvents = async () => {
      const response = await axios.get('http://localhost:8080/events/findAll');
      setEventList(response.data);
      console.log(response.data)
    };
    fetchEvents();
  }, []);

  const addNewEvent = async () => {
    const response = await axios.post('http://localhost:8080/events/create', {
      eventName: newEventName,
      eventDate: newEventDate,
      vendorName: newVendorName,
      eventLocation: newEventLocation,
      eventAddress: newEventAddress
    });
    setEventList([...eventList, response.data]);
    setNewEventName('');
    setNewEventDate('');
    setNewVendorName('');
    setNewEventLocation('');
    setNewEventAddress('');
  };

  const searchEvents = () => {
    return eventList.filter(event =>
      event.name.toLowerCase().includes(searchQuery.toLowerCase())
    );
  };

  const filterEvents = () => {
    let filteredEvents = [...eventList];

    if (filterMonth) {
      filteredEvents = filteredEvents.filter(event => {
        const eventDate = new Date(event.date);
        return eventDate.getMonth() === parseInt(filterMonth);
      });
    }

    if (filterCity) {
      filteredEvents = filteredEvents.filter(
        event => event.location.toLowerCase() === filterCity.toLowerCase()
      );
    }

    if (filterState) {
      filteredEvents = filteredEvents.filter(
        event => event.address.toLowerCase().includes(filterState.toLowerCase())
      );
    }

    return filteredEvents;
  };

  const showMapHandler = () => {
    setShowMap(!showMap);
  };

  return (
    <div className='event-box flex-col'>
      <h1>Events</h1>
      <div>
        <input
          type="text"
          value={newEventName}
          onChange={e => setNewEventName(e.target.value)}
          placeholder="Event Name"
        />
        <input
          type="date"
          value={newEventDate}
          onChange={e => setNewEventDate(e.target.value)}
          placeholder="Event Date"
        />
        <input
          type="text"
          value={newVendorName}
          onChange={e => setNewVendorName(e.target.value)}
          placeholder="Vendor Name"
        />
        <input
          type="text"
          value={newEventLocation}
          onChange={e => setNewEventLocation(e.target.value)}
          placeholder="Event Location"
        />
        <input
          type="text"
          value={newEventAddress}
          onChange={e => setNewEventAddress(e.target.value)}
          placeholder="Event Address"
        />
        <button onClick={addNewEvent}>Add Event</button>
      </div>
      <div>
    <input
      type="text"
      value={searchQuery}
      onChange={e => setSearchQuery(e.target.value)}
      placeholder="Search Events"
    />
  </div>
  <div>
    <label>Filter by Month:</label>
    <select value={filterMonth} onChange={e => setFilterMonth(e.target.value)}>
      <option value="">All</option>
      <option value="January">January</option>
      <option value="February">February</option>
      <option value="March">March</option>
      <option value="April">April</option>
      <option value="May">May</option>
      <option value="June">June</option>
      <option value="July">July</option>
      <option value="August">August</option>
      <option value="September">September</option>
      <option value="October">October</option>
      <option value="November">November</option>
      <option value="December">December</option>
    </select>

    <label>Filter by City:</label>
    <input
      type="text"
      value={filterCity}
      onChange={e => setFilterCity(e.target.value)}
    />

    <label>Filter by State:</label>
    <input
      type="text"
      value={filterState}
      onChange={e => setFilterState(e.target.value)}
    />
  </div>
  <ul>
    {filterEvents().map((event) => {
      return (
      <li key={event.id}>
        <h2>{event.eventName}</h2>
        <p>Date: {event.eventDate}</p>
        <p>Vendor: {event.vendorName}</p>
        <p>Location: {event.eventLocation}</p>
        <button onClick={showMapHandler}>{showMap ? 'Hide Map' : 'Show Map'}</button>
        {showMap && (
          <div style={{ marginTop: '10px' }}>
            <iframe
              width="200"
              height="150"
              style={{ frameborder: '0',
                border: '0' }}
              src={`pk.eyJ1Ijoicm9uaGlsbDMxNCIsImEiOiJjbGhpMDBtZngwMzZnM2p0bDRic3JsNHF4In0.KvPK_COLD2Hxt-iTYPy2oQ${event.eventAddress}`}
              allowfullscreen
            ></iframe>
          </div>
        )}
      </li>
)})}
  </ul>
</div>
);
};

export default EventScheduler;
