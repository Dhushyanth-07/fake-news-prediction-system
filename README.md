# 📰 Fake News Prediction System

A full-stack Fake News Detection application built using Java (Spring Boot) and a custom Logistic Regression model.

## 🚀 Features
- Title-based Fake/Real news classification
- Hashing-based text vectorization for memory efficiency
- REST API for prediction
- Interactive frontend using HTML, CSS, JavaScript
- Input validation for reliable predictions

## 🛠 Tech Stack
- Java
- Spring Boot
- Logistic Regression (Custom Implementation)
- Hashing Vectorizer
- HTML, CSS, JavaScript

## 📌 How It Works
1. User enters news text in the frontend.
2. JavaScript sends a POST request to `/predict`.
3. Backend checks rule-based fake triggers.
4. Text is vectorized using hashing technique.
5. Logistic Regression predicts Fake or Real.
6. Result is returned to UI.

## ▶ Run Instructions
1. Run `FakeNewsBackendApplication.java`
2. Open `frontend/index.html` in browser
3. Enter news and click Predict
## 📸 Screenshots

### Application UI
![UI](screenshots/ui.png)

### Prediction Result
![Result](screenshots/ui.png)

## 📂 Note
Dataset files are excluded from repository due to size.