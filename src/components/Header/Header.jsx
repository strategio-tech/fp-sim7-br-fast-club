import React from 'react';
import { Autocomplete } from '@react-google-maps/api';

import { AppBar, Toolbar, Typography, InputBase, Box } from '@material-ui/core';
import SearchIcon from '@material-ui/icons/Search';
import useStyles from './styles.js';
import AddRestaurant from './AddRestaurant';

const Header = ({ onPlaceChanged, onLoad }) => {
  const classes = useStyles();

  return (
    <AppBar position="static" className={classes.appbar}>
      <Toolbar className={classes.toolbar}>
        <Typography variant="h5" className={classes.title}>
          (add image here) Tech Taste
          {/* <img src='../'></img> */}
        </Typography>
        <Box display="flex">
          <Typography variant="h6" className={classes.title}>
            Saved 
          </Typography>
          <Typography variant="h6" className={classes.title}>
            Search
          </Typography>
          <Typography> 
             <AddRestaurant />
          </Typography>
          <Typography variant="h6" className={classes.title}>
            Logout
          </Typography>
        </Box>
      </Toolbar>
          {/* <Autocomplete onLoad={onLoad} onPlaceChanged={onPlaceChanged}> */}
            <div className={classes.search} >
              <div className={classes.searchIcon}>
                <SearchIcon />
              </div>
              <InputBase placeholder="Search…" classes={{ root: classes.inputRoot, input: classes.inputInput }} />
            </div>
          {/* </Autocomplete> */}
    </AppBar>
  );
};

export default Header;
