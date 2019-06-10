--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: meeting; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.meeting (
    id integer NOT NULL,
    user_id integer,
    date timestamp without time zone
);


ALTER TABLE public.meeting OWNER TO postgres;

--
-- Name: meeting_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.meeting_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.meeting_id_seq OWNER TO postgres;

--
-- Name: meeting_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.meeting_id_seq OWNED BY public.meeting.id;


--
-- Name: user_agend; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_agend (
    id integer NOT NULL,
    name character varying(50),
    lastname character varying(50)
);


ALTER TABLE public.user_agend OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public.user_agend.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meeting ALTER COLUMN id SET DEFAULT nextval('public.meeting_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_agend ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- Data for Name: meeting; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.meeting (id, user_id, date) VALUES (1, 1, '2019-06-10 13:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (2, 1, '2019-06-10 14:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (3, 1, '2019-06-10 18:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (4, 2, '2019-06-10 07:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (5, 2, '2019-06-10 09:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (6, 2, '2019-06-10 13:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (7, 2, '2019-06-10 15:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (8, 2, '2019-06-10 15:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (9, 3, '2019-06-10 08:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (10, 3, '2019-06-10 09:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (11, 3, '2019-06-10 12:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (12, 3, '2019-06-10 15:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (13, 4, '2019-06-10 09:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (14, 4, '2019-06-10 13:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (15, 4, '2019-06-10 15:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (16, 4, '2019-06-10 15:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (17, 5, '2019-06-10 08:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (18, 5, '2019-06-10 09:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (19, 5, '2019-06-10 18:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (20, 6, '2019-06-10 08:00:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (21, 6, '2019-06-10 12:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (22, 6, '2019-06-10 13:30:00');
INSERT INTO public.meeting (id, user_id, date) VALUES (23, 6, '2019-06-10 15:30:00');


--
-- Name: meeting_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.meeting_id_seq', 5, true);


--
-- Data for Name: user_agend; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_agend (id, name, lastname) VALUES (1, 'Kyle', NULL);
INSERT INTO public.user_agend (id, name, lastname) VALUES (2, 'Paul', NULL);
INSERT INTO public.user_agend (id, name, lastname) VALUES (3, 'Alex', NULL);
INSERT INTO public.user_agend (id, name, lastname) VALUES (4, 'Luis', NULL);
INSERT INTO public.user_agend (id, name, lastname) VALUES (5, 'Jairo', NULL);
INSERT INTO public.user_agend (id, name, lastname) VALUES (6, 'Sonya', NULL);


--
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 6, true);


--
-- Name: meeting_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meeting
    ADD CONSTRAINT meeting_pkey PRIMARY KEY (id);


--
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_agend
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

