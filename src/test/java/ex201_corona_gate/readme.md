# Corona gate

Je schrijft de software voor een automatische deur. 
Vandaag schrijf je een klasse CoronaGate die op basis van externe sensoren beslist of iemand
door de poort mag of niet.

De sensoren worden door een externe firma geschreven, het aansturen van de poort zelf is reeds klaar.

Er worden 2 interfaces aangeleverd:
- GateController stuurt de poort aan
  - void allowOnePersonThrough() laat 1 persoon door de poort
  - void blockPerson() blokkeert de toegang voor de persoon voor de poort
- HeatSensor kan de lichaamstemperatuur meten van de persoon voor de poort
  - boolean feverDetected() geeft true wanneer de persoon voor de poort koorts heeft

De klasse CoronaGate heeft slechts 1 functie:
- handlePersonAtTheGate()
  - Blokkeert de poort wanneer de persoon voor de poort koorts heeft
  - Laat de persoon voor de poort door wanneer dat niet zo is

Het is dus niet nodig om de implementatie voor deze interfaces te schrijven, de koppeling tussen de klasse
CoronaGate en de implementatie gebeurt via de constructor, en dat zijn dan ook de 2 parameters voor de klasse.

Schrijf de unittesten door middel van mocking, net als de implementatie van CoronaGate.