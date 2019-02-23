-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-02-2019 a las 05:46:38
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cama`
--

CREATE TABLE `cama` (
  `id_cama` int(50) NOT NULL,
  `id_planta` int(50) NOT NULL,
  `estado` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia`
--

CREATE TABLE `historia` (
  `id_historia` int(50) NOT NULL,
  `fec_ingreso` date NOT NULL,
  `fec_alta` date NOT NULL,
  `estado` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DNI` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id_medico` int(50) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Apellido1` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Apellido2` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` int(50) NOT NULL,
  `cargo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `salario` int(50) NOT NULL,
  `especializacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fec_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `DNI` int(50) NOT NULL,
  `EPS` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Apelido1` varchar(50) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `Apellido2` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` int(50) NOT NULL,
  `Fec_Nac` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientecama`
--

CREATE TABLE `pacientecama` (
  `id_pacientecama` int(50) NOT NULL,
  `fec_asignacion` date NOT NULL,
  `id_cama` int(50) NOT NULL,
  `id_historia` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planta`
--

CREATE TABLE `planta` (
  `id_planta` int(50) NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_camas` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetavisita`
--

CREATE TABLE `tarjetavisita` (
  `id_tarjeta` int(50) NOT NULL,
  `id_cama` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visitamedica`
--

CREATE TABLE `visitamedica` (
  `fec_visita` date NOT NULL,
  `hora_visita` time(6) NOT NULL,
  `diagnostico` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `id_medico` int(50) NOT NULL,
  `id_pacientecama` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cama`
--
ALTER TABLE `cama`
  ADD PRIMARY KEY (`id_cama`),
  ADD KEY `id_planta` (`id_planta`);

--
-- Indices de la tabla `historia`
--
ALTER TABLE `historia`
  ADD PRIMARY KEY (`id_historia`),
  ADD KEY `DNI` (`DNI`),
  ADD KEY `DNI_2` (`DNI`),
  ADD KEY `idhistoria` (`id_historia`),
  ADD KEY `DNI_3` (`DNI`),
  ADD KEY `DNI_4` (`DNI`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `DNI` (`DNI`);

--
-- Indices de la tabla `pacientecama`
--
ALTER TABLE `pacientecama`
  ADD PRIMARY KEY (`id_pacientecama`),
  ADD KEY `id_cama` (`id_cama`),
  ADD KEY `id_historia` (`id_historia`);

--
-- Indices de la tabla `planta`
--
ALTER TABLE `planta`
  ADD PRIMARY KEY (`id_planta`);

--
-- Indices de la tabla `tarjetavisita`
--
ALTER TABLE `tarjetavisita`
  ADD PRIMARY KEY (`id_tarjeta`),
  ADD KEY `id_cama` (`id_cama`);

--
-- Indices de la tabla `visitamedica`
--
ALTER TABLE `visitamedica`
  ADD UNIQUE KEY `id_pacientecama` (`id_pacientecama`),
  ADD KEY `id_medico` (`id_medico`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cama`
--
ALTER TABLE `cama`
  ADD CONSTRAINT `cama_ibfk_2` FOREIGN KEY (`id_planta`) REFERENCES `planta` (`id_planta`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `historia`
--
ALTER TABLE `historia`
  ADD CONSTRAINT `historia_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `paciente` (`DNI`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pacientecama`
--
ALTER TABLE `pacientecama`
  ADD CONSTRAINT `pacientecama_ibfk_1` FOREIGN KEY (`id_historia`) REFERENCES `historia` (`id_historia`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pacientecama_ibfk_2` FOREIGN KEY (`id_cama`) REFERENCES `cama` (`id_cama`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarjetavisita`
--
ALTER TABLE `tarjetavisita`
  ADD CONSTRAINT `tarjetavisita_ibfk_1` FOREIGN KEY (`id_cama`) REFERENCES `cama` (`id_cama`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `visitamedica`
--
ALTER TABLE `visitamedica`
  ADD CONSTRAINT `visitamedica_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`) ON UPDATE CASCADE,
  ADD CONSTRAINT `visitamedica_ibfk_2` FOREIGN KEY (`id_pacientecama`) REFERENCES `pacientecama` (`id_pacientecama`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
