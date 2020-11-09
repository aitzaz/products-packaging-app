import { connect } from 'react-redux';
import NavBar from '../presentational/NavBar';

const showBackButton = pathname => pathname !== '/';

const showCartButton = pathname => !pathname.includes('cart');

const mapStateToProps = (state, ownProps) => (
  {
    cart: state.cart,
    backButton: showBackButton(ownProps.location.pathname),
    cartButton: showCartButton(ownProps.location.pathname),
  }
);

export default connect(
  mapStateToProps,
)(NavBar);
