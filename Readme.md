# クイズアプリ - 段階的開発ガイド

## 概要

このプロジェクトは、Spring Boot + MyBatis + H2を使ったクイズアプリを段階的に開発することで、以下を学習します：

- Spring MVCの基本
- セッション管理
- データベース設計（正規化・リレーション）
- MyBatisでのJOIN操作
- 段階的なリファクタリング

---

## 開発フェーズ

### Phase 1: シンプルクイズ（基礎編）
**学習目標:**
- Spring MVCの基本的な流れ
- セッション管理
- MyBatisの基本操作

**機能:**
- 1問ずつ表示するクイズ
- セッションで正解数を管理
- 結果表示

**テーブル構成:**
```
questions
├── id
├── text
├── option_a
├── option_b
├── option_c
├── option_d
└── correct_answer
```

**実装方法:**
1. `QuizController.java` のコメントを解除
2. セッションの使い方を理解
3. 1問ずつ表示する仕組みを実装

---

### Phase 2: カテゴリ別クイズ（リレーション編）
**学習目標:**
- テーブル正規化
- 外部キー制約
- JOINクエリ
- 1対多のリレーション

**機能:**
- カテゴリ一覧から選択
- カテゴリ別に問題を出題
- カテゴリ別の統計表示

**テーブル構成:**
```
categories (追加)
├── id
└── name

questions (変更)
├── id
├── category_id ← 外部キー
├── text
├── option_a
├── option_b
├── option_c
├── option_d
└── correct_answer
```

**実装方法:**
1. `schema.sql` にcategoriesテーブル追加
2. `CategoryMapper.java` を実装
3. JOINクエリを書く
4. カテゴリ選択画面を追加

---

### Phase 3: 統計機能（応用編）
**学習目標:**
- 集計関数（COUNT, AVG）
- GROUP BY句
- 複雑なJOIN
- データ分析の基礎

**機能:**
- 問題別正解率
- カテゴリ別正解率
- ユーザー別成績（オプション）

**テーブル構成:**
```
quiz_results (追加)
├── id
├── user_name
├── question_id ← 外部キー
├── category_id ← 外部キー
├── is_correct
└── answered_at
```

**実装方法:**
- 自分で設計・実装する
- ヒント: 結果を保存するテーブルを追加
- 集計クエリの練習

---

## セッション管理について

### セッションとは
- ユーザーごとの一時的なデータ保存領域
- サーバー側で管理
- ブラウザを閉じるまで有効

### このアプリでの使い方

```java
// セッションに保存
session.setAttribute("userName", "太郎");
session.setAttribute("correct", 0);

// セッションから取得
String userName = (String) session.getAttribute("userName");
int correct = (int) session.getAttribute("correct");

// セッション削除
session.invalidate();
```

### なぜセッションを使うのか？

**問題:** クイズを1問ずつ表示すると、前の問題の回答を覚えておく必要がある

**解決策:**
1. ❌ フォームで全部送る → データが大きくなる
2. ❌ データベースに都度保存 → 処理が重い
3. ✅ **セッションで管理** → シンプルで効率的

---

## 起動方法

```bash
# ビルド
./gradlew build

# 起動
./gradlew bootRun
```

ブラウザで `http://localhost:8080/quiz/` にアクセス

---

## H2コンソール

データベースの中身を確認：
```
http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: (空欄)
```

---

## 実装の進め方

### Phase 1の実装手順

#### Step 1: トップページの確認
- 最初から動く状態を確認
- `index.html` を見て理解

#### Step 2: /start の実装
1. `QuizController.java` の `/start` のコメントを解除
2. セッションの初期化を理解
   ```java
   session.setAttribute("userName", userName);
   session.setAttribute("correct", 0);
   ```
3. 動作確認

#### Step 3: /question の実装
1. `/question` のコメントを解除
2. セッションから情報を取得
3. 問題番号に応じた問題を表示
4. 動作確認

