CREATE TABLE IF NOT EXISTS public.user
(
    id serial primary key,
    name VARCHAR(40) not null,
    post_code VARCHAR(15),
    profession VARCHAR(40)
) ;
