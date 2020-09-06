insert into workflow_category(ID_CATEGORY, DESCRIPTION, LOGO, NAME, STATUS, CREATE_AT, UPDATE_AT, PARENT_ID_CATEGORY) values(1, 'CATEGORY', 'LOGO_CAT1', 'CAT1', 1, sysdate(), sysdate(), null);
insert into workflow_category(ID_CATEGORY, DESCRIPTION, LOGO, NAME, STATUS, CREATE_AT, UPDATE_AT, PARENT_ID_CATEGORY) values(2, 'CATEGORY', 'LOGO_CAT2', 'CAT2', 2, sysdate(), sysdate(), 1);
insert into workflow_category(ID_CATEGORY, DESCRIPTION, LOGO, NAME, STATUS, CREATE_AT, UPDATE_AT, PARENT_ID_CATEGORY) values(3, 'CATEGORY', 'LOGO_CAT3', 'CAT3', 3, sysdate(), sysdate(), 2);

insert into workflow(ID_WORKFLOW, DESCRIPTION, NAME, STATUS) values(1, 'WORKFLOW', 'WORKFLOW1', 1);
insert into workflow(ID_WORKFLOW, DESCRIPTION, NAME, STATUS) values(2, 'WORKFLOW', 'WORKFLOW2', 2);
insert into workflow(ID_WORKFLOW, DESCRIPTION, NAME, STATUS) values(3, 'WORKFLOW', 'WORKFLOW3', 3);

insert into workflows_categories(WORKFLOW_ID, CATEGORY_ID) values(1, 1);
insert into workflows_categories(WORKFLOW_ID, CATEGORY_ID) values(1, 2);
insert into workflows_categories(WORKFLOW_ID, CATEGORY_ID) values(2, 3);
