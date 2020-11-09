import React from "react";
import {Provider} from "react-redux";
import {
    BrowserRouter as Router,
    Route,
    Switch
} from "react-router-dom";
import { store } from "../redux/store";
import NavBarContainer from './container/NavBarContainer';
import Shop from './presentational/Shop';
import ItemContainer from './container/ItemDetailsContainer';
import CartContainer from './container/CartContainer';
import NoMatch from './presentational/NoMatch';
import {Container} from "react-bootstrap";
import './App.css'

function App() {
  return (
      <Provider store={store}>
          <Router>
              <Route path="/" component={NavBarContainer} />
              <Switch>
                  <Container className="p-2">
                      <Route exact path="/" component={Shop} />
                      <Route path="/packages/:id" component={ItemContainer} />
                      <Route path="/cart" component={CartContainer} />
                  </Container>
              </Switch>
          </Router>
      </Provider>
  );
}

export default App;
