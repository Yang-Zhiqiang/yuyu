CREATE VIEW JT_AksrendouzumiSyoruiImg AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     imageid ,         /* イメージID */
     syoruiimagepagecnt ,         /* 書類イメージページ数 */
     syoruiCd ,         /* 書類コード */
     aksrendoupdffilenm ,         /* ＡＫＳ連動用ＰＤＦファイル名 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_AksrendouzumiSyoruiImg_Z;