document.onclick = function (event) {
	var modal = document.getElementById('terms');
	console.log(event.target)
	if (event.target == modal) {
		modal.style.display = "none";
	}
}
