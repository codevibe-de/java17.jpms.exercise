# Übungen

## 1. Start der Anwendung

Starten Sie die Anwendung über die Main-Class `application.BookApplication` in Ihrer IDE.

Untersuchen Sie das Kommando, mit dem die Anwendung gestartet wurde und insbesondere, wie der Classpath aufgebaut wird.

In **Eclipse** öffnen Sie dazu die zugehörige *Run Configuration* und schauen Sie sich die Einstellungen an:
- Menü *Run* > *Run Configurations...*
- Wählen Sie die Konfiguration für die Klasse `application.BookApplication` aus
- Klicken Sie den Button *Show Command Line*

In *IntelliJ IDEA* finden Sie das ausgeführte Kommando als erste Zeile in der Ausgabe.

## 2. Modularisierung der Anwendung

Beginnen Sie die Nutzung des Java 9 Module Systems mit der Modularisierung des `app` Moduls.

Hierzu erstellen Sie ein Modul-Deskriptor-File `module-info.java` im Verzeichnis `./app/src/main/java` mit den folgenden
Inhalten:

- Modul-Name `jpms.app`

Versuchen Sie nun, die Anwendung zu kompilieren oder zu starten. Entweder in der IDE oder
wenn gewünscht auch über Maven mittels `mvnw clean compile`