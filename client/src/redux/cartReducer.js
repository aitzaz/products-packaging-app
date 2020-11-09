import {ADD_TO_CART} from "../actions/actionTypes";

const initialState = {
    mapPackageIdToCount: new Map(),
    fullPrice: 0,
    discountedPrice: 0,
    discount: 0,
    numItemsInCart: 0
}

const cartReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TO_CART:
            const mapPackageIdToCount = new Map(state.mapPackageIdToCount);
            const priorPkgCount =  mapPackageIdToCount.get(action.packageDetails.id);
            mapPackageIdToCount.set(action.packageDetails.id, priorPkgCount ? priorPkgCount + 1 : 1);

            const fullPrice = state.fullPrice + action.packageDetails.price;
            const numItemsInCart = Array.from(mapPackageIdToCount.values()).reduce((a,b) => a + b, 0);

            let discountedPrice = fullPrice;
            let discount = 0;
            if (numItemsInCart > 1) {
                discountedPrice =  (fullPrice * .90).toFixed(2);
                discount = (fullPrice - discountedPrice).toFixed(2);
            }

            return {
                mapPackageIdToCount,
                fullPrice,
                discountedPrice,
                discount,
                numItemsInCart
            };
        default:
            return state;
    }
};


export default cartReducer;

