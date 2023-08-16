  var selectedItems = [];
    var selectBox = document.getElementById("departmentList");
    var department = document.getElementById("department");
    var modal_body_form = document.getElementById("modal_body_form");
    var form = document.querySelector("#user");
    var selectedSearch = document.getElementById("search");
    var btnSearch  = document.getElementById("searchBtn");
    var newInputHiden = document.createElement("input");
  	newInputHiden.setAttribute("type", "hiden");
    newInputHiden.setAttribute("name", "departmentHiden");
    newInputHiden.setAttribute("style", "display:none;");
    newInputHiden.setAttribute("class", "form-control");
    newInputHiden.setAttribute("id", "departmentHiden");
     
    modal_body_form.appendChild(newInputHiden);



    const getSelectedItems = () => {
        department.innerHTML = "";
        for (var i = 0; i < selectBox.length; i++) {
            if (selectBox.options[i].selected) {
                selectedItems = [...selectedItems, selectBox.options[i].value];
                selectBox.options[i].setAttribute("style", "display: none");
            }
        }

        var newValueInputHiden = selectedItems.map((item) => (
            `${item}`
        )).join(",");
        var inputHiden = document.querySelector("#departmentHiden");
		
        inputHiden.innerHTML = newValueInputHiden;
        inputHiden.value = newValueInputHiden;
        var newOptions = selectedItems.map((item) => {
            var option = document.createElement("option");
            option.value = item;
            option.text = item;
            return option;
        });
        
 form.action = "/AIPO/user/saveOrUpdate/"+newValueInputHiden;
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

const handleSelectedSearch  = () => {
    for(var i =0; i <selectedSearch.length;i++){
        if (selectedSearch.options[i].selected) {
            btnSearch.setAttribute("href", "${pageContext.request.contextPath}/user/list?searchSelectBox="+selectedSearch.options[i].value)
        }
    }
}