connect 'jdbc:derby:MyDBFirst';
create table sensor(Sensor_ID int, Sensor_Name varchar(100));
CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE ('APP','SENSOR','sensor_table.csv',null,null,null,0);

create table date_time(Date_Time varchar(30),Sensor_ID int, Year_year int,Month varchar(10), Mdate int, Day varchar(10), Time int , Hourly_counts int);
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('DATA');
CALL SYSCS_UTIL.SYSCS_IMPORT_DATA ('APP','DATE_TIME',null,'1,2,3,4,5,6,7,8','date_time_table.csv',null,null,null,0);
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);

create table id_table(ID int, Date_Time varchar(30),Sensor_ID int);
CALL SYSCS_UTIL.SYSCS_IMPORT_DATA ('APP','ID_TABLE',null,'1,2,3','id_table.csv',null,null,null,0);

CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(1);
CALL SYSCS_UTIL.SYSCS_SET_STATISTICS_TIMING(1);
CALL SYSCS_UTIL.SYSCS_SET_XPLAIN_SCHEMA('QUERY');
select day,max(Hourly_counts) as max_hour
from date_time
group by day;
CALL SYSCS_UTIL.SYSCS_SET_RUNTIMESTATISTICS(0);

