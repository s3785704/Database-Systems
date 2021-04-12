mkdir -p stats
#data_setup.sh
python database_format.py
echo "Date_time table size is "
du -hs date_time_table.csv
echo "Importing date_time into mongodob"
time mongoimport --collection date_time --type csv --headerline --file date_time_table.csv >& stats/mongodb_load_statistics_preprocess_date_time_file
echo "id_table size is "
du -hs id_table.csv
echo "Importing id_table into mongodb"
time mongoimport --collection id_table  --type csv --headerline --file id_table.csv >& stats/mongodb_load_statistics_preprocess_id_table
echo "Sensor table size is "
du -hs sensor_table.csv
echo "Importing sensor table into mongodb"
time mongoimport --collection sensor  --type csv --headerline --file sensor_table.csv >& stats/mongodb_load_statistics_preprocess_sensor_file
echo "original table size is "
du -hs pedestrian.csv
echo "Importing pedestrian table into mongodb"
time mongoimport --collection pedestrian  --type csv --headerline --file pedestrian.csv >& stats/mongodb_load_statistics_flat_load
