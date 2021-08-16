const copyButton = document.querySelector(".copy_button");

if (copyButton !== null) {
    copyButton.addEventListener("click", function () {
        document.querySelector(".textarea_content").select();
        document.execCommand("copy");
    });
}

const selectFileInput = document.querySelector(".select_file_input");

if (selectFileInput !== null) {
    selectFileInput.addEventListener("change", function () {
        selectFileInput.parentElement.childNodes[1].textContent = this.files[0].name;
    });
}
