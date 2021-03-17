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
