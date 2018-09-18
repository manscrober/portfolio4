------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Library
PURPOSE OF PROJECT: Simple project to support the business processes of a library
VERSION or DATE: Aug 2017
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS: 
- Siehe Aufgabenstellung
- Nutzen Sie unten stehendes Template
- Markieren Sie korrekte Aussagen mit einem X (also [X] ), die anderen lassen Sie bitte einfach leer
- Kurze Begründung: 1-2 Sätze, bzw., wenn passend, die konkreten Beispiele (also z.B. Klasse X greift Variable Z der Klasse Y zu)

------------------------------------------------------------------------
1. und 2. Aufgabe - Kopplung und Kohäsion

------------------------------------------
### Book

--------------------
## Kopplung

#Book -> Library 
[] Lose Kopplung
[X] Enge Kopplung

Kurze Begründung: Book greift auf books und clients in Library zu.

#Book -> Client 
[] Lose Kopplung
[X] Enge Kopplung

Kurze Begründung: Book greift auf borrowedBooks in Client zu.

--------------------
## Kohäsion

[X] Niedrig
[] Hoch

Kurze Begründung:addAndBorrowBook vs addAndBorrowCD,CDs als boolean in Büchern,

--------------------
## Probleme

------------------------------------------
### Client

--------------------
## Kopplung

#Client -> Library 
[] Lose Kopplung
[X] Enge Kopplung

Kurze Begründung: Client greift auf clients in Library zu

#Client -> Book
[] Lose Kopplung
[X] Enge Kopplung

Kurze Begründung: Client greift auf caption in Book zu

--------------------
## Kohäsion

[X] Niedrig
[] Hoch

Kurze Begründung: Hinzufügen von clients aus Client-Objekten, obwohl in Library gespeichert,
es gibt returnBook aber nicht returnCD. stattdessen wäre vielleicht besser (Namensgebung)

--------------------
## Probleme

------------------------------------------
### Library

--------------------
## Kopplung

#Library -> Client 
[] Lose Kopplung
[X] Enge Kopplung

Kurze Begründung: Library greift auf borrowedBooks in client zu.

#Library -> Book
[] Lose Kopplung
[X] Enge Kopplung

Kurze Begründung: Library greift auf caption und category in Book zu

--------------------
## Kohäsion

[X] Niedrig
[] Hoch

Kurze Begründung:Hinzufügen von clients nur aus Client-Objekten, obwohl in Library gespeichert.
addBook, obwohl books public. Library selbst trägt als eigentlicher Focus des Projekts sehr wenig Funktionalität.

--------------------
## Probleme

------------------------------------------
### Diskussion