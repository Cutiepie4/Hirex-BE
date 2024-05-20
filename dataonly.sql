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

--
-- Data for Name: ability; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ability (id, name) FROM stdin;
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
1	USER
2	ADMIN
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
10	2024-05-14 01:04:23.649845	2024-05-14 01:04:23.649863	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$8L4BXnphKkzgiX8Qj66KheD8po3flNkgYSJYW/IdYAPu9t35EbbMS	0974098799	1
11	2024-05-14 01:04:29.861692	2024-05-14 01:04:29.861711	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$6K.YeOKuW2lYvhEuvo6.WORT7xSl6AjsMSpYERPiBVIn3Jg4NEV/C	0974098780	2
12	2024-05-14 01:04:31.684838	2024-05-14 01:04:31.684858	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$egrWm4MQz/aLMUoIeHLvjOSxhYQJxUAdQsrQB4rvO.SnIvj42tuL6	0974098781	2
13	2024-05-14 01:04:36.367269	2024-05-14 01:04:36.367287	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$ZodBjDRMAp8pFmCbpIrDYe4Bg0OzgwQuEmgKxUAH37omSPbjqBAva	0974098782	2
14	2024-05-14 01:04:38.377418	2024-05-14 01:04:38.377441	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$TJNkfQ2qrC4rGmfnz2sOb.5kmb49/75foRxvvz7xDCW9/i55aDaSS	0974098783	2
15	2024-05-14 01:04:40.548757	2024-05-14 01:04:40.548783	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$HPiwansIWWeLgiIfLV1ahuoo0Q0EiaTZ.MBmQ9kTGr6n9ADYX8KMy	0974098784	2
16	2024-05-14 01:04:42.259588	2024-05-14 01:04:42.259607	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$s3m9K6ZJmzk24la.cxYBNOnQDzzhKqJ/zE/hvopf81jH1UGYgrRAC	0974098785	2
17	2024-05-14 01:04:45.531561	2024-05-14 01:04:45.53158	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$yJn6d.cBuqM/1JiDzfQB7uV7XazVevf6VvEOhOXl8ifLYmPrpDSUG	0974098786	2
18	2024-05-14 01:04:48.120317	2024-05-14 01:04:48.120337	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$8KoSdR6Yx0tCeFkasY844u/rD4MRP76arMXJDq1DDKJczrSqx2vxa	0974098787	2
19	2024-05-14 01:04:51.966279	2024-05-14 01:04:51.966298	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$.dsFSEfvE68Se4IWSGZHuORkdoQ0pG7PrbOfd51I1.ciqoNIJyh9C	0974098788	2
20	2024-05-14 01:04:55.285832	2024-05-14 01:04:55.285849	f	\N	\N	0	\N	\N	0	\N	\N	$2a$10$SYqSURjKJLYwpQxiCVxugO0T1mkqY8C2uco4TPQgdiVRteIbg9DiW	0974098789	2
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
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.company (id, description, employee_size, head_office, image_base64, industry, name, short_name, website, employer_id) FROM stdin;
1	HIVELAB VINA là agency truyền thông kỹ thuật số đa nền tảng. HIVELAB VINA mang tới một cuộc cách mạng trong thời đại chuyển đổi kỹ thuật số đang biến đổi một cách chóng mặt.	100	Tòa nhà UDIC Complex N04	UklGRtgCAABXRUJQVlA4IMwCAADwFACdASqMAIwAPm02mkkkIyKhI5VYIIANiWlu4XVBtAHX7/avxL6Cg8++t/lLopv7NvBHBv5L/gPy5/Gb1g5CLiBpjf9C83P/S+4D3B/Rv/L9wv9Yv9d2EPQrDsAeWnlebo4xc3Rxi5ujjFyfOUELx1WlE1zHUUFkeiCd1g0fUjjgam5StpfH/NgUO4gRSe7qXFY+SQPmLJeqlRGHmzHPe/0QeWnlebo4xc3Rxi5MAAD+/6tgAUr8MRYNgYWFVDFzcirq+n7C+iiwMhhv6wis8x//ENKC/g8c3prBZP47ZGA/JopmkOstUXierWnW4/Zd3bH1OzntLCWe6ZsZzhCpYq4KMVhdVyTHXyQ4rMS38ByWojuNiYbInZn//+YdoRiXzHQOa/C2r+E8wX0hFvCpNyvZXzSqj7S0/JrBl0T+FITlvj2B/ipuDQZ76FmQWH7rc+VLlZ+uFkf/oGJKqrc2IXyJz3mM3Gi04yrrzm6F4ub9y2nA4YAlVSwVjqQ8JL0zobZZLRBTvDp0ir8owHn4tJv/5YHWsTdnKDEsUlPw4lJD1WmAQt6aHYVGx/3WbAbUma1gohoeUwEnHCjXD6/FPgApdzM+v4dzt79xl9CrDgeeW/lfuqAbOjXnY3RzJM40OQXXxbEFDhJozOc7yNcym94vUl9BQnJdt5f1Min/6g2cyEQg8eBwZC7iC0wEG0hXkb/ZP/m9W0O9BRri/XYr6vWi78eE21/gbyyQHgIGseACSecvb9LQwHPC7IT+UNhyT0Z41VvFRjBweiohVUdC8DZ1NzQCRW78aMiJYrYGgv3/1VL/3+3TFO23/v+uVHp7M0NlBCetPZjI0HQSlphMvvL67/ZFwCooqXX6kRGGjtLxnEoyCd0HqjprCeyT493z85aUb0dqlmvp7LG39BANbrcmf6SzqhG6V4eL53h1n964bcslxlJAAAAAAA==	IT	Công ty TNHH Hivelab Vina	Hivelab Vina	https://hivelab.com/vn	1
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
-- Data for Name: expert; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.expert (id, name) FROM stdin;
1	Design
\.


