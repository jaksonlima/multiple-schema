create table public.timeline (
	id serial primary key,
	mobile_id int4,
	unit_id int4,
	created_at timestamp default now(),
	updated_at timestamp default now()
);


create table mobile.mobile(
id serial primary key,
name varchar(10)
);


create table public.unit(
id serial primary key,
name varchar(10)
);

alter table public.timeline
add constraint fk_mobile_id
foreign key (mobile_id)
references mobile.mobile (id);

alter table public.timeline
add constraint fk_unit_id
foreign key (unit_id)
references public.unit (id);