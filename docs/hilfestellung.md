
# 💡 Hilfestellung für den Workshop

### **Schritt 1: Einstieg & Verständnis einzelner Files**

**Prompts zum Einstieg:**
- `Erkläre mir die Funktion und das Ziel der Klasse BookRepository.java in einfachen Worten.`
- `Beschreibe, was das Modul Series.java macht und wie es mit anderen Teilen des Projekts zusammenhängt.`

**Ziel:**  
Verstehe den Inhalt und die Logik des Codes – das hilft später beim gezielten Refactoren.

---

### **Schritt 2: Erste Schwächen in einzelnen Klassen/Methoden finden**

**Prompts zur Codeanalyse:**
- `Findest du in BookRepository.java typische CodeSmells oder Qualitätsmängel? Notiere sie bitte in einer Liste.`
- `Analysiere die Methode filterBooks in BookRepository.java und liste mögliche Problemstellen oder Verbesserungsmöglichkeiten auf.`
- `Welche Schwächen im Bezug auf Lesbarkeit oder Wartbarkeit hat die Klasse SeriesRepository.java?`

**Ziel:**  
Gezielt Schwächen pro Datei/Methode aufdecken.

---

### **Schritt 3: Gezielte Verbesserung der einzelnen Methoden/Klassen**

**Prompts zur Korrektur und Refaktorisierung (startklein):**
- `Schlage sinnvolle Refactoring-Maßnahmen für die Klasse BookRepository.java vor – bitte mit Beispielcode!`
- `Erkläre an einem Code-Vergleich, wie du Magic Numbers in SeriesRepository.java durch Konstanten ersetzen würdest.`

**Ziel:**  
Einzelne Methoden klassennah, iterativ modernisieren und verbessern.

---

### **Schritt 4: Schwächen und Verbesserungen im Zusammenspiel mehrerer Komponenten**

**Prompts zur übergreifenden Optimierung:**
- `Gibt es Überschneidungen oder doppelten Code zwischen BookRepository.java und SeriesRepository.java? Wie kann man das besser strukturieren?`
- `Wie würdest du die Geschäftslogik aus den Controllern (BookController.java) sinnvoll in Services auslagern und trennen?`
- `Schlage vor, wie JSON-Serialisierung im gesamten Projekt vereinheitlicht und modernisiert werden kann.`

**Ziel:**  
Die Struktur des Projekts als Ganzes überdenken und gezielte Optimierungen anregen.

---

### **Schritt 5: Komplettes Projekt-Review & Refactoring starten**

**Prompts zur umfassenden Modernisierung:**
- `Reviewe das komplette Projekt und liste alle großen Schwächen sowie Verbesserungspotenziale in Struktur, Architektur und Sicherheit auf.`
- `Gib einen Plan ab, wie du das gesamte Projekt mit modernen Best Practices refaktorisieren würdest (Schichten, DTOs, Logging, Fehlerbehandlung).`
- `Erstelle einen ersten Entwurf für ein modernes, sauberes Projekt-Layout und gib Beispielcode für zentrale Klassen.`

**Ziel:**  
Nach und nach von Detail- zu Gesamtbetrachtung steigern und dabei die LLMs als Review- und Refactoring-Coach nutzen.
