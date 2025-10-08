
# 💡 Hilfestellungen für den Workshop

## Mögliche Schwächen im Code

Achte besonders auf folgende Probleme („Code Smells“ & Anti-Patterns):

- **Fehlende Kapselung:** Public-Felder, keine Getter/Setter
- **Magic Numbers:** Konstante Werte direkt im Code
- **Unsichere SQL-Strings:** Manuelle Query-Strings (SQL-Injection-Gefahr)
- **God Methods:** Methoden mit zu vielen Aufgaben
- **Komplexe SQL-Queries:** Schwer lesbar und wartbar
- **Manuelle JSON-Serialisierung:** Statt moderner Bibliotheken
- **Wiederholte Logik:** Kopier- und Serialisierungslogik
- **Fehlende Fehlerbehandlung:** Leere Catches, kein Logging
- **Business-Logik im Controller/Repository**
- **Direkte Datenbankzugriffe:** Ohne PreparedStatements
- **Kryptische Variablennamen**
- **Schlechte Dokumentation/Kommentare**
- **Doppelter Code, wenig Wiederverwendung**
- **Fehlende Trennung von Verantwortlichkeiten**

---

## Bonusaufgabe: Neue Funktionalität mit KI generieren

Falls noch Zeit ist, generiere eine neue Funktionalität komplett mit KI. Beispiele:

### Preisstatistik/Report

Implementiere einen neuen REST-Endpunkt `/books/report`, der folgende Statistiken liefert:
- Durchschnittspreis aller Bücher
- Anzahl verfügbarer Bücher
- Teuerstes und günstigstes Buch (inkl. Titel & Preis)
- Gruppierung nach Genre (wie viele Bücher pro Genre)

Nutze KI zur Generierung von SQL, Aggregationslogik und JSON-Ausgabe.

### Weitere Ideen

- Verfügbarkeits-Check für eine ganze Reihe
- Autoren-Statistik (z.B. Bücher pro Autorin, Durchschnittspreis pro Autorin)
- REST-Endpunkt für Bücher in einer bestimmten Preisspanne
- Komplexere Suchen: Fuzzy-Suche, Filter mit mehreren Parametern

---

## Tipps & Tricks: KI (Copilot/ChatGPT) richtig prompten

- **Sei präzise:** Schildere konkret, was du möchtest  
	*Beispiel:* „Reviewe Methode xyz auf Lesbarkeit und Effizienz“
- **Kontext geben:** Nenne Zweck/Aufgabenbereich der Klasse/Methode
- **Verbesserungen anfordern:** Bitte um Empfehlungen oder Alternativen  

---