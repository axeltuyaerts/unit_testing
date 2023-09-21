# TDD Exercise - HelloFresh

## Requirements:

We schrijven een aantal utility classes die gebruikt zullen worden in een HelloFresh applicatie.

* We hebben een database met recepten.
* Elk van deze recepten heeft een ingrediëntenlijst.
* De afzonderlijke ingrediënten zijn bedoeld voor 1 persoon
* Een recept is ook bedoeld voor 1 persoon
* We willen de ingrediëntenlijst en het recept wel kunnen afdrukken voor een willekeurig aantal personen.

De applicatie waarin deze utility classes gebruikt zal worden, wordt geschreven door een ander dev team. We kunnen dus
niet de applicatie gebruiken om de utility classes te testen.

Merk op: In de HelloFresh applicatie waar de classes gebruikt zullen worden, komt alle data uit de database.
Er zullen ook pagina's gemaakt worden waar de HelloFresh medewerkers recepten kunnen ingeven.   

We gebruiken unit testen om:

* de correctheid van de utility classes te bewijzen
* documentatie: hoe deze classes te gebruiken

Genereer ook javadoc documentatie voor de gebruikers van deze package.

We bouwen deze utility classes op in kleine stapjes.

## Ingredient class

Schrijf eerst een class Ingredient. Een Recipe class zal een lijst bevatten met Ingredients. Een Ingredient kan
bevatten:

* naam
  * bvb zout, bloem, suiker
* unit van het Ingredient in enkelvoud en meervoud
  * bvb: units mogelijk in enkelvoud/meervoud: stuk/stuks, eetlepel/eetlepels, zakje/zakjes
    * opgelet: sommige units bestaan alleen in enkelvoud: gram, cl
  * bij sommige ingrediënten wordt enkelvoud/meervoud niet uitgedrukt in units - bvb appel/appels,
    courgette/courgettes, ei/eieren
  * er bestaan ingrediënten zonder unit of aantal: een beetje zout, peper en zout naar smaak
* amount = aantal van dit Ingredient nodig voor 1 persoon

Een Ingredient heeft een functie **getText**
Die heeft als parameter: **nrOfPortions**. (int)
Dit is het aantal porties waarvoor we de ingrediëntenlijst willen afdrukken. 

### Mogelijke waarden in de parameters en hun effect

| naam            | unit == 1 | unit > 1 | amount   | getText(1) result | getText(2) result |
|-----------------|-----------|----------|----------|-------------------|-------------------|
| suiker          | lepel     | lepels   | 1        | 1 lepel suiker    | 2 lepels suiker   |
| suiker          | lepel     | lepels   | 2        | 2 lepels suiker   | 2 lepels suiker   |
| bloem           | gram      | gram     | 20       | 20 gram bloem     | 40 gram bloem     |
| zout naar smaak | **null**  | **null** | **null** | zout naar smaak   | zout naar smaak   |
| **null**        | ei        | eieren   | 1        | 1 ei              | 2 eieren          |

_Vergeet geen validatie te doen op de juistheid van de parameters! amount < 0 is bv verboden._

## Recipe class

Maak een object van class Recipe aan met: 
* dishName (String) - bvb "appeltaart", "pasta pesto" 

Een Recipe moet opgebouwd worden door Ingredients toe te voegen.
Maak hiervoor een functie **addIngredient** met parameter een object van de class Ingredient

Als een Recipe opgebouwd is kan je de ingrediëntenlijst afdrukken. 
Maar hiervoor een functie **getRecipeText** met parameter **nrOfPersons**: het aantal personen waarvoor we het recept willen afdrukken. 
De functie drukt eerst de dishName af met het aantal personen - bvb "Appeltaart voor 10 personen". 
Dan volgt op de volgende lijnen (**\n** is het "new-line" teken) de ingrediëntenlijst.

## Uitbreiding 1
Een ingrediënt kan een helft van iets zijn. Bijvoorbeeld een halve appel.  

Bvb: **courgette in de oven**
Een van de Ingredients in dit recept is: **1 courgette**

Als je het recept afdrukt voor 1 persoon: Ingredient.getText(1) --> dan print je "1/2 courgette"
Als je het recept afdrukt voor 2 personen: Ingredient.getText(2) --> dan print je "1 courgette"
Als je het recept afdrukt voor 2 personen: Ingredient.getText(3) --> dan print je "3/2 courgette"
Als je het recept afdrukt voor 4 personen: Ingredient.getText(4) --> dan print je "2 courgette**s**"

## Uitbreiding 2
* Een recept is standaard voorzien voor een aantal personen (**nrOfPersons**), default is dat 1 persoon.
* Een recept kan dus ook standaard voor 2 of meer personen bestemd zijn. De ingrediëntenlijst moet hier rekening mee houden

## Uitbreiding 3
Maak een functie **addRecipeLine** waarmee je de tekst van het recept kan toevoegen. 
Maak een functie **getRecipeText** waarmee je de tekst teruggeeft. 
Hoe kan je het aanpakken om ook in de tekst de juiste aantallen/enkelvoud/meervoud te printen? 
Hoe kan formattering in de tekst aanbrengen? 

