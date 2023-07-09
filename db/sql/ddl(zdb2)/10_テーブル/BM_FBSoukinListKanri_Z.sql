CREATE TABLE BM_FBSoukinListKanri_Z (
     syoricd                                            VARCHAR     (4)                                                       NOT NULL  ,  /* 処理コード */
     syorisosikicd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* 処理組織コード */
     tantositucd                                        VARCHAR     (3)                                                                 ,  /* 担当室コード */
     fbmeisaisyoruicd                                   VARCHAR     (5)                                                                 ,  /* ＦＢ明細書類コード */
     gkfbmeisaisyoruicd                                 VARCHAR     (5)                                                                 ,  /* 外貨ＦＢ明細書類コード */
     fbgoukeisyoruicd                                   VARCHAR     (5)                                                                 ,  /* ＦＢ合計書類コード */
     gkfbgoukeisyoruicd                                 VARCHAR     (5)                                                                 ,  /* 外貨ＦＢ合計書類コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_FBSoukinListKanri_Z ADD CONSTRAINT PK_FBSoukinListKanri PRIMARY KEY (
     syoricd                                                  , /* 処理コード */
     syorisosikicd                                              /* 処理組織コード */
) ;
