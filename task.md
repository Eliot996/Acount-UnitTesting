# Konto opgave

## Opgaven involverer:

- Egen klasse
- Instansvariable 
- Konstruktør 
- Metoder med parametre og returværdi 
- Unit tests

### Lav en klasse med navn Account.

Klassen skal have flg. instansvariable og tilhørende get og set metoder:

- Kontonummer
- Ejernavn
- Saldo

Når man opretter en ny konto kan man som bruger enten give en start-saldo eller ingenting som parameter – i sidste tilfælde sættes saldoen per default til 0.

Det skal være muligt at indsætte og hæve penge på kontoen. Derfor har vi brug for flg. metoder:

- En metode insert, som modtager et beløb, sætter det ind på kontoen og returnerer den ny saldo.
  - Skriv unit tests til metoden inden du går videre til næste metode.
- En metode withdraw, som modtager et beløb, hæver beløbet fra kontoen, og returnerer den ny saldo. Det er ikke muligt at hæve flere penge, end der er på kontoen. Hvis dette forsøges, skal metoden returnere a) enten -1 eller b) en exception.
  - Skriv unit tests til metoden inden du går videre til næste metode.
- En toString metode, som kan udskrive information om en konto.



## Ekstraopgave, hvis du har tid …

Lav en transfer() metode, som tager flg. parametre: et beløb og den konto, som man vil overføre beløbet til. Når man overfører penge mellem to konti, er der et gebyr på 5 kr., der trækkes fra den konto man overfører pengene fra.

Metoden skal returnere den nye saldo på kontoen, der hæves fra. Hvis der ikke er nok penge på kontoen til både gebyr og overførsel skal overførslen ikke gennemføres, og metoden skal returnere a) enten -1 eller b) en exception.

Skriv unit tests til metoden.