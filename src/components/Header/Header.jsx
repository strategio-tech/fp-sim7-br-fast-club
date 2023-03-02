import React from 'react';
import { Autocomplete } from '@react-google-maps/api';

import { AppBar, Toolbar, Typography, InputBase, Box } from '@material-ui/core';
import SearchIcon from '@material-ui/icons/Search';
import useStyles from './styles.js';
import AddRestaurant from './AddRestaurant';
import SearchButton from './Search';
import SavedButton from './Saved.jsx';
import LogoutButton from './LogoutButton.jsx';

const Header = ({ onPlaceChanged, onLoad }) => {
  const classes = useStyles();

  return (
    <AppBar position="static" className={classes.appbar}>
      <Toolbar className={classes.toolbar}>
        <Typography variant="h5" className={classes.title}>
          (add image here) Tech Taste
          {/* <img src='../../whitelogotransparentbkgd.png'></img> */}
        </Typography>
        <Box display="flex">
          <Typography variant="h6" className={classes.title}>
            <SavedButton /> 
          </Typography>
          <Typography variant="h6" className={classes.title}>
            <SearchButton />
          </Typography>
          <Typography> 
             <AddRestaurant />
          </Typography>
          <Typography variant="h6" className={classes.title}>
            <LogoutButton />
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
