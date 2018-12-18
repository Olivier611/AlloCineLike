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
-- Structure de la table `projections`
--

CREATE TABLE IF NOT EXISTS `projections` (
`id` int(64) NOT NULL,
  `id_cinema` int(11) NOT NULL,
  `id_film` int(11) NOT NULL,
  `date_debut` text NOT NULL,
  `date_fin` text NOT NULL,
  `seances` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `projections`
--

INSERT INTO `projections` (`id`, `id_cinema`, `id_film`, `date_debut`, `date_fin`, `seances`) VALUES
(2, 2, 1, '10/09/2018', '10/10/2018', '[{"jour":"Lundi","heure":"10:00"},{"jour":"Mardi","heure":"10:00"},{"jour":"Mercredi","heure":"10:00"}]'),
(4, 7, 1, '10/09/2018', '10/10/2018', '[{"jour":"Lundi","heure":"10:00"},{"jour":"Mardi","heure":"10:00"},{"jour":"Mercredi","heure":"10:00"}]'),
(5, 8, 3, '18/09/2018', '16/10/2018', '[{"jour":"Lundi","heure":"10:00"},{"jour":"Mardi","heure":"10:00"},{"jour":"Mercredi","heure":"10:00"}]');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `projections`
--
ALTER TABLE `projections`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `projections`
--
ALTER TABLE `projections`
MODIFY `id` int(64) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
