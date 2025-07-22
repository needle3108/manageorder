CREATE SCHEMA IF NOT EXISTS customerorder;

CREATE TABLE IF NOT EXISTS customer_order (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS order_line (
    id SERIAL PRIMARY KEY,
    order_id UUID REFERENCES customer_order(id) ON DELETE CASCADE,
    product_id UUID NOT NULL,
    quantity INTEGER NOT NULL
    );

INSERT INTO customer_order (id, status) VALUES
('11111111-1111-1111-1111-111111111111', 'CREATED'),
('22222222-2222-2222-2222-222222222222', 'CONFIRMED');

INSERT INTO order_line (order_id, product_id, quantity) VALUES
('11111111-1111-1111-1111-111111111111', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 10),
('11111111-1111-1111-1111-111111111111', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 5),
('22222222-2222-2222-2222-222222222222', 'cccccccc-cccc-cccc-cccc-cccccccccccc', 2);

CREATE SCHEMA IF NOT EXISTS manufacturingorder;

CREATE TABLE IF NOT EXISTS manufacturing_order (
    id UUID PRIMARY KEY,
    status VARCHAR(50) NOT NULL
    );