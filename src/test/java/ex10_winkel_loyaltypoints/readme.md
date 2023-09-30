# Winkel korting punten

Schrijf een klasse die de klantpunten van een winkel moet voorstellen. Bij elke aankoop krijgt een klant
een aantal punten toegevoegd aan zijn of haar klantenrekening. Met die punten kan de klant dan korting krijgen
op een toekomstige aankoop. De gegevens worden in het geheugen bewaard, niet in een database. 
Die gegevens zijn de naam van een persoon en het aantal punten op de rekening.

- Als een klant nog geen rekening heeft, wordt er een nieuwe gemaakt
- Als een klant wel een rekening heeft, wordt het aantal punten verhoogd met het nieuwe aantal
- Het aantal nieuwe punten wordt berekend op het totaalbedrag van de aankoop (1 punt per 20€)
- Punten zijn gehele getallen, geen kommagetallen
- Elk punt is 2€ waard bij een toekomstige aankoop

De klasse heeft de volgende functies:
- newSale(name, totalAmount)
- getClientPoints(name)
- getPointTotal → geeft het totaal aantal punten voor de winkel
- getPointTotalAmount → geeft het totaalbedrag voor het totaal aantal punten (1 punt = 2€)