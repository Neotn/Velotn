-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 24 fév. 2020 à 02:09
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
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id` int(50) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `prixtotal` float NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_user` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id`, `date_debut`, `date_fin`, `prixtotal`, `id_produit`, `id_user`) VALUES
(18, '2020-02-20', '2020-02-21', 50, 1, 12);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`,`id_produit`),
  ADD KEY `id_produitFK` (`id_produit`),
  ADD KEY `id_userFk` (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `id_produitFK` FOREIGN KEY (`id_produit`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_userFk` FOREIGN KEY (`id_user`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
