| uthyrningsnummer | datum      | kunduppgifter                            | filmtitel   | speltid | 
|------------------|------------|------------------------------------------|-------------|---------|
| 101              | 2026-11-01 | Anna Berg, anna@example.com, 070-1111111 | Stjärnresan | 119 min | 
| 102              | 2026-11-02 | Erik Lind, erik@example.com, 070-2222222 | Månjakten   | 99 min  | 
| 103              | 2026-11-05 | Anna Berg, anna@example.com, 070-1111111 | Månjakten   | 99 min  |

1. Dela upp celler som innehåller flera separata uppgifter.

| uthyrningsnummer | datum      | namn      | mail             | telefonnummer | filmtitel   | speltid | 
|------------------|------------|-----------|------------------|---------------|-------------|---------|
| 101              | 2026-11-01 | Anna Berg | anna@example.com | 070-1111111   | Stjärnresan | 119 min | 
| 102              | 2026-11-02 | Erik Lind | erik@example.com | 070-2222222   | Månjakten   | 99 min  | 
| 103              | 2026-11-05 | Anna Berg | anna@example.com | 070-1111111   | Månjakten   | 99 min  |

2. Leta efter fakta som upprepas. Måste samma ändring göras på flera ställen?

Anna Bergs uppgifter upprepas, även filmen Månjakten och dess speltid. Det gör att man måste ändra på till exempel Annas
telefonnummer på två ställen om det skulle behöva ändras. Upprepat data är onödig lagring och kan ge avvikelser.

3. Fundera på vilka uppgifter som hör ihop och bör få en egen tabell.

Kunduppgifter hör ihop och även filminformation. Alltså kan vi skapa två sådana tabeller så man bara behöver referera
till mail och titel i tabellen så att man slipper ha all info där och därmed behöva ändra till exempel Annas
telefonnummer på två ställen.

Kund

| mail             | namn      | telefonnummer |  
|------------------|-----------|---------------|
| anna@example.com | Anna Berg | 070-1111111   |  
| erik@example.com | Erik Lind | 070-2222222   |

mail är PK. En bättre primärnyckel hade varit autogenererat kund_id då till exempel mailen kan ändras och vi slipper
tänka på att skapa kund_id då det autogenereras,

Film

| titel       | speltid | 
|-------------|---------|
| Stjärnresan | 119 min |
| Månjakten   | 99 min  | 

titel är PK. En bättre primärnyckel hade varit autogenererat film_id då det till exempel kan vara flera filmer med samma
titel.

4. Välj nycklar så att tabellerna kan kopplas ihop igen.

uthyrningsnummer är PK, mail (hänvisar till kundtabellen) och titel (hänvisar till filmtabellen) är FK

Uthyrning

| uthyrningsnummer | datum      | mail             | titel       |
|------------------|------------|------------------|-------------|
| 101              | 2026-11-01 | anna@example.com | Stjärnresan | 
| 102              | 2026-11-02 | erik@example.com | Månjakten   |  
| 103              | 2026-11-05 | anna@example.com | Månjakten   |

Relationer mellan tabellerna:
uthyrning-kund är en till flera relation eftersom en uthyrning tillhör en kund men en kund kan ha flera uthyrningar
uthyrning-film är också en till flera relation eftersom en uthyrning gäller en film men samma film kan finnas i flera
uthyrningar kund-film har relationen flera till flera då en person kan hyra flera filmer och en film kan hyras till
flera kunder