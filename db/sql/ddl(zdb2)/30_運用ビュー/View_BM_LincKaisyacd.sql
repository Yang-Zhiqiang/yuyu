CREATE VIEW BM_LincKaisyacd AS SELECT
     linckaisyacdnum ,         /* ＬＩＮＣ会社コード（数字） */
     linckaisyanm ,         /* ＬＩＮＣ会社名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_LincKaisyacd_Z;