--
-- Data for Name: work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work (id, address, create_on, description, end_date, end_time, job_position, name, start_date, start_time, type_job, type_work, wage, company_id, expert_id) FROM stdin;
1	Hà Nội	2024-05-14 00:54:00+00	Thiết kế UI cho Responsive Web, Mobile Web, App\nLead và thiết kế dự án UI vừa/lớn. Đưa ra đề xuất thiết kế và thuyết trình. Xây dựng hệ thống thiết kế. Trên 4 năm kinh nghiệm.	2024-08-01	17:00:00	Senior	UI Designer	2024-06-01	08:00:00	ONSITE	FULLTIME	18000000000	1	1
2	Hà Nội	2024-05-14 00:54:00+00	Thiết kế UI cho Responsive Web, Mobile Web, App\nLead và thiết kế dự án UI vừa/lớn. Đưa ra đề xuất thiết kế và thuyết trình. Xây dựng hệ thống thiết kế. Trên 4 năm kinh nghiệm.	2024-08-01	17:00:00	Senior	UI Designer	2024-06-01	08:00:00	REMOTE	FULLTIME	17000000000	1	1
\.


--
-- Data for Name: appreciation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.appreciation (id, created_at, updated_at, achievement, award, description, end_date, employee_id, work_id) FROM stdin;
\.


--
-- Data for Name: certification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.certification (id, description, end_date, name, start_date, employee_id) FROM stdin;
\.


--
-- Data for Name: device_token; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.device_token (id, device_token, user_id) FROM stdin;
1	fAJ8huL_Q1SlPRc2KAoiT7:APA91bE2BZsPwkTvd1j7qQbktfARFWS8vGLQ7tfwiPrC8Xp_PIRgUNk31ghSz8uutyrKZRC1lwWSJAJ9NoB9Sx5yMa8JkuvXGfgqBcSVAYwoZaonLbgmdslBMiiUMtYSUQQznrTCmM72	1
\.


--
-- Data for Name: education; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.education (id, description, end_date, institution, level, major, start_date, employee_id) FROM stdin;
\.


