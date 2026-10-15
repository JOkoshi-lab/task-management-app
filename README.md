# タスク管理システム

タスクの一覧表示や登録、期限の管理、完了状態の変更を扱うWebアプリケーションです。CRUD操作とデータベース連携を中心に整理しています。

## 使用技術
Java / Spring Boot / Thymeleaf / Spring JDBC / H2 Database

## 起動方法（Windows）

プロジェクトフォルダをPowerShellで開き、次のコマンドを実行してください。

```powershell
.\mvnw.cmd spring-boot:run
```

アプリのアクセス先：http://localhost:8080/tasklist

データベースを使用する作品は、起動時にH2のインメモリデータベースを初期化します。再起動すると、登録内容は初期状態に戻ります。