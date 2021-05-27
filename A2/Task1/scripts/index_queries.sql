connect 'jdbc:derby:A1';

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('NOINDEX');
select * from recordings where hourly_counts >= 100 and hourly_counts <= 120;
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(0);

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('CREATEINDEX');
create index hr_count on recordings(hourly_counts);
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(0);

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('WITHINDEX');
select * from recordings where hourly_counts >= 100 and hourly_counts <= 120;
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(0);

select stmt_text,execute_time from noindex.sysxplain_resultset_timings;
select execute_time from createindex.sysxplain_resultset_timings;
select execute_time from withindex.sysxplain_resultset_timings;
#select * from createindex.sysxplain_resultset_timings;

exit;
