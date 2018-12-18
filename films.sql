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
-- Structure de la table `films`
--

CREATE TABLE IF NOT EXISTS `films` (
`id` int(64) NOT NULL,
  `nom` text NOT NULL,
  `date_sortie` text NOT NULL,
  `acteurs_principaux` text NOT NULL,
  `synopsis` text NOT NULL,
  `distributeur` text NOT NULL,
  `type` text NOT NULL,
  `langue` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `films`
--

INSERT INTO `films` (`id`, `nom`, `date_sortie`, `acteurs_principaux`, `synopsis`, `distributeur`, `type`, `langue`) VALUES
(1, 'Peter Pan', '10/10/2001', 'Grégoire, François', 'Peter Pan est un personnage créé par l''auteur écossais J. M. Barrie, apparu pour la première fois dans le roman The Little White Bird en 1902, puis dans la pièce du même nom et enfin dans le roman Peter et Wendy, plus connu sous le titre Peter Pan. \r\n', 'WaltDisney', 'Enfant', 'Français'),
(2, 'Snowden', '01/01/2016', '', 'Violant la Constitution, soutenue par de grandes entreprises, la NSA collecte des montagnes de données et piste toutes les formes de télécommunications à un niveau planétaire. Choqué par cette intrusion systématique dans nos vies privées, Edward Snowden décide de rassembler des preuves et de tout di… PLUS\r\n', 'Sony', 'Drame/Thriller', 'Anglais, Français'),
(3, 'Star Wars: les derniers Jedi', '13/12/17', '', 'Les héros du Réveil de la force rejoignent les figures légendaires de la galaxie dans une aventure épique qui révèle des secrets ancestraux sur la Force et entraîne de surprenantes révélations sur le passé…', 'The Walt Disney Company France', 'Science-fiction', 'Français, anglais'),
(4, 'Le Roi lion', '15/10/2019', 'Jon Favreau', 'Le Roi lion est un film américain réalisé par Jon Favreau, dont la sortie est prévue en été 2019. Il s''agit d''une nouvelle version du film d''animation Le Roi lion sorti en 1994. Ce film utilise la technique de l''animation 3D', 'Fairview Entertainment Walt Disney Pictures', 'Enfants', 'Anglais, Français');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `films`
--
ALTER TABLE `films`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `films`
--
ALTER TABLE `films`
MODIFY `id` int(64) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
