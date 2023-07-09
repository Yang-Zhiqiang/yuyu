CREATE VIEW BM_FBSoukinListKanri AS SELECT
     syoricd ,         /* 処理コード */
     syorisosikicd ,         /* 処理組織コード */
     tantositucd ,         /* 担当室コード */
     fbmeisaisyoruicd ,         /* ＦＢ明細書類コード */
     gkfbmeisaisyoruicd ,         /* 外貨ＦＢ明細書類コード */
     fbgoukeisyoruicd ,         /* ＦＢ合計書類コード */
     gkfbgoukeisyoruicd ,         /* 外貨ＦＢ合計書類コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_FBSoukinListKanri_Z;