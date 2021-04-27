create table forma_pagamento (
id INT GENERATED ALWAYS AS IDENTITY primary key,
tipo character varying (100),
modo_pagamento character varying (100),
descricao character varying (255)
);

insert into forma_pagamento (tipo, modo_pagamento, descricao) values ('CARTAO', 'ONLINE', 'Visa');
insert into forma_pagamento (tipo, modo_pagamento, descricao) values ('CARTAO', 'ONLINE', 'Mastercard');
insert into forma_pagamento (tipo, modo_pagamento, descricao) values ('DINHEIRO', 'OFFLINE', 'Dinheiro');
insert into forma_pagamento (tipo, modo_pagamento, descricao) values ('MAQUINA', 'OFFLINE', 'Vários cartões');