CREATE VIEW IT_TRAuthoriKekka AS SELECT
     syono ,         /* 証券番号 */
     syoriYmd ,         /* 処理年月日 */
     authorikktrrenno ,         /* オーソリ結果TR連番 */
     creditcardno1 ,         /* クレジットカード番号１ */
     creditcardno2 ,         /* クレジットカード番号２ */
     creditcardno3 ,         /* クレジットカード番号３ */
     creditcardno4 ,         /* クレジットカード番号４ */
     authorijkkbn ,         /* オーソリ状況区分 */
     authoritrkkbn ,         /* オーソリ登録区分 */
     authorigk ,         /* オーソリ金額 */
     authorigk$ ,         /* オーソリ金額(通貨型) */
     authorikanryoymd ,         /* オーソリ完了日 */
     syouninno ,         /* 承認番号 */
     tanmatusyorino ,         /* 端末処理通番 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_TRAuthoriKekka_Z;