#### Step 4: /answer の実装
1. `/answer` のコメントを解除
2. 正解判定の実装
3. セッションの更新
4. 次の問題へリダイレクト
5. 動作確認

#### Step 5: /result の実装
1. `/result` のコメントを解除
2. セッションから結果を取得
3. `session.invalidate()` でセッションをクリア
4. 動作確認

### デバッグのヒント

**セッションの中身を確認:**
```java
System.out.println("userName: " + session.getAttribute("userName"));
System.out.println("correct: " + session.getAttribute("correct"));
```

**問題数の確認:**
```java
System.out.println("Total questions: " + questions.size());
```

---

## Phase 2の実装手順（概要）

### Step 1: テーブル設計
1. `schema.sql` を編集
2. categoriesテーブル追加
3. questionsにcategory_id追加

### Step 2: マッパー作成
1. `CategoryMapper.java` 作成
2. `CategoryMapper.xml` 作成
3. JOINクエリを書く

### Step 3: 画面追加
1. カテゴリ選択画面
2. カテゴリ別結果画面

### Step 4: コントローラー実装
- TODOコメントを埋める
- セッションにcategoryIdを保存

---

## よくあるエラーと対処法

### エラー1: NullPointerException
```
原因: セッションから取得した値がnull
対処: session.getAttribute() の前に値が入っているか確認
```

### エラー2: リダイレクトループ
```
原因: セッションが初期化されていない
対処: /start を経由しているか確認
```

### エラー3: 問題が表示されない
```
原因: data.sqlが実行されていない
対処: application.propertiesの設定確認
```

---

## コードの説明

### リダイレクトとforwardの違い

**リダイレクト:**
```java
return "redirect:/quiz/question?no=1";
```
- URLが変わる
- 画面遷移が見える
- セッションは保持される

**forward:**
```java
return "question";
```
- URLが変わらない
- Thymeleafテンプレートを表示
- modelの値を使える

### @RequestParamの使い方

```java
@GetMapping("/question")
public String question(@RequestParam int no) {
    // URLの ?no=1 を受け取る
}
```

### セッションのライフサイクル

```
1. /start で session.setAttribute() → 作成
2. /question, /answer で session.getAttribute() → 使用
3. /result で session.invalidate() → 破棄
```

---

## 発展課題

Phase 3実装後、以下の機能を追加してみましょう：

1. **タイマー機能**
   - 制限時間を設定
   - JavaScriptで実装

2. **ランキング機能**
   - 成績をDBに保存
   - TOP10を表示

3. **問題追加機能**
   - 管理画面を作成
   - CRUDの実装

4. **画像問題**
   - 画像をアップロード
   - 問題に画像を表示

---

## 学習のポイント

### Phase 1で学ぶこと
- セッション管理の必要性
- MVCの流れ
- リダイレクトの使い方

### Phase 2で学ぶこと
- なぜテーブルを分けるのか
- JOINの書き方
- 外部キーの役割

### Phase 3で学ぶこと
- データ分析の基礎
- 集計クエリ
- 実務的な機能設計

---

## 参考資料

- Spring Boot公式: https://spring.io/projects/spring-boot
- MyBatis公式: https://mybatis.org/mybatis-3/
- Thymeleaf公式: https://www.thymeleaf.org/

---

## トラブルシューティング

### 起動しない
1. Java 17がインストールされているか確認
2. `./gradlew clean build` で再ビルド

### データが入らない
1. `schema.sql` と `data.sql` の内容確認
2. H2コンソールで直接確認

### セッションが動かない
1. ブラウザのCookieを確認
2. シークレットモードで試す

---

## 完成イメージ

### Phase 1
```
トップ → 名前入力 → 問題1 → 問題2 → 問題3 → 結果
```

### Phase 2
```
トップ → カテゴリ選択 → 名前入力 → 問題1 → ... → 結果（カテゴリ別統計付き）
```

### Phase 3
```
トップ → 統計表示 → カテゴリ選択 → ... → 結果 → 全体統計
```

---

## ライセンス

教育目的での利用を想定しています。自由に改変・配布してください。