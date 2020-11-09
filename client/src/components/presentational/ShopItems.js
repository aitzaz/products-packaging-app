import React, {useEffect} from 'react';
import ShopItem from './ShopItem';
import {Alert, CardDeck} from "react-bootstrap";

const ShopItems = ({packagesData, fetchPackages}) => {
    useEffect(() => {
        fetchPackages()
    }, []);

    if (packagesData.loading) {
        return (
            <Alert variant="primary" className="text-center">
                Loading...
            </Alert>
        )
    }
    else if (packagesData.error) {
        return (
            <Alert variant="danger" className="text-center">
                {packagesData.error}
            </Alert>
        )
    }
    else if (!packagesData.packages.length) {
        return (
            <Alert variant="secondary" className="text-center">
                No packages available at the moment! <br/>
                Come back later.
            </Alert>
        );
    }

    return (
        <CardDeck>
            {
                packagesData.packages.map(pkg => (
                    <ShopItem
                        key={pkg.id}
                        id={pkg.id}
                        name={pkg.name}
                        price={pkg.price}
                    />
                ))
            }
        </CardDeck>
    );
};

export default ShopItems;
