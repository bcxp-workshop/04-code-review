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