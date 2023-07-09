CREATE VIEW JT_SateiMeigihenkouInfo AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     meihenyuukoumukoukbn ,         /* 名義変更有効無効区分 */
     meihenuktkbn ,         /* 名義変更受取人区分 */
     meihenuktnm ,         /* 名義変更受取人名 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SateiMeigihenkouInfo_Z;