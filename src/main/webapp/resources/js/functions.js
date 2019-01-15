function modifyDiscipline() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select discipline!");
        return;
    }

    if (items.length > 1) {
        alert("Please select only one discipline!");
        return;
    }

    var idSelected = $(items).attr("id");
    $('#selectedId').val(idSelected);
    $('#discipline-modify-form').submit();
}

function deleteDiscipline() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select at least one discipline!");
        return;
    }

    var idsSelected = "";
    for (var i = 0; i < items.length; ++i) {
        idsSelected = idsSelected + $(items[i]).attr("id") + ",";
    }

    $("#idDelete").val(idsSelected);
    $('#delete-discipline-form').submit();

}

function deleteStudents() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select at least one student!")
    }

    var studentIdSelected = "";
    for (var i = 0; i < items.length; i++) {
        studentIdSelected += $(items[i]).attr("id") + ",";
    }
    $("#studentDelete").val(studentIdSelected);
    $('#delete-student-form').submit();
}

function modifyStudent() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select student!");
        return;
    }
    if (items.length > 1) {
        alert("Please select only one student!");
        return;
    }

    var studentIdSelected = $(items).attr("id");
    $("#studentIdHidden").val(studentIdSelected);
    $('#student-modify-form').submit();
}

function studentProgress() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select student!");
        return;
    }
    if (items.length > 1) {
        alert("Please select only one student!");
        return;
    }

    var studentIdSelected = $(items).attr("id");
    $("#studentIdProgress").val(studentIdSelected);
    $('#student-progress-form').submit();

}

function deleteTerm() {
    var items = $("input[type=checkbox]:checked")
    var idsSelected = "";
    for (var i = 0; i < items.length; ++i) {
        idsSelected = idsSelected + $(items[i]).attr("id") + ",";
    }

    $("#idTermDelete").val(idsSelected);
    $('#delete-term-form').submit();

}