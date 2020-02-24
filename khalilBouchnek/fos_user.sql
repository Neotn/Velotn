-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 24 fév. 2020 à 02:10
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `esprit`
--

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

CREATE TABLE `fos_user` (
  `id` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `date_naiss` date NOT NULL,
  `tel` varchar(100) NOT NULL,
  `interets` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `email`, `password`, `nom`, `prenom`, `date_naiss`, `tel`, `interets`, `image`) VALUES
(12, 'fm', 'f@esprit.tn', '154', 'f', 'm', '1970-01-01', '21456654', 'in', 'im'),
(14, 'farahg', 'l@esprit.tn', '1458', 'far', 'gab', '3894-11-12', 'tel', 'interets', 'image'),
(123, 'fm', 'f@esprit.tn', '154', 'f', 'm', '1970-01-01', '21456654', 'in', 'im');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `fos_user`
--
ALTER TABLE `fos_user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
