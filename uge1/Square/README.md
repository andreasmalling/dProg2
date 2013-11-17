# Square #
I denne opgave skal du skrive et lille program Square, der tager en parameter n på kommandolinjen og derefter beder brugeren indtaste n tal. Programmet gemmer de indtastede tal i et array (ikke et ArrayList-objekt, men et array-objekt!) og udskriver til slut kvadraterne på de indtastede tal. Hvis programmet udføres med kommandoen java Square 3 kan der udspilles en dialog med brugeren således:

		indtast tal nummer 1: 4 
		indtast tal nummer 2: 12 
		indtast tal nummer 3: 7 
		kvadraterne på de indtastede tal er: 16 144 49

De 3 tal efte kolonnet skrives af brugeren, mens den øvrige del af dialogen skrives af programmet.

Vink: Når du indlæser kommandolinje-parameteren n får du brug for at fortolke en tekst som et heltal. Dette kan du gøre med den statiske ''parseInt'' metode i klassen Integer. F.eks. 

		int n = Integer.parseInt("27");


Læs mere på:
http://www.cs.au.dk/~gudmund/dprog2_2013/uge1/#SECTION00000200000000000000