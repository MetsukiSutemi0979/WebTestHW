# WebTestHW — Selenium WebDriver: форма заявки

[![Java CI with Gradle](https://github.com/MetsukiSutemi0979/WebTestHW/actions/workflows/gardle.yml/badge.svg)](https://github.com/MetsukiSutemi0979/WebTestHW/actions/workflows/gardle.yml)

Домашняя работа курса «Тестировщик»: автоматизация формы заявки на Selenium WebDriver (без обёрток).

## Что покрыто
- Заполнение полей (имя, телефон), принятие соглашения, отправка формы
- Проверка экрана успеха: видимость элемента и точный текст сообщения
- Headless-запуск Chrome (`--headless`, `--no-sandbox`)

## Стек
- Java 11, Gradle, JUnit 5
- Selenium WebDriver 4.18 + WebDriverManager 5.7 (автоскачивание драйвера)
- CI: GitHub Actions (бейдж выше)

## Запуск
```PowerShell
java -jar ./artifacts/app-order.jar   # SUT на localhost:9999
./gradlew clean test
```