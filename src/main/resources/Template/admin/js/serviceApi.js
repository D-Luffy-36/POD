// // Load file sidebar.html
// fetch('../layout/sidebar.html')
//     .then(response => response.text())
//     .then(data => {
//         document.getElementById('sidebar').innerHTML = data;
//     })
//     .catch(error => console.error('Error loading sidebar:', error));



// Lấy thẻ <div> có id="sidebar"
const sidebarContainer = document.getElementById('sidebar');

// Đường dẫn tương đối tới file sidebar.html
const sidebarPath = '../layout/sidebar.html';

// Fetch nội dung file sidebar.html
fetch(sidebarPath)
    .then((response) => {
        if (!response.ok) {
            throw new Error(`Failed to load sidebar: ${response.statusText}`);
        }
        return response.text();
    })
    .then((data) => {
        // Đưa nội dung vào thẻ <div>
        sidebarContainer.innerHTML = data;
    })
    .catch((error) => {
        console.error(error);
    });
