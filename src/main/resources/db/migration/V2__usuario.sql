create table usuario (
id INT GENERATED ALWAYS AS IDENTITY primary key,
email character varying (255)
);

create table usuario_forma_pagamento (
id_usuario INT,
id_forma_pagamento INT
);

ALTER TABLE usuario_forma_pagamento ADD CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id);
ALTER TABLE usuario_forma_pagamento ADD CONSTRAINT forma_pagamento_fk FOREIGN KEY (id_forma_pagamento) REFERENCES forma_pagamento (id);

insert into usuario (email) values ('diego@gmail.com');
insert into usuario (email) values ('joao@gmail.com');

insert into usuario_forma_pagamento (id_usuario, id_forma_pagamento) values (1,1);
insert into usuario_forma_pagamento (id_usuario, id_forma_pagamento) values (1,3);
insert into usuario_forma_pagamento (id_usuario, id_forma_pagamento) values (2,2);
insert into usuario_forma_pagamento (id_usuario, id_forma_pagamento) values (2,4);