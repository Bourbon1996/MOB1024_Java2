use asm2 ;
CREATE TABLE DOCUMENT (
    id VARCHAR(20) PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    category VARCHAR(100)
);

CREATE TABLE DOCUMENT_COPY (
    id VARCHAR(20) PRIMARY KEY,
    document_id VARCHAR(20),
    status VARCHAR(50),
    FOREIGN KEY (document_id) REFERENCES DOCUMENT(id)
);

select * from document_copy;