-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 25 fév. 2020 à 21:27
-- Version du serveur :  5.7.26
-- Version de PHP :  5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `velotn`
--

-- --------------------------------------------------------

--
-- Structure de la table `accessoires`
--

DROP TABLE IF EXISTS `accessoires`;
CREATE TABLE IF NOT EXISTS `accessoires` (
  `id` int(11) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `accessoires`
--

INSERT INTO `accessoires` (`id`, `marque`, `type`) VALUES
(2, 'shimano', 'arriere');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `prix` double NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `don`
--

DROP TABLE IF EXISTS `don`;
CREATE TABLE IF NOT EXISTS `don` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `somme` double NOT NULL,
  `date_don` date NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `don`
--

INSERT INTO `don` (`id`, `somme`, `date_don`, `user_id`) VALUES
(7, 200, '2020-02-17', 1),
(8, 350, '2020-02-17', 2),
(9, 1000, '2020-02-17', 1),
(17, 57.0880012512207, '2020-02-19', 1),
(18, 22, '2020-02-20', 1),
(19, 20, '2020-02-20', 1);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `heure` time NOT NULL,
  `date` date NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `nom`, `heure`, `date`, `description`) VALUES
(10, 'trtrtrrtrtrtrt', '13:30:00', '2021-02-01', 'ahla wsahla'),
(11, 'trtrtrrtrtrtrt', '13:30:00', '2021-02-01', 'ahla wsahla'),
(12, 'trtrtrrtrtrtrt', '13:30:00', '2021-02-01', 'ahla wsahla'),
(13, 'zefds', '15:30:00', '2021-02-01', 'ahla wsahla'),
(14, 'Ahlawshla', '03:00:00', '2020-03-14', 'Anniversaire '),
(15, 'Ahlawshla', '03:00:00', '2020-03-14', 'Anniversaire '),
(16, 'Ahlawshla', '03:00:00', '2020-03-14', 'Anniversaire '),
(21, 'yellou', '12:30:00', '2020-02-07', 'yallor'),
(22, 'yallor', '13:30:00', '2020-02-27', 'yallorin');

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `date_naiss` date NOT NULL,
  `tel` varchar(100) NOT NULL,
  `interets` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL,
  `pays` varchar(100) NOT NULL,
  `region` varchar(100) NOT NULL,
  `code_postal` varchar(100) NOT NULL,
  `rue` varchar(100) NOT NULL,
  `claire` char(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `email`, `password`, `nom`, `prenom`, `date_naiss`, `tel`, `interets`, `image`, `pays`, `region`, `code_postal`, `rue`, `claire`) VALUES
(9, 'ons', 'ons.bouali@esprit.tn', '$2y$13$GOzIL9y7Y2EaSS2OF50Ep.iHO4Ql8FNOoNXfOknGzdccgzSXq8nQW', 'bouali', 'ons', '2020-02-24', 'ons', 'ons.bouali@esprit.tn', 'velo.jpg', 'tunis', 'mourouj', '2074', 'hambourg', '123'),
(11, 'eskander', 'eskander.guedouar@esprit.tn', '$2y$13$jTU/o54863ZdZOPs5by/weGwPYx.j/eOmOlPbd0C82LIGAbyzqLju', 'guedouar', 'eskander', '2020-02-25', 'eskander', 'eskander.guedouar@esprit.tn', 'trou-noir-espace-univers-astronomie.jpg', 'tunis', 'moknine', '5050', 'cartier tunis', '123'),
(12, 'safwan', 'safwen.zakhama@esprit.tn', '$2y$13$UjMPnLeFSA95JC6xKVPSMeo4BxOF8S9MrlA9gY3JMgIo95z6y/.h2', 'zk', 'afwan', '2020-02-25', 'safwan', 'safwen.zakhama@esprit.tn', 'trou-noir-espace-univers-astronomie.jpg', 'tunis', 'banan', '5050', 'jjjj', '123'),
(16, 'wajih', 'wajih.mejri@esprit.tn', '$2y$13$8Tq4VrvkcZP3tVwx6iBc2ej.n6.1iojJJ0pSZE8pIeTn.rsLfJOtW', 'hjgrf', 'wajih', '2020-02-25', 'wajih', 'wajih.mejri@esprit.tn', '596ce466ed07ad6118f998f6.png', 'hjyhryufire', 'jhkjhrf', '5234', 'hjhfed', '1234'),
(17, '6988989', 'farah.gabsi@esprit.tn', '$2y$13$yYSHcVF3cMo3agf4KgbTkuPr.w/lBKZ.UKtojxQPMWHqGZyg49lQa', '45454545', '5454545', '2020-02-25', '6988989', 'farah.gabsi@esprit.tn', '596ce466ed07ad6118f998f6.png', '454545454', '54465', '7894545', '456465', '123');

-- --------------------------------------------------------

