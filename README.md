# ProjektarbeitEventplaner

### Projektbeschreibung

Wir sind Elena und Nina und planen sowie organisieren schon seit längerer Zeit gerne Geburtstage, Partys und andere Feiern. Um dabei den Überblick zu behalten, entstand die Idee eines Eventplaners, der dabei hilft Events strukturiert zu verwalten.

Diese Projektarbeit beinhaltet die Umsetzung eines Eventplaners in Java mit grafischer Benutzeroberfläche. Ziel des Programms ist es, Events zu erfassen, zu verwalten und zeitnah anstehende Events übersichtlich darzustellen. Zusätzlich bietet der Eventplaner die Möglichkeit, Events gefiltert anzuzeigen, um relevante Termine schnell wiederzufinden.

### Projektstruktur

Das Programm besteht aus zwei zentralen Klassen.


**Die Klasse `Event.java`**

Die Klasse Event ist die zentrale Klasse zur Speicherung und Verarbeitung von Eventdaten.

Funktionen: 
- Verwaltung der Eventinformationen (Name, Beschreibung, Location, Kosten, Datum)
- Prüfen, ob ein Event in naher Zukunft stattfindet (mithilfe der Methode `checkTimely`, welche feststellt, ob das Event in den nächsten 30 Tagen stattfindet)
- Bereitstellung von Getter-Methoden für die Anzeige in der Benutzeroberfläche

**Die Klasse `EventPlanerGUI.java`**

Die Klasse EventPlanerGUI ist für die grafische Benutzeroberfläche zuständig.

Funktionen:
- Aufbau und Gestaltung der Oberfläche mithilfe von Java Swing
  - durch ein `GridBagLayout` werden die verschiedenen Komponenten angeordnet
- Erfassen der Benutzereingaben
- Anlegen neuer Event-Objekte
- Darstellung der Events in einer Tabelle
  - mithilfe von `JTable` werden die Eventaten übersichtlich angezeigt

### Nutzung des Programms

Beim Aufruf des Programms öffnet sich ein Fenster mit Eingabefeldern und Buttons.
In folgendem Format kann man ein Event anlegen: Eventname, Beschreibung, Location, Kosten in Euro, Datum(YYYY-MM-DD) eingeben.
Durch klicken des Speichern-Buttons wird das neue Event-Objekt in einer internen Liste gespeichert. Alle gespeicherten Events kann man durch den Alle Events-Button anzeigen lassen. In der Ansicht Nächste Events werden Events, welche in den nächsten 30 Tagen stattfinden, angezeigt. Die Tabellenansicht ist sortierbar (alphabetisch).
