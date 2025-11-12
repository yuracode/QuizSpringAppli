-- ========================================
-- Phase 1: 初期データ
-- ========================================

--INSERT INTO questions (text, option_a, option_b, option_c, option_d, correct_answer) VALUES
--('Javaのprintlnはどのクラスにある?', 'System.in', 'System.out', 'System.err', 'System.log', 'B'),
--('Javaのint型は何ビット?', '8', '16', '32', '64', 'C'),
--('Spring Bootのデフォルトポートは?', '3000', '8080', '5000', '9000', 'B'),
--('JavaでNullPointerExceptionが発生する原因は?', 'メモリ不足', 'null参照', '型変換エラー', '無限ループ', 'B'),
--('MyBatisで使用するアノテーションは?', '@Service', '@Mapper', '@Controller', '@Component', 'B');

-- ========================================
-- Phase 2: カテゴリ別データ
-- ========================================


--TODO Phase 2: このコメントを解除してデータを追加

-- カテゴリデータ
INSERT INTO categories (name) VALUES
('Java基礎'),
('Spring Boot'),
('データベース'),
('ネットワーク');

-- 問題データ（category_id付き）
 INSERT INTO questions (category_id, text, option_a, option_b, option_c, option_d, correct_answer) VALUES
 -- Java基礎
 (1, 'Javaのprintlnはどのクラスにある?', 'System.in', 'System.out', 'System.err', 'System.log', 'B'),
 (1, 'Javaのint型は何ビット?', '8', '16', '32', '64', 'C'),
 (1, 'JavaでNullPointerExceptionが発生する原因は?', 'メモリ不足', 'null参照', '型変換エラー', '無限ループ', 'B'),

-- -- Spring Boot
 (2, 'Spring Bootのデフォルトポートは?', '3000', '8080', '5000', '9000', 'B'),
 (2, 'MyBatisで使用するアノテーションは?', '@Service', '@Mapper', '@Controller', '@Component', 'B'),
 (2, '@Controllerの役割は?', 'データアクセス', 'ビジネスロジック', 'リクエスト処理', '設定管理', 'C'),

-- -- データベース
 (3, 'SQLでデータを取得するのは?', 'INSERT', 'UPDATE', 'SELECT', 'DELETE', 'C'),
 (3, '主キーの制約は?', '重複可', '重複不可', 'NULL可', 'なんでも可', 'B'),

-- -- ネットワーク
 (4, 'HTTPSのポート番号は?', '80', '443', '8080', '3000', 'B'),
 (4, 'IPアドレスのバージョンは?', 'v1とv2', 'v4とv6', 'v3とv5', 'v2とv4', 'B');

 INSERT INTO authentications (username, password) VALUES 
('user', '$2a$10$37pvt9phv.DPNF/lFcHIP.MpiBPWh5eokVXX66rWw98.GyrDtCYpi');