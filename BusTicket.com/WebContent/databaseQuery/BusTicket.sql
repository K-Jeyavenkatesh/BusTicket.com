create database busticketdotcom;
use busticketdotcom;

create table passenger(username varchar(100), 
			 fullname varchar(100), 
			 dob varchar(10), 
			 gender varchar(10), 
			 phonenumber varchar(10), 
			 emailid varchar(50) primary key, 
			 password varchar(50));
desc passenger;
select * from passenger;
truncate table passenger;
select * from busdetails;
drop table busdetails;
truncate busdetails;
create table busdetails(busid int auto_increment primary key,
						bustravelname varchar(200), 
						busnumber varchar(100), 
                        boardingpoints json,
                        droppingpoints json,
                        boardingtime json,
                        droppingtime json,
                        date varchar(10),
                        busaircondition varchar(10),
                        bustype varchar(10),
                        seatavaliable varchar(3),
                        totalseats varchar(3),
                        price json,
                        wifi varchar(5),
                        charging varchar(5),
                        foodorsnacks varchar(5),
                        movie varchar(5),
                        journeyid varchar(500),
                        driverphone varchar(10),
                        additionaldriverphone varchar(10),
                        bookedseats json);
                        

create table passengerbookinghistory(historyid int auto_increment primary key,
							  email varchar(50),
                              journeyid int,
                              boardingpoint varchar(100),
                              droppingpoint varchar(100),
                              boardingtime varchar(10),
                              droppingtime varchar(10),
                              date varchar(10),
                              price varchar(5));
truncate table passengerhistory;
drop table passengerhistory;
select * from passengerbookinghistory;


create table travelinformation(journeyid int auto_increment primary key,
							   busid int,
                               passengeremailids json,
                               passengernames json,
                               passengerage json,
                               passengergender json,
                               passengerboardings json,
                               passengerdroppings json,
                               busseatings json);

drop table travelinformation;
select * from travelinformation;
truncate table travelinformation;
                               
#insert into travelinformation(busid,passengeremailids,passengernames,passengerage,passengergender,passengerboardings,passengerdroppings) 
#values(1,'[]','[]','[]','[]','[]','[]');

create table bustravelagency(busagencyid int auto_increment primary key,
	travelsName varchar(100),
	travelsOwnerName varchar(100),
	ownerEmailid varchar(100),
	ownerPhoneNo varchar(10),
	agencyAddress varchar(200),
	agencyPhoneNo varchar(100),
	emailid varchar(100),
	password varchar(50));
    
select * from bustravelagency;
truncate bustravelagency;

drop table busdriver;
create table busdriver(name varchar(100),
						licenceno varchar(50) primary key,
                        emailid varchar(100),
                        phoneno varchar(10),
                        travelsagency varchar(100),
                        licphotof mediumblob,
                        licphotob mediumblob,
                        healthcert longblob);
                        
truncate table busdriver;
select * from busdriver;
drop table ticket;
select * from ticket;
truncate table ticket;
create table ticket(pnr bigint auto_increment primary key,
					travelinfo json,
                    busid int,
                    transacationid varchar(50),
                    transactionmode varchar(20))ENGINE=InnoDB AUTO_INCREMENT=91653214 DEFAULT CHARSET=latin1;
                    
drop table businfo;
select * from businfo;
create table businfo(busno varchar(20) primary key,
						busmodel varchar(150) ,
                        ownername varchar(100),
                        owneremail varchar(50),
                        ownerphone varchar(10),
                        travelsagency varchar(100),
                        rcbook longblob,
                        insurance longblob,
                        puccert longblob,
                        fitness longblob);


select * from ticket;

select * from rental;
create table rental(id int auto_increment primary key,
					places varchar(500),
                    date varchar(10),
                    days varchar(3),
                    details varchar(3000),
                    busdetails varchar(3000),
                    username varchar(100),
                    useremail varchar(100),
                    userphoneno1 varchar(10),
                    userphone2 varchar(10));






