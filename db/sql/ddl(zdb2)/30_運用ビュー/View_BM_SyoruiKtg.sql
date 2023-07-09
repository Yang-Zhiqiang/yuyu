CREATE VIEW BM_SyoruiKtg AS SELECT
     syoruiCd ,         /* 書類コード */
     ktgsyoruicd ,         /* 結合対象書類コード */
     sortNo ,         /* ソート番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SyoruiKtg_Z;