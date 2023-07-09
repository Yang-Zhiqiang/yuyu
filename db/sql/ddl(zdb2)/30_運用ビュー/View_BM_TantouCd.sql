CREATE VIEW BM_TantouCd AS SELECT
     tantocd ,         /* 担当コード */
     busitucd ,         /* 部・室コード */
     tantounm ,         /* 担当名 */
     busitunm ,         /* 部・室名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_TantouCd_Z;