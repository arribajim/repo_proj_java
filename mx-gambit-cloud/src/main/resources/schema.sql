create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null
);

create table if not exists Taco (
  id identity,
  name varchar(50) not null,
  created_At timestamp not null
);

create table if not exists Taco_Ingredients (
  taco bigint not null,
  ingredient varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);
alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);


create table if not exists Taco_Order (
	id identity,
	delivery_name varchar(50) not null,
	delivery_state varchar(50) not null,
	delivery_city varchar(50) not null,
	delivery_street varchar(2) not null,
	delivery_zip varchar(10) not null,
	cc_number varchar(16) not null,
	cc_Expiration varchar(5) not null,
	ccCVV varchar(3) not null,
	user_id bigint,
    placed_at timestamp not null
);

create table if not exists Taco_Order_Tacos (
	tacoOrder bigint not null,
	taco bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);



--
-- Name: countries; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE  if not exists countries (
    nodeid integer NOT NULL,
	name character varying(100),
    countrycode character varying(10),   
    priority integer    
);

CREATE TABLE  if not exists leagues (
    nodeid BIGINT NOT NULL,
    name character varying(200),
    priority integer,
    parentnodeid BIGINT
);

CREATE TABLE  if not exists events (
    nodeid bigint NOT NULL,
    name character varying(200),
    startdate timestamp without time zone,
    priority integer,
    locked boolean DEFAULT false,
    statisticsid character varying(12),
    parentnodeid BIGINT
);

CREATE TABLE  if not exists games (
  nodeid       bigint                 NOT NULL, 
  name         character varying(200)     NULL, 
  priority     integer                    NULL, 
  locked       boolean                    NULL DEFAULT false, 
  parentnodeid BIGINT                     NULL
);


CREATE TABLE  if not exists gambit_results (
  nodeid       bigint                      NOT NULL, 
  name         character varying(200)          NULL, 
  create_time   timestamp without time zone     NULL, 
  odd          numeric(5,3)                    NULL, 
  priority     integer                         NULL, 
  locked       boolean                         NULL, 
  parentnodeid BIGINT                          NULL
);

CREATE TABLE  if not exists gambit_trace (
  nodeid       bigint                     NOT NULL, 
  create_time   timestamp without time zone     NULL, 
  odd          numeric(5,3)                    NULL, 
  parentnodeid BIGINT                          NULL
);

ALTER TABLE leagues
    ADD CONSTRAINT leagues_pk PRIMARY KEY (nodeid);

ALTER TABLE leagues
    ADD CONSTRAINT leagues_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES countries ( nodeid );
	

ALTER TABLE events
    ADD CONSTRAINT events_pkey PRIMARY KEY (nodeid);

ALTER TABLE events
    ADD CONSTRAINT events_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES leagues(nodeid);
	
ALTER TABLE games ADD
  CONSTRAINT game_pkey PRIMARY KEY ( nodeid );

ALTER TABLE games ADD
  CONSTRAINT game_parentnodeid_fkey FOREIGN KEY ( parentnodeid )
    REFERENCES events ( nodeid );	
	
ALTER TABLE gambit_results ADD
  CONSTRAINT gmt_reslts_pk PRIMARY KEY ( nodeid );

ALTER TABLE gambit_results ADD
  CONSTRAINT gambit_results_parentnodeid_fkey FOREIGN KEY ( parentnodeid )
    REFERENCES games ( nodeid );
	
ALTER TABLE gambit_trace ADD
  CONSTRAINT gambit_pkey PRIMARY KEY ( nodeid );

ALTER TABLE gambit_trace ADD
  CONSTRAINT gambit_parentnodeid_fkey FOREIGN KEY ( parentnodeid )
    REFERENCES gambit_results ( nodeid );