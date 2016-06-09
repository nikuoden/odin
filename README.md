# 作りかけCMS
---

# 仕様
左側にマークダウンで記述して右側にHTML表示で記事作成できる。
写真とかカテゴリとか細かいところはまだです。
ポートは8009にデフォルト設定してあります。

# 使った技術系

Spring・javaのお勉強プロジェクトです。
去年作ったのでライブラリのバージョンが古いので更新予定

 * Spring Boot 1.2.3
 * Spring Web
 * Spring Security
 * Spring Data JPA(実装はhibernate)
 * Mysql

## 動かし方
xaamp入れてmysql起動してodinってDB作って
/odin/src/main/java/com/odin/Application.java
こいつを実行すれば後は勝手に組み込みtomcatが起動して
JPAがテーブル自動生成します。
