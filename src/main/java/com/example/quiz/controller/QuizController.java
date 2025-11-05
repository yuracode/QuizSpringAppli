package com.example.quiz.controller;

import com.example.quiz.mapper.QuestionMapper;
import com.example.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    private QuestionMapper questionMapper;
    
    // ========================================
    // Phase 1: シンプルクイズ
    // ========================================
    
    /**
     * トップページ表示（最初から動く）
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    /**
     * クイズ開始
     * セッションを初期化して最初の問題へリダイレクト
     * 
     * TODO Phase 1: このコメントを解除して実装
     */
    /*
    @GetMapping("/start")
    public String start(@RequestParam String userName, HttpSession session) {
        // セッションに名前を保存
        session.setAttribute("userName", userName);
        
        // 正解数を初期化
        session.setAttribute("correct", 0);
        
        // 総問題数を保存
        session.setAttribute("total", questionMapper.findAll().size());
        
        // 最初の問題へリダイレクト
        return "redirect:/quiz/question?no=1";
    }
    */
    
    /**
     * 問題表示
     * セッションから情報を取得し、指定された問題番号の問題を表示
     * 
     * TODO Phase 1: このコメントを解除して実装
     */
    /*
    @GetMapping("/question")
    public String question(@RequestParam int no, HttpSession session, Model model) {
        // 全問題を取得
        List<Question> questions = questionMapper.findAll();
        
        // 問題番号が範囲外なら結果画面へ
        if (no > questions.size()) {
            return "redirect:/quiz/result";
        }
        
        // 指定された問題をモデルに追加（配列は0始まりなので -1）
        model.addAttribute("question", questions.get(no - 1));
        
        // 現在の問題番号と総問題数をモデルに追加
        model.addAttribute("no", no);
        model.addAttribute("total", session.getAttribute("total"));
        
        return "question";
    }
    */
    
    /**
     * 回答処理
     * ユーザーの回答を受け取り、正解判定してセッションを更新
     * 
     * TODO Phase 1: このコメントを解除して実装
     */
    /*
    @PostMapping("/answer")
    public String answer(@RequestParam int no,
                        @RequestParam String answer,
                        HttpSession session) {
        // 全問題を取得
        List<Question> questions = questionMapper.findAll();
        
        // 現在の問題を取得
        Question q = questions.get(no - 1);
        
        // セッションから現在の正解数を取得
        int correct = (int) session.getAttribute("correct");
        
        // 正解判定
        if (answer.equals(q.getCorrectAnswer())) {
            correct++;
            // 正解数を更新
            session.setAttribute("correct", correct);
        }
        
        // 最後の問題なら結果画面へ
        if (no >= questions.size()) {
            return "redirect:/quiz/result";
        }
        
        // 次の問題へリダイレクト
        return "redirect:/quiz/question?no=" + (no + 1);
    }
    */
    
    /**
     * 結果表示
     * セッションから結果を取得して表示し、セッションをクリア
     * 
     * TODO Phase 1: このコメントを解除して実装
     */
    /*
    @GetMapping("/result")
    public String result(HttpSession session, Model model) {
        // セッションから結果を取得してモデルに追加
        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("correct", session.getAttribute("correct"));
        model.addAttribute("total", session.getAttribute("total"));
        
        // セッションをクリア（次回のために）
        session.invalidate();
        
        return "result";
    }
    */
    
    // ========================================
    // Phase 2: カテゴリ別クイズ
    // ========================================
    
    /**
     * カテゴリ一覧表示
     * 
     * TODO Phase 2: カテゴリマッパーを使って実装
     */
    /*
    @GetMapping("/categories")
    public String categories(Model model) {
        // TODO: CategoryMapper.findAll() でカテゴリ一覧を取得
        // TODO: モデルに "categories" という名前で追加
        // TODO: "categories" テンプレートを返す
        return null;
    }
    */
    
    /**
     * カテゴリ選択後の開始処理
     * 
     * TODO Phase 2: カテゴリIDをセッションに保存
     */
    /*
    @GetMapping("/start-category")
    public String startCategory(@RequestParam int categoryId,
                               @RequestParam String userName,
                               HttpSession session) {
        // TODO: セッションにcategoryIdを保存
        // TODO: セッションにuserNameを保存
        // TODO: 正解数を初期化
        // TODO: カテゴリ別の問題数を取得してセッションに保存
        // TODO: 最初の問題へリダイレクト
        return null;
    }
    */
    
    /**
     * カテゴリ別問題表示
     * 
     * TODO Phase 2: JOINを使った実装に変更
     */
    /*
    @GetMapping("/question-category")
    public String questionCategory(@RequestParam int no,
                                   HttpSession session,
                                   Model model) {
        // TODO: セッションからcategoryIdを取得
        // TODO: QuestionMapper.findByCategoryId() でカテゴリ別問題を取得
        // TODO: 指定された問題をモデルに追加
        // TODO: カテゴリ名も表示したい場合は CategoryMapper.findById() を使う
        return null;
    }
    */
    
    /**
     * カテゴリ別結果表示
     * 
     * TODO Phase 2: カテゴリ名も表示する
     */
    /*
    @GetMapping("/result-category")
    public String resultCategory(HttpSession session, Model model) {
        // TODO: セッションから結果を取得
        // TODO: セッションからcategoryIdを取得
        // TODO: CategoryMapper.findById() でカテゴリ名を取得
        // TODO: モデルに追加
        // TODO: セッションをクリア
        return null;
    }
    */
    
    // ========================================
    // Phase 3: 統計機能
    // ========================================
    
    /**
     * 統計画面表示
     * 
     * Phase 3: ここに統計機能を実装してください
     * ヒント:
     * - 問題別正解率を表示
     * - カテゴリ別正解率を表示
     * - GROUP BYとJOINを使った集計クエリが必要
     */
    
    /**
     * 結果保存
     * 
     * Phase 3: ここに結果保存機能を実装してください
     * ヒント:
     * - quiz_resultsテーブルを作成
     * - 回答処理で結果を保存
     * - 後で統計を取れるようにする
     */
}