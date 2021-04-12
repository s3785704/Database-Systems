sensor_table = open("pedestrian.csv","r")

sensor_dict = {}
max_str = 0;
i=0
for line in sensor_table:
    i = i +1
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
    Length = len(Sensor_Name) 
    if Length <= 10 :
        area = 10;
    elif Length <= 20 :
        area = 20;
    elif Length <= 30 :
        area = 30;
    else:
        area = 40;
    if area > max_str:
        max_str = area
    if area  in sensor_dict: 
        sensor_dict[area]=sensor_dict[area] +1 
    else: 
        sensor_dict[area]=1
for key in sorted(sensor_dict.keys()):
    print(key,"- %.2f"%((sensor_dict[key]/float(i))*100))
print("Max = ",max_str)
