function filterProcessKind() {
    let input = document.querySelector('select#process-kind-sel');
    let li = document.querySelectorAll('ul.process-kinds > li');

    for (let i = 0; i < li.length; i++) {
        let liClass = li[i].className;
        if (input.value === liClass || input.value === "none") {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}
