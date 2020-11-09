import {connect} from 'react-redux';
import { addToCart } from '../../actions';
import AddToCartBtn from '../presentational/AddToCartBtn';

const mapStateToProps = (state, ownProps) => (
    {
        packageDetails: state.stock.packages.find(item => item.id == ownProps.id)
    }
);

const mapDispatchToProps = (dispatch) => (
    {
        addToCart: (packageDetails) => dispatch(addToCart(packageDetails))
    }
)

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(AddToCartBtn);
