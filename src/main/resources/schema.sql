-- ========================================
-- Phase 1: シンプルなテーブル構成
-- ========================================

DROP TABLE IF EXISTS questions;

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(500) NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    correct_answer CHAR(1) NOT NULL
);

-- ========================================
-- Phase 2: カテゴリテーブル追加
-- ========================================


--TODO Phase 2: このコメントを解除してテーブルを追加

-- カテゴリテーブル
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- questionsテーブルにcategory_idを追加
-- 注意: 既存のquestionsテーブルを削除して再作成する必要がある

-- DROP TABLE IF EXISTS questions;

-- CREATE TABLE questions (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     category_id INT NOT NULL,
--     text VARCHAR(500) NOT NULL,
--     option_a VARCHAR(200) NOT NULL,
--     option_b VARCHAR(200) NOT NULL,
--     option_c VARCHAR(200) NOT NULL,
--     option_d VARCHAR(200) NOT NULL,
--     correct_answer CHAR(1) NOT NULL,
--     FOREIGN KEY (category_id) REFERENCES categories(id)
-- );


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