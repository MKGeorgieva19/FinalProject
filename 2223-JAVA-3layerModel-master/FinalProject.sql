CREATE DATABASE FinalProject
USE FinalProject



create table Books (
	Id INT,
	Title VARCHAR(50),
	Author VARCHAR(50),
	[Year] VARCHAR(50)
);
insert into Books (Id, Title, Author, [Year]) values (1, 'All American Chump', 'Martino Simonsson', 2008);
insert into Books (Id, Title, Author, [Year]) values (2, 'Texas Across the River', 'Priscella Pennycock', 1997);
insert into Books (Id, Title, Author, [Year]) values (3, 'School of Rock', 'Way Traynor', 2007);
insert into Books (Id, Title, Author, [Year]) values (4, 'Big Blue, The (Grand bleu, Le)', 'Joseito Cowp', 1998);
insert into Books (Id, Title, Author, [Year]) values (5, 'Elvis and Me', 'Clevey McBeith', 2012);
insert into Books (Id, Title, Author, [Year]) values (6, 'Earth Dies Screaming, The', 'Sylvan Naish', 1989);
insert into Books (Id, Title, Author, [Year]) values (7, 'The Studio Murder Mystery', 'Kingsley Snook', 2002);
insert into Books (Id, Title, Author, [Year]) values (8, 'Schooled: The Price of College Sports ', 'Lizette Kindleside', 2002);
insert into Books (Id, Title, Author, [Year]) values (9, 'National Velvet', 'Mahmoud Walshaw', 2003);
insert into Books (Id, Title, Author, [Year]) values (10, 'Flight of the Conchords: A Texan Odyssey', 'Floris Spaxman', 2005);
insert into Books (Id, Title, Author, [Year]) values (11, 'Two Moon Junction', 'Lyndsay Janssen', 2012);
insert into Books (Id, Title, Author, [Year]) values (12, 'The Pacific', 'Sile Kinvan', 2005);
insert into Books (Id, Title, Author, [Year]) values (13, 'Mission Congo', 'Wynn Whitington', 1992);
insert into Books (Id, Title, Author, [Year]) values (14, 'Make Believe', 'Iona Delete', 2005);
insert into Books (Id, Title, Author, [Year]) values (15, 'Man Vanishes, A (Ningen Johatsu)', 'Maurene Ledrane', 2010);
insert into Books (Id, Title, Author, [Year]) values (16, 'Maniac', 'Hollis Rodway', 1993);
insert into Books (Id, Title, Author, [Year]) values (17, 'Keith Lemon: The Film', 'Ayn Guilfoyle', 2002);
insert into Books (Id, Title, Author, [Year]) values (18, 'Less of Sugar (Cheeni Kum)', 'Madella Gowrich', 2006);
insert into Books (Id, Title, Author, [Year]) values (19, 'Paranormal Activity', 'Daniele Delgardillo', 2009);
insert into Books (Id, Title, Author, [Year]) values (20, 'Beck - Familjen', 'Conn Nicolson', 1986);

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