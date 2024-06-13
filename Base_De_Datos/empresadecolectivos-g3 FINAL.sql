-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2024 a las 06:29:55
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresadecolectivos-g3`
--
CREATE DATABASE IF NOT EXISTS `empresadecolectivos-g3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `empresadecolectivos-g3`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivos`
--

CREATE TABLE `colectivos` (
  `idColectivo` int(11) NOT NULL,
  `matricula` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colectivos`
--

INSERT INTO `colectivos` (`idColectivo`, `matricula`, `marca`, `modelo`, `capacidad`, `estado`) VALUES
(1, 'AMB 209', 'Mercedes Benz', 'GTX3', 10, 1),
(2, 'BPD 609', 'Scania', 'T2000', 10, 1),
(3, 'GFS 401', 'Volkswagen', 'DT90', 30, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `idHorario` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `horaSalida` time NOT NULL,
  `horaLlegada` time NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`idHorario`, `idRuta`, `horaSalida`, `horaLlegada`, `estado`) VALUES
(1, 1, '10:30:00', '11:30:00', 1),
(2, 1, '17:00:00', '18:00:00', 1),
(3, 2, '14:00:00', '16:00:00', 1),
(4, 2, '20:00:00', '22:00:00', 1),
(5, 3, '15:00:00', '17:30:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `idPasajero` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`idPasajero`, `nombre`, `apellido`, `dni`, `correo`, `telefono`, `estado`) VALUES
(1, 'Juan Carlos', 'Sosa', '16764289', 'sosajuan@gmail.com', '2664521789', 1),
(2, 'Claudia', 'Fernandez', '26846902', 'claudia12@hotmail.com', '0115465821', 1),
(3, 'Fabricio', 'Bustamante', '40932267', 'fabri02@gmail.com', '2665890231', 1),
(4, 'Mariana', 'Quiroga', '22390368', 'marianaq@gmail.com', '351678249', 1),
(5, 'Cristobal', 'Reyes', '39827005', 'cristobalrey@gmail.com', '2664658092', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajes`
--

CREATE TABLE `pasajes` (
  `idPasaje` int(11) NOT NULL,
  `idPasajero` int(11) NOT NULL,
  `idColectivo` int(11) NOT NULL,
  `idRuta` int(11) NOT NULL,
  `fechaViaje` date NOT NULL,
  `horaViaje` time NOT NULL,
  `asiento` int(11) NOT NULL,
  `precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajes`
--

INSERT INTO `pasajes` (`idPasaje`, `idPasajero`, `idColectivo`, `idRuta`, `fechaViaje`, `horaViaje`, `asiento`, `precio`) VALUES
(1, 1, 1, 1, '2024-06-13', '10:30:00', 1, 15000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `idRuta` int(11) NOT NULL,
  `origen` varchar(30) NOT NULL,
  `destino` varchar(30) NOT NULL,
  `duracionEstimada` time NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutas`
--

INSERT INTO `rutas` (`idRuta`, `origen`, `destino`, `duracionEstimada`, `estado`) VALUES
(1, 'San Luis', 'La Punta', '01:00:00', 1),
(2, 'Merlo', 'Villa Mercedes', '02:00:00', 1),
(3, 'Quines', 'La Toma', '02:30:00', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`idColectivo`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`idHorario`),
  ADD KEY `idRuta` (`idRuta`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`idPasajero`),
  ADD UNIQUE KEY `dni` (`dni`,`correo`);

--
-- Indices de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`idPasaje`),
  ADD KEY `idPasajero` (`idPasajero`),
  ADD KEY `idColectivo` (`idColectivo`),
  ADD KEY `idRuta` (`idRuta`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`idRuta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `idColectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `idPasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `idRuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`);

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`idPasajero`) REFERENCES `pasajeros` (`idPasajero`) ON DELETE CASCADE,
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`idColectivo`) REFERENCES `colectivos` (`idColectivo`) ON DELETE CASCADE,
  ADD CONSTRAINT `pasajes_ibfk_3` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
