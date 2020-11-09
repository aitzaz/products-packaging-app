import {connect} from 'react-redux';
import Cart from '../presentational/Cart';

const mapStateToProps = state => {
    const cartPkgIds = Array.from(state.cart.mapPackageIdToCount.keys());
    const packagesInCart = state.stock.packages.filter(pkg => cartPkgIds.includes(pkg.id));

    return {
        cart: state.cart,
        packagesInCart
    }
};

    // {
        // cart: state.cart.map((cartItem) => {
        //     const item = state.stock.find(stockItem => cartItem.id === stockItem.id);
        //     return {
        //         id: cartItem.id,
        //         name: item.name,
        //         price: item.price,
        //         count: cartItem.count,
        //         stockCount: item.count,
        //     };
        // }),
    // }

export default connect(
    mapStateToProps
)(Cart);
