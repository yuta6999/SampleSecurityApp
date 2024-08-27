-- ▼リスト7-27――「authorities」テーブルのクエリ
CREATE TABLE `authorities` (
  `id` int(11) PRIMARY KEY NOT NULL,
  `username` varchar(255) NOT NULL,
  `authority` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
