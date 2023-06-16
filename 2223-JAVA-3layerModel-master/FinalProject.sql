CREATE DATABASE FinalProject
USE FinalProject

create table Categories (
	Id INT PRIMARY KEY,
	[Name] VARCHAR(50)
);
insert into Categories (Id, [Name]) values (1, 'DOBUTamine Hydrochloride in Dextrose');
insert into Categories (Id, [Name]) values (2, 'Promethazine HCl');
insert into Categories (Id, [Name]) values (3, 'Agaricus Phosphorus');
insert into Categories (Id, [Name]) values (4, 'Venlafaxine Hydrochloride');
insert into Categories (Id, [Name]) values (5, 'Losartan Potassium and Hydrochlorothiazide');
insert into Categories (Id, [Name]) values (6, 'Scal tonic shampoo');
insert into Categories (Id, [Name]) values (7, 'COREGCR');
insert into Categories (Id, [Name]) values (8, 'Medi-First');
insert into Categories (Id, [Name]) values (9, 'Longleaf Pine');
insert into Categories (Id, [Name]) values (10, 'Bethanechol Chloride');
insert into Categories (Id, [Name]) values (11, 'Gas Relief');
insert into Categories (Id, [Name]) values (12, 'Aspergillus niger');
insert into Categories (Id, [Name]) values (13, 'Triamterene and Hydrochlorothiazide');
insert into Categories (Id, [Name]) values (14, 'Amoxicillin and Clavulanate Potassium');
insert into Categories (Id, [Name]) values (15, 'REPAGLINIDE');
insert into Categories (Id, [Name]) values (16, 'athletes foot');
insert into Categories (Id, [Name]) values (17, 'Ranexa');
insert into Categories (Id, [Name]) values (18, 'Nortriptyline Hydrochloride');
insert into Categories (Id, [Name]) values (19, 'GUNA-DIZZY');
insert into Categories (Id, [Name]) values (20, 'Sodium Bicarbonate');

create table Books (
	Id INT PRIMARY KEY,
	Title VARCHAR(50),
	Author VARCHAR(50),
	[Year] VARCHAR(50),
	CategoryId INT,
	FOREIGN KEY (CategoryId) REFERENCES Categories(Id)
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
	Username VARCHAR(50),
	[Password] VARCHAR(50),
	[Address] VARCHAR(50),
	Phone VARCHAR(50),
	Email VARCHAR(50),
);

insert into Users (Id, Username, [Password], [Address], Phone, Email) values (1, 'dedensor0', 'eQ1<J$_ubY', '9091 Longview Drive', '528-523-3698', 'bcleeton0@edublogs.org');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (2, 'kleibold1', 'gF0>#eX`+3x', '5 Vera Street', '493-696-1342', 'cnealey1@eepurl.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (3, 'awateridge2', 'cX2@5ge%EX', '9813 Texas Hill', '901-633-6487', 'tlezemere2@pagesperso-orange.fr');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (4, 'riczokvitz3', 'xM4}S,vE=dRw0', '9 Columbus Pass', '126-797-2301', 'jdelatour3@stumbleupon.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (5, 'fdominick4', 'nZ9~b+Szd7pVq=l{', '9760 Linden Alley', '778-850-0970', 'wtillot4@cnet.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (6, 'dfraanchyonok5', 'kF8\$U+s)l0M&/0', '025 Summer Ridge Street', '835-383-6342', 'ltointon5@icq.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (7, 'sgrimwade6', 'bD4!$%)3M/=ibTd%', '84629 Anniversary Way', '966-685-8702', 'dbradbrook6@oakley.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (8, 'cshelborne7', 'xZ2+z+23', '88051 Corscot Crossing', '292-593-5363', 'slarham7@meetup.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (9, 'lmenlow8', 'nN7~yYm$r24~~#~W', '507 Dakota Hill', '125-335-3681', 'cbrandacci8@cmu.edu');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (10, 'rmacghee9', 'jK4$`O2N#)mq}k', '1666 Schiller Court', '449-897-3104', 'ewoodcock9@thetimes.co.uk');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (11, 'ipaleka', 'hW0!@3KhH', '3660 Waxwing Crossing', '997-882-0760', 'wlatorea@yellowpages.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (12, 'sspeechlyb', 'zB1}N1)?0<', '4 Sunbrook Pass', '307-384-6303', 'rbusekb@a8.net');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (13, 'tmorridc', 'wZ8_sl<~xEo~|a', '9306 Basil Drive', '318-419-6712', 'ralvaradoc@ucsd.edu');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (14, 'swhildd', 'eG1!O%iT$3Cu~', '1 Talisman Junction', '461-828-7096', 'kewerd@sbwire.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (15, 'soxtibye', 'qM9`!$IBAu9u,Q', '3964 Corry Plaza', '324-488-0211', 'aclaesense@rambler.ru');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (16, 'sitzkowiczf', 'gY7(UKJWtBi$`', '15 Clemons Lane', '568-159-2432', 'kbrixeyf@marriott.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (17, 'cbaptyg', 'yW7>|UlgjSYR', '996 Porter Circle', '691-511-6354', 'ffusseng@com.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (18, 'broylanceh', 'eY9}4''Q*49', '02597 Swallow Trail', '142-834-6115', 'iganth@hugedomains.com');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (19, 'gorpwoodi', 'kH0"SHVH', '5602 Elmside Road', '152-269-1208', 'kjirii@ustream.tv');
insert into Users (Id, Username, [Password], [Address], Phone, Email) values (20, 'lleperej', 'yK7''mCl%bp9/<C', '7787 Carey Drive', '330-101-3772', 'jattwoolj@studiopress.com');

create table Reservations (
	Id INT PRIMARY KEY,
	BookId INT,
	UserId INT,
	ReservationDate DATE,
	FOREIGN KEY (BookId) REFERENCES Books(Id),
	FOREIGN KEY (UserId) REFERENCES Users(Id)
);
insert into Reservations (Id, ReservationDate) values (1, '2/25/2021');
insert into Reservations (Id, ReservationDate) values (2, '4/14/2008');
insert into Reservations (Id, ReservationDate) values (3, '8/9/2005');
insert into Reservations (Id, ReservationDate) values (4, '2/22/2004');
insert into Reservations (Id, ReservationDate) values (5, '11/7/2005');
insert into Reservations (Id, ReservationDate) values (6, '5/29/2011');
insert into Reservations (Id, ReservationDate) values (7, '8/16/2004');
insert into Reservations (Id, ReservationDate) values (8, '10/8/2005');
insert into Reservations (Id, ReservationDate) values (9, '1/22/2018');
insert into Reservations (Id, ReservationDate) values (10, '10/28/2004');
insert into Reservations (Id, ReservationDate) values (11, '11/24/2022');
insert into Reservations (Id, ReservationDate) values (12, '4/30/2004');
insert into Reservations (Id, ReservationDate) values (13, '5/12/2005');
insert into Reservations (Id, ReservationDate) values (14, '4/18/2016');
insert into Reservations (Id, ReservationDate) values (15, '7/14/2008');
insert into Reservations (Id, ReservationDate) values (16, '6/13/2020');
insert into Reservations (Id, ReservationDate) values (17, '6/29/2016');
insert into Reservations (Id, ReservationDate) values (18, '6/2/1995');
insert into Reservations (Id, ReservationDate) values (19, '7/22/2006');
insert into Reservations (Id, ReservationDate) values (20, '10/28/2001');