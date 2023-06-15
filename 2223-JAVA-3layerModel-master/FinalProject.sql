CREATE DATABASE FinalProject
USE FinalProject

create table Books (
	Id INT PRIMARY KEY,
	[Name] VARCHAR(50),
	Autor VARCHAR(50),
	[Date] DATE
);
insert into Books (Id, [Name], Autor, [Date]) values (1, 'Antibiotic', 'Nil Lakin', '1/24/2009');
insert into Books (Id, [Name], Autor, [Date]) values (2, 'Ortho-K Thick', 'Dorolice Merman', '11/2/2015');
insert into Books (Id, [Name], Autor, [Date]) values (3, 'Gemcitabine', 'Rhonda Owbrick', '7/27/1986');
insert into Books (Id, [Name], Autor, [Date]) values (4, 'Molds, Rusts and Smuts, Curvularia spicifera', 'Evyn Becom', '11/27/2005');
insert into Books (Id, [Name], Autor, [Date]) values (5, 'Venlafaxine Hydrochloride', 'Frederik Crowne', '2/14/1982');
insert into Books (Id, [Name], Autor, [Date]) values (6, 'Burrobrush', 'Kaylil Tschirschky', '5/12/2000');
insert into Books (Id, [Name], Autor, [Date]) values (7, 'Vancomycin HCl', 'Aurora Madgin', '1/6/1987');
insert into Books (Id, [Name], Autor, [Date]) values (8, 'Enviroclenz', 'Joanna Blackborn', '10/13/2020');
insert into Books (Id, [Name], Autor, [Date]) values (9, 'Pleo Fort', 'Carlo Ryley', '5/27/2016');
insert into Books (Id, [Name], Autor, [Date]) values (10, 'Treatment Set TS333176', 'Codee Minghella', '9/16/1971');
insert into Books (Id, [Name], Autor, [Date]) values (11, 'Aspirin', 'Othello Barron', '6/14/2021');
insert into Books (Id, [Name], Autor, [Date]) values (12, 'Nutropin AQ NuSpin 10', 'Kaleb McGahey', '10/22/1975');
insert into Books (Id, [Name], Autor, [Date]) values (13, 'GlycoPan Tox', 'Cristine Decort', '10/21/1976');
insert into Books (Id, [Name], Autor, [Date]) values (14, 'Sore Throat', 'Giffard Opie', '6/5/2011');
insert into Books (Id, [Name], Autor, [Date]) values (15, 'Haloperidol', 'Edee Swanton', '2/6/2015');
insert into Books (Id, [Name], Autor, [Date]) values (16, 'Squash Zucchini', 'Esme Thaller', '12/12/1983');
insert into Books (Id, [Name], Autor, [Date]) values (17, 'Synovium', 'Brnaby Emmanuel', '8/16/1992');
insert into Books (Id, [Name], Autor, [Date]) values (18, 'Clorazepate Dipotassium', 'Connie Lindenman', '11/8/1970');
insert into Books (Id, [Name], Autor, [Date]) values (19, 'Tranexamic Acid', 'Stern Marcinkus', '2/20/1995');
insert into Books (Id, [Name], Autor, [Date]) values (20, 'Halls', 'Shirlee Shory', '9/9/2007');

