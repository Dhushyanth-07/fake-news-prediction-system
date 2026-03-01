function predict() {
    const text = document.getElementById("newsInput").value.trim();
    const resultDiv = document.getElementById("result");

    if (text === "") {
        resultDiv.innerHTML = "⚠️ Please enter some news text";
        resultDiv.className = "";
        return;
    }

    resultDiv.innerHTML = "⏳ Predicting...";
    resultDiv.className = "";

    fetch("http://localhost:8080/predict", {
        method: "POST",
        headers: {
            "Content-Type": "text/plain"
        },
        body: text
    })
    .then(response => response.text())
    .then(data => {

        if (data.startsWith("Enter detailed")) {
            resultDiv.innerHTML = "⚠️ " + data;
            resultDiv.className = "";
            return;
        }

        if (data.includes("FAKE")) {
            resultDiv.innerHTML = "🚨 FAKE NEWS";
            resultDiv.className = "fake";
        } else {
            resultDiv.innerHTML = "✅ REAL NEWS";
            resultDiv.className = "real";
        }
    })
    .catch(error => {
        resultDiv.innerHTML = "❌ Backend not running";
        resultDiv.className = "";
    });
}