CREATE VIEW JT_SibouSateiChkInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     bengosikenkaiumukbn ,         /* 弁護士見解有無区分 */
     kujyouumukbn ,         /* 苦情有無区分 */
     jimumissumukbn ,         /* 事務ミス有無区分 */
     kyhgksitukaisouyouhikbn ,         /* 給付金室回送要否区分 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SibouSateiChkInfo_Z;