create table Users (
	Id INT PRIMARY KEY,
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	Username VARCHAR(50),
	[Password] VARCHAR(50)
);
insert into Users (Id, FirstName, LastName, Username, [Password]) values (1, 'Svend', 'Lequeux', 'slequeux0', 'p7CK7sq');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (2, 'Ginger', 'Lyvon', 'glyvon1', 'sR6ATYPQ19');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (3, 'Henrietta', 'Menham', 'hmenham2', 'xS3A5FrP');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (4, 'Ermanno', 'Gilhespy', 'egilhespy3', 'wYVhzR');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (5, 'Prescott', 'Frederick', 'pfrederick4', 'Zs1laN');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (6, 'Raynell', 'Spreckley', 'rspreckley5', '17TpgXegJ');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (7, 'Fernando', 'Souley', 'fsouley6', 'npcNoN');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (8, 'Matt', 'Brumbie', 'mbrumbie7', '7TpNsb');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (9, 'Lezlie', 'Fransewich', 'lfransewich8', 'kyLxZkgH7');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (10, 'Melodie', 'Maddick', 'mmaddick9', 'KAkD0kC');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (11, 'Melva', 'Aronoff', 'maronoffa', 'n8GXsdeM');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (12, 'Celina', 'McNern', 'cmcnernb', 'vXppPmC');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (13, 'Cece', 'Ionesco', 'cionescoc', 'vhKojUZp8Odv');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (14, 'Gabbie', 'Crufts', 'gcruftsd', 'V7D8Jjt1z9d');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (15, 'Archer', 'Huston', 'ahustone', 'frKQu1Piy');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (16, 'Dotty', 'Mulqueeny', 'dmulqueenyf', 'x0bk9TjRobs');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (17, 'Trever', 'Edgeller', 'tedgellerg', '74cEXTga');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (18, 'Delphinia', 'Brinded', 'dbrindedh', 'QEjzhGn9FaX');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (19, 'Kipper', 'Wellum', 'kwellumi', '2Agfhxfr4');
insert into Users (Id, FirstName, LastName, Username, [Password]) values (20, 'Fin', 'Berens', 'fberensj', 'YRSaytV');

create table Libraries (
	Id INT PRIMARY KEY,
	[Name] VARCHAR(50),
	[Address] VARCHAR(50),
	UserId INT,
	BookId INT,
	FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (BookId) REFERENCES Books(Id)
);
insert into Libraries (Id, [Name], [Address]) values (1, 'Dabvine', '12 Bartelt Street');
insert into Libraries (Id, [Name], [Address]) values (2, 'Photojam', '5264 Graceland Trail');
insert into Libraries (Id, [Name], [Address]) values (3, 'Dabtype', '26241 Eastlawn Court');
insert into Libraries (Id, [Name], [Address]) values (4, 'Divanoodle', '218 Valley Edge Alley');
insert into Libraries (Id, [Name], [Address]) values (5, 'Eamia', '27 Nobel Court');
insert into Libraries (Id, [Name], [Address]) values (6, 'Minyx', '5 Northfield Center');
insert into Libraries (Id, [Name], [Address]) values (7, 'Yodel', '309 Pine View Junction');
insert into Libraries (Id, [Name], [Address]) values (8, 'Oloo', '15 Lawn Drive');
insert into Libraries (Id, [Name], [Address]) values (9, 'Jetwire', '52780 International Avenue');
insert into Libraries (Id, [Name], [Address]) values (10, 'Trilith', '5 Miller Terrace');
insert into Libraries (Id, [Name], [Address]) values (11, 'Twitterwire', '34454 Onsgard Road');
insert into Libraries (Id, [Name], [Address]) values (12, 'Tagchat', '95 Fordem Parkway');
insert into Libraries (Id, [Name], [Address]) values (13, 'Meevee', '44 Ronald Regan Junction');
insert into Libraries (Id, [Name], [Address]) values (14, 'Zazio', '2186 Crownhardt Alley');
insert into Libraries (Id, [Name], [Address]) values (15, 'Vidoo', '3 Derek Junction');
insert into Libraries (Id, [Name], [Address]) values (16, 'Geba', '260 Sloan Trail');
insert into Libraries (Id, [Name], [Address]) values (17, 'Devify', '3288 Schurz Point');
insert into Libraries (Id, [Name], [Address]) values (18, 'Eayo', '7 Rigney Way');
insert into Libraries (Id, [Name], [Address]) values (19, 'Kwimbee', '6951 Hudson Parkway');
insert into Libraries (Id, [Name], [Address]) values (20, 'Avamm', '88474 Lerdahl Pass');