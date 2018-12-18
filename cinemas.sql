-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 18 Décembre 2018 à 10:14
-- Version du serveur :  5.5.58-0+deb8u1-log
-- Version de PHP :  7.1.13-1+0~20180105151310.14+jessie~1.gbp1086fa

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `francois`
--

-- --------------------------------------------------------

--
-- Structure de la table `cinemas`
--

CREATE TABLE IF NOT EXISTS `cinemas` (
`id` int(64) NOT NULL,
  `nom` text NOT NULL,
  `adresse` text NOT NULL,
  `nombre_salles` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cinemas`
--

INSERT INTO `cinemas` (`id`, `nom`, `adresse`, `nombre_salles`) VALUES
(2, 'Le Grand REX', '{"numero":12,"rue":"Avenue de Paris","codePostal":94800,"ville":"Villejuif","pays":"France"}', 45),
(6, 'Pathé', '{"numero":85,"rue":"Avenue de Paris","codePostal":94800,"ville":"Villejuif","pays":"France"}', 12),
(7, 'Gaumont', '{"numero":12,"rue":"Avenue de la république","codePostal":33000,"ville":"Bordeaux","pays":"France"}', 18),
(8, 'Pathé', '{"numero":87,"rue":"Avenue de la banane","codePostal":33000,"ville":"Bordeaux","pays":"France"}', 22),
(12, 'Le Grand REXX2', '{"numero":12,"rue":"Avenue de Paris","codePostal":94800,"ville":"Villejuif","pays":"France"}', 45);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `cinemas`
--
ALTER TABLE `cinemas`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `cinemas`
--
ALTER TABLE `cinemas`
MODIFY `id` int(64) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
