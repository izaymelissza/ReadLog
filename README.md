📚 ReadLog - Személyes Könyv Kezelő Alkalmazás
📖 Projekt Leírás
A ReadLog egy webes könyvkezelő alkalmazás, amellyel a felhasználók nyomon követhetik olvasási szokásaikat, könyveket vihetnek fel, értékelhetnek, és részletes statisztikákat tekinthetnek meg olvasási aktivitásukról.
✨ Főbb Funkciók
Felhasználói Funkciók
•	📚 Könyvek kezelése: Új könyvek hozzáadása, böngészés, szerkesztés
•	📝 Olvasási listák: Könyvek kategorizálása (Olvasni szeretném, Jelenleg olvasom, Elolvastam)
•	⭐ Értékelések: Könyvek értékelése 1-5 csillaggal, vélemények írása
•	📊 Statisztikák: Részletes statisztikák olvasási szokásokról (évente, műfajonként, havi bontásban)
•	👤 Profil kezelés: Személyes olvasási előzmények megtekintése
Admin Funkciók
•	🔧 Felhasználó kezelés: Felhasználók listázása, jogosultságok kezelése
•	📖 Tartalom moderálás: Könyvek és értékelések kezelése
•	📈 Rendszer statisztikák: Globális statisztikák az alkalmazás használatáról
🛠️ Technológiai Stack
Backend
•	Java 17
•	Spring Boot 3.x 
o	Spring MVC
o	Spring Data JPA
o	Spring Security
•	MySQL adatbázis
•	Maven build tool
Frontend
•	Thymeleaf template engine
•	Bootstrap 5 CSS framework
•	Chart.js statisztika vizualizációhoz
•	Egyedi CSS és JavaScript interaktív funkciókhoz
📊 Adatbázis Struktúra
Táblák és Kapcsolatok
USERS (Felhasználók)
- id (PK)
- username
- email
- password
- registration_date
- role (USER/ADMIN)
BOOKS (Könyvek)
- id (PK)
- title
- author
- genre
- publication_year
- pages
- description
- cover_url
- added_by (FK -> USERS)
READING_LISTS (Olvasási Listák) - N:M köztes tábla
- id (PK)
- user_id (FK -> USERS)
- book_id (FK -> BOOKS)
- status (TO_READ, READING, READ)
- added_at
- started_reading_at
- finished_reading_at
REVIEWS (Értékelések)
- id (PK)
- user_id (FK -> USERS)
- book_id (FK -> BOOKS)
- rating (1-5)
- comment
- created_at
Kapcsolatok
•	Users → Books: 1:N (egy felhasználó több könyvet vihet fel)
•	Users ↔ Books (Reading Lists): N:M (egy felhasználó több könyvet olvashat, egy könyvet több felhasználó is olvashat)
•	Users → Reviews: 1:N (egy felhasználó több értékelést írhat)
•	Books → Reviews: 1:N (egy könyvhöz több értékelés tartozhat)
🎯 Követelmények Teljesítése
2-es szint :
•	1:N kapcsolat: Users → Books
•	CRUD: Books táblára teljes CRUD műveletek
•	Olvasás: Users lista csak olvasható
•	Navigáció: Menürendszer az oldalak között
3-as szint :
•	N:M kapcsolat: Users ↔ Books (Reading Lists köztes táblával)
•	CRUD mindkét táblára: Users és Books is teljes CRUD-dal
•	Navigáció: Teljes menürendszer
4-es szint 
•	Spring Security: Bejelentkezés, regisztráció
•	Jogosultság alapú hozzáférés: 
o	USER role: Saját tartalmak kezelése
o	ADMIN role: Minden tartalom kezelése
•	Adatbázis alapú authentikáció: Felhasználók a DB-ben tárolódnak
•	Jelszó titkosítás: BCrypt hash
5-ös szint 
•	Egyedi CSS: Bootstrap alapú egyedi témázás, animációk, hover effektek
•	Chart.js vizualizációk: 
o	Havi olvasási statisztika (oszlopdiagram)
o	Műfaj eloszlás (kördiagram)
o	Éves olvasási trend (vonaldiagram)
