--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3 (Debian 16.3-1.pgdg120+1)
-- Dumped by pg_dump version 16.3 (Debian 16.3-1.pgdg120+1)

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

COPY public.users (id, created_at, updated_at, is_active, address, date_of_birth, facebook_account_id, fullname, google_account_id, image_base64, mail, password, phone_number, role_id) FROM stdin;
1	2024-05-13 15:21:14.401916	2024-05-13 15:21:14.401972	f	\N	\N	0	\N	0	\N	\N	$2a$10$K8lwxAeHbrOB6DlFJynQQOC9vHgA5/qXJdmZDlQbztorh.V5NDNZa	0974098799	2
2	2024-05-13 15:21:23.512444	2024-05-13 15:21:23.512487	f	\N	\N	0	\N	0	\N	\N	$2a$10$o.yJyWhM9biRpPqxjSCH8OlaPTqblMyRbi39lIwi5GxkpmF5LaJYu	0974098798	1
\.


--
-- Data for Name: employer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employer (id, user_id) FROM stdin;
1	1
\.


--
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.company (id, description, employee_size, head_office, image_base64, industry, name, short_name, website, employer_id) FROM stdin;
1	mo ta	1	tru so	\N		industry	hehe	hehehe	1
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, about, user_id) FROM stdin;
1	about	2
\.


--
-- Data for Name: appreciation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.appreciation (id, created_at, updated_at, achievement, award, description, end_date, company_id, employee_id) FROM stdin;
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
1	fAJ8huL_Q1SlPRc2KAoiT7:APA91bE2BZsPwkTvd1j7qQbktfARFWS8vGLQ7tfwiPrC8Xp_PIRgUNk31ghSz8uutyrKZRC1lwWSJAJ9NoB9Sx5yMa8JkuvXGfgqBcSVAYwoZaonLbgmdslBMiiUMtYSUQQznrTCmM72	2
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
-- Data for Name: work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.work (id, address, create_on, description, end_date, end_time, name, start_date, start_time, company_id, expert_id, job_position, type_job, type_work, wage) FROM stdin;
1	Austin	2020-01-01 00:00:00+00	SynergisticIT is committed to fast track your career by increasing your career prospects. We provide a broad spectrum of career advancement solutions. Whether you are struggling to find a job or hustling to get noticed by the hiring managers, we can help you stand out in your professional endeavors. Trusted by thousands of tech enthusiasts, SynergisticIT can bridge your skill and knowledge gap to make you competent for high-tech jobs. Our invaluable business acumen helps us assist thriving job seekers in achieving their career goals. Currently, we are looking for adept entry-level Python Developers to work with our elite group of clients, namely Client, PayPal, Expedia Group, Google, Apple, Cognizant, Ford, Cisco, Walmart Labs, etc. Required Qualifications and Background • Bachelor's degree or Master's degree in Computer Science, Electrical Engineering, Computer Engineering, Information Systems, IT, Mathematics, • Mathematics or Statistics background Skills Required • 0 to 2 years of experience in Python development • Deep understanding of the software development life cycle • Knowledge of Linear Algebra, Statistics, and Mathematics concepts • Excellent written and verbal communication skills • Technically inquisitive, self-learner, team player, and highly motivated • Strong work ethics and creative problem-solving abilities Preferred Skills • Deep Learning • Data visualization • Scala • NLP • Django • Roles and Responsibilities As an entry-level Python Developer, you need to perform the following duties: • Write server-side web application logic • Write scalable and effective codes in Python • Develop backend components to boost overall application's performance • Executing tests and fixing bugs in applications and software • Implement data protection and security solutions • Connect applications with third-party web services • Support frontend developers by integrating UI elements into Python applications Benefits • Competitive salary • Flexible work schedule & part-time off • E-verified • H1B Filing • No relocation • On job technical support • Skill Enhancement • Opportunity to work with Fortune 500 Companies Who can apply? This job opportunity is best suited for recent IT graduates who want to make a mark in the tech industry and upskill their IT talent. Anyone with a basic knowledge of Python programming or having some experience in building Python software solutions can apply for this position. No third-party candidates or c2c candidates If you are interested, please apply to the posting. No phone calls please, Shortlisted candidates would be reached out.	2020-01-01	00:00:00	SynergisticIT	2020-01-01	00:00:00	1	1	DEVELOPER	ONSITE	FULLTIME	\N
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
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message (id, created_by, created_on, is_employer_sender, message, employee_id, employer_id) FROM stdin;
\.


--
-- Data for Name: notification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification (id, created_at, updated_at, company_detail, content, job_detail, title, sender_id) FROM stdin;
9	2024-05-13 16:17:05.574211	2024-05-13 16:17:05.574239	{wqewq,dasdsa,1}	Application for wqewq	{sadasd,ads}	Application accepted	\N
\.


--
-- Data for Name: notification_receiver; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification_receiver (id, read, notification_id, receiver_id) FROM stdin;
3	f	9	2
\.


--
-- Data for Name: resume; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resume (id, created_at, updated_at, image_base64, name, size, employee_id) FROM stdin;
1	\N	\N	\N	dsadsa	\N	1
\.


--
-- Data for Name: resume_work; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resume_work (id, created_at, updated_at, information, status, resume_id, work_id) FROM stdin;
1	2024-05-13 15:28:21.217593	2024-05-13 16:17:05.466573	\N	ACCEPTED	1	1
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
1	1
1	1
1	1
1	1
1	1
1	1
1	1
1	1
1	1
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
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.message_id_seq', 1, false);


--
-- Name: notification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_id_seq', 9, true);


--
-- Name: notification_receiver_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_receiver_id_seq', 3, true);


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

SELECT pg_catalog.setval('public.users_id_seq', 2, true);


--
-- Name: work_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.work_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--

