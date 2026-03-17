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
let departureAerodromeInput;
let destinationAerodromeInput;
let startTimeInput;
let stopTimeInput;

/**
 * Load the main elements, constants and link events once the DOM is loaded
 */
document.addEventListener("DOMContentLoaded", () => {
    const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
    const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
    flightForm = document.getElementById("flightForm");
    gliderBtn = document.getElementById("gliderBtn");
    aircraftSelect = document.getElementById("aircraftId");
    towAirplaneSelect = document.getElementById("towAirplaneId");
    towAirplaneSection = document.getElementById("towAirplaneSection");
    aircraftTypeInput = document.getElementById("aircraftType");
    departureAerodromeInput = document.getElementById("destinationId");
    destinationAerodromeInput = document.getElementById("destinationId");
    startTimeInput = document.getElementById("startTime");
    stopTimeInput = document.getElementById("stopTime");
    towSectionCollapse = new bootstrap.Collapse(towAirplaneSection, {toggle: false});

    // Start linking event listeners
    flightForm.addEventListener("submit", event => validateForm(event));
    aircraftSelect.addEventListener("change", event => handleAircraftSelection(event));
});



function validateForm(event) {
    if (!flightForm.checkValidity()){
        event.preventDefault();
        event.stopPropagation();
    }

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
