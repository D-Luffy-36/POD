// Get the modal
var modal = document.getElementById("authModal");

// Get the login and register forms
var loginForm = document.getElementById("loginForm");
var registerForm = document.getElementById("registerForm");

// Get the button that opens the modal
var loginIcon = document.querySelector(".action__login a");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// Get the links to switch between forms
var showRegister = document.getElementById("showRegister");
var showLogin = document.getElementById("showLogin");

// Get the login button
var loginButton = document.getElementById("loginButton");


// When the user clicks the login icon, open the modal and show the login form
loginIcon.onclick = function(event) {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ <a>
    modal.style.display = "block";
    loginForm.style.display = "block";
    registerForm.style.display = "none";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// When the user clicks the "Đăng ký ngay" link, show the register form
showRegister.onclick = function(event) {
    event.preventDefault();
    loginForm.style.display = "none";
    registerForm.style.display = "block";
}

// When the user clicks the "Đăng nhập" link, show the login form
showLogin.onclick = function(event) {
    event.preventDefault();
    loginForm.style.display = "block";
    registerForm.style.display = "none";
}

// Prevent form submission and handle login manually
loginButton.onclick = function(event) {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của form

    // Xử lý đăng nhập ở đây
    var password = document.getElementById("password").value;
    var username = document.getElementById("username").value;

    console.log("Tên đăng nhập:", username);
    console.log("Mật khẩu:", password);
   

    // Đóng modal sau khi đăng nhập thành công
    
}
