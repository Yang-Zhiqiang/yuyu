CREATE VIEW BM_Syokugyou AS SELECT
     syokugyoucd ,         /* 職業コード */
     syokugyounm ,         /* 職業名 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Syokugyou_Z;