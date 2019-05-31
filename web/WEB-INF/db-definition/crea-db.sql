DROP DATABASE IF EXISTS fpw19_dbvaccaalessandro;
CREATE DATABASE fpw19_dbvaccaalessandro;
USE fpw19_dbvaccaalessandro;

CREATE TABLE stati(
    nomeStato VARCHAR(128) NOT NULL,
    idStato INT AUTO_INCREMENT,
    PRIMARY KEY (idStato)
);

CREATE TABLE articoli(
    idArticolo INT AUTO_INCREMENT,
    titolo VARCHAR(128) NOT NULL,
    testo VARCHAR(299) NOT NULL,
    dataPubblicazione DATE NOT NULL,
    foto VARCHAR(128),
    idStato INT NOT NULL,
    PRIMARY KEY(idArticolo),
    FOREIGN KEY (idStato) REFERENCES stati (idStato)
);


CREATE TABLE utenti(
    idUtente INT AUTO_INCREMENT,
    nome VARCHAR(128) NOT NULL,
    cognome VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    ente VARCHAR(128),
    foto VARCHAR(128),
    isOrganizzatore BOOL NOT NULL,
    PRIMARY KEY(idUtente)
);

    CREATE TABLE categorie(
    idCategoria INT AUTO_INCREMENT,
    nomeCategoria VARCHAR(128) NOT NULL,
    PRIMARY KEY(idCategoria)
);

CREATE TABLE valutazioniArticoli(
    idUtente INT,
    idArticolo INT ,
    commentoOrganizzatori VARCHAR(99) NOT NULL,
    commentoAutori VARCHAR(99) NOT NULL,
    voto INT NOT NULL,
    PRIMARY KEY(idUtente, idArticolo),
    FOREIGN KEY (idUtente) REFERENCES utenti (idUtente),
    FOREIGN KEY (idArticolo) REFERENCES articoli (idArticolo)
);

CREATE TABLE autoriArticoli(
    idUtente INT,
    idArticolo INT,
    PRIMARY KEY(idUtente, idArticolo),
    FOREIGN KEY (idUtente) REFERENCES utenti (idUtente),
    FOREIGN KEY (idArticolo) REFERENCES articoli (idArticolo)
);

CREATE TABLE categorieArticoli(
    idArticolo INT,
    idCategoria INT,
    PRIMARY KEY(idArticolo, idCategoria),
    FOREIGN KEY (idArticolo) REFERENCES articoli (idArticolo),
    FOREIGN KEY (idCategoria) REFERENCES categorie (idCategoria)
);

CREATE TABLE articoliAssegnati (
    idUtente INT,
    idArticolo INT,
    PRIMARY KEY (idUtente, idArticolo),
    FOREIGN KEY (idUtente) REFERENCES utenti(idUtente),
    FOREIGN KEY (idArticolo) REFERENCES articoli(idArticolo)
);

INSERT INTO stati (idStato,nomeStato) values (default,"APERTO");
INSERT INTO stati (idStato,nomeStato) values (default,"VALUTAZIONE");
INSERT INTO stati (idStato,nomeStato) values (default,"ACCETTATO");
INSERT INTO stati (idStato,nomeStato) values (default,"RIFIUTATO");

INSERT INTO categorie (idCategoria,nomeCategoria) values (default,"HTML");
INSERT INTO categorie (idCategoria,nomeCategoria) values (default,"JSP");
INSERT INTO categorie (idCategoria,nomeCategoria) values (default,"CSS");
INSERT INTO categorie (idCategoria,nomeCategoria) values (default,"JavaScript");
INSERT INTO categorie (idCategoria,nomeCategoria) values (default,"Servlet");
INSERT INTO categorie (idCategoria,nomeCategoria) values (default,"AJAX");
 

INSERT INTO utenti (idUtente,nome,cognome,email,password,isOrganizzatore) values (default,"Massimiliano","Allegri","massimiliano@gmail.com","123",'1');
INSERT INTO utenti (idUtente,nome,cognome,email,password,isOrganizzatore) values (default,"Luciano","Spalletti","luciano@gmail.com","456",'0');
INSERT INTO utenti (idUtente,nome,cognome,email,password,isOrganizzatore) values (default,"Rino","Gattuso","rino@gmail.com","789",'0');

INSERT INTO articoli (idArticolo,titolo,testo,dataPubblicazione,idStato) values (default,"Articolo di Luciano","Testo articolo di Luciano",'2019-05-04','1');
INSERT INTO articoli (idArticolo,titolo,testo,dataPubblicazione,idStato) values (default,"Articolo di Rino","Testo articolo di Rino",'2019-05-10','2');
INSERT INTO articoli (idArticolo,titolo,testo,dataPubblicazione,idStato) values (default,"Articolo di Luciano e Rino","Testo articolo di Luciano e Rino",'2019-05-06','1');

INSERT INTO autoriArticoli (idUtente,idArticolo) values ('2','1');
INSERT INTO autoriArticoli (idUtente,idArticolo) values ('3','3');
INSERT INTO autoriArticoli (idUtente,idArticolo) values ('3','2');
INSERT INTO autoriArticoli (idUtente,idArticolo) values ('2','3');

INSERT INTO categorieArticoli (idArticolo,idCategoria) values ('1','3');
INSERT INTO categorieArticoli (idArticolo,idCategoria) values ('1','4');
INSERT INTO categorieArticoli (idArticolo,idCategoria) values ('2','1');
INSERT INTO categorieArticoli (idArticolo,idCategoria) values ('2','2');
INSERT INTO categorieArticoli (idArticolo,idCategoria) values ('3','5');
INSERT INTO categorieArticoli (idArticolo,idCategoria) values ('3','6');

INSERT INTO valutazioniArticoli (idArticolo,idUtente,commentoAutori,commentoOrganizzatori,voto) values (2,1,"Lol","Lol",2);
INSERT INTO valutazioniArticoli (idArticolo,idUtente,commentoAutori,commentoOrganizzatori,voto) values (2,2,"Lol","Lol",2);
INSERT INTO valutazioniArticoli (idArticolo,idUtente,commentoAutori,commentoOrganizzatori,voto) values (2,3,"Lol","Lol",2);