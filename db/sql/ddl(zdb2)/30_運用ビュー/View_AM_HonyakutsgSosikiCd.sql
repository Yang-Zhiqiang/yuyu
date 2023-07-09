CREATE VIEW AM_HonyakutsgSosikiCd AS SELECT
     sosikicd ,         /* 組織コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_HonyakutsgSosikiCd_Z;