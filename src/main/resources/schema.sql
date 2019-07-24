DROP TABLE IF EXISTS families;
DROP TABLE IF EXISTS companies;

CREATE TABLE IF NOT EXISTS companies (
  id VARCHAR(32) NOT NULL,
  name VARCHAR(45) NOT NULL,
  position_x VARCHAR(20) NULL,
  position_y VARCHAR(20) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS families (
  id VARCHAR(32) NOT NULL,
  company_id VARCHAR(32) NOT NULL,
  name VARCHAR(45) NOT NULL,
  link_url VARCHAR(45) NOT NULL,
  create_date VARCHAR(45) NOT NULL,
  PRIMARY KEY (id, company_id),
  CONSTRAINT fk_families_companies1
    FOREIGN KEY (company_id)
    REFERENCES companies (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS restaurants (
  id VARCHAR(32) NOT NULL,
  family_id VARCHAR(32) NOT NULL,
  name VARCHAR(45) NOT NULL,
  type VARCHAR(10) NOT NULL,
  place_id VARCHAR(45) NOT NULL,
  position_x VARCHAR(20) NULL,
  position_y VARCHAR(20) NULL,
  PRIMARY KEY (id, family_id),
  CONSTRAINT fk_restaurants_families1
    FOREIGN KEY (family_id)
    REFERENCES families (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS members (
  id VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  sign_up_date VARCHAR(19) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS family_members (
  id VARCHAR(32) NOT NULL,
  family_id VARCHAR(32) NOT NULL,
  member_id VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  is_master INT NOT NULL DEFAULT 0,
  taste VARCHAR(45) NULL,
  join_date VARCHAR(19) NOT NULL,
  PRIMARY KEY (id, family_id, member_id),
  CONSTRAINT fk_family_member_members
    FOREIGN KEY (member_id)
    REFERENCES members (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_family_member_families1
    FOREIGN KEY (family_id)
    REFERENCES families (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS restaurant_reviews (
  family_id VARCHAR(32) NOT NULL,
  restaurant_id VARCHAR(32) NOT NULL,
  member_id VARCHAR(45) NOT NULL,
  star_score INT NULL,
  comment VARCHAR(100) NULL,
  PRIMARY KEY (family_id, restaurant_id, member_id),
  CONSTRAINT fk_table1_restaurants1
    FOREIGN KEY (family_id , restaurant_id)
    REFERENCES restaurants (family_id , id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_table1_family_member1
    FOREIGN KEY (member_id)
    REFERENCES family_members (member_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
