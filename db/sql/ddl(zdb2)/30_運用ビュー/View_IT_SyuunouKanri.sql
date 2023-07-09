CREATE VIEW IT_SyuunouKanri AS SELECT
     syuudaikocd ,         /* 収納代行社コード */
     hurikaeymd ,         /* 振替日 */
     bankcd ,         /* 銀行コード */
     annaikensuu ,         /* 案内件数 */
     annaigk ,         /* 案内金額 */
     annaigk$ ,         /* 案内金額(通貨型) */
     hurizumikensuu ,         /* 振替済件数 */
     hurizumigk ,         /* 振替済金額 */
     hurizumigk$ ,         /* 振替済金額(通貨型) */
     hurihunokensuu ,         /* 振替不能件数 */
     hurihunogk ,         /* 振替不能金額 */
     hurihunogk$ ,         /* 振替不能金額(通貨型) */
     syuunousyoriymd ,         /* 収納処理日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_SyuunouKanri_Z;