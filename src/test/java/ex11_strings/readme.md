# Oefeningen met strings

Maak een klasse StringFunctions met daarin de volgende functies

## containsAllCharacters

Deze functie krijgt volgende parameters mee:
- reference: een string waarbinnen gezocht wordt
- toBeFound: een string waarvan elk karakters in de "reference" string gezocht wordt

De functie geeft true terug wanneer *ELK* karakter in "toBeFound" ook voorkomt in "reference".

Deze regels zijn van toepassing
- de functie maakt geen onderscheid tussen kleine of hoofdletters. (a == A)
- niet alleen letters maar alle karakters kunnen in beide parameters voorkomen
- volgorde is niet belangrijk

## switchCharacters

Deze functie krijgt volgende parameters mee:
- original: de string waarin gewerkt wordt
- character1: 
- character2: twee karakters die met elkaar verwisseld moeten worden

De functie geeft een string terug waarvan elk "character1" omgewisseld is met "character2" en omgekeerd.
Bv. switchCharacters("AbCbdE", 'b', 'E') geeft als resultaat "AECEdb"

Deze regels zijn van toepassing:
- de functie maakt onderscheid tussen kleine of hoofdletters. (a != A)
- character1 en character2 kunnen elk een verschillend aantal keren voorkomen in de originele string. 