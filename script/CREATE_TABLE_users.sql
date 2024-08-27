-- ▼リスト7-27――「users」テーブルのクエリ
CREATE TABLE `users` (
  `id` int(11) PRIMARY KEY NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
