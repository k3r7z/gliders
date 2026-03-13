/**
 * Constats
 * @type {string}
 */
const PLANE_OPT = "Avión";
const GLIDER_OPT = "Planeador";

/**
 * Declare common elements variables
 */
let gliderBtn;
let aircraftSelect;
let towAirplaneSelect;
let towAirplaneSection;
let towSectionCollapse;
let aircraftTypeInput;
let flightForm;

/**
 * Load the main elements, constants and link events once the DOM is loaded
 */
document.addEventListener("DOMContentLoaded", () => {
    flightForm = document.getElementById("flightForm");
    gliderBtn = document.getElementById("gliderBtn");
    aircraftSelect = document.getElementById("aircraftId");
    towAirplaneSelect = document.getElementById("towAirplaneId");
    towAirplaneSection = document.getElementById("towAirplaneSection");
    aircraftTypeInput = document.getElementById("aircraftType");
    towSectionCollapse = new bootstrap.Collapse(towAirplaneSection, {toggle: false});

    // Start linking event listeners
    flightForm.addEventListener("submit", event => validateForm(event));
    aircraftSelect.addEventListener("change", event => handleAircraftSelection(event));
});



function validateForm(event) {
    if (!flightForm.checkValidity()){
        console.log("Inválido!");
        event.preventDefault();
        event.stopPropagation();
    }
    else
        console.log("Válido!");

    flightForm.classList.add("was-validated");
}

/**
 * Handles the on change event for the aircraft selection
 * @param event
 */
function handleAircraftSelection(event) {
    const selectedAircraft = aircraftSelect.options[aircraftSelect.selectedIndex];

    if(selectedAircraft.value !== "") {
        const type = selectedAircraft.getAttribute('data-type');
        aircraftTypeInput.innerText = type;
        if (type === GLIDER_OPT)
            towSectionCollapse.show();
        else {
            towSectionCollapse.hide();
            towAirplaneSelect.value = "";
        }
    }
    else aircraftTypeInput.innerText = "Tipo de aeronave";
}
