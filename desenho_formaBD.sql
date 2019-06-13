 CREATE DATABASE psw;
 
 USE psw;

CREATE TABLE desenho (
  id 	INT 
		NOT NULL 
		AUTO_INCREMENT,
  
  nome  VARCHAR(45) 
		NULL,
  
  PRIMARY KEY (id)
);

CREATE TABLE forma (
  id 		INT 
				NOT NULL 
				AUTO_INCREMENT,
  
  nome 			VARCHAR(45) 
				NULL,
                
  pontos 		TEXT 
				NULL,
                
  desenho_id 	INT 
				NOT NULL,
  
  PRIMARY KEY (id, desenho_id),
  
FOREIGN KEY (desenho_id) REFERENCES desenho (id)
);