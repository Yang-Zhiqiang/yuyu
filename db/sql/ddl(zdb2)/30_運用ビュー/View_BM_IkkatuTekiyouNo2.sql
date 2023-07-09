CREATE VIEW BM_IkkatuTekiyouNo2 AS SELECT
     syouhncd ,         /* 商品コード */
     ryouritusdno ,         /* 料率世代番号 */
     yoteiriritu ,         /* 予定利率 */
     ikttekiyoubr1 ,         /* 一括払適用分類１ */
     ikttekiyoubr2 ,         /* 一括払適用分類２ */
     ikttekiyoubr3 ,         /* 一括払適用分類３ */
     ikttekiyouno ,         /* 一括払適用番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_IkkatuTekiyouNo2_Z;