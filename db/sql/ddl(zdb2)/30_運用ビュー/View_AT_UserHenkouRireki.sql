CREATE VIEW AT_UserHenkouRireki AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     userId ,         /* ユーザーＩＤ */
     rirekiSyuruiKbn ,         /* 履歴種類区分 */
     userNm ,         /* ユーザー名 */
     specialUserKbn ,         /* 特別ユーザー区分 */
     password ,         /* パスワード */
     passwordSetteiYmd ,         /* パスワード設定年月日 */
     passwordYuukouKigenYmd ,         /* パスワード有効期限年月日 */
     passwordYuukouCountY ,         /* パスワード有効年数 */
     passwordYuukouCountM ,         /* パスワード有効月数 */
     passwordYuukouCountD ,         /* パスワード有効日数 */
     passwordYuukouKikanKbn ,         /* パスワード有効期間区分 */
     passwordHenkouKyokaKbn ,         /* パスワード変更許可区分 */
     passwordHenkouYoukyuuKbn ,         /* パスワード変更要求区分 */
     loginKyokaKbn ,         /* ログイン許可区分 */
     loginErrorCount ,         /* ログインエラー回数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_UserHenkouRireki_Z;