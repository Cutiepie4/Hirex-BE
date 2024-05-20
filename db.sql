--
-- PostgreSQL database dump
--

-- Dumped from database version 15.6
-- Dumped by pg_dump version 15.6

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: ability; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ability (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.ability OWNER TO postgres;

--
-- Name: ability_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ability_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ability_id_seq OWNER TO postgres;

--
-- Name: ability_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ability_id_seq OWNED BY public.ability.id;


--
-- Name: appreciation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.appreciation (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    achievement character varying(255),
    award character varying(255),
    description text,
    end_date character varying(255),
    employee_id bigint,
    work_id integer
);


ALTER TABLE public.appreciation OWNER TO postgres;

--
-- Name: appreciation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.appreciation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.appreciation_id_seq OWNER TO postgres;

--
-- Name: appreciation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.appreciation_id_seq OWNED BY public.appreciation.id;


--
-- Name: certification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.certification (
    id bigint NOT NULL,
    description character varying(255),
    end_date character varying(255),
    name character varying(255),
    start_date character varying(255),
    employee_id bigint
);


ALTER TABLE public.certification OWNER TO postgres;

--
-- Name: certification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.certification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.certification_id_seq OWNER TO postgres;

--
-- Name: certification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.certification_id_seq OWNED BY public.certification.id;


--
-- Name: company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.company (
    id bigint NOT NULL,
    description character varying(255),
    employee_size integer,
    head_office character varying(255),
    image_base64 text,
    industry character varying(255),
    name character varying(255),
    short_name character varying(255),
    website character varying(255),
    employer_id bigint
);


ALTER TABLE public.company OWNER TO postgres;

--
-- Name: company_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.company_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.company_id_seq OWNER TO postgres;

--
-- Name: company_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.company_id_seq OWNED BY public.company.id;


--
-- Name: device_token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.device_token (
    id bigint NOT NULL,
    device_token character varying(255) NOT NULL,
    user_id bigint
);


ALTER TABLE public.device_token OWNER TO postgres;

--
-- Name: device_token_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.device_token_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.device_token_id_seq OWNER TO postgres;

--
-- Name: device_token_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.device_token_id_seq OWNED BY public.device_token.id;


--
-- Name: education; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.education (
    id bigint NOT NULL,
    description character varying(255),
    end_date character varying(255),
    institution character varying(255),
    level character varying(255),
    major character varying(255),
    start_date character varying(255),
    employee_id bigint
);


ALTER TABLE public.education OWNER TO postgres;

--
-- Name: education_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.education_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.education_id_seq OWNER TO postgres;

--
-- Name: education_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.education_id_seq OWNED BY public.education.id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    about character varying(255),
    user_id bigint
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_id_seq OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_id_seq OWNED BY public.employee.id;


--
-- Name: employer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer (
    id bigint NOT NULL,
    user_id bigint
);


ALTER TABLE public.employer OWNER TO postgres;

--
-- Name: employer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employer_id_seq OWNER TO postgres;

--
-- Name: employer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employer_id_seq OWNED BY public.employer.id;


--
-- Name: experience; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.experience (
    id bigint NOT NULL,
    company character varying(255),
    description character varying(255),
    end_date character varying(255),
    job_title character varying(255),
    start_date character varying(255),
    employee_id bigint
);


ALTER TABLE public.experience OWNER TO postgres;

--
-- Name: experience_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.experience_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.experience_id_seq OWNER TO postgres;

--
-- Name: experience_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.experience_id_seq OWNED BY public.experience.id;


--
-- Name: expert; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expert (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.expert OWNER TO postgres;

--
-- Name: expert_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expert_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.expert_id_seq OWNER TO postgres;

--
-- Name: expert_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.expert_id_seq OWNED BY public.expert.id;


--
-- Name: hire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hire (
    id integer NOT NULL,
    employee_id bigint
);


ALTER TABLE public.hire OWNER TO postgres;

--
-- Name: hire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hire_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hire_id_seq OWNER TO postgres;

--
-- Name: hire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hire_id_seq OWNED BY public.hire.id;


--
-- Name: items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.items (
    id integer NOT NULL,
    end_time time(6) without time zone,
    notes character varying(255),
    start_time time(6) without time zone,
    title character varying(255),
    type character varying(255),
    schedule_id integer
);


ALTER TABLE public.items OWNER TO postgres;

--
-- Name: items_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.items_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.items_id_seq OWNER TO postgres;

--
-- Name: items_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.items_id_seq OWNED BY public.items.id;


--
-- Name: leave_reason; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.leave_reason (
    id integer NOT NULL,
    is_accept boolean,
    reason character varying(255),
    employee_id bigint,
    employer_id bigint,
    items_id integer
);


ALTER TABLE public.leave_reason OWNER TO postgres;

--
-- Name: leave_reason_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.leave_reason_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.leave_reason_id_seq OWNER TO postgres;

--
-- Name: leave_reason_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.leave_reason_id_seq OWNED BY public.leave_reason.id;


--
-- Name: notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notification (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    company_detail character varying(255)[],
    content character varying(255),
    job_detail character varying(255)[],
    title character varying(255),
    sender_id bigint
);


ALTER TABLE public.notification OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notification_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.notification_id_seq OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notification_id_seq OWNED BY public.notification.id;


--
-- Name: notification_receiver; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notification_receiver (
    id bigint NOT NULL,
    read boolean NOT NULL,
    notification_id bigint,
    receiver_id bigint
);


ALTER TABLE public.notification_receiver OWNER TO postgres;

--
-- Name: notification_receiver_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notification_receiver_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.notification_receiver_id_seq OWNER TO postgres;

--
-- Name: notification_receiver_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notification_receiver_id_seq OWNED BY public.notification_receiver.id;


--
-- Name: resume; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resume (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    image_base64 text,
    name character varying(255) NOT NULL,
    size bigint,
    employee_id bigint
);


ALTER TABLE public.resume OWNER TO postgres;

--
-- Name: resume_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resume_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resume_id_seq OWNER TO postgres;

--
-- Name: resume_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resume_id_seq OWNED BY public.resume.id;


--
-- Name: resume_work; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resume_work (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    information text,
    status character varying(255),
    resume_id bigint,
    work_id integer,
    CONSTRAINT resume_work_status_check CHECK (((status)::text = ANY ((ARRAY['PENDING'::character varying, 'ACCEPTED'::character varying, 'REJECTED'::character varying])::text[])))
);


ALTER TABLE public.resume_work OWNER TO postgres;

--
-- Name: resume_work_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resume_work_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resume_work_id_seq OWNER TO postgres;

--
-- Name: resume_work_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resume_work_id_seq OWNED BY public.resume_work.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: schedule; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.schedule (
    id integer NOT NULL,
    date date,
    work_id integer
);


ALTER TABLE public.schedule OWNER TO postgres;

--
-- Name: schedule_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.schedule_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.schedule_id_seq OWNER TO postgres;

--
-- Name: schedule_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.schedule_id_seq OWNED BY public.schedule.id;


--
-- Name: skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.skill (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    note character varying(255),
    employee_id bigint
);


ALTER TABLE public.skill OWNER TO postgres;

--
-- Name: skill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.skill_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.skill_id_seq OWNER TO postgres;

--
-- Name: skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.skill_id_seq OWNED BY public.skill.id;


--
-- Name: tokens; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tokens (
    id bigint NOT NULL,
    expiration_date timestamp(6) without time zone,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(255),
    token_type character varying(50),
    user_id bigint
);


ALTER TABLE public.tokens OWNER TO postgres;

--
-- Name: tokens_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tokens_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tokens_id_seq OWNER TO postgres;

--
-- Name: tokens_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tokens_id_seq OWNED BY public.tokens.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    is_active boolean,
    address character varying(200),
    date_of_birth character varying(255),
    facebook_account_id integer,
    fullname character varying(100),
    gender character varying(255),
    google_account_id integer,
    image_base64 text,
    mail character varying(255),
    password character varying(200) NOT NULL,
    phone_number character varying(10) NOT NULL,
    role_id bigint
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: work; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.work (
    id integer NOT NULL,
    address character varying(255),
    create_on timestamp(6) with time zone,
    description text,
    end_date date,
    end_time time(6) without time zone,
    job_position character varying(255),
    name character varying(255),
    start_date date,
    start_time time(6) without time zone,
    type_job character varying(255),
    type_work character varying(255),
    wage bigint,
    company_id bigint,
    expert_id integer
);


ALTER TABLE public.work OWNER TO postgres;

--
-- Name: work_employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.work_employee (
    work_id integer NOT NULL,
    employee_id bigint NOT NULL
);


ALTER TABLE public.work_employee OWNER TO postgres;

--
-- Name: work_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.work_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.work_id_seq OWNER TO postgres;

--
-- Name: work_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.work_id_seq OWNED BY public.work.id;


--
-- Name: work_optional_ability; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.work_optional_ability (
    work_id integer NOT NULL,
    ability_id integer NOT NULL
);


ALTER TABLE public.work_optional_ability OWNER TO postgres;

--
-- Name: work_required_ability; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.work_required_ability (
    work_id integer NOT NULL,
    ability_id integer NOT NULL
);


ALTER TABLE public.work_required_ability OWNER TO postgres;

--
-- Name: ability id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ability ALTER COLUMN id SET DEFAULT nextval('public.ability_id_seq'::regclass);


--
-- Name: appreciation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appreciation ALTER COLUMN id SET DEFAULT nextval('public.appreciation_id_seq'::regclass);


--
-- Name: certification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certification ALTER COLUMN id SET DEFAULT nextval('public.certification_id_seq'::regclass);


--
-- Name: company id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.company ALTER COLUMN id SET DEFAULT nextval('public.company_id_seq'::regclass);


--
-- Name: device_token id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.device_token ALTER COLUMN id SET DEFAULT nextval('public.device_token_id_seq'::regclass);


--
-- Name: education id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.education ALTER COLUMN id SET DEFAULT nextval('public.education_id_seq'::regclass);


--
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public.employee_id_seq'::regclass);


--
-- Name: employer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer ALTER COLUMN id SET DEFAULT nextval('public.employer_id_seq'::regclass);


--
-- Name: experience id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experience ALTER COLUMN id SET DEFAULT nextval('public.experience_id_seq'::regclass);


--
-- Name: expert id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expert ALTER COLUMN id SET DEFAULT nextval('public.expert_id_seq'::regclass);


--
-- Name: hire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hire ALTER COLUMN id SET DEFAULT nextval('public.hire_id_seq'::regclass);


--
-- Name: items id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items ALTER COLUMN id SET DEFAULT nextval('public.items_id_seq'::regclass);


--
-- Name: leave_reason id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leave_reason ALTER COLUMN id SET DEFAULT nextval('public.leave_reason_id_seq'::regclass);


--
-- Name: notification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification ALTER COLUMN id SET DEFAULT nextval('public.notification_id_seq'::regclass);


--
-- Name: notification_receiver id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification_receiver ALTER COLUMN id SET DEFAULT nextval('public.notification_receiver_id_seq'::regclass);


--
-- Name: resume id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume ALTER COLUMN id SET DEFAULT nextval('public.resume_id_seq'::regclass);


--
-- Name: resume_work id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume_work ALTER COLUMN id SET DEFAULT nextval('public.resume_work_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: schedule id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule ALTER COLUMN id SET DEFAULT nextval('public.schedule_id_seq'::regclass);


--
-- Name: skill id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skill ALTER COLUMN id SET DEFAULT nextval('public.skill_id_seq'::regclass);


--
-- Name: tokens id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tokens ALTER COLUMN id SET DEFAULT nextval('public.tokens_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: work id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work ALTER COLUMN id SET DEFAULT nextval('public.work_id_seq'::regclass);


--
-- Data for Name: ability; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ability (id, name) FROM stdin;
\.


--
-- Data for Name: appreciation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.appreciation (id, created_at, updated_at, achievement, award, description, end_date, employee_id, work_id) FROM stdin;
1	2024-05-14 02:25:27.43132	2024-05-14 02:25:27.431336	Ag	Qja	Ahau	Agh	1	1
\.


--
-- Data for Name: certification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.certification (id, description, end_date, name, start_date, employee_id) FROM stdin;
\.


--
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.company (id, description, employee_size, head_office, image_base64, industry, name, short_name, website, employer_id) FROM stdin;
1	HIVELAB VINA là agency truyền thông kỹ thuật số đa nền tảng. HIVELAB VINA mang tới một cuộc cách mạng trong thời đại chuyển đổi kỹ thuật số đang biến đổi một cách chóng mặt.	100	Tòa nhà UDIC Complex N04	UklGRtgCAABXRUJQVlA4IMwCAADwFACdASqMAIwAPm02mkkkIyKhI5VYIIANiWlu4XVBtAHX7/avxL6Cg8++t/lLopv7NvBHBv5L/gPy5/Gb1g5CLiBpjf9C83P/S+4D3B/Rv/L9wv9Yv9d2EPQrDsAeWnlebo4xc3Rxi5ujjFyfOUELx1WlE1zHUUFkeiCd1g0fUjjgam5StpfH/NgUO4gRSe7qXFY+SQPmLJeqlRGHmzHPe/0QeWnlebo4xc3Rxi5MAAD+/6tgAUr8MRYNgYWFVDFzcirq+n7C+iiwMhhv6wis8x//ENKC/g8c3prBZP47ZGA/JopmkOstUXierWnW4/Zd3bH1OzntLCWe6ZsZzhCpYq4KMVhdVyTHXyQ4rMS38ByWojuNiYbInZn//+YdoRiXzHQOa/C2r+E8wX0hFvCpNyvZXzSqj7S0/JrBl0T+FITlvj2B/ipuDQZ76FmQWH7rc+VLlZ+uFkf/oGJKqrc2IXyJz3mM3Gi04yrrzm6F4ub9y2nA4YAlVSwVjqQ8JL0zobZZLRBTvDp0ir8owHn4tJv/5YHWsTdnKDEsUlPw4lJD1WmAQt6aHYVGx/3WbAbUma1gohoeUwEnHCjXD6/FPgApdzM+v4dzt79xl9CrDgeeW/lfuqAbOjXnY3RzJM40OQXXxbEFDhJozOc7yNcym94vUl9BQnJdt5f1Min/6g2cyEQg8eBwZC7iC0wEG0hXkb/ZP/m9W0O9BRri/XYr6vWi78eE21/gbyyQHgIGseACSecvb9LQwHPC7IT+UNhyT0Z41VvFRjBweiohVUdC8DZ1NzQCRW78aMiJYrYGgv3/1VL/3+3TFO23/v+uVHp7M0NlBCetPZjI0HQSlphMvvL67/ZFwCooqXX6kRGGjtLxnEoyCd0HqjprCeyT493z85aUb0dqlmvp7LG39BANbrcmf6SzqhG6V4eL53h1n964bcslxlJAAAAAAA==	IT	Công ty TNHH Hivelab Vina	Hivelab Vina	https://hivelab.com/vn	1
\.


--
-- Data for Name: device_token; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.device_token (id, device_token, user_id) FROM stdin;
4	eTFyPN2eTV2BZkyncIX5q8:APA91bGgtIeOU93qtvLlH0gwUZKuaz-4lFOwBu98a9d9kHV-pl6VmW4P_UiQgHQ-B9h3BxM44w3FKF7fxIh9DUECWws3iPuxsSY2pEd-XnNt0FP-THsJ1QPDZcBMDa30g8MPzW5KZSGo	11
5	fAJ8huL_Q1SlPRc2KAoiT7:APA91bE2BZsPwkTvd1j7qQbktfARFWS8vGLQ7tfwiPrC8Xp_PIRgUNk31ghSz8uutyrKZRC1lwWSJAJ9NoB9Sx5yMa8JkuvXGfgqBcSVAYwoZaonLbgmdslBMiiUMtYSUQQznrTCmM72	10
6	cMobpafASmWNZTz1ZuSdJh:APA91bF3L4ZRbuLaez6L6Nq7AtI226A78wwjGMAY-tE5X2Zb3APgOkChtfnJWDZvvWK3BcVk_2EKzKiO7pT4oObhOyhEeEPjpBbHW6SjKr1mZues_vF1VSYIYWdl-YZ1jZNW5B1MsCIl	11
\.


--
-- Data for Name: education; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.education (id, description, end_date, institution, level, major, start_date, employee_id) FROM stdin;
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, about, user_id) FROM stdin;
1	\N	1
2	\N	2
3	\N	3
4	\N	4
5	\N	5
6	\N	6
7	\N	7
8	\N	8
9	\N	9
10	\N	10
\.


--
-- Data for Name: employer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employer (id, user_id) FROM stdin;
1	11
2	12
3	13
4	14
5	15
6	16
7	17
8	18
9	19
10	20
\.


--
-- Data for Name: experience; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.experience (id, company, description, end_date, job_title, start_date, employee_id) FROM stdin;
\.


--
-- Data for Name: expert; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.expert (id, name) FROM stdin;
1	Design
\.


--
-- Data for Name: hire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hire (id, employee_id) FROM stdin;
\.


--
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.items (id, end_time, notes, start_time, title, type, schedule_id) FROM stdin;
\.


--
-- Data for Name: leave_reason; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.leave_reason (id, is_accept, reason, employee_id, employer_id, items_id) FROM stdin;
\.


--
-- Data for Name: notification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification (id, created_at, updated_at, company_detail, content, job_detail, title, sender_id) FROM stdin;
1	2024-05-14 02:24:08.255662	2024-05-14 02:24:08.255677	{"Công ty TNHH Hivelab Vina","HIVELAB VINA là agency truyền thông kỹ thuật số đa nền tảng. HIVELAB VINA mang tới một cuộc cách mạng trong thời đại chuyển đổi kỹ thuật số đang biến đổi một cách chóng mặt.",100}	Đơn xin việc của bạn cho công ty Công ty TNHH Hivelab Vina đã được chấp thuận. Vui lòng liên hệ nhà tuyển dụng để biết thêm thông tin chi tiết	{"UI Designer","Thiết kế UI cho Responsive Web, Mobile Web, App\nLead và thiết kế dự án UI vừa/lớn. Đưa ra đề xuất thiết kế và thuyết trình. Xây dựng hệ thống thiết kế. Trên 4 năm kinh nghiệm."}	Đã có kết quả ứng tuyển	\N
10	2024-05-14 10:01:18.471708	2024-05-14 10:01:18.471749	{"Công ty TNHH Hivelab Vina","HIVELAB VINA là agency truyền thông kỹ thuật số đa nền tảng. HIVELAB VINA mang tới một cuộc cách mạng trong thời đại chuyển đổi kỹ thuật số đang biến đổi một cách chóng mặt.",100}	Đơn xin việc của bạn cho công ty Công ty TNHH Hivelab Vina đã được chấp thuận. Vui lòng liên hệ nhà tuyển dụng để biết thêm thông tin chi tiết	{"UI Designer","Thiết kế UI cho Responsive Web, Mobile Web, App\nLead và thiết kế dự án UI vừa/lớn. Đưa ra đề xuất thiết kế và thuyết trình. Xây dựng hệ thống thiết kế. Trên 4 năm kinh nghiệm."}	Đã có kết quả ứng tuyển	\N
\.


--
-- Data for Name: notification_receiver; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification_receiver (id, read, notification_id, receiver_id) FROM stdin;
1	t	10	10
\.


--
-- Data for Name: resume; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resume (id, created_at, updated_at, image_base64, name, size, employee_id) FROM stdin;
1	2024-05-14 01:45:00	2024-05-14 01:45:00	JVBERi0xLjQKJfbk/N8KMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwovVmVyc2lvbiAvMS40Ci9QYWdlcyAyIDAgUgo+PgplbmRvYmoKMiAwIG9iago8PAovVHlwZSAvUGFnZXMKL0tpZHMgWzMgMCBSXQovQ291bnQgMQo+PgplbmRvYmoKMyAwIG9iago8PAovVHlwZSAvUGFnZQovUGFyZW50IDIgMCBSCi9NZWRpYUJveCBbMC4wIDAuMCA1OTUuMCA4NDEuMF0KL1Jlc291cmNlcyA8PAovWE9iamVjdCA0IDAgUgovUHJvY1NldCBbL1BERiAvVGV4dCAvSW1hZ2VCIC9JbWFnZUMgL0ltYWdlSV0KPj4KL0NvbnRlbnRzIDUgMCBSCi9Sb3RhdGUgMAovQ3JvcEJveCBbMC4wIDAuMCA1OTUuMCA4NDEuMF0KPj4KZW5kb2JqCjQgMCBvYmoKPDwKL0pJMjdPYmoxIDYgMCBSCi9USTI3T2JqMSA3IDAgUgovVEkyN09iajIgOCAwIFIKL1RJMjdPYmozIDkgMCBSCi9USTI3T2JqNCAxMCAwIFIKL1RJMjdPYmo1IDExIDAgUgovVEkyN09iajYgMTIgMCBSCi9USTI3T2JqNyAxMyAwIFIKL1RJMjdPYmo4IDE0IDAgUgovVEkyN09iajkgMTUgMCBSCi9USTI3T2JqMTAgMTYgMCBSCi9USTI3T2JqMTEgMTcgMCBSCi9USTI3T2JqMTIgMTggMCBSCi9USTI3T2JqMTMgMTkgMCBSCi9USTI3T2JqMTQgMjAgMCBSCi9USTI3T2JqMTUgMjEgMCBSCi9USTI3T2JqMTYgMjIgMCBSCi9USTI3T2JqMTcgMjMgMCBSCi9USTI3T2JqMTggMjQgMCBSCi9USTI3T2JqMTkgMjUgMCBSCi9USTI3T2JqMjAgMjYgMCBSCi9USTI3T2JqMjEgMjcgMCBSCi9USTI3T2JqMjIgMjggMCBSCi9USTI3T2JqMjMgMjkgMCBSCi9USTI3T2JqMjQgMzAgMCBSCi9USTI3T2JqMjUgMzEgMCBSCi9USTI3T2JqMjYgMzIgMCBSCi9USTI3T2JqMjcgMzMgMCBSCi9USTI3T2JqMjggMzQgMCBSCi9USTI3T2JqMjkgMzUgMCBSCi9USTI3T2JqMzAgMzYg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	Nguyen Van A CV	\N	1
2	2024-05-14 01:45:00	2024-05-14 01:45:00	JVBERi0xLjQKJfbk/N8KMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwovVmVyc2lvbiAvMS40Ci9QYWdlcyAyIDAgUgo+PgplbmRvYmoKMiAwIG9iago8PAovVHlwZSAvUGFnZXMKL0tpZHMgWzMgMCBSXQovQ291bnQgMQo+PgplbmRvYmoKMyAwIG9iago8PAovVHlwZSAvUGFnZQovUGFyZW50IDIgMCBSCi9NZWRpYUJveCBbMC4wIDAuMCA1OTUuMCA4NDEuMF0KL1Jlc291cmNlcyA8PAovWE9iamVjdCA0IDAgUgovUHJvY1NldCBbL1BERiAvVGV4dCAvSW1hZ2VCIC9JbWFnZUMgL0ltYWdlSV0KPj4KL0NvbnRlbnRzIDUgMCBSCi9Sb3RhdGUgMAovQ3JvcEJveCBbMC4wIDAuMCA1OTUuMCA4NDEuMF0KPj4KZW5kb2JqCjQgMCBvYmoKPDwKL0pJMjdPYmoxIDYgMCBSCi9USTI3T2JqMSA3IDAgUgovVEkyN09iajIgOCAwIFIKL1RJMjdPYmozIDkgMCBSCi9USTI3T2JqNCAxMCAwIFIKL1RJMjdPYmo1IDExIDAgUgovVEkyN09iajYgMTIgMCBSCi9USTI3T2JqNyAxMyAwIFIKL1RJMjdPYmo4IDE0IDAgUgovVEkyN09iajkgMTUgMCBSCi9USTI3T2JqMTAgMTYgMCBSCi9USTI3T2JqMTEgMTcgMCBSCi9USTI3T2JqMTIgMTggMCBSCi9USTI3T2JqMTMgMTkgMCBSCi9USTI3T2JqMTQgMjAgMCBSCi9USTI3T2JqMTUgMjEgMCBSCi9USTI3T2JqMTYgMjIgMCBSCi9USTI3T2JqMTcgMjMgMCBSCi9USTI3T2JqMTggMjQgMCBSCi9USTI3T2JqMTkgMjUgMCBSCi9USTI3T2JqMjAgMjYgMCBSCi9USTI3T2JqMjEgMjcgMCBSCi9USTI3T2JqMjIgMjggMCBSCi9USTI3T2JqMjMgMjkgMCBSCi9USTI3T2JqMjQgMzAgMCBSCi9USTI3T2JqMjUgMzEgMCBSCi9USTI3T2JqMjYgMzIgMCBSCi9USTI3T2JqMjcgMzMgMCBSCi9USTI3T2JqMjggMzQgMCBSCi9USTI3T2JqMjkgMzUgMCBSCi9USTI3T2JqMzAgMzYg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	Viet CV	\N	10
\.


--
-- Data for Name: resume_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resume_work (id, created_at, updated_at, information, status, resume_id, work_id) FROM stdin;
3	2024-05-14 09:18:40.10681	2024-05-14 10:01:18.401621		ACCEPTED	2	1
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
1	USER
2	ADMIN
\.


--
-- Data for Name: schedule; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.schedule (id, date, work_id) FROM stdin;
\.


--
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.skill (id, name, note, employee_id) FROM stdin;
\.


--
-- Data for Name: tokens; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tokens (id, expiration_date, expired, revoked, token, token_type, user_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, created_at, updated_at, is_active, address, date_of_birth, facebook_account_id, fullname, gender, google_account_id, image_base64, mail, password, phone_number, role_id) FROM stdin;
1	2024-05-14 01:03:49.234271	2024-05-14 01:03:49.234308	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$as9.Fuknwd74juTKVcHy8u8RudhFENDEKAwPbDScyyS4OrEg3N7VC	0974098790	1
2	2024-05-14 01:03:54.404823	2024-05-14 01:03:54.404842	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$qRP2kSXuxc9QZuox3TRbEeDfjyrB/8rbbIAWg74hqMfvkWCylCXAa	0974098791	1
3	2024-05-14 01:03:57.013965	2024-05-14 01:03:57.014	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$rsg08Isqgq/1YcETE1CY8.tSBfEn08W1QrJMEkviKzOLnASc0LFmS	0974098792	1
4	2024-05-14 01:03:59.488466	2024-05-14 01:03:59.488487	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$BWGFnDigaQehIpImkQdS4OTuIrkiBooJYC2kLT5vuYuFCl20088kC	0974098793	1
5	2024-05-14 01:04:02.152049	2024-05-14 01:04:02.152091	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$f2pzNCCUhJnSwKL8.Sn0b.Nrffu5wWXywOXSX.iM44Z42FzK1Nxyy	0974098794	1
6	2024-05-14 01:04:04.969256	2024-05-14 01:04:04.969296	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$e2Dg//sLX8OdnSXV55n.BeI5Ode26zr3xDo0HPgrQF43rkUGkvB2C	0974098795	1
7	2024-05-14 01:04:07.554261	2024-05-14 01:04:07.55428	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$4voVF19Eo37FJnhzpXrql.It0scDCyOEZiZm0uufA2T3qIR4rY1yG	0974098796	1
8	2024-05-14 01:04:11.097403	2024-05-14 01:04:11.097473	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$PTl4qqCL/USqrmj81Tdl0urJxKsWk11A46MnlDFAi7f.7uxPs//YS	0974098797	1
9	2024-05-14 01:04:14.964261	2024-05-14 01:04:14.964278	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$vCxBwwbd7nXiCLkEjufqzOj/zTXpl2u3Ws0Z5H.Ro2TMub3PnbpGK	0974098798	1
12	2024-05-14 01:04:31.684838	2024-05-14 01:04:31.684858	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$egrWm4MQz/aLMUoIeHLvjOSxhYQJxUAdQsrQB4rvO.SnIvj42tuL6	0974098781	2
13	2024-05-14 01:04:36.367269	2024-05-14 01:04:36.367287	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$ZodBjDRMAp8pFmCbpIrDYe4Bg0OzgwQuEmgKxUAH37omSPbjqBAva	0974098782	2
14	2024-05-14 01:04:38.377418	2024-05-14 01:04:38.377441	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$TJNkfQ2qrC4rGmfnz2sOb.5kmb49/75foRxvvz7xDCW9/i55aDaSS	0974098783	2
15	2024-05-14 01:04:40.548757	2024-05-14 01:04:40.548783	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$HPiwansIWWeLgiIfLV1ahuoo0Q0EiaTZ.MBmQ9kTGr6n9ADYX8KMy	0974098784	2
16	2024-05-14 01:04:42.259588	2024-05-14 01:04:42.259607	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$s3m9K6ZJmzk24la.cxYBNOnQDzzhKqJ/zE/hvopf81jH1UGYgrRAC	0974098785	2
17	2024-05-14 01:04:45.531561	2024-05-14 01:04:45.53158	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$yJn6d.cBuqM/1JiDzfQB7uV7XazVevf6VvEOhOXl8ifLYmPrpDSUG	0974098786	2
18	2024-05-14 01:04:48.120317	2024-05-14 01:04:48.120337	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$8KoSdR6Yx0tCeFkasY844u/rD4MRP76arMXJDq1DDKJczrSqx2vxa	0974098787	2
19	2024-05-14 01:04:51.966279	2024-05-14 01:04:51.966298	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$.dsFSEfvE68Se4IWSGZHuORkdoQ0pG7PrbOfd51I1.ciqoNIJyh9C	0974098788	2
20	2024-05-14 01:04:55.285832	2024-05-14 01:04:55.285849	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$SYqSURjKJLYwpQxiCVxugO0T1mkqY8C2uco4TPQgdiVRteIbg9DiW	0974098789	2
10	2024-05-14 01:04:23.649845	2024-05-14 01:04:23.649863	f	\N	\N	0	Viet	\N	0	\N	\N	$2a$10$8L4BXnphKkzgiX8Qj66KheD8po3flNkgYSJYW/IdYAPu9t35EbbMS	0946745428	1
11	2024-05-14 01:04:29.861692	2024-05-14 01:04:29.861711	f	\N	\N	0	Thanh	\N	0	\N	\N	$2a$10$6K.YeOKuW2lYvhEuvo6.WORT7xSl6AjsMSpYERPiBVIn3Jg4NEV/C	0974098780	2
\.


--
-- Data for Name: work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work (id, address, create_on, description, end_date, end_time, job_position, name, start_date, start_time, type_job, type_work, wage, company_id, expert_id) FROM stdin;
1	Hà Nội	2024-05-14 00:54:00+00	Thiết kế UI cho Responsive Web, Mobile Web, App\nLead và thiết kế dự án UI vừa/lớn. Đưa ra đề xuất thiết kế và thuyết trình. Xây dựng hệ thống thiết kế. Trên 4 năm kinh nghiệm.	2024-08-01	17:00:00	Senior	UI Designer	2024-06-01	08:00:00	ONSITE	FULLTIME	18000000000	1	1
2	Hà Nội	2024-05-14 00:54:00+00	Thiết kế UI cho Responsive Web, Mobile Web, App\nLead và thiết kế dự án UI vừa/lớn. Đưa ra đề xuất thiết kế và thuyết trình. Xây dựng hệ thống thiết kế. Trên 4 năm kinh nghiệm.	2024-08-01	17:00:00	Senior	UI Designer	2024-06-01	08:00:00	REMOTE	FULLTIME	17000000000	1	1
\.


--
-- Data for Name: work_employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work_employee (work_id, employee_id) FROM stdin;
1	10
\.


--
-- Data for Name: work_optional_ability; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work_optional_ability (work_id, ability_id) FROM stdin;
\.


--
-- Data for Name: work_required_ability; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work_required_ability (work_id, ability_id) FROM stdin;
\.


--
-- Name: ability_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ability_id_seq', 1, false);


--
-- Name: appreciation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.appreciation_id_seq', 1, true);


--
-- Name: certification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.certification_id_seq', 1, false);


--
-- Name: company_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.company_id_seq', 1, false);


--
-- Name: device_token_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.device_token_id_seq', 6, true);


--
-- Name: education_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.education_id_seq', 1, false);


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_id_seq', 1, false);


--
-- Name: employer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employer_id_seq', 1, true);


--
-- Name: experience_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.experience_id_seq', 1, false);


--
-- Name: expert_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.expert_id_seq', 1, false);


--
-- Name: hire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hire_id_seq', 1, false);


--
-- Name: items_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.items_id_seq', 1, false);


--
-- Name: leave_reason_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.leave_reason_id_seq', 1, false);


--
-- Name: notification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_id_seq', 10, true);


--
-- Name: notification_receiver_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_receiver_id_seq', 1, true);


--
-- Name: resume_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resume_id_seq', 1, false);


--
-- Name: resume_work_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resume_work_id_seq', 3, true);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 1, false);


--
-- Name: schedule_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.schedule_id_seq', 1, false);


--
-- Name: skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.skill_id_seq', 1, false);


--
-- Name: tokens_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tokens_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 20, true);


--
-- Name: work_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.work_id_seq', 1, false);


--
-- Name: ability ability_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ability
    ADD CONSTRAINT ability_pkey PRIMARY KEY (id);


--
-- Name: appreciation appreciation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appreciation
    ADD CONSTRAINT appreciation_pkey PRIMARY KEY (id);


--
-- Name: certification certification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certification
    ADD CONSTRAINT certification_pkey PRIMARY KEY (id);


--
-- Name: company company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


--
-- Name: device_token device_token_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.device_token
    ADD CONSTRAINT device_token_pkey PRIMARY KEY (id);


--
-- Name: education education_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.education
    ADD CONSTRAINT education_pkey PRIMARY KEY (id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: employer employer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_pkey PRIMARY KEY (id);


--
-- Name: experience experience_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experience
    ADD CONSTRAINT experience_pkey PRIMARY KEY (id);


--
-- Name: expert expert_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expert
    ADD CONSTRAINT expert_pkey PRIMARY KEY (id);


--
-- Name: hire hire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hire
    ADD CONSTRAINT hire_pkey PRIMARY KEY (id);


--
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT items_pkey PRIMARY KEY (id);


--
-- Name: leave_reason leave_reason_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leave_reason
    ADD CONSTRAINT leave_reason_pkey PRIMARY KEY (id);


--
-- Name: notification notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (id);


--
-- Name: notification_receiver notification_receiver_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification_receiver
    ADD CONSTRAINT notification_receiver_pkey PRIMARY KEY (id);


--
-- Name: resume resume_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume
    ADD CONSTRAINT resume_pkey PRIMARY KEY (id);


--
-- Name: resume_work resume_work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume_work
    ADD CONSTRAINT resume_work_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: schedule schedule_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY (id);


--
-- Name: skill skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- Name: tokens tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_pkey PRIMARY KEY (id);


--
-- Name: employer uk_k30e1f6l8hxi1t8aabflue0he; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT uk_k30e1f6l8hxi1t8aabflue0he UNIQUE (user_id);


--
-- Name: employee uk_mpps3d3r9pdvyjx3iqixi96fi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT uk_mpps3d3r9pdvyjx3iqixi96fi UNIQUE (user_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: work work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work
    ADD CONSTRAINT work_pkey PRIMARY KEY (id);


--
-- Name: company fk1fcyk534qc5f7r4ctl05c78aa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.company
    ADD CONSTRAINT fk1fcyk534qc5f7r4ctl05c78aa FOREIGN KEY (employer_id) REFERENCES public.employer(id);


--
-- Name: tokens fk2dylsfo39lgjyqml2tbe0b0ss; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT fk2dylsfo39lgjyqml2tbe0b0ss FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: employer fk43iuo0lskcmiokbwvolc0lmj9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT fk43iuo0lskcmiokbwvolc0lmj9 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: work fk4wk9vb6533f8wtp03biftqqmp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work
    ADD CONSTRAINT fk4wk9vb6533f8wtp03biftqqmp FOREIGN KEY (company_id) REFERENCES public.company(id);


--
-- Name: work_optional_ability fk597ablwunym4k0wgp0xm4vjp5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_optional_ability
    ADD CONSTRAINT fk597ablwunym4k0wgp0xm4vjp5 FOREIGN KEY (work_id) REFERENCES public.work(id);


--
-- Name: work_required_ability fk7rmygphh3uw6wnaqh98burqc5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_required_ability
    ADD CONSTRAINT fk7rmygphh3uw6wnaqh98burqc5 FOREIGN KEY (ability_id) REFERENCES public.ability(id);


--
-- Name: appreciation fk881isobm2q3hqcaxcodywsu63; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appreciation
    ADD CONSTRAINT fk881isobm2q3hqcaxcodywsu63 FOREIGN KEY (work_id) REFERENCES public.work(id);


--
-- Name: work_employee fkaoq6752w4mhh1kfy3a876qva0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_employee
    ADD CONSTRAINT fkaoq6752w4mhh1kfy3a876qva0 FOREIGN KEY (work_id) REFERENCES public.work(id);


--
-- Name: resume fkc23lph87g197vxyda403qsks3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume
    ADD CONSTRAINT fkc23lph87g197vxyda403qsks3 FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: resume_work fkc5caxlx9ve5e2gbgmowa0aok; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume_work
    ADD CONSTRAINT fkc5caxlx9ve5e2gbgmowa0aok FOREIGN KEY (work_id) REFERENCES public.work(id);


--
-- Name: work fkctnbs6n18oaqqfokbq6kjihu5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work
    ADD CONSTRAINT fkctnbs6n18oaqqfokbq6kjihu5 FOREIGN KEY (expert_id) REFERENCES public.expert(id);


--
-- Name: device_token fkdklq4fbedbwx14v2varmsjeb5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.device_token
    ADD CONSTRAINT fkdklq4fbedbwx14v2varmsjeb5 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: items fkdofgbrcx9wmstf7xpdu5dqpdk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.items
    ADD CONSTRAINT fkdofgbrcx9wmstf7xpdu5dqpdk FOREIGN KEY (schedule_id) REFERENCES public.schedule(id);


--
-- Name: skill fkeqkx730icjs5oq845i9b286fn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skill
    ADD CONSTRAINT fkeqkx730icjs5oq845i9b286fn FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: work_employee fkfdmof3xgxq1be4fu2j31j5ywt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_employee
    ADD CONSTRAINT fkfdmof3xgxq1be4fu2j31j5ywt FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: leave_reason fkfff74wn95dovppgs7l6cr09gs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leave_reason
    ADD CONSTRAINT fkfff74wn95dovppgs7l6cr09gs FOREIGN KEY (items_id) REFERENCES public.items(id);


--
-- Name: leave_reason fkfwa3dvx68v7rw7lmj5nicrlor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leave_reason
    ADD CONSTRAINT fkfwa3dvx68v7rw7lmj5nicrlor FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: leave_reason fkh6yqve86iq29i8ncju0lt30s2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.leave_reason
    ADD CONSTRAINT fkh6yqve86iq29i8ncju0lt30s2 FOREIGN KEY (employer_id) REFERENCES public.employer(id);


--
-- Name: notification_receiver fkh7c941e7d3l1mndu9tcptvtl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification_receiver
    ADD CONSTRAINT fkh7c941e7d3l1mndu9tcptvtl FOREIGN KEY (receiver_id) REFERENCES public.users(id);


--
-- Name: employee fkhal2duyxxjtadykhxos7wd3wg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkhal2duyxxjtadykhxos7wd3wg FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: resume_work fkjgxhe12xdaqukugeovnyxy87q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resume_work
    ADD CONSTRAINT fkjgxhe12xdaqukugeovnyxy87q FOREIGN KEY (resume_id) REFERENCES public.resume(id);


--
-- Name: experience fkl2jnevdmibil233ecogbvoff4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.experience
    ADD CONSTRAINT fkl2jnevdmibil233ecogbvoff4 FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: notification_receiver fkmkh5n7otyogidkltg6oh64psj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification_receiver
    ADD CONSTRAINT fkmkh5n7otyogidkltg6oh64psj FOREIGN KEY (notification_id) REFERENCES public.notification(id);


--
-- Name: work_optional_ability fknfkcrqdigjiwqax42c2m1yfh5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_optional_ability
    ADD CONSTRAINT fknfkcrqdigjiwqax42c2m1yfh5 FOREIGN KEY (ability_id) REFERENCES public.ability(id);


--
-- Name: schedule fkntbodux7df96xm8x7t173u95b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT fkntbodux7df96xm8x7t173u95b FOREIGN KEY (work_id) REFERENCES public.work(id);


--
-- Name: users fkp56c1712k691lhsyewcssf40f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkp56c1712k691lhsyewcssf40f FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: hire fkpfgmhipwk3c1axwf31jwbq3ol; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hire
    ADD CONSTRAINT fkpfgmhipwk3c1axwf31jwbq3ol FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: work_required_ability fkqpyp9wckw5sytpxjm3mogbhlw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.work_required_ability
    ADD CONSTRAINT fkqpyp9wckw5sytpxjm3mogbhlw FOREIGN KEY (work_id) REFERENCES public.work(id);


--
-- Name: notification fkrg0atx075rr68et2rqrh34qwj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT fkrg0atx075rr68et2rqrh34qwj FOREIGN KEY (sender_id) REFERENCES public.users(id);


--
-- Name: education fkrphg8gbx569xvj1txkkt91uy4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.education
    ADD CONSTRAINT fkrphg8gbx569xvj1txkkt91uy4 FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: appreciation fksflvdb3dm1wq5h6hqkotgjgfo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appreciation
    ADD CONSTRAINT fksflvdb3dm1wq5h6hqkotgjgfo FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: certification fksjeb90rsau4j8bh8j0ik25ayq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certification
    ADD CONSTRAINT fksjeb90rsau4j8bh8j0ik25ayq FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- PostgreSQL database dump complete
--

