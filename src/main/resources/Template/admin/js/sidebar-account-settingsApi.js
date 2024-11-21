// // Load file sidebar-account-settings.html
// fetch('../layout/sidebar-account-settings.html')
//     .then(response => response.text())
//     .then(data => {
//         document.getElementById('sidebar-account-settings').innerHTML = data;
//     })
//     .catch(error => console.error('Error loading sidebar-account-settings:', error));



// Lấy thẻ <div> có id="sidebar-account-settings"
const accountContainer = document.getElementById('sidebarSettings');

// Đường dẫn tương đối tới file sidebar-account-settings.html
const accountPath = '../layout/sidebar-account-settings.html';

// Fetch nội dung file sidebar-account-settings.html
fetch(accountPath)
    .then((response) => {
        if (!response.ok) {
            throw new Error(`Failed to load sidebar-account-settings: ${response.statusText}`);
        }
        return response.text();
    })
    .then((data) => {
        // Đưa nội dung vào thẻ <div>
        accountContainer.innerHTML = data;
    })
    .catch((error) => {
        console.error(error);
    });
