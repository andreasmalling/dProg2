# Multimængde
En multimængde er en datastruktur, hvor et element kan forekomme flere gange og elementernes orden er ligegyldig. F.eks. er multimængderne:
``["abe","kat","due","kat","kat"]`` og ``["kat","due","kat","abe","kat"]`` identiske. Lav en *MultiSet\<E\>* klasse som en udvidelse til *AbstractCollection\<E\>*. Du skal implementere metoderne size og iterator, og override add.
Vink: Det er nok at vide, hvor mange elementer der er af hver slags, så multimængden ``["abe","kat","due","kat","kat"]`` kan repræsenteres ved hjælp af et Map ``[due -> 1, kat -> 3,abe -> 1]``

,f.eks. java.util.HashMap.

Vink: hvordan kan du kontruere en iterator for multimængden ved hjælp af en iterator for dit map's nøglemængde? Bemærk at metoden *keySet()* giver dig nøglemængden for et map i form af et Set, som har en iterator metode. Du kan lade iteratorens remove metode kaste en *UnsupportedOperationException*.

Test din klasse. Hvad sker der hvis du forsøger at fjerne et element fra multimængden (dvs kalder remove metoden, som er arvet fra *AbstractCollection*)?