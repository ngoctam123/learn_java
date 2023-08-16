const validate = (isChange)=>{
    var idCauThu = document.getElementById("idCauThu");
    var idCLB = document.getElementById("idCLB");
    var tienChuyenNhuong = document.getElementById("tienChuyenNhuong");
    var thoiGianChuyenNhuong = document.getElementById("thoiGianChuyenNhuong");
    var isValid = true;
  
    if (idCauThu.value == "") {
      isValid = false;
      idCauThu.style.border = "1px solid red";
    }
  
    if (idCLB.value == "") {
      isValid = false;
      idCLB.style.border = "1px solid red";
    }
  
    if (tienChuyenNhuong.value == "") {
      isValid = false;
      tienChuyenNhuong.style.border = "1px solid red";
    }
  
    if (thoiGianChuyenNhuong.value == "") {
      isValid = false;
      thoiGianChuyenNhuong.style.border = "1px solid red";
    }
  
    if (!isValid) {
      alert("Please fill in all required fields!");
      return false;
    }

    if (!isChange) {
        isValid = false;
        idCLB.style.border = "1px solid red";
      }
    
}