insert into customers (email, pwd) VALUES
  ('account@debuggeandoieas.com', 'to_be_encoded'),
  ('cards@debuggeandoieas.com', 'to_be_encoded'),
  ('loans@debuggeandoieas.com', 'to_be_encoded'),
  ('balance@debuggeandoieas.com', 'to_be_encoded');

 insert into roles (role_name, description, id_customer) VALUES
   ('VIEW_ACCOUNT', 'account endpoint', 1),
   ('VIEW_CARDS', 'card endpoint', 2),
   ('VIEW_LOANS', 'loan endpoint', 3),
   ('VIEW_BALANCE', 'balance endpoint', 4);