--
-- Data for Name: experience; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.experience (id, company, description, end_date, job_title, start_date, employee_id) FROM stdin;
\.


--
-- Data for Name: hire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hire (id, employee_id) FROM stdin;
\.


--
-- Data for Name: schedule; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.schedule (id, date, work_id) FROM stdin;
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
\.


--
-- Data for Name: notification_receiver; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification_receiver (id, read, notification_id, receiver_id) FROM stdin;
\.


--
-- Data for Name: resume; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resume (id, created_at, updated_at, image_base64, name, size, employee_id) FROM stdin;
1	2024-05-14 01:45:00	2024-05-14 01:45:00	UklGRtgCAABXRUJQVlA4IMwCAADwFACdASqMAIwAPm02mkkkIyKhI5VYIIANiWlu4XVBtAHX7/avxL6Cg8++t/lLopv7NvBHBv5L/gPy5/Gb1g5CLiBpjf9C83P/S+4D3B/Rv/L9wv9Yv9d2EPQrDsAeWnlebo4xc3Rxi5ujjFyfOUELx1WlE1zHUUFkeiCd1g0fUjjgam5StpfH/NgUO4gRSe7qXFY+SQPmLJeqlRGHmzHPe/0QeWnlebo4xc3Rxi5MAAD+/6tgAUr8MRYNgYWFVDFzcirq+n7C+iiwMhhv6wis8x//ENKC/g8c3prBZP47ZGA/JopmkOstUXierWnW4/Zd3bH1OzntLCWe6ZsZzhCpYq4KMVhdVyTHXyQ4rMS38ByWojuNiYbInZn//+YdoRiXzHQOa/C2r+E8wX0hFvCpNyvZXzSqj7S0/JrBl0T+FITlvj2B/ipuDQZ76FmQWH7rc+VLlZ+uFkf/oGJKqrc2IXyJz3mM3Gi04yrrzm6F4ub9y2nA4YAlVSwVjqQ8JL0zobZZLRBTvDp0ir8owHn4tJv/5YHWsTdnKDEsUlPw4lJD1WmAQt6aHYVGx/3WbAbUma1gohoeUwEnHCjXD6/FPgApdzM+v4dzt79xl9CrDgeeW/lfuqAbOjXnY3RzJM40OQXXxbEFDhJozOc7yNcym94vUl9BQnJdt5f1Min/6g2cyEQg8eBwZC7iC0wEG0hXkb/ZP/m9W0O9BRri/XYr6vWi78eE21/gbyyQHgIGseACSecvb9LQwHPC7IT+UNhyT0Z41VvFRjBweiohVUdC8DZ1NzQCRW78aMiJYrYGgv3/1VL/3+3TFO23/v+uVHp7M0NlBCetPZjI0HQSlphMvvL67/ZFwCooqXX6kRGGjtLxnEoyCd0HqjprCeyT493z85aUb0dqlmvp7LG39BANbrcmf6SzqhG6V4eL53h1n964bcslxlJAAAAAAA==	Nguyen Van A CV	\N	1
\.


--
-- Data for Name: resume_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resume_work (id, created_at, updated_at, information, status, resume_id, work_id) FROM stdin;
1	2024-05-14 01:52:15.570522	2024-05-14 01:52:15.570571	\N	PENDING	1	1
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
-- Data for Name: work_employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work_employee (work_id, employee_id) FROM stdin;
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

SELECT pg_catalog.setval('public.appreciation_id_seq', 1, false);


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

SELECT pg_catalog.setval('public.device_token_id_seq', 1, true);


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

SELECT pg_catalog.setval('public.employer_id_seq', 1, false);


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

SELECT pg_catalog.setval('public.notification_id_seq', 1, false);


--
-- Name: notification_receiver_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_receiver_id_seq', 1, false);


--
-- Name: resume_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resume_id_seq', 1, false);


--
-- Name: resume_work_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resume_work_id_seq', 1, true);


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
-- PostgreSQL database dump complete
--

