-- ========================================
-- Phase 1: シンプルなテーブル構成
-- ========================================

DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT NOT NULL,
    text VARCHAR(500) NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    correct_answer CHAR(1) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- ========================================
-- Phase 2: カテゴリテーブル追加
-- ========================================

-- Phase2 でカテゴリ対応実装済み（上で反映）

-- ========================================
-- Phase 3: 結果保存テーブル追加
-- ========================================

/*
TODO Phase 3: 結果を保存するテーブルを設計・実装

ヒント:
- user_name: 回答者名
- question_id: 問題ID（外部キー）
- category_id: カテゴリID（外部キー）
- is_correct: 正解かどうか（BOOLEAN）
- answered_at: 回答日時（TIMESTAMP）

これを使って統計機能を実装する
*/