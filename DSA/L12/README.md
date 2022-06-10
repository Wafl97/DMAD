# L12 Uge 16

## A

### A1 Eksamen januar 2007, opgave 2

### A2 Eksamen juni 2012, opgave 5

### A3

Vi ser her p˚a disjoints sets implementeret via lænkede lister og brug af
weighted-union heuristikken for Union (dvs. at den korteste liste sættes ind i den længste liste). Beskriv hvordan denne implementation kan
laves, selv hvis header-objekter ikke indeholder en tail-pointer og ikke gemmer listens længde. Den asymptotiske køretid af operationerne
skal selvfølgelig ikke blive ændret. [Hint: løb lister igennem synkront.
Husk opdatering af elementers pointer til header.]

### A4 Cormen et al. øvelse 21.2-2 (side 567)

Dine tegninger behøver ikke
være lige s˚a detaljerede som i Figur 21.1 (side 565).

### A5 Cormen et al. øvelse 21.3-2 (side 572)

[Hint: løb stien igennem to
gange.]

### A6 Cormen et al. øvelse 21.3-1 (side 572)

### A7 Cormen et al. øvelse 22.1-1 (side 592)

### A8 Cormen et al. øvelse 22.1-3 (side 592)

### A9 Cormen et al. øvelse 22.2-1 (side 601)

### A10 Cormen et al. øvelse 22.2-2 (side 601)

### A11 Cormen et al. øvelse 22.2-3 (side 602)

NB: Hvis jeres bog ikke er
“third printing” (eller senere) af third edition af Cormen et al., st˚ar
der fejlagtigt “if lines 4 and 14 were removed” - det skal ændres til “if
line 18 was removed”.

## B

### B1 Eksamen juni 2011, opgave 3

### B2 Eksamen januar 2007, opgave 1

Sidehenvisningerne skal være til side 298 (opgave b) og 294 (opgave c) i vores udgave (tredie) af Cormen
et al., i stedet for de angivne sider 261 og 262.

### B3 (∗) Cormen et al. problem 16.1 (side 446)

Erstat spørgsm˚al b med
flg. mere generelle: Vis, at hvis der for et møntsæt med møntstørrelser
m1 = 1, m2, . . . , mk gælder at mi g˚ar op i mi+1 for alle i, da virker
den gr˚adige algoritme fra spørgsm˚al a.
Hint til spørgsm˚al a: Quarters, dimes, nickels og pennies betyder 25-
ører, 10-ører, 5-ører og 1-ører. Du skal vise, at der altid er en optimal
løsning best˚aende af dit første gr˚adige valg samt en optimal løsning
til rest-problemet. Det kan hjælpe at se p˚a en optimal løsning, og
stille dens mønter op sorteret efter størrelse. Hint til spørgsm˚al b: er
ikke s˚a forskellig fra spørgsm˚al a. Hint til spørgsm˚al c: et møntsæt
med tre mønter og et beløb n under ti er nok til et modeksempel.
Hint til spørgsm˚al d: Man m˚a her bruge dynamisk programmering i
stedet for gr˚adighed. Det vil være nok med en tabel R[i] af størrelse
1 × n, hvor R[i] indeholder antallet af mønter i en optimal løsning
for beløbet i. Tænk derudover lidt som for guldkæde-problemet (se
slides om dynamisk programmering)—en optimal løsning for beløb i
m˚a indeholde enten en mønt af type 1, eller en af type 2, eller en af
type 3, og s˚a videre.
Bemærk at problem 16.1 viser, at design af et lands møntsæt kræver
overvejelser, for at det bliver simpelt (dvs. en naturlig gr˚adig algoritme
fungerer) at give penge tilbage.

### B4 Eksamen juni 2009, opgave 1 a

### B5 Eksamen januar 2005, opgave 5

### B6 Eksamen juni 2010, opgave 5
