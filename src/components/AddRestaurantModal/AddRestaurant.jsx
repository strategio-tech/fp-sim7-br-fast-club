import React from 'react';

const AddRestaurant = () => {

    return (
        <div>
            <a href="#modal-opened" class="link-1" id="modal-closed">Add Restaurant</a>

            <div class="modal-container" id="modal-opened">
            <div class="modal">

            <div class="modal__details">
            <h1 class="modal__title">Add a Restaurant</h1>
            <p class="modal__description">Add your favorite restaurant for other users to view.</p>
            </div>

            <section className="addResForm">
                <div class="inputBox">
                    <input type="text" required="required"/>
                    <span>Full Name</span>
                </div>

                <div class="inputBox">
                    <input type="text" required="required"/>
                    <span>Description</span>
                </div>
        
            </section>

             <button class="modal__btn">Add &rarr;</button>

            <a href="#modal-closed" class="link-2"></a>

        </div>
        </div>
            {/* I think this is more for dark mode */}
            <a href="https://codepen.io/AbubakerSaeed/full/eYOvKpY" class="second-version-link" target="_blank">CSS Modals (Modal v2)</a>

            <a href="https://abubakersaeed.netlify.app/designs/d7-modal" class="abs-site-link" rel="nofollow noreferrer" target="_blank">abs/designs/d7-modal</a>
        </div>
    );
};

export default AddRestaurant