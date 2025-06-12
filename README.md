# 🌐 IoT Project – IR Sensor

## 📋 Opis projektu

Projekt umożliwia sterowanie komputerem (np. odtwarzaczem multimedialnym,
prezentacjami lub innymi funkcjonalnościami systemu) za pomocą pilota IR. Projekt ma
posłużyć wygodniejszemu korzystaniu z komputera z większej odległości (np. Siedząc na
kanapie).


## 🛠️ Technologie

• Odbiornik podczerwieni VS1838B (IR) – podłączony do pierwszego komputera przez Arduino Uno.

• Płytka stykowa

• Pilot IR – uniwersalny pilot od tv SONY (RM-ED062) do wysyłania komend.

• Komputer 1 (klient, np. laptop) – odbiera sygnały IR i przesyła je do serwera.

• Komputer 2 (serwer, Spring Boot) – obsługuje żądania i umożliwia zdalne sterowanie klientem przez internet.

• Komunikacja internetowa – komputer klient wysyła żądania do serwera przez REST API

## 🔄 Scenariusz działania 

1. Użytkownik naciska przycisk na pilocie.
2. Czujnik IR podłączony do płytki Arduino Uno odbiera sygnał i przesyła go przy pomocy interfejsu UART do komputera klienta do aplikacji (zrealizowanej np. W Pythonie).
3. Aplikacja przesyła kod IR do serwera Spring Boot.
4. Serwer interpretuje sygnał i decyduje o akcji (np. zmiana slajdu, regulacja głośności, włączenie filmu).
5. Serwer wysyła odpowiednią komendę zwrotną do komputera klienta.
6. Klient wykonuje akcję, np. symuluje naciśnięcie klawisza lub uruchamia skrypt sterujący programem. 
