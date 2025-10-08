# book-catalog – Workshop-Projekt

## Hintergrund
Dieses Projekt simuliert eine in die Jahre gekommene Backend-Anwendung zur Verwaltung eines Buchkatalogs. Sie ist absichtlich mit "Altlasten" und schlechtem Stil versehen, um als Grundlage für eure KI gestützte Reviews zu dienen.

**Kontext:**
- Verwaltung von Büchern und Buchreihen
- REST-API für zentrale Buchabfrage, Filterung, Hinzufügen/Löschen
- Direkter Datenbankzugriff (H2 In-Memory, JDBC)

---

## Projektstruktur
- `src/main/java/com/example/Book.java` – Buchobjekt
- `src/main/java/com/example/Series.java` – Buchreihe
- `src/main/java/com/example/BookRepository.java` – Datenbankzugriff für Bücher
- `src/main/java/com/example/SeriesRepository.java` – Datenbankzugriff für Reihen
- `src/main/java/com/example/BookController.java` – REST-Endpunkte für Bücher
- `src/main/java/com/example/SeriesController.java` – REST-Endpunkte für Reihen
- `src/main/java/com/example/Utils.java` – Hilfsfunktionen (z.B. JSON-Serialisierung)
- `src/main/java/com/example/MainApp.java` – Startpunkt, Server-Setup
- `src/main/resources/data.sql` – Datenbankschema & erste Daten
- `src/test/java/com/example/` – Tests (JUnit)

---

## Hinweise 

### Ziel des Workshops
- Identifiziere "Code Smells" und Altlasten im Projekt mithilfe von ChatGPT und Github Copilot 
- Führe gezielte Verbesserungen mithilfe der KI durch

Viel Erfolg beim Reviewen!