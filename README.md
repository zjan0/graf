graf:
orientovany-ma omezeni smeru car
neorientovany-nema omezeni smeru
ohodnoceny-ma hodnotu na kazde care
kostra grafu-podgraf ktery hranami spojuje vsechny vrcholy grafu a sam neobsahuje kružnici
matice sousednosti-ctvercova tabulka kde 1 reprezentuje primy spoj s bodem a 0 reprezentuje kdyz neexistuje primy spoj s tim bodem, diagonala z leveho horniho do praveho dolniho rohu je 0 a jsou to body samotne
seznam sousedu-uvadi vsechny vrcholy, a hrany ktery definuji spoje mezi dvema body
nejkratsi cesta- cesta s nejmensi celkovou delkou
negativni hrany-zkomplikovava hledani nejkratsi cesty,zvysuje slozitost efektivitu a cas hledani nejkratsi cesty, Dijkstrův algoritmus neni schopny pracovat s negativni hodnotou
vyuziti-hledai trasy v gps,hledani nejkratsi trasy u sitovych spoju
Dijkstrův algoritmus-nejhure O(V^2) jinak O((V + E) log V), E: Počet hran v grafu,V: Počet vrcholů v grafu,log V: Logaritmická složitost haldových operací
greedy přístup-bere nejkratsi cestu v ten moment tzv. nekouká se nepred
prioritní fronta-fronta nejkratsich vzdalenosti k dalsimu bodu
