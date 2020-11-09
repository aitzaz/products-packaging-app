import React from 'react';
import {Button} from "react-bootstrap";

const AddToCartBtn = ({packageDetails, addToCart}) => {
    const handleAddToCart = () => {
        addToCart(packageDetails);
    }

    return (
        <Button className="bg-primary" onClick={handleAddToCart}>
            Add to cart
        </Button>
    );
};

export default AddToCartBtn;
