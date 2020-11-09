import {
    FETCH_PACKAGES_FAILURE,
    FETCH_PACKAGES_REQUEST,
    FETCH_PACKAGES_SUCCESS
} from './actionTypes';
import axios from 'axios';

export const fetchPackagesRequest = () => (
    {
        type: FETCH_PACKAGES_REQUEST
    }
);

export const fetchPackagesSuccess = (packagesList) => (
    {
        type: FETCH_PACKAGES_SUCCESS,
        payload: packagesList
    }
);

export const fetchPackagesFailure = (error) => (
    {
        type: FETCH_PACKAGES_FAILURE,
        payload: error
    }
);

export const fetchPackages = () => {
    return (dispatch) => {
        dispatch(fetchPackagesRequest());
        axios.get('http://localhost:8080/api/v1/packages')
            .then(response => {
                const data = response.data.data;
                dispatch(fetchPackagesSuccess(data))
            })
            .catch(error => {
                const errorMsg = error.message;
                dispatch(fetchPackagesFailure(errorMsg));
            });
    };
};
