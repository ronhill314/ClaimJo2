import React from 'react'
import '../../css/aboutNeighbors.css'

function AboutNeighbors(props) {
  return (
    
    <div className='about-us flex-row flex-col'> 
    <div className='heading'>About Neighbors</div>
        <div className=''>
          Our Neighbors Organization was created to benefit farmers and small farmers from the ability to sell their products anywhere.
          The loss of money, food, and healthy option availability has put the country into a painful state of living.
          Our aim is to fix this by building a program that allows people to sell and buy products directly on farms. 
          The farmers markets today are helping to solve this issue, but we aim to expand it more. The delivery service
          we will provide will allow those who can’t attend markets to get their products from anywhere based on the product. 
          Neighbors will also aim to improve coordination of farmers markets to increase awareness and availability to public. 
          As we aim to better improve this service to the public feel free to contact us below with ideas, suggestions, or if there’s any issues. 
        </div>
        <div className='contact'> Contact Email: Contact Phone:</div>
    </div>
  )
}

export default AboutNeighbors