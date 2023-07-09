CREATE VIEW BM_Syoubyou AS SELECT
     syoubyoucd ,         /* 傷病コード */
     syoubyounm ,         /* 傷病名 */
     syoubyoucdtyuubunruikbn ,         /* 傷病コード中分類区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Syoubyou_Z;