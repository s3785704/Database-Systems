connect 'jdbc:derby:A1';

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('NOINDEX');
select sum(hourly_counts)  from recordings where mMonth = 'November' ;
select sum(hourly_counts)  from recordings where mMonth = 'November' ;
select sum(hourly_counts)  from recordings where mMonth = 'November' ;
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(0);

select s.stmt_text,st.execute_time from noindex.sysxplain_statements s,
noindex.sysxplain_statement_timings st
where s.timing_id = st.timing_id;
select scan_object_name,scan_type,no_visited_pages,no_visited_rows,no_qualified_rows,btree_height,fetch_size from noindex.sysxplain_scan_props ;
exit;
