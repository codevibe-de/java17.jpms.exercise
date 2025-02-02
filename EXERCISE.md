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
optional auch über Maven (mittels `mvnw clean compile`).

## 3. Modularisierung der Bibliothek

Fahren Sie fort mit der Modularisierung des `book-core` Moduls.

Dazu erstellen Sie ein Modul-Deskriptor-File `module-info.java` im Verzeichnis `./book-core/src/main/java`
mit den folgenden Inhalten:

- Modul-Name `jpms.book.core`
- Export des Packages `book.api`
- Import des Moduls `org.apache.commons.lang3`

Nun müsste die Anwendung wieder kompilierbar und ausführbar sein.

## 4. Öffnung für Reflection

Entkommentieren Sie nun die zwei Zeilen rund um die Erstellung des Publishers.

Was passiert wenn Sie die Anwendung nun ausführen?

Beheben Sie das Problem, indem Sie das Modul `jpms.book.core` für Reflection öffnen.

## 5. Verwendung von ServiceLoader

Verwenden Sie das **ServiceLoader-Pattern** um im Modul `app` eine
`BookService` Implementierung zu laden und zu verwenden. Der Singleton Zugriff soll dann entfallen.

Dazu muss folgendes passieren:

- Deklaration des bereitgestellten Service im Modul-Deskriptor von `jpms.book.core` mittels `provides` Keyword
- Nutzung des Service im Modul-Deskriptor von `app` mittels `uses` Keyword
- Lookup des Service im Source-Code von `app` wie folgt:
    ```java
          BookService bookService = ServiceLoader.load(BookService.class)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No BookService found"));
    ```
  
## 6. Starter-Modul

Nutzen Sie das vorhandene `book-starter` Subprojekt, um dies zu einem "Starter" Modul zu machen.
Ein Starter ist typischerweise eine leere Bibliothek (d.h. ohne Klassen), die einfach nur anderen
Bibliotheken (bzw. hier Module) transitiv einbindet.

Hier brauchen Sie dann das Keyword `requires transitive` im Modul-Deskriptor, um die
drei anderen Module (nämlich `book-core`, `book-io` und `book-report`) transitiv zu importieren.

Nun können Sie aus der `app` Anwendung heraus nur noch das `book-starter` Modul importieren und
erhalten implizit Zugriff auf die anderen Module.

## 7. Verwendung von `jdeps`

Nutzen Sie das Tool `jdeps` um die Abhängigkeiten der Module zu analysieren.

Dies erfolgt auf der Kommandozeile:

```shell
jdeps --module-path app/target/classes:app/target/dependency --multi-release 9 --module jpms.app  
```
