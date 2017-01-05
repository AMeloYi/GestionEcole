DROP DATABASE IF EXISTS GestionEcole;

CREATE DATABASE IF NOT EXISTS GestionEcole;
USE GestionEcole;
# -----------------------------------------------------------------------------
#       TABLE : ETUDIANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETUDIANT
 (
   IDETUDIANT INTEGER(32) NOT NULL AUTO_INCREMENT,
   NOMETUDIANT CHAR(32) NULL  ,
   PRENOMETUDIANT CHAR(32) NULL  ,
   DDN CHAR(32) NULL  ,
   ADRESS CHAR(32) NULL  ,
   ANNEEINSCRIPTION CHAR(32) NULL  
   , PRIMARY KEY (IDETUDIANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ENSEIGNANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENSEIGNANT
 (
   IDENSEIGNANT INTEGER NOT NULL AUTO_INCREMENT,
   NOMENSEIGNANT CHAR(32) NULL  ,
   PRENOMENSEIGNANT CHAR(32) NULL  ,
   DATEENTREE CHAR(32) NULL  ,
   SALAIRE DOUBLE NULL  
   , PRIMARY KEY (IDENSEIGNANT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COURS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COURS
 (
   IDCOURS INTEGER NOT NULL  AUTO_INCREMENT,
   IDENSEIGNANT INTEGER NOT NULL  ,
   NOMCOURS CHAR(32) NULL  ,
   DESCRIPTION CHAR(32) NULL  
   , PRIMARY KEY (IDCOURS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COURS
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COURS_ENSEIGNANT
     ON COURS (IDENSEIGNANT ASC);

# -----------------------------------------------------------------------------
#       TABLE : RESULTAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RESULTAT
 (
   IDETUDIANT INTEGER NOT NULL  ,
   IDCOURS INTEGER NOT NULL  ,
   DATERESULTAT CHAR(32) NULL  ,
   NOTE CHAR(32) NULL  
   , PRIMARY KEY (IDETUDIANT,IDCOURS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE RESULTAT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_RESULTAT_ETUDIANT
     ON RESULTAT (IDETUDIANT ASC);

CREATE  INDEX I_FK_RESULTAT_COURS
     ON RESULTAT (IDCOURS ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE COURS 
  ADD FOREIGN KEY FK_COURS_ENSEIGNANT (IDENSEIGNANT)
      REFERENCES ENSEIGNANT (IDENSEIGNANT) ;


ALTER TABLE RESULTAT 
  ADD FOREIGN KEY FK_RESULTAT_ETUDIANT (IDETUDIANT)
      REFERENCES ETUDIANT (IDETUDIANT) ;


ALTER TABLE RESULTAT 
  ADD FOREIGN KEY FK_RESULTAT_COURS (IDCOURS)
      REFERENCES COURS (IDCOURS) ;

