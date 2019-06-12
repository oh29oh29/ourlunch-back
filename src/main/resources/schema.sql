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
  `id` VARCHAR(32) NOT NULL,
  `company_id` VARCHAR(32) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `link_url` VARCHAR(45) NOT NULL,
  `create_date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `company_id`),
    FOREIGN KEY (`company_id`)
    REFERENCES companies (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
