var selectedItems = [];
var selectBox = document.getElementById("departmentList");

var department = document.getElementById("department");
var departmentListIterm = selectBox.options;

// console.log(departmentListIterm);
const getSelectedItems = () => {
  // xoa het department da tick
  department.innerHTML = "";
  // department.removeChild(option);
  for (var i = 0; i < selectBox.length; i++) {
    if (selectBox.options[i].selected) {
      selectedItems = [...selectedItems, selectBox.options[i].text];
      selectBox.options[i].setAttribute("style", "display: none");
    }
  }
  var newOptions = selectedItems.map((item) => {
    var option = document.createElement("option");
    option.value = item;
    option.text = item;
    return option;
  });
  newOptions.forEach((option) => {
    department.appendChild(option);
  });
};

const removeDepartment = () => {
    var size = selectedItems.length
   for(var i = 0 ; i < size;i++){
    if(department.options[i].selected){
        // console.log(department.options[i]);
        var checked =  selectBox.querySelector(`option[value="${department.options[i].value}"]`);
        checked.removeAttribute("style")
        selectedItems.forEach((item,index) => {
            if(item === department.options[i].value){
                selectedItems.splice(index,1);
            }
        })
        department.removeChild(department.options[i])
    }
   }
    
}

