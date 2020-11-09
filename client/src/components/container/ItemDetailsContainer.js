import {connect} from 'react-redux';
import ItemDetails from '../presentational/ItemDetails';

const mapStateToProps = (state, ownProps) => (
    {
        packageData: state.stock.packages.find(item => item.id == ownProps.match.params.id)
    }
);

export default connect(
    mapStateToProps
)(ItemDetails);
