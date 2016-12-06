# Useri
GET /users - toti userii (parola e pusa cu null, sa nu fie publica)
Pentru a cauta dupa nume mergeti pe GET/{nume}, va returna la fel userii care contin in nume.
ex: GET /users/radu va returna toti userii ale caror nume contine 'radu'.
ex raspuns:
[
  {
    "name": "Paul",
    "password": null,
    "phone": "0743773521"
  },
  {
    "name": "Raul",
    "password": null,
    "phone": "0743773521"
  }
]

POST /users - adauga un user, are nevoie de un body
ex body
{
	"name":"Darius",
	"password":"1234",
	"phone":"0743773521"
}
ex raspuns
{
  "success": true
}
Success fiind false daca numele e deja folosit.

# Programari
Am considerat ca o programare are totdeauna 1 ora, si poate fi facuta doar la ora fixa
0,1,2,3,4...23, in orice zi.
GET /appointments va returna programarile
[
  {
    "day": 6,
    "month": 12,
    "year": 2016,
    "hour": 10,
    "userId": 4162366,
    "user": {
      "name": "paul",
      "password": null,
      "phone": "112321",
      "id": 4162366
    },
    "id": 3940460
  },
  {
    "day": 6,
    "month": 12,
    "year": 2016,
    "hour": 12,
    "userId": 4162366,
    "user": {
      "name": "paul",
      "password": null,
      "phone": "112321",
      "id": 4162366
    },
    "id": 707567
  }
]
In cazul asta, userul cu numele paul, are 2 programari, si anume pe
*6/12/2016 10:00
*6/12/2016 12:00

POST /appointments va adauga o noua programare. Necesita body
ex body:
{
	"day":"6",
	"month":"12",
	"year":"2016",
	"hour":12,
	"name":"paul",
	"password":"1234"
}
Aici va fi data programarii, numele si parola userului. Fiindca o programare apartine doar unui user.
Ca raspuns vei primi ceva gen
{
  "message": "Success",
  "success": true
}
Unde mesajul spune daca e vreo problema, alte ex de mesaje:
{
  "message": "There is an appointment already at the selected date.",
  "success": false
}
Si daca numele si parola nu sunt bune
{
  "message": "User not found!",
  "success": false
}