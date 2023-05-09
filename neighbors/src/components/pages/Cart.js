import axios from 'axios'
import ProductBox from '../reusable/ProductBox'


function Cart(props) {

    const submitHandler = (product) => {
        axios.post(`http://localhost:8080/cart/removeProductToCart/${props.user.cart.id}`, product)
        .then((response) => {
            props.setUpdateUser({})
        })
        .catch((e) => {
            console.log(e)
        })
    }

    const renderProducts = () => {

        if(props.user.cart === undefined) {

           

        } else {
            return props.user.cart.itemsInCart.map((product) => {
                return (
                    <ProductBox 
                        product={product}
                        text="Remove from Cart!"
                        onClick={submitHandler}
                    />
                    
                )
            })
        }
    }

  return (
    <div className='flex-row product-container'>
        {renderProducts()}
    </div>
  )
}

export default Cart