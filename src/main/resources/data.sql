-- Category
INSERT INTO Category(id,name) VALUES (1,'Spring Boot');
INSERT INTO Category(id,name) VALUES (2,'Spring Data');
-- Post
INSERT INTO Post(id,title,body) VALUES (1,'Many to Many Demo','This is a Spring Boot demo of how to create a many to many relationship.');
-- JOIN TABLE
INSERT INTO post_categories(fk_post,fk_category) VALUES (1,1);
INSERT INTO post_categories(fk_post,fk_category) VALUES (1,2);