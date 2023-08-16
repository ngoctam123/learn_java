const handle = (event)=>{
    var navLinks = document.getElementsByClassName('nav-link');

    // Xóa lớp 'active' khỏi tất cả các thẻ <a>
    for (var i = 0; i < navLinks.length; i++) {
      navLinks[i].classList.remove('active');
    }

    // Thêm lớp 'active' cho thẻ <a> được nhấp vào
    event.target.classList.add('active');
    
    // elmNav.setAttribute(className, 'active');
}