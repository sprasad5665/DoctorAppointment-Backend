INSERT INTO public.patient (patient_id, address,age,blood_group,email,gender,mobile_no,password,patient_name) VALUES (1, 'hyd',23,'b positive','sll@gmail.com','male','9377377','guest','sai');

INSERT INTO public.doctor (doctor_id, doctor_name,speciality,location,hospital_name,mobile_no,email,password,charged_per_visit) VALUES (1, 'Dr.Mohan','heart','hyd','kims','665554','dfrer@gggg','guest',12.06);

INSERT INTO public.appointment (appointment_id, patient_id,doctor_id,appointment_date,appointment_status,remark) VALUES (1, 1,1,'2021-06-05 20:12:22','booked','none');

INSERT INTO public.patient (patient_id, address,age,blood_group,email,gender,mobile_no,password,patient_name) VALUES (2, 'BLG',23,'b positive','sll@gmail.com','male','9377377','guest','prasad');

INSERT INTO public.doctor (doctor_id, doctor_name,speciality,location,hospital_name,mobile_no,email,password,charged_per_visit) VALUES (2, 'Dr.Suresh','heart','hyd','kims','665554','dfrer@gggg','guest',12.06);

INSERT INTO public.patient (patient_id, address,age,blood_group,email,gender,mobile_no,password,patient_name) VALUES (3, 'CHENNAI',23,'b positive','sll@gmail.com','male','9377377','guest','sadan');

INSERT INTO public.doctor (doctor_id, doctor_name,speciality,location,hospital_name,mobile_no,email,password,charged_per_visit) VALUES (3, 'Dr.Vinod','heart','hyd','kims','665554','dfrer@gggg','guest',12.06);

INSERT INTO public.patient (patient_id, address,age,blood_group,email,gender,mobile_no,password,patient_name) VALUES (4, 'MUMBAI',23,'b positive','sll@gmail.com','male','9377377','guest','praneeth');

INSERT INTO public.doctor (doctor_id, doctor_name,speciality,location,hospital_name,mobile_no,email,password,charged_per_visit) VALUES (4, 'Dr.Vaseem','heart','hyd','kims','665554','dfrer@gggg','guest',12.06);

INSERT INTO public.user (user_id, user_name,password,roles) VALUES (1, 'admin','Admin@1234','Admin');