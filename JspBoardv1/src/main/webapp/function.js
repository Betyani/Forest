console.log("✅ function.js 로딩 성공");

function validateForm() {
      
    const title = document.forms["form"]["title"].value.trim();
    const id = document.forms["form"]["id"].value.trim();
    const content = document.forms["form"]["content"].value.trim();

    if (title === "" || id === "" || content === "") {
        alert("모든 항목을 입력해야 합니다.");
        return false;
    }
    return true;
}
