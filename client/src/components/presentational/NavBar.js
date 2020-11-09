import React from "react";
import {Link} from 'react-router-dom';
import {Navbar, NavbarBrand, NavLink} from "react-bootstrap";

const NavBar = ({cart, backButton, cartButton}) => {
    const getBackButton = () => (
        <NavLink>
            <Link to="/" className="nav-link btn-outline-info">
                &lt; Back to shop
            </Link>
        </NavLink>
    );

    const getCartButton = () => (
        <div className="text-info">
            <NavLink>
                <Link to="/cart" className="nav-link btn-outline-info">
                    Cart ({cart.numItemsInCart} Packages)
                </Link>
            </NavLink>
            <div className="pl-3">
                <small>Price: ${cart.discountedPrice}</small> | <small>Discount: ${cart.discount}</small>
            </div>
        </div>
    );

    return (
        <Navbar bg="dark" variant="dark">
            <NavbarBrand className="navbar-brand"><Link to="/">Packages Shop</Link></NavbarBrand>
            <Navbar.Collapse className="justify-content-end">
                {backButton ? getBackButton() : ''}
                {cartButton ? getCartButton() : ''}
            </Navbar.Collapse>
        </Navbar>
    );
};

export default NavBar;
