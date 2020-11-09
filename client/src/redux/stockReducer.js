import {FETCH_PACKAGES_FAILURE, FETCH_PACKAGES_REQUEST, FETCH_PACKAGES_SUCCESS} from "../actions/actionTypes";

const initialState = {
    loading: false,
    packages: [],
    error: ''
}

const stockReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_PACKAGES_REQUEST:
            return {
                ...state,
                loading: true
            }
        case FETCH_PACKAGES_SUCCESS:
            return {
                loading: false,
                packages: action.payload,
                error: ''
            }
        case FETCH_PACKAGES_FAILURE:
            return {
                loading: false,
                packages: [],
                error: action.payload
            }
        default:
            return state;
    }
};

export default stockReducer;

