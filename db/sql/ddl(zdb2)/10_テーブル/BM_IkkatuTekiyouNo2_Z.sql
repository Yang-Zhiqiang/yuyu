CREATE TABLE BM_IkkatuTekiyouNo2_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     yoteiriritu                                        DECIMAL     (5,4)                                                     NOT NULL  ,  /* 予定利率 */
     ikttekiyoubr1                                      VARCHAR     (6)                                                       NOT NULL  ,  /* 一括払適用分類１ */
     ikttekiyoubr2                                      VARCHAR     (6)                                                       NOT NULL  ,  /* 一括払適用分類２ */
     ikttekiyoubr3                                      VARCHAR     (6)                                                       NOT NULL  ,  /* 一括払適用分類３ */
     ikttekiyouno                                       DECIMAL     (9)                                                                 ,  /* 一括払適用番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_IkkatuTekiyouNo2_Z ADD CONSTRAINT PK_IkkatuTekiyouNo2 PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     ryouritusdno                                             , /* 料率世代番号 */
     yoteiriritu                                              , /* 予定利率 */
     ikttekiyoubr1                                            , /* 一括払適用分類１ */
     ikttekiyoubr2                                            , /* 一括払適用分類２ */
     ikttekiyoubr3                                              /* 一括払適用分類３ */
) ;
