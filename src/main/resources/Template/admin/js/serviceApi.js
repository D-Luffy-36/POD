// Load file sidebar.html
fetch('../layout/sidebar.html')
    .then(response => response.text())
    .then(data => {
        document.getElementById('sidebar').innerHTML = data;
    })
    .catch(error => console.error('Error loading sidebar:', error));
