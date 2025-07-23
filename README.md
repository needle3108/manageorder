Baza danych postgreSQL - uruchomiona w kontenerze Docker, plik inicjalizacyjny w folderze init-db, uruchomienie kontenera: docker compose up -d

Moduł customerorder działa na porcie 8081, manufacturingorder - 8082

Zastosowano architekturę synchroniczną - komunikacja poprzez porty

Manufacturingorder pozwala na tworzenie nowych zamówień produkcyjnych oraz na zmianę ich statusów

Customerorder umożliwia stworzenie nowego zamówienia klienckiego oraz pozwala na śledzenie statusu danego zamówienia produkcyjnego

Napisano kilka testów jednostkowych i integracyjnych w celu przetestowania zaimplementowanych funkcjonalności
