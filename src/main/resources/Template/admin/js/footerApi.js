// // Load file footer.html
// fetch('../layout/footer.html')
//     .then(response => response.text())
//     .then(data => {
//         document.getElementById('footer').innerHTML = data;
//     })
//     .catch(error => console.error('Error loading footer:', error));



// Lấy thẻ <div> có id="footer"
const footerContainer = document.getElementById('footer');

// Đường dẫn tương đối tới file footer.html
const footerPath = '../layout/footer.html';

// Fetch nội dung file footer.html
fetch(footerPath)
    .then((response) => {
        if (!response.ok) {
            throw new Error(`Failed to load footer: ${response.statusText}`);
        }
        return response.text();
    })
    .then((data) => {
        // Đưa nội dung vào thẻ <div>
        footerContainer.innerHTML = data;
    })
    .catch((error) => {
        console.error(error);
    });
