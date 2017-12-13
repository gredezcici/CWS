CREATE TABLE Users (
    ID varchar(36) NOT NULL PRIMARY KEY,
    LastName varchar(50),
    FirstName varchar(50),
    phone varchar(25),
    age int,
    email varchar(100),
    birthDay date,
    address varchar(255),   
);

	private String lastname;
	private String firstname;
	private String loginname;
	private int phone;
	private String email;
	private String wechat_account;
	private String address;
	private int age;
	private Date birthDay;
	private String group;