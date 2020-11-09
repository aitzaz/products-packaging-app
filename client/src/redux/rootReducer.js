import { combineReducers } from 'redux';
import cartReducer from "./cartReducer";
import stockReducer from "./stockReducer";

const rootReducer = combineReducers({
    cart: cartReducer,
    stock: stockReducer
});

export default rootReducer;