--
-- Structure de la table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbrMembre` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date_de_creation` date NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nbr_signal` int(11) NOT NULL,
  `IdUser` int(11) DEFAULT NULL,
  `lieux` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `IDX_F06D3970F9C28DE1` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `groups`
--

INSERT INTO `groups` (`id`, `nom`, `nbrMembre`, `description`, `date_de_creation`, `image`, `nbr_signal`, `IdUser`, `lieux`) VALUES
(17, 'hhhh', 1, 'dksqcl', '2020-02-23', 'trou-noir-espace-univers-astronomie.jpg', 0, 8, 'jklk');

-- --------------------------------------------------------

--
-- Structure de la table `groups_members`
--

DROP TABLE IF EXISTS `groups_members`;
CREATE TABLE IF NOT EXISTS `groups_members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groups_id` int(11) DEFAULT NULL,
  `confirmation` tinyint(1) NOT NULL,
  `dateInscri` datetime DEFAULT NULL,
  `Idauthor` int(11) DEFAULT NULL,
  `nomGroup` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5C1D0E4A20641732` (`Idauthor`),
  KEY `IDX_5C1D0E4AF373DCF` (`groups_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `groups_members`
--

INSERT INTO `groups_members` (`id`, `groups_id`, `confirmation`, `dateInscri`, `Idauthor`, `nomGroup`) VALUES
(1, 16, 1, NULL, 9, 'velo.tn');

-- --------------------------------------------------------

--
-- Structure de la table `listprod`
--

DROP TABLE IF EXISTS `listprod`;
CREATE TABLE IF NOT EXISTS `listprod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `command_id` int(11) NOT NULL,
  `product` int(11) NOT NULL,
  `qte` int(11) NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1` (`command_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `prixtotal` float NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_user` int(100) NOT NULL,
  PRIMARY KEY (`id`,`id_produit`),
  KEY `id_produitFK` (`id_produit`),
  KEY `id_userFk` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produit_id` int(11) NOT NULL,
  `qte` int(11) NOT NULL,
  `prix_unitaire` decimal(10,0) NOT NULL,
  `prix_total` decimal(10,0) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produit` (`produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `piecesrechanges`
--

DROP TABLE IF EXISTS `piecesrechanges`;
CREATE TABLE IF NOT EXISTS `piecesrechanges` (
  `id` int(11) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `piecesrechanges`
--

INSERT INTO `piecesrechanges` (`id`, `marque`, `type`) VALUES
(3, 'sikapiki', 'head');

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomProd` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `prix` float NOT NULL,
  `quantite` int(11) NOT NULL,
  `img_url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`id`, `nomProd`, `description`, `prix`, `quantite`, `img_url`) VALUES
(1, 'velo', 'velovlo', 450, 100, 'http://localhost/velotnproducts/vtt.png'),
(2, 'derailleur', 'lalallalalalalala', 30, 50, 'http://localhost/velotnproducts/vtt.png'),
(3, 'casque', 'dsqhfqsidufhidqsfhipods', 50, 20, 'http://localhost/velotnproducts/road.png');

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `taux` float NOT NULL,
  `id_produits` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produitsFK` (`id_produits`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id`, `type`, `taux`, `id_produits`) VALUES
(9, 'dfghjk', 10, 1);

-- --------------------------------------------------------

--
-- Structure de la table `publication_group`
--

DROP TABLE IF EXISTS `publication_group`;
CREATE TABLE IF NOT EXISTS `publication_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupid` int(11) DEFAULT NULL,
  `contenu` longtext COLLATE utf8_unicode_ci NOT NULL,
  `datePublication` datetime NOT NULL,
  `IdUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_49DF2D4DF9C28DE1` (`IdUser`),
  KEY `IDX_49DF2D4D7805AC12` (`groupid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `publication_group`
--

INSERT INTO `publication_group` (`id`, `groupid`, `contenu`, `datePublication`, `IdUser`) VALUES
(17, 16, 'hhhh', '2020-02-23 18:19:15', 8),
(18, 16, 'hhuh', '2020-02-23 19:42:00', 8),
(19, 16, 'bonjour', '2020-02-24 20:36:22', 9),
(20, 17, 'ghdhfjkhrf', '2020-02-25 15:00:23', 13);

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `descriptionR` text NOT NULL,
  `etat` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `signalgroup`
--

DROP TABLE IF EXISTS `signalgroup`;
CREATE TABLE IF NOT EXISTS `signalgroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdUser` int(11) DEFAULT NULL,
  `IdGroup` int(11) DEFAULT NULL,
  `visible` tinyint(1) DEFAULT NULL,
  `valider` tinyint(1) DEFAULT NULL,
  `nomGroup` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_25C3CFE8F9C28DE1` (`IdUser`),
  KEY `IDX_25C3CFE8B5B93E44` (`IdGroup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `velos`
--

DROP TABLE IF EXISTS `velos`;
CREATE TABLE IF NOT EXISTS `velos` (
  `id` int(11) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `velos`
--

INSERT INTO `velos` (`id`, `marque`, `type`) VALUES
(1, 'btwin', 'vtt');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `accessoires`
--
ALTER TABLE `accessoires`
  ADD CONSTRAINT `idProduitA` FOREIGN KEY (`id`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `listprod`
--
ALTER TABLE `listprod`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`command_id`) REFERENCES `commande` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `id_produitFK` FOREIGN KEY (`id_produit`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_userFk` FOREIGN KEY (`id_user`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`produit_id`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `piecesrechanges`
--
ALTER TABLE `piecesrechanges`
  ADD CONSTRAINT `idProduit` FOREIGN KEY (`id`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `id_produitsFK` FOREIGN KEY (`id_produits`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`idUser`) REFERENCES `fos_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `velos`
--
ALTER TABLE `velos`
  ADD CONSTRAINT `idProduitFK` FOREIGN KEY (`id`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
