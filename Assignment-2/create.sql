CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `developer` (
  `developer_person_generalization` int(11) NOT NULL,
  `developer_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`developer_person_generalization`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`developer_person_generalization`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `user_person_generalization` int(11) NOT NULL,
  `user_agreement` tinyint(4) DEFAULT NULL,
  `user_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_person_generalization`),
  CONSTRAINT `id` FOREIGN KEY (`user_person_generalization`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary_address` tinyint(4) DEFAULT NULL,
  `address_person_generalization` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `personIDs_idx` (`address_person_generalization`),
  CONSTRAINT `address_person_generalization` FOREIGN KEY (`address_person_generalization`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(45) DEFAULT NULL,
  `primary_number` tinyint(4) DEFAULT NULL,
  `phone_person_generalization` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `personsID_idx` (`phone_person_generalization`),
  CONSTRAINT `personsID` FOREIGN KEY (`phone_person_generalization`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

CREATE TABLE `website` (
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `website_developer_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `developer_person_generalization_idx` (`website_developer_fk`),
  CONSTRAINT `website_developer_fk` FOREIGN KEY (`website_developer_fk`) REFERENCES `developer` (`developer_person_generalization`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

CREATE TABLE `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `page_website_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_key_website_idx` (`page_website_fk`),
  CONSTRAINT `page_website_fk` FOREIGN KEY (`page_website_fk`) REFERENCES `website` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `widget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `css_class` varchar(45) DEFAULT NULL,
  `css_style` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `orderType` int(11) DEFAULT NULL,
  `dtype` varchar(45) NOT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareable` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `html` varchar(45) DEFAULT NULL,
  `widget_page_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `widget_page_fk_idx` (`widget_page_fk`),
  CONSTRAINT `widget_page_fk` FOREIGN KEY (`widget_page_fk`) REFERENCES `page` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `priviledge` (
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Roles` (
  `roles` varchar(45) NOT NULL,
  PRIMARY KEY (`roles`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `website_privilege` (
  `priviledge_website` varchar(45) DEFAULT NULL,
  `webPriviledge_developer_fk` int(11) DEFAULT NULL,
  `webPriviledge_website_fk` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `priviledge_website_fk_idx` (`priviledge_website`),
  KEY `webPriviledge_developer_fk_idx` (`webPriviledge_developer_fk`),
  KEY `webPriviledge_website_fk_idx` (`webPriviledge_website_fk`),
  CONSTRAINT `priviledge_website_fk` FOREIGN KEY (`priviledge_website`) REFERENCES `priviledge` (`type`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `webPriviledge_developer_fk` FOREIGN KEY (`webPriviledge_developer_fk`) REFERENCES `developer` (`developer_person_generalization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `webPriviledge_website_fk` FOREIGN KEY (`webPriviledge_website_fk`) REFERENCES `website` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=535 DEFAULT CHARSET=latin1;

CREATE TABLE `website_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `websiteRole_developer_fk` int(11) DEFAULT NULL,
  `websiteRole_website_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_fk_idx` (`roles`),
  KEY `websiteRole_developer_fk_idx` (`websiteRole_developer_fk`),
  KEY `websiteRole_website_fk_idx` (`websiteRole_website_fk`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role`) REFERENCES `Roles` (`roles`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `websiteRole_developer_fk` FOREIGN KEY (`websiteRole_developer_fk`) REFERENCES `developer` (`developer_person_generalization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `websiteRole_website_fk` FOREIGN KEY (`websiteRole_website_fk`) REFERENCES `website` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

CREATE TABLE `page_priviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priviledge` varchar(45) DEFAULT NULL,
  `pagePriviledge_developer_fk` int(11) DEFAULT NULL,
  `pagePrivildege_page_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `priviliedge_page_idx` (`priviledge`),
  KEY `pagePriviledge_developer_fk_idx` (`pagePriviledge_developer_fk`),
  KEY `pagePriviledge_page_fk_idx` (`pagePrivildege_page_fk`),
  CONSTRAINT `pagePriviledge_developer_fk` FOREIGN KEY (`pagePriviledge_developer_fk`) REFERENCES `developer` (`developer_person_generalization`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pagePriviledge_page_fk` FOREIGN KEY (`pagePrivildege_page_fk`) REFERENCES `page` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `priviliedge_page` FOREIGN KEY (`priviledge`) REFERENCES `priviledge` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=latin1;

CREATE TABLE `page_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  `pageRole_developer_fk` int(11) DEFAULT NULL,
  `pageRole_page_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `page_role_idx` (`role`),
  KEY `pageRole_developer_fk_idx` (`pageRole_developer_fk`),
  KEY `pageRole_page_fk_idx` (`pageRole_page_fk`),
  CONSTRAINT `pageRole_developer_fk` FOREIGN KEY (`pageRole_developer_fk`) REFERENCES `developer` (`developer_person_generalization`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pageRole_page_fk` FOREIGN KEY (`pageRole_page_fk`) REFERENCES `page` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `page_role` FOREIGN KEY (`role`) REFERENCES `Roles` (`roles`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;
