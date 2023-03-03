import "./addrestaurant.css"
import restaurants_data from '../../data/restaurants.json';
import { useState } from "react";
// import {writeJsonFile} from 'write-json-file';


export default function AddRestaurant () {

    let restaurants = restaurants_data.data;
    // const history = useHist

    const [filteredData, setFilteredData] = useState([]);
    const [wordEntered, setWordEntered] = useState("");
    const [fullName, setFullName] = useState("");
    const [description, setDescription] = useState("");
    const [saving, setSaving] = useState({});


    // const fillTheBar = e => {

    // }

    const saveToCollection = () => {
        setFullName("");
        setDescription("");
        setSaving({});
        setWordEntered("");
        window.location.href="#modal-closed";
        // history.push()
        // console.log(writeJsonFile);
        // const fs = window.require('fs');
        // let rawdata = fs.readFileSync('../../data/collection.json');
        // console.log(rawdata);
    }

    const handleFilter = (event) => {
        setSaving({});
        const searchWord = event.target.value;
        setWordEntered(searchWord);
        const newFilter = restaurants.filter((r) => {
            // console.log(r.name);
            if(r.name){
                return r.name.toLowerCase().includes(searchWord.toLowerCase());
            }
        });

        if (searchWord === "") {
          setFilteredData([]);
        } else {
          setFilteredData(newFilter);
        }
      };

    return (
        <div className="modalBody">
            <a href="#modal-opened" class="link-1" id="modal-closed">Add Restaurant</a>

            <div class="modal-container" id="modal-opened">
            <div class="modal">

            <div class="modal__details">
            <h1 class="modal__title">Add Restaurant</h1>
            <p class="modal__description">Add your favorite restaurant for other users to view.</p>
            </div>

            <section className="addResForm">
                <div class="inputBox">
                    <input type="text" required="required" value={fullName} onChange={(e) => setFullName(e.target.value)}/>
                    <span>Full Name</span>
                </div>

                <div class="inputBox">
                    <input className="rest-search" type="text" required="required" value={wordEntered} onChange={handleFilter}/>
                    {filteredData.length != 0 && (
                        <div className="dataResult">
                            {filteredData.slice(0,15).map(r => {
                                return (
                                    <div className="dataItem" onClick={e => {setWordEntered(r.name); setFilteredData([]); setSaving(r)}}>
                                        <p>{r.name}</p>
                                    </div>
                                )
                            })}
                        </div>
                    )}
                    <span>Search Restaurant</span>
                </div>

                <div class="inputBox">
                    <input type="text" required="required" value={description} onChange={(e) => setDescription(e.target.value)}/>
                    <span>Description</span>
                </div>

            </section>

             <button class="modal__btn" disabled={!saving.name || !description || !fullName} style={{cursor:(!saving.name || !description || !fullName)?"not-allowed":"pointer"}} onClick={saveToCollection}>{
                (!saving.name || !description || !fullName)?"Fill to Add":"Add!"
             }&rarr;</button>

            <a href="#modal-closed" class="link-2"></a>

        </div>
        </div>
            {/* I think this is more for dark mode */}
            {/* <a href="https://codepen.io/AbubakerSaeed/full/eYOvKpY" class="second-version-link" target="_blank">CSS Modals (Modal v2)</a>

            <a href="https://abubakersaeed.netlify.app/designs/d7-modal" class="abs-site-link" rel="nofollow noreferrer" target="_blank">abs/designs/d7-modal</a> */}
        </div>
    );
};
