-- Include table data insertion, updation, deletion and select scripts

-- ----------------- * A D M I N   F L O W * ---------------------
-- Insert movies into Movie List Admin
insert into movie
values
(1,  'Avatar',  2787965087,  'Yes',  '2017-03-15',  'Science Fiction',  'Yes'),
(2,  'The Avengers',  1518812988,  'Yes',  '2017-12-23',  'Superhero',  'No'),
(3,  'Titanic',  2187463944,  'Yes',' 2017-08-21', 'Romance',  'No'),
(4,  'Jurassic World',  1671713208,  'No', '2017-07-02', 'Science Fiction', 'Yes'),
(5,  'Avengers: End Game', 2750760348,  'Yes', '2022-11-02', 'Superhero',  'Yes');

-- -------------------------------------------------------------------------------------------
-- View Movie List Admin
select mv_title as Title, mv_box_office as Box_Office, mv_active as Active, mv_date_of_launch as Date_Of_Launch, mv_genre as Genre, mv_has_teaser as Has_Teaser  from movie ;

-- -------------------------------------------------------------------------------------------
-- Edit Movie
update movie
set mv_title = 'Lion King' , mv_box_office = 123456789 , mv_active = 'Yes' , mv_date_of_launch = '2018-05-01', mv_genre = 'Superhero' , mv_has_teaser = 'Yes' 
where mv_id = 2 ;

-- ----------------------------------------------------------------------------------------------
-- Edited Movie 

select mv_title as Title , mv_box_office as Box_Office, mv_active as Active, mv_date_of_launch as Date_Of_Launch, mv_genre as Genre, mv_has_teaser as Has_Teaser from movie where mv_id = 2 ;

-- ---------------------------------------------------------------------------------------------------------------------------
-- Movie List Admin after edit
 
select mv_title as Title, mv_box_office as Box_Office, mv_active as Active, mv_date_of_launch as Date_Of_Launch, mv_genre as Genre, mv_has_teaser as Has_Teaser  from movie ;
 
 -- -----------------------------------------------------------------------------------------------------
 -- -----------------------------------------------------------------------------------------------------
 
-- ---------- * U S E R   F L O W * ----------------------------------------------------------------------
-- Add Users to User Table

insert into user
values (1, 'Sandy'),
(2, 'Prakash'), 
(3, 'Vishwa');

-- -------------------------------------------------------------------------------------------------------
-- view users
 
 select us_id as Id, us_name as Name from user ;
 
 -- -------------------------------------------------------------------------------------------------------
 
 -- Movie List Customer ( user movie list)

select mv_title as Title, mv_box_office as Box_Office, mv_genre as Genre, mv_has_teaser as Has_Teaser from movie where mv_active = 'Yes' and  mv_date_of_launch < current_date() ; 

-- ------------------------------------------------------------------------------------------------------------------------

-- Add movie to favourite table
 
insert into favorite
values (1,1,1),
 (2,1,2),
 (3,1,3),
 (4,1,1),
 (5,1,2),
 (6,1,3),
 (7,1,1);
 
 -- -------------------------------------------------------------------------------------------------------------------------
 -- View Favourite Movie list
 
 select m.mv_title as Title, m.mv_box_office as Box_Office, m.mv_genre as Genre from movie m
 join favorite f 
 on m.mv_id = f.fv_mv_id where fv_us_id = 1  ;
 
-- ---------------------------------------------------------------------------------------------------------------------
-- delete favourite movie

delete from favorite where fv_mv_id = 2 limit 1 ;

-- --------------------------------------------------------------------------------------------------------------------
 -- number of favourite movie items
 
 select count(*) as number_of_favourite from movie m
 join favorite f 
 on m.mv_id = f.fv_mv_id ;
 
 -- ----------------------------------------------------------------------------------------------------------------
 