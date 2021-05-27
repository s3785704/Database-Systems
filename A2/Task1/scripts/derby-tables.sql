connect 'jdbc:derby:A1';


create table sensors(
    sensor_id varchar(4),
    sensor_name varchar(50),

    PRIMARY KEY (sensor_id)
);

create table recordings(
    recording_id varchar(8),
    mYear INTEGER,
    mMonth varchar(9),
    mDate INTEGER,
    mDay varchar(9),
    time INTEGER,
    hourly_counts INTEGER,
    
    PRIMARY KEY (recording_id)
);

create table sensors_recordings(
    sensor_id varchar(4) REFERENCES sensors(sensor_id),
    recording_id varchar(8) REFERENCES recordings(recording_id),
    
    PRIMARY KEY (sensor_id, recording_id)
);


CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE(null,'SENSORS','/home/ec2-user/A2/derby-sensors.csv',',',null,null,0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE(null,'RECORDINGS','/home/ec2-user/A2/derby-recordings.csv',',',null,null,0);

CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE(null,'SENSORS_RECORDINGS','/home/ec2-user/A2/derby-sensors-recordings.csv',',',null,null,0);
