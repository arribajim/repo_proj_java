--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.12 (Ubuntu 10.12-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cities; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.cities (
    name character varying(80),
    location point
);


--
-- Name: countries; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.countries (
    nodeid integer NOT NULL,
    countrycode character varying(3),
    name character varying(100),
    priority integer
);


--
-- Name: data_from_url; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.data_from_url (
    id integer NOT NULL,
    url_relative character varying(2000) NOT NULL,
    content text,
    create_time timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    url_from integer
);


--
-- Name: data_from_url_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.data_from_url ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.data_from_url_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: events; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.events (
    nodeid bigint NOT NULL,
    name character varying(200),
    startdate timestamp without time zone,
    priority integer,
    locked boolean DEFAULT false,
    statisticsid character varying(12),
    parentnodeid integer
);


--
-- Name: gambit; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.gambit (
    nodeid integer NOT NULL,
    createtime timestamp without time zone,
    odd numeric(5,2),
    parentnodeid bigint
);


--
-- Name: gambit_nodeid_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.gambit_nodeid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: gambit_nodeid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.gambit_nodeid_seq OWNED BY public.gambit.nodeid;


--
-- Name: gambit_results; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.gambit_results (
    nodeid bigint NOT NULL,
    name character varying(200),
    createtime timestamp without time zone,
    odd numeric(5,2),
    priority integer,
    locked boolean,
    parentnodeid bigint
);


--
-- Name: games; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.games (
    nodeid bigint NOT NULL,
    name character varying(200),
    priority integer,
    locked boolean DEFAULT false,
    parentnodeid bigint
);


--
-- Name: leagues; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.leagues (
    nodeid integer NOT NULL,
    name character varying(200),
    priority integer,
    parentnodeid integer
);


--
-- Name: participants; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.participants (
    nodeid integer NOT NULL,
    name character varying(100),
    shortname character varying(20),
    parentnodeid integer
);


--
-- Name: url_source; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.url_source (
    id integer NOT NULL,
    url character varying(200) NOT NULL,
    description character varying(1500)
);


--
-- Name: url_source_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.url_source ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.url_source_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: gambit nodeid; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.gambit ALTER COLUMN nodeid SET DEFAULT nextval('public.gambit_nodeid_seq'::regclass);


--
-- Name: countries country_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT country_pk PRIMARY KEY (nodeid);


--
-- Name: data_from_url data_from_url_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.data_from_url
    ADD CONSTRAINT data_from_url_pkey PRIMARY KEY (id);


--
-- Name: events events_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (nodeid);


--
-- Name: gambit gambit_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.gambit
    ADD CONSTRAINT gambit_pkey PRIMARY KEY (nodeid);


--
-- Name: games game_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.games
    ADD CONSTRAINT game_pkey PRIMARY KEY (nodeid);


--
-- Name: gambit_results gmt_reslts_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.gambit_results
    ADD CONSTRAINT gmt_reslts_pk PRIMARY KEY (nodeid);


--
-- Name: leagues leagues_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.leagues
    ADD CONSTRAINT leagues_pk PRIMARY KEY (nodeid);


--
-- Name: participants participants_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.participants
    ADD CONSTRAINT participants_pkey PRIMARY KEY (nodeid);


--
-- Name: url_source url_source_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.url_source
    ADD CONSTRAINT url_source_pkey PRIMARY KEY (id);


--
-- Name: data_from_url data_from_url_url_from_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.data_from_url
    ADD CONSTRAINT data_from_url_url_from_fkey FOREIGN KEY (url_from) REFERENCES public.url_source(id);


--
-- Name: events events_parentnodeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES public.leagues(nodeid);


--
-- Name: gambit gambit_parentnodeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.gambit
    ADD CONSTRAINT gambit_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES public.gambit_results(nodeid);


--
-- Name: gambit_results gambit_results_parentnodeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.gambit_results
    ADD CONSTRAINT gambit_results_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES public.games(nodeid);


--
-- Name: games game_parentnodeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.games
    ADD CONSTRAINT game_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES public.events(nodeid);


--
-- Name: leagues leagues_parentnodeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.leagues
    ADD CONSTRAINT leagues_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES public.countries(nodeid);


--
-- Name: participants participants_parentnodeid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.participants
    ADD CONSTRAINT participants_parentnodeid_fkey FOREIGN KEY (parentnodeid) REFERENCES public.leagues(nodeid);


--
-- PostgreSQL database dump complete
--

