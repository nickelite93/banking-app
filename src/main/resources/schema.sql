CREATE TABLE CurrentAccount (
    id BIGINT PRIMARY KEY,
    balance DECIMAL(10,2)
);

CREATE TABLE Customer (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    currentAccount_id BIGINT,
    FOREIGN KEY (currentAccount_id) REFERENCES CurrentAccount(id)
);