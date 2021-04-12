f = open("pedestrian.csv","r")
id_table = open("id_table.csv","w")
date_time_table = open("date_time_table.csv","w")
sensor_table = open("sensor_table.csv","w")

sensor_dict = {}

print("Preprocess Begin")
i =0
for line in f:
    i = i + 1
    if i == 1:
        continue
    x = line.strip().split(",")
    ID = x[0]
    Date_Time = x[1]
    Year = x[2]
    Month = x[3]
    Mdate = x[4]
    Day = x[5]
    Time = x[6]
    Sensor_ID = x[7]
    Sensor_Name = x[8]
    Hourly_Counts = x[9]
    id_str = ID + "," + "\"" +  Date_Time + "\"" + "," + Sensor_ID + "\n"
    date_time_str = "\"" + Date_Time + "\"" +  "," + Sensor_ID + "," + Year + "," + "\"" + Month + "\"" + "," +Mdate
    date_time_str += "," + "\"" +  Day + "\"" +  "," + Time + "," + Hourly_Counts + "\n"
    if not Sensor_ID == "Sensor_ID":
        sensor_dict[int(Sensor_ID)] = Sensor_Name
    id_table.write(id_str)
    date_time_table.write(date_time_str)

#sensor_str = "Sensor_ID" + "," + "Sensor_Name" + "\n"
#sensor_table.write(sensor_str)
for key in sorted(sensor_dict.keys()):
    if not key == "Sensor_ID":
        sensor_str = str(key) + "," + "\"" + sensor_dict[key] + "\"" + "\n"
        sensor_table.write(sensor_str)
print("Preprocess End")
print("Created table \"id_table.csv\" with fields [ID,Date_Time,Sensor_ID]. primary_key = \"ID\"")
print("Created table \"date_time_table.csv\" with fields [Date_Time,Sensor_ID,Year,Month,Mdate.Day,Time,Hourly_Counts]. primary_key = \"Date_TimeSensor_ID\"")
print("Created table \"sensor_table.csv\" with fields [Sensor_ID,Sensor_Name]. primary_key = \"Sensor_ID\"")
id_table.close() 
date_time_table.close()
sensor_table.close()
