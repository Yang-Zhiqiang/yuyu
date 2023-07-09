CREATE VIEW BM_Syoritanto AS SELECT
     syoricd ,         /* 処理コード */
     tantocd ,         /* 担当コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Syoritanto_Z;