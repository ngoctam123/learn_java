USE [JWFW_AIPO]
GO
/****** Object:  Table [dbo].[eip_m_company]    Script Date: 31/05/2023 4:46:12 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[eip_m_company](
	[company_id] [bigint] NOT NULL,
	[address] [varchar](64) NULL,
	[company_name] [varchar](64) NOT NULL,
	[company_name_kana] [varchar](64) NULL,
	[create_date] [datetime2](7) NULL,
	[fax_number] [varchar](15) NULL,
	[ipaddress] [varchar](99) NULL,
	[ipaddress_internal] [varchar](99) NULL,
	[port] [int] NULL,
	[port_internal] [int] NULL,
	[telephone] [varchar](15) NULL,
	[update_date] [datetime2](7) NULL,
	[url] [varchar](99) NULL,
	[zipcode] [varchar](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[company_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[eip_m_position]    Script Date: 31/05/2023 4:46:12 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[eip_m_position](
	[position_id] [bigint] NOT NULL,
	[create_date] [datetime2](7) NULL,
	[position_name] [varchar](64) NOT NULL,
	[sort] [int] NULL,
	[update_date] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[position_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[eip_m_post]    Script Date: 31/05/2023 4:46:12 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[eip_m_post](
	[post_id] [bigint] NOT NULL,
	[address] [varchar](64) NULL,
	[create_date] [datetime2](7) NULL,
	[fax_number] [varchar](15) NULL,
	[in_telephone] [varchar](15) NULL,
	[out_telephone] [varchar](15) NULL,
	[post_name] [varchar](64) NOT NULL,
	[sort] [int] NULL,
	[update_date] [datetime2](7) NULL,
	[zipcode] [varchar](8) NULL,
	[company_id] [bigint] NULL,
	[group_name] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[post_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[turbine_group]    Script Date: 31/05/2023 4:46:12 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[turbine_group](
	[group_id] [bigint] NOT NULL,
	[group_name] [varchar](99) NOT NULL,
	[objectdata] [varbinary](max) NULL,
	[group_alias_name] [varchar](255) NULL,
	[owner_id] [int] NULL,
	[public_flag] [char](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[turbine_user]    Script Date: 31/05/2023 4:46:12 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[turbine_user](
	[user_id] [bigint] IDENTITY(1,1) NOT NULL,
	[cellular_mail] [varchar](99) NULL,
	[cellular_phone] [varchar](15) NULL,
	[cellular_uid] [varchar](99) NULL,
	[confirm_value] [varchar](99) NULL,
	[created] [datetime2](7) NULL,
	[created_user_id] [int] NULL,
	[disabled] [varchar](1) NULL,
	[email] [varchar](99) NULL,
	[first_name] [varchar](99) NOT NULL,
	[first_name_kana] [varchar](99) NULL,
	[has_photo] [varchar](1) NULL,
	[has_photo_smartphone] [varchar](1) NULL,
	[in_telephone] [varchar](15) NULL,
	[last_login] [datetime2](7) NULL,
	[last_name] [varchar](99) NOT NULL,
	[last_name_kana] [varchar](99) NULL,
	[login_name] [varchar](32) NOT NULL,
	[migrate_version] [int] NOT NULL,
	[modified] [datetime2](7) NULL,
	[objectdata] [varbinary](max) NULL,
	[out_telephone] [varchar](15) NULL,
	[password_changed] [datetime2](7) NULL,
	[password_value] [varchar](200) NOT NULL,
	[photo] [varbinary](max) NULL,
	[photo_modified] [datetime2](7) NULL,
	[photo_modified_smartphone] [datetime2](7) NULL,
	[photo_smartphone] [varbinary](max) NULL,
	[tutorial_forbid] [varchar](1) NULL,
	[updated_user_id] [int] NULL,
	[company_id] [bigint] NULL,
	[position_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[eip_m_company] ([company_id], [address], [company_name], [company_name_kana], [create_date], [fax_number], [ipaddress], [ipaddress_internal], [port], [port_internal], [telephone], [update_date], [url], [zipcode]) VALUES (1, N'137 NGUYEN THI THAP', N'fpt soft ware', NULL, CAST(N'2001-01-01T00:00:00.0000000' AS DateTime2), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[eip_m_company] ([company_id], [address], [company_name], [company_name_kana], [create_date], [fax_number], [ipaddress], [ipaddress_internal], [port], [port_internal], [telephone], [update_date], [url], [zipcode]) VALUES (2, N'137 NGUYEN THI THAP', N'FPT Polytechnix', NULL, CAST(N'2001-01-01T00:00:00.0000000' AS DateTime2), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[eip_m_position] ([position_id], [create_date], [position_name], [sort], [update_date]) VALUES (1, NULL, N'Product Manager', 1, NULL)
INSERT [dbo].[eip_m_position] ([position_id], [create_date], [position_name], [sort], [update_date]) VALUES (2, NULL, N'Software Engineer', 1, NULL)
INSERT [dbo].[eip_m_position] ([position_id], [create_date], [position_name], [sort], [update_date]) VALUES (3, NULL, N'UI/UX Designer', 1, NULL)
INSERT [dbo].[eip_m_position] ([position_id], [create_date], [position_name], [sort], [update_date]) VALUES (4, NULL, N'Data Engineer', 1, NULL)
INSERT [dbo].[eip_m_position] ([position_id], [create_date], [position_name], [sort], [update_date]) VALUES (5, NULL, N'Project Manager', 1, NULL)
INSERT [dbo].[eip_m_position] ([position_id], [create_date], [position_name], [sort], [update_date]) VALUES (6, NULL, N'Data Analyst', 1, NULL)
GO
INSERT [dbo].[turbine_group] ([group_id], [group_name], [objectdata], [group_alias_name], [owner_id], [public_flag]) VALUES (1, N'R17', NULL, NULL, 1, N'1')
GO
SET IDENTITY_INSERT [dbo].[turbine_user] ON 

INSERT [dbo].[turbine_user] ([user_id], [cellular_mail], [cellular_phone], [cellular_uid], [confirm_value], [created], [created_user_id], [disabled], [email], [first_name], [first_name_kana], [has_photo], [has_photo_smartphone], [in_telephone], [last_login], [last_name], [last_name_kana], [login_name], [migrate_version], [modified], [objectdata], [out_telephone], [password_changed], [password_value], [photo], [photo_modified], [photo_modified_smartphone], [photo_smartphone], [tutorial_forbid], [updated_user_id], [company_id], [position_id]) VALUES (2, N'', N'', NULL, NULL, NULL, NULL, NULL, N'lam171ttt@gmail.com', N'manh', N'manh', NULL, NULL, N'', NULL, N'le', N'le', N'manhld', 0, NULL, NULL, N'0941194703', NULL, N'123', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1)
SET IDENTITY_INSERT [dbo].[turbine_user] OFF
GO
ALTER TABLE [dbo].[turbine_user] ADD  DEFAULT ((0)) FOR [migrate_version]
GO
ALTER TABLE [dbo].[eip_m_post]  WITH CHECK ADD  CONSTRAINT [FKg0c5bl6mun845b8mflibuvjs5] FOREIGN KEY([group_name])
REFERENCES [dbo].[turbine_group] ([group_id])
GO
ALTER TABLE [dbo].[eip_m_post] CHECK CONSTRAINT [FKg0c5bl6mun845b8mflibuvjs5]
GO
ALTER TABLE [dbo].[eip_m_post]  WITH CHECK ADD  CONSTRAINT [FKip064y46ig9vl6l1x5msn22np] FOREIGN KEY([company_id])
REFERENCES [dbo].[eip_m_company] ([company_id])
GO
ALTER TABLE [dbo].[eip_m_post] CHECK CONSTRAINT [FKip064y46ig9vl6l1x5msn22np]
GO
ALTER TABLE [dbo].[turbine_user]  WITH CHECK ADD  CONSTRAINT [FK6xie5rjq0dw8tew4mwywwc8yh] FOREIGN KEY([position_id])
REFERENCES [dbo].[eip_m_position] ([position_id])
GO
ALTER TABLE [dbo].[turbine_user] CHECK CONSTRAINT [FK6xie5rjq0dw8tew4mwywwc8yh]
GO
ALTER TABLE [dbo].[turbine_user]  WITH CHECK ADD  CONSTRAINT [FKp2tfp9uwrx66n27y9xrlo368x] FOREIGN KEY([company_id])
REFERENCES [dbo].[eip_m_company] ([company_id])
GO
ALTER TABLE [dbo].[turbine_user] CHECK CONSTRAINT [FKp2tfp9uwrx66n27y9xrlo368x]
GO
