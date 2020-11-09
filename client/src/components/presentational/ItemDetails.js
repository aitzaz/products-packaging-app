import React from 'react';
import AddToCartBtn from '../container/AddToCartBtnContainer';
import {Alert, Card, CardColumns} from "react-bootstrap";

const ItemDetails = ({packageData}) => {
    return !packageData ? (
        <Alert variant="danger">
            Package not found!
        </Alert>
    ) : (
        <div className="p-3">
            <h1>
                {packageData.name}
            </h1>
            <h2 className="text-muted">
                ${packageData.price}
            </h2>
            <label className="font-weight-bold">Description:</label>
            <p>
                {packageData.description}
            </p>
            <label className="font-weight-bold">Includes:</label>
            <CardColumns>
                {
                    packageData.products.map(product => (
                        <Card border="primary" style={{width: '18rem'}} className="text-center">
                            <Card.Header>{product.name}</Card.Header>
                            <Card.Body>
                                <Card.Subtitle className="p-2 text-muted">Product Price: ${product.usdPrice}</Card.Subtitle>
                            </Card.Body>
                        </Card>
                    ))
                }
            </CardColumns>

            <div>
                <AddToCartBtn id={packageData.id}/>
            </div>
        </div>
    )
};

export default ItemDetails;
