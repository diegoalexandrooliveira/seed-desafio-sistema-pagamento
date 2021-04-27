create table restaurante (
id INT GENERATED ALWAYS AS IDENTITY primary key,
nome character varying (255)
);

create table restaurante_forma_pagamento (
id_restaurante INT,
id_forma_pagamento INT
);

ALTER TABLE restaurante_forma_pagamento ADD CONSTRAINT restaurante_fk FOREIGN KEY (id_restaurante) REFERENCES restaurante (id);
ALTER TABLE restaurante_forma_pagamento ADD CONSTRAINT forma_pagamento_fk FOREIGN KEY (id_forma_pagamento) REFERENCES forma_pagamento (id);

insert into restaurante (nome) values ('Pizza Boa');

insert into restaurante_forma_pagamento (id_restaurante, id_forma_pagamento) values (1,1);
insert into restaurante_forma_pagamento (id_restaurante, id_forma_pagamento) values (1,2);
insert into restaurante_forma_pagamento (id_restaurante, id_forma_pagamento) values (1,3);
insert into restaurante_forma_pagamento (id_restaurante, id_forma_pagamento) values (1,4);

