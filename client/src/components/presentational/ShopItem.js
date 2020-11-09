import React from 'react';
import { useHistory } from "react-router-dom";
import {Button, Card} from "react-bootstrap";
import AddToCartBtn from "../container/AddToCartBtnContainer";

const ShopItem = ({id, name, price}) => {
    const history = useHistory();

    const handleDetailsRequest = () => {
        history.push(`/packages/${id}`);
    }

    return (
        <Card border="dark" style={{width: '18rem'}} className="text-center">
            <Card.Header>{name}</Card.Header>
            <Card.Body>
                <Card.Subtitle className="p-2 text-muted">Price: ${price}</Card.Subtitle>
            </Card.Body>
            <Card.Footer>
                <Button className="btn-info mr-4" onClick={handleDetailsRequest}>Details</Button>
                <AddToCartBtn id={id}/>
                {/*<Button className="btn-primary ml-auto">Add to Cart</Button>*/}
            </Card.Footer>
        </Card>
    )
};

export default ShopItem;
