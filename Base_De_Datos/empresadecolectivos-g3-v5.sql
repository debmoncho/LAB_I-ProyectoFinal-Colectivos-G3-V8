-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2024 a las 19:56:04
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

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
(1, '875SPX', 'Mercedes Benz', 'XT1000', 45, 0),
(2, '875SPX', 'Airton Menta', 'XT1000', 45, 1),
(3, '951TBX', 'LG', 'Terreneitor', 60, 1),
(4, '654LOL', 'SONY', 'ToT', 45, 1),
(5, '842IKJ', 'Peugeot', 'Lambo', 60, 1),
(6, '657AAB', 'LaHora', 'DarkThtrone', 60, 1);

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
(1, 2, '22:32:00', '22:42:00', 0),
(5, 3, '23:59:59', '00:00:00', 1),
(7, 1, '22:30:00', '23:50:00', 1),
(11, 2, '21:40:00', '23:50:00', 0),
(12, 3, '12:50:00', '23:20:00', 1),
(13, 3, '15:00:00', '17:00:00', 1);

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
(1, 'Javier Alejandro', 'Pepon', '51489753', 'lala@gmail.com', '2665854796', 1),
(3, 'Luis', 'Mercado', '12159741', 'lilo@gmail.com', '4459874', 0),
(4, 'Juan', 'Lopez', '43178350', 'correo1@gmail.com', '2664112233', 1);

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
(1, 1, 2, 1, '2024-03-25', '07:20:00', 1, 19099),
(2, 4, 5, 3, '2024-06-08', '04:20:00', 17, 3);

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
(1, 'San luis', 'Merlo', '04:25:00', 1),
(2, 'San luis', 'Villa Mercedes', '04:30:00', 1),
(3, 'San luis', 'Merlo', '04:25:00', 1),
(4, 'Quines', ' San Luis', '02:30:00', 1),
(5, 'San Luis ', 'Villa Mercedez', '01:00:00', 1),
(6, 'La Florida', 'San Luis', '01:00:00', 1),
(7, 'Carolina', 'San Luis', '02:00:00', 1),
(8, 'La Punta ', 'Nogoli', '01:00:00', 1),
(9, 'Villa De La Quebrada', 'Villa Mercedez', '02:00:00', 1),
(10, 'Juana Koslay', 'Rio Negro', '01:00:00', 1),
(11, 'San Luis', 'Trapiche', '01:00:00', 1),
(12, 'Batabia ', 'San Luis', '02:30:00', 1),
(13, 'Paso Del Ray', 'La Punta', '01:00:00', 1),
(14, 'Desaguadero', 'San Luis', '01:00:00', 1),
(15, 'Balde', ' Villa Mercedez', '01:00:00', 1);

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
  MODIFY `idColectivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `idPasajero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `idRuta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

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
  ADD CONSTRAINT `pasajes_ibfk_1` FOREIGN KEY (`idPasajero`) REFERENCES `pasajeros` (`idPasajero`),
  ADD CONSTRAINT `pasajes_ibfk_2` FOREIGN KEY (`idColectivo`) REFERENCES `colectivos` (`idColectivo`),
  ADD CONSTRAINT `pasajes_ibfk_3` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
