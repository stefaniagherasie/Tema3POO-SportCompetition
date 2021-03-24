# Tema3POO-SportCompetition
[Tema3 Programare Orientata pe Obiecte (2019-2020, seria CB)]


Tema presupune simularea unei gale de sport in cadrul careia se vor desfasura
mai multe competitii sportive precum fotbal, baschet si handbal. Se urmareste
implementarea unui sistem care inscrie jucatorii si gestioneaza competitia.

#### IMPLEMENTARE CERINTA 1

Clasa Player reprezinta tipul jucator si are are un constructor cu parametrii
si suprascrie metodele toString si compareTo, implementand interfata Comparable.
Acest lucru va fi util pentru afisare si obtinerea jucatorilor cu scor minim/maxim.

Clasa Team reprezinta entitatea de echipa si contine informatii despre echipa
si un constructor cu parametrii. Aceasta este mostenita de FootballTeam, 
HandballTeam si BasketballTeam.

Clasa TeamFactory foloseste Design Patternul Singleton care garanteaza unicitatea
acestui obiect si este folosita pentru creearea obiectelor de tip Team, lasand
subclasele sa decida ce tip de clasa sa instantieze(FootballTeam, HandballTeam 
sau BasketballTeam).

#### IMPLEMENTARE CERINTA 2

Pentru a folosi Design Pattern-ul Visitor s-au creat interfetele Visitor si 
Visitable, avand implementarea standard. Cele 4 tipuri "team" implementeaza 
Visitable si metoda accept, iar clasa TeamVisitor implementeaza Visitor
si calculeaza, in cadrul metodei visit, scorul total al fiecarei echipe, depinzand
de tipul de sport si de modalitatile de calcul din cerinta.

Pentru simularea competitiei se citesc initial datele despre competitie si 
echipele participante, tinandu-se cont de corectitudinea informatiilor.

Clasa Competition este folosita in acest caz si sunt implementate interfetele
Observer si Subject pentru Design Pattern-ul Observer. Echipele reprezinta
observatorii care vor fi notificati despre rezultatul fiecarui meci.
Competition implementeaza Subject si metodele register, unregister si 
notifyObserver. Dupa fiecare meci sunt atribuite punctele corespunzatore.
La sfarsit se afiseaza echipele aflate pe primele 3 locuri si apoi toti participantii
in ordinea intrarii in competitie, precum si locul ocupat de acestia.
