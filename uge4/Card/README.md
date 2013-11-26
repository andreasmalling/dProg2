# Modellering af Spillekort


I denne opgave skal du lave en klasse *Card*, der modellerer et spillekort.

Lav først to enum typer, en type *Suit* med værdierne:

    DIAMOND, CLUB, HEART, SPADE

Samt en type *Rank* med værdierne:

    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE

*Card* klassen skal have en konstruktør *public Card(Suit s, Rank r)* der konstruerer et kort udfra farve og værdi. Endvidere skal kortklassen implementere *Comparable<Card>* og override *toString()*, *equals()* og *hashCode()*.

Kortrækkefølgen er primært baseret på værdi (2 < 3 < ... < Es) og sekundært på farve (ruder < klør < hjerter < spar). *toString()* metoden skal returnere en kortbeskrivelse på formen "HEART FIVE", "CLUB KING", etc.

Din klasse skal kunne klare assertions i CardTest.java.

Vink: en enum type E implementerer automatisk Comparable<E> baseret på definitionsrækkefølgen af typens værdier. En enumtype overrider også toString() metoden, så den pågældende værdi udskrives.

# Implementering af Hand-klasse
I denne opgave skal du arbejde videre med Card klassen fra A-opgaverne.

Lav en Hand klasse, der kan holde nogle kort. Du kan antage at alle kort på hånden er fra et enkelt spil kort, så der er ingen dubletter. Man kan indsætte og fjerne kort fra hånden med metoderne ``public boolean add(Card c)`` og ``public boolean remove(Card c)``, idet metoderne returnerer true, pånær hvis man forsøger at indsætte et kort der allerede er på hånden eller fjerne et kort der ikke er på hånden.

Endvidere skal Hand-klassen override ``toString()``, ``equals()`` og ``hashCode()`` metoderne. ``toString()`` metoden skal beskrive kortene i stigende rækkefølge, og ``equals()`` metoden skal identificere ens hænder uanset i hvilken rækkefølge kortene er indsat og hvorvidt der har været flere kort på hånden tidligere.

Før du begynder at programmere skal du overveje hvilken collection der mest hensigtsmæssigt kan anvendes til at holde kortene på hånden. Overvej om det er *ArrayList*, *LinkedList*, *HashSet*, *TreeSet* eller *MultiSet* (fra den anden afleveringsopgave). Det er muligt at træffe et valg, så alle dine metoder får meget korte (trivielle) implementationer.

Din klasse skal kunne klare assertions i *programmeringsseksempler/uge4/HandTest.java*.