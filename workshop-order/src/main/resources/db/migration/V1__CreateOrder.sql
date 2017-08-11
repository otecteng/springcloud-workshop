CREATE TABLE orders (
  id             VARCHAR(64),
  user           VARCHAR(64),
  product        VARCHAR(64),
  price           INT,
  product_id      VARCHAR(64),
  created_at     DATETIME,
  CONSTRAINT pk_service_measure PRIMARY KEY (id)
)
