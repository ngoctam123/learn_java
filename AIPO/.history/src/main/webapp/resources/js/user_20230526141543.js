  var selectedItems = [];
    var selectBox = document.getElementById("departmentList");
    var department = document.getElementById("department");

    const getSelectedItems = () => {
        department.innerHTML = "";
        for (var i = 0; i < selectBox.length; i++) {
            if (selectBox.options[i].selected) {
                selectedItems = [...selectedItems, selectBox.options[i].value];
                selectBox.options[i].setAttribute("style", "display: none");
            }
        }

        var newInputHiden = selectedItemsmap((item) => {
            var inputHiden = document.createElement("input");
            inputHiden.setAttribute("style", "display:none");
            inputHiden.value = item;
            inputHiden.name = "departmentInput";
            return option;
          });
        
        var newOptions = selectedItems.map((item) => {
            var option = document.createElement("option");
            option.value = item;
            option.text = item;
            return option;
        });
        newInputHiden.forEach((item) => {
            department.appendChild(item);
        });

        newOptions.forEach((option) => {
            department.appendChild(option);
        });
    };

    const removeDepartment = () => {
    var selectedOptions = [...department.selectedOptions];
    selectedOptions.forEach((option) => {
        var checked = selectBox.querySelector(`option[value="${option.value}"]`);
        checked.removeAttribute("style");
        selectedItems = selectedItems.filter((item) => item !== option.value);
        department.removeChild(option);
    });
};