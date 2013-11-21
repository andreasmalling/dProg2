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