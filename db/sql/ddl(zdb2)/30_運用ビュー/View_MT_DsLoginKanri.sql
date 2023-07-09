CREATE VIEW MT_DsLoginKanri AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     syokailoginymd ,         /* 初回ログイン年月日 */
     syokailogintime ,         /* 初回ログイン時刻 */
     syokailoginbaitaikbn ,         /* 初回ログイン媒体区分 */
     saisinloginymd ,         /* 最新ログイン年月日 */
     saisinlogintime ,         /* 最新ログイン時刻 */
     saisinloginbaitaikbn ,         /* 最新ログイン媒体区分 */
     dshnnkakcderrorkaisuu ,         /* ＤＳ本人確認コードエラー回数 */
     dskokyakunmerrorkaisuu ,         /* ＤＳ顧客名エラー回数 */
     dskokyakuseiymderrorkaisuu ,         /* ＤＳ顧客生年月日エラー回数 */
     dskokyakutelnoerrorkaisuu ,         /* ＤＳ顧客電話番号エラー回数 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsLoginKanri_Z;