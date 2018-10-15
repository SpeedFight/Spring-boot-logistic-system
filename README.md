# Spring-boot-logistic-system

#budowanie:

zależności:
maven -> w zmiennej PATH
java -> w zmiennej PATH

Aby skompilować:

Linux:
./compile.sh

Windows
compile.bat

# Przykład użycia:
1)
run --input input.xml --output out.csv --raport a
lub
run -i input.xml -o out.csv -r a

Przeparsuje plik input.xml w celu uzyskania ilości zamówień łącznie, a wynik zapisze do pliku output.csv

2)
run --input in.xml in.csv --raport b --client-id 1
lub
run -i in.xml in.csv -r a -c 1

Przeparsuje pliku wejsciowe in.xml oraz in.cvs w celu uzyskania ilości zamówień łącznie dla klienta o id = 1.
Wynik zostanie wypisany w konsoli.

Opcje parametry raport:
a Ilość zamówień łącznie,
b Ilość zamówień do klienta o wskazanym identyfikatorze,
c Łączna kwota zamówień,
d Łączna kwota zamówień do klienta o wskazanym identyfikatorze,
e Lista wszystkich zamówień,
f Lista zamówień do klienta o wskazanym identyfikatorze,
g Średnia wartość zamówienia ,
h Średnia wartość zamówienia do klienta o wskazanym identyfikatorze. 

# Warunki działania

# Pliki wejściowe

Program parsuje wszystkie pliku wejściowe podane po argumencie -i
Wszystkie pliki wejsciowe powinny być formatu xml lub csv i zawierać prawidłowe pola:

Dla pliku csv: 
Client_Id,Request_id,Name,Quantity,Price

Dla pliku xml: 
<requests>
  <request>
    <clientId></clientId>
    <requestId></requestId>
    <name></name>
    <quantity></quantity>
    <price></price>
  </request>
</requests>

W razie braku pewnych danych, poszczególne części pliku są ignorowane.
Ignorowane są również pliki w złym formacie, nieistniejące lub bez prawa do odczytu

# Pliki wyjściowe
Plik wyjściowy to pierwszy argument parametru -o
Jeśli nie podano pliku wyjściowego, wynik operacji zostanie wyświetlony w konsoli.
Powinny być formaru xml lub csv.
Można podać nieistniejącą ścieżkę. Program stworzy potrzebne pliki.

# Opis działania

1) Program przetwarza pliku wejściowe.
2) Prawidłowe dane zapisuje do bazy danych.
3) Odpowiednio przetwarza dane z bazy w wybrany przez użytkownika sposób.
4) prezentuje dane (zapis do pliku/wyświetlenie w konsoli)

Program w czasie działania ignoruje w miarę możliwości błęde dane.
Dostarczając przy tym stosowne informacje dlaczego.

# Opcje programu

usage: Przykładowe użycie:  
run -i[pliki wejsciowe] -r[typ generowanego raportu]  
 -c,--client-id <USER_ID>   [PARAMETR WYMAGANY z opcjami b, d, f, h  
                            parametru raport]  
                            Identyfikator klienta. Jeśli podano  
                            nieistniejącego klienta, informacja o tym  
                            zostanie wyświetlona po odczytaniu danych  
 -h,--help                  Wypisują tą pomoc na ekranie.  
 -i,--input <FILES>         [PARAMETR WYMAGANY][Jeden lub wiele]  
                            Ściezka do jednego lubi wiecej plików  
                            wejsciowych. Akcepowalne rozszerzenia to xml    
                            oraz csv.    
 -o,--output <FILE>         [Tylko jeden]Sćieżka do pliku wyjściowego.  
                            Może się kończyć rozszerzeniem .cvs/.xml. W  
                            razie potrzeby wygeneruje potrzebne  
                            rozszerzenie (standardowo .scv), oraz nazwę  
                            pliku.  
                            Gdy nie podano ścieżki do pliku wyjściowego,  
                            wynik działania programu zostaniewyswietlony w  
                            konsoli.  
 -r,--raport <OPTION>       [PARAMETR WYMAGANY][Tylko jeden] Typ  
                            generowanego raportu  
                            kod  | typ raportu  
                            a   | Ilość zamówień łącznie,  
                            b   | -||- do klienta o wskazanym identyfikatorze,  
                            c   | Łączna kwota zamówień,  
                            d   | -||- do klienta o wskazanym identyfikatorze,  
                            e   | Lista wszystkich zamówień,  
                            f   | -||- do klienta wskazanym identyfikatorze,  
                            g   | Średnia wartość zamówienia ,  
                            h   | -||- do klienta o wskazanym identyfikatorze  
                            
                            
////////////  
Karol Łukasiewicz
