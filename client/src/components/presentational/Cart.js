import React from 'react';
import {Alert, Table} from "react-bootstrap";

const Cart = ({cart, packagesInCart}) => {
    if (cart.numItemsInCart === 0) {
        return (
            <div className="cart">
                <h1>My Cart</h1>
                <Alert variant="info text-center">
                    Cart is empty.
                </Alert>
            </div>
        )
    }

    return (
        <div className="cart">
            <h1>My Cart</h1>

            <Table striped bordered hover>
                <thead>
                    <tr className="bg-dark text-white font-weight-bold">
                        <td>#</td>
                        <td>Package Name</td>
                        <td>Quantity</td>
                        <td>Price</td>
                    </tr>
                </thead>
                <tbody>
                {
                    packagesInCart.map((pkg, idx) => {
                        return (
                            <tr>
                                <td>{idx + 1}</td>
                                <td>{pkg.name}</td>
                                <td>{cart.mapPackageIdToCount.get(pkg.id)}</td>
                                <td>${pkg.price * cart.mapPackageIdToCount.get(pkg.id)}</td>
                            </tr>
                        )
                    })
                }
                <tr className="bg-info">
                    <td colSpan="3">Total</td>
                    <td>${cart.fullPrice}</td>
                </tr>
                <tr className="bg-info">
                    <td colSpan="3">Discount</td>
                    <td>${cart.discount}</td>
                </tr>
                <tr className="bg-primary">
                    <td colSpan="3">Total Payable</td>
                    <td>${cart.discountedPrice}</td>
                </tr>
                </tbody>
            </Table>
        </div>
    )
};

export default Cart;
