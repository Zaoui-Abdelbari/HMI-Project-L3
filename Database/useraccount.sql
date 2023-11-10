-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 nov. 2023 à 21:14
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `useraccount`
--

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `passwordconf` varchar(50) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `update_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`user_id`, `email`, `username`, `password`, `passwordconf`, `question`, `answer`, `date`, `update_date`) VALUES
(1, 'zaouiabdo@gmail.com', 'abdo', 'abdlbar1027U', '', 'Where do you live now?', 'adrar', '2023-11-05', '2023-11-08'),
(2, 'zaouiboulam', 'abddelbari', '123456789', '', 'Where do you live now?', 'adrar', '2023-11-05', NULL),
(3, 'housin@gmail.com', 'housin', '123456789', '', 'What is your favorite sport?', 'football', '2023-11-05', NULL),
(4, 'sergin@gmail.com', 'abdlilah', '123456789', '', 'Where do you live now?', 'telemcan', '2023-11-05', NULL),
(5, 'test@gmail.com', 'test', '123456789', '', 'What\'s the name of your college?', 'ahmed Draiaa', '2023-11-05', NULL),
(6, 'omiga@gmail.com', 'omiga', '987123654', '', 'Where do you live now?', 'adrar', '2023-11-06', NULL),
(7, 'housin@gmail.com', 'l2h', '123456789', '', 'Where do you live now?', 'founghil', '2023-11-06', NULL),
(8, 'abdo@gmail.com', 'abdlbar1027U', '0', '9871236455', 'Where do you live now?', 'Adrar', '2023-11-06', '2023-11-07'),
(9, 'abdlgany@gmail.com', 'abdelghany', '123456789', '123456789', 'What\'s the name of your college?', 'Mouchy Boudjmaa', '2023-11-06', NULL),
(10, 'mr.demri@gmail.com', 'Mohemmed ', '123456789', '123456789', 'Where do you live now?', 'Adrar', '2023-11-06', NULL),
(12, 'abdo@gmail.com', 'hola', '9871236455', 'abdlbar1027U', 'Where do you live now?', 'adrar', '2023-11-08', '2023-11-08');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
