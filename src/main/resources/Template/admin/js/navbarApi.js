// // Load file navbar.html
// fetch('../layout/navbar.html')
//     .then(response => response.text())
//     .then(data => {
//         document.getElementById('navbar').innerHTML = data;
//     })
//     .catch(error => console.error('Error loading navbar:', error));



// Lấy thẻ <div> có id="navbar"
const navbarContainer = document.getElementById('navbar');

// Đường dẫn tương đối tới file navbar.html
const navbarPath = '../layout/navbar.html';

// Fetch nội dung file navbar.html
fetch(navbarPath)
    .then((response) => {
        if (!response.ok) {
            throw new Error(`Failed to load navbar: ${response.statusText}`);
        }
        return response.text();
    })
    .then((data) => {
        // Đưa nội dung vào thẻ <div>
        navbarContainer.innerHTML = data;  
    })
    .catch((error) => {
        console.error(error);
    });
