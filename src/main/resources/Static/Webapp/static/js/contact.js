// Lấy các phần tử HTML
const contactModal = document.getElementById("contactModal");
const contactOverlay = document.getElementById("contactOverlay");
const contactLink = document.getElementById("contactModalLink");
const contactCloseBtn = document.getElementsByClassName("contact-close")[0];

// Khi nhấn vào liên kết "Liên Hệ"
contactLink.onclick = function(event) {
    event.preventDefault();
    contactOverlay.style.display = "block"; // Hiển thị overlay
    contactModal.style.display = "block"; // Hiển thị modal
}

// Khi nhấn vào nút đóng (x)
contactCloseBtn.onclick = function() {
    contactOverlay.style.display = "none"; // Ẩn overlay
    contactModal.style.display = "none"; // Đóng modal
}

// Khi nhấn vào overlay cũng sẽ đóng modal
contactOverlay.onclick = function() {
    contactOverlay.style.display = "none";
    contactModal.style.display = "none";
}
