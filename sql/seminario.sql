USE [master]
GO
/****** Object:  Database [seminario2]    Script Date: 11/14/2018 9:52:45 AM ******/
CREATE DATABASE [seminario2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'seminario2', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\seminario2.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'seminario2_log', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\seminario2_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [seminario2] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [seminario2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [seminario2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [seminario2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [seminario2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [seminario2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [seminario2] SET ARITHABORT OFF 
GO
ALTER DATABASE [seminario2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [seminario2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [seminario2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [seminario2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [seminario2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [seminario2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [seminario2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [seminario2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [seminario2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [seminario2] SET  DISABLE_BROKER 
GO
ALTER DATABASE [seminario2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [seminario2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [seminario2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [seminario2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [seminario2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [seminario2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [seminario2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [seminario2] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [seminario2] SET  MULTI_USER 
GO
ALTER DATABASE [seminario2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [seminario2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [seminario2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [seminario2] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [seminario2]
GO
/****** Object:  User [db_seminario]    Script Date: 11/14/2018 9:52:45 AM ******/
CREATE USER [db_seminario] FOR LOGIN [db_seminario] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[Amigo]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Amigo](
	[idAmigo] [int] IDENTITY(1,1) NOT NULL,
	[idDuenio] [int] NOT NULL,
	[idAmistad] [int] NOT NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Amigo] PRIMARY KEY CLUSTERED 
(
	[idAmigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categoria]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categoria](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Categoria] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Favorito]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Favorito](
	[idFavorito] [int] IDENTITY(1,1) NOT NULL,
	[idUsuario] [int] NOT NULL,
	[idRegalo] [int] NOT NULL,
	[activo] [int] NOT NULL,
 CONSTRAINT [PK_Favorito] PRIMARY KEY CLUSTERED 
(
	[idFavorito] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Imagen]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Imagen](
	[idImagen] [int] NOT NULL,
	[nombre] [nchar](100) NULL,
	[label] [nchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Regalo]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Regalo](
	[idRegalo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[precio] [float] NOT NULL,
	[idCategoria] [int] NOT NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Regalo] PRIMARY KEY CLUSTERED 
(
	[idRegalo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[idUsuario] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [nvarchar](50) NOT NULL,
	[pass] [nvarchar](50) NOT NULL,
	[idCategoriaPreferida] [int] NULL,
	[activo] [bit] NOT NULL,
	[email] [nchar](50) NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UsuarioImagen]    Script Date: 11/14/2018 9:52:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UsuarioImagen](
	[idUsuarioImagen] [int] IDENTITY(1,1) NOT NULL,
	[idUsuario] [int] NOT NULL,
	[idImagen] [int] NOT NULL,
	[recomendado] [bit] NOT NULL,
 CONSTRAINT [PK_UsuarioImagen] PRIMARY KEY CLUSTERED 
(
	[idUsuarioImagen] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Imagen] ([idImagen], [nombre], [label]) VALUES (1, N'1.jpg                                                                                               ', N'bici                                                                                                ')
INSERT [dbo].[Imagen] ([idImagen], [nombre], [label]) VALUES (2, N'2.png                                                                                               ', N'celu1                                                                                               ')
INSERT [dbo].[Imagen] ([idImagen], [nombre], [label]) VALUES (3, N'3.png                                                                                               ', N'otro celu                                                                                           ')
INSERT [dbo].[Imagen] ([idImagen], [nombre], [label]) VALUES (4, N'4.png                                                                                               ', N'celu nokia                                                                                          ')
SET IDENTITY_INSERT [dbo].[Usuario] ON 

INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (12, N'emi', N'ICy5YqxZB1uWSwcVLSNLcA==', NULL, 1, N'elaneri@gmail.com                                 ')
INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (13, N'dqwdqwdqw', N'Rj8eq+j4MGU7L/2Kic0Scg==', NULL, 1, N'dqwdqwdqw                                         ')
INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (14, N'eqweq', N'smmGzu5g90RTSqq5KMwS3w==', NULL, 1, N'qweqweqweqweqwe                                   ')
INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (15, N'ewdewfwefwef', N'ICy5YqxZB1uWSwcVLSNLcA==', NULL, 1, N'p@p.com                                           ')
INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (16, N'fer', N'km4n7s28ehiFizeYupm93Q==', NULL, 1, N'fer@fer.com                                       ')
INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (17, N'test', N'ICy5YqxZB1uWSwcVLSNLcA==', NULL, 1, N'test@test.com                                     ')
INSERT [dbo].[Usuario] ([idUsuario], [usuario], [pass], [idCategoriaPreferida], [activo], [email]) VALUES (18, N'test2', N'ICy5YqxZB1uWSwcVLSNLcA==', NULL, 1, N'elaneri2@gmail.com                                ')
SET IDENTITY_INSERT [dbo].[Usuario] OFF
SET IDENTITY_INSERT [dbo].[UsuarioImagen] ON 

INSERT [dbo].[UsuarioImagen] ([idUsuarioImagen], [idUsuario], [idImagen], [recomendado]) VALUES (1, 12, 4, 0)
SET IDENTITY_INSERT [dbo].[UsuarioImagen] OFF
ALTER TABLE [dbo].[Amigo] ADD  CONSTRAINT [DF_Amigo_activo]  DEFAULT ((1)) FOR [activo]
GO
ALTER TABLE [dbo].[Categoria] ADD  CONSTRAINT [DF_Categoria_activo]  DEFAULT ((1)) FOR [activo]
GO
ALTER TABLE [dbo].[Favorito] ADD  CONSTRAINT [DF_Favorito_activo]  DEFAULT ((1)) FOR [activo]
GO
ALTER TABLE [dbo].[Regalo] ADD  CONSTRAINT [DF_Regalo_activo]  DEFAULT ((1)) FOR [activo]
GO
ALTER TABLE [dbo].[Usuario] ADD  CONSTRAINT [DF_Usuario_activo]  DEFAULT ((1)) FOR [activo]
GO
ALTER TABLE [dbo].[Amigo]  WITH CHECK ADD FOREIGN KEY([idAmistad])
REFERENCES [dbo].[Usuario] ([idUsuario])
GO
ALTER TABLE [dbo].[Amigo]  WITH CHECK ADD FOREIGN KEY([idDuenio])
REFERENCES [dbo].[Usuario] ([idUsuario])
GO
ALTER TABLE [dbo].[Favorito]  WITH CHECK ADD FOREIGN KEY([idUsuario])
REFERENCES [dbo].[Usuario] ([idUsuario])
GO
USE [master]
GO
ALTER DATABASE [seminario2] SET  READ_WRITE 
GO
