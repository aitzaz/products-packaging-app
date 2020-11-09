import { connect } from 'react-redux';
import ShopItems from '../presentational/ShopItems';
import {fetchPackages} from "../../actions";

const mapStateToProps = state => (
    {
        packagesData: state.stock,
    }
);

const mapDispatchToProps = (dispatch) => {
    return {
        fetchPackages: () => dispatch(fetchPackages())
    }
};

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ShopItems);
