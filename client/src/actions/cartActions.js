import {ADD_TO_CART, APPLY_DISCOUNT} from "./actionTypes";

export const addToCart = (packageDetails) => (
    {
        type: ADD_TO_CART,
        packageDetails
    }
);

// export const applyDiscount = () => (
//     {
//         type: APPLY_DISCOUNT
//     }
// );

// TODO: Clear cart or remove from cart
