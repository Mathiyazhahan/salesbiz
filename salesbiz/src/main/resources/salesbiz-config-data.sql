INSERT INTO `login` (`id`,`created`,`createdBy`,`modified`,`modifiedBy`,`version`,`confirmpassword`,`email_Id`,`isActive`,`isDelete`,`mobileno`,`name`,`password`) VALUES
 (1,'2021-11-07 05:33:52',0,'2021-11-07 05:33:52',0,0,'8sbMBUhbt42n1zMl4xQewEc6RBM1ib0qxeAq+/FP8+uvZt1pM/RTQBBILhKN1fI5','mysales@softtwig.com',1,0,'9884720323','selva','8sbMBUhbt42n1zMl4xQewEc6RBM1ib0qxeAq+/FP8+uvZt1pM/RTQBBILhKN1fI5');


INSERT INTO `roles` (`roleId`,`created`,`createdBy`,`modified`,`modifiedBy`,`version`,`isActive`,`privilegesVo`,`roleName`) VALUES
 (1,'2021-11-07 05:31:40',0,'2021-11-07 05:31:40',0,0,1,NULL,'ADMIN'),
 (2,'2021-11-16 17:27:07',0,'2021-11-16 17:27:07',0,0,1,NULL,'CAMPAIGN_MANAGER'),
 (3,'2021-11-07 05:31:02',0,'2021-11-07 05:31:02',0,0,1,NULL,'CAMPAIGN_TEAM'),
 (4,'2021-11-16 17:27:36',0,'2021-11-16 17:27:36',0,0,1,NULL,'SALES_MANAGER'),
 (5,'2021-11-07 05:31:19',0,'2021-11-07 05:31:19',0,0,1,NULL,'SALES_TEAM'),
 (6,'2021-11-09 18:32:20',0,'2021-11-09 18:32:20',0,0,0,NULL,'SALES');


INSERT INTO `users_roles` (`id`,`roleId`) VALUES
 (1,1);


INSERT INTO `privileges` (`privilegeId`,`created`,`createdBy`,`modified`,`modifiedBy`,`version`,`isDeleted`,`privileges_name`) VALUES
 (1,'2021-11-07 05:31:59',0,'2021-11-07 05:31:59',0,0,0,'ROLE_ADMIN'),
 (2,'2021-11-15 09:47:33',0,'2021-11-15 09:47:33',0,0,0,'ROLE_CAMPAIGN_MANAGER'),
 (3,'2021-11-15 09:52:09',0,'2021-11-15 09:52:09',0,0,0,'ROLE_CAMPAIGN_TEAM'),
 (4,'2021-11-07 05:29:08',0,'2021-11-07 05:29:08',0,0,0,'ROLE_SALES_TEAM'),
 (5,'2021-11-07 05:29:16',0,'2021-11-07 05:29:16',0,0,0,'ROLE_SALES_MANAGER');


INSERT INTO `role_privileges_role` (`roleId`,`privilegeId`) VALUES
 (5,3),
 (5,5),
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (1,5);

INSERT INTO `accesss` (`accessId`,`created`,`createdBy`,`modified`,`modifiedBy`,`version`,`accessName`) VALUES
 (1,'2021-11-07 05:29:42',0,'2021-11-07 05:29:42',0,0,'ROLE_ADMIN'),
 (2,'2021-11-07 05:29:55',0,'2021-11-07 05:29:55',0,0,'ROLE_CAMPAIGN_MANAGER'),
 (3,'2021-11-07 05:30:06',0,'2021-11-07 05:30:06',0,0,'ROLE_CAMPAIGN_TEAM'),
 (4,'2021-11-07 05:30:19',0,'2021-11-07 05:30:19',0,0,'ROLE_SALES_TEAM'),
 (5,'2021-11-07 05:30:23',0,'2021-11-07 05:30:23',0,0,'ROLE_SALES_MANAGER');

INSERT INTO `privileges_access` (`privilege_Id`,`access_Id`) VALUES
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (1,5);