document.addEventListener("DOMContentLoaded", () => {
    const dynamicForm = new bootstrap.Carousel("#dynamicForm");
    const airplaneBtn = document.getElementById("airplaneBtn");
    const gliderBtn = document.getElementById("gliderBtn");
    const aircraftSelect = document.getElementById("aircraftId");
    const towAirplaneSelect = document.getElementById("towAirplaneId");

    airplaneBtn.addEventListener("click", (event) => {
        dynamicForm.next();
    });

});

