document.getElementById('appraisalForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const employeeName = document.getElementById('employeeName').value;
    const performanceScore = document.getElementById('performanceScore').value;

    // Create the data object to send to the backend
    const data = {
        name: employeeName,
        score: performanceScore
    };

    // Send a POST request to the backend API
    fetch('http://localhost:8080/api/appraisals', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        // Redirect to the result page with the performance score as a query parameter
        window.location.href = `result.html?score=${performanceScore}`;
    })
    .catch(error => {
        const resultDiv = document.getElementById('result');
        resultDiv.innerHTML = `<h2>Error</h2><p>${error.message}</p>`;
    });
});