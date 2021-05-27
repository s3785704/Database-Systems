connect 'jdbc:derby:A1';

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('NOINDEX');
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(0);

create index hr_count on recordings(hourly_counts);

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('WITHINDEX');
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
select * from recordings where hourly_counts = 11612 or hourly_counts=7777;
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(0);


select s.stmt_text,st.execute_time from noindex.sysxplain_statements s,
noindex.sysxplain_statement_timings st
where s.timing_id = st.timing_id;

select s.stmt_text,st.execute_time from withindex.sysxplain_statements s,
withindex.sysxplain_statement_timings st
where s.timing_id = st.timing_id;
exit;
