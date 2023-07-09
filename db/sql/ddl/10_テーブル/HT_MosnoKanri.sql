CREATE TABLE HT_MosnoKanri (
     mosno8keta                                         VARCHAR     (8)                                                       NOT NULL  ,  /* 申込番号（８桁） */
     saibankahikbn                                      VARCHAR     (1)                                                                 ,  /* 採番可否区分 */
     mossykykyoteiymd                                   VARCHAR     (8)                                                                 ,  /* 申込消却予定日 */
     saibanymd                                          VARCHAR     (8)                                                                 ,  /* 採番日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_MosnoKanri ADD CONSTRAINT PK_MosnoKanri PRIMARY KEY (
     mosno8keta                                                 /* 申込番号（８桁） */
) ;

CREATE INDEX IX1_MosnoKanri ON HT_MosnoKanri (
     saibankahikbn                                            , /* 採番可否区分 */
     saibanymd                                                  /* 採番日 */
) ;

CREATE INDEX IX2_MosnoKanri ON HT_MosnoKanri (
     mossykykyoteiymd                                           /* 申込消却予定日 */
) ;

CREATE INDEX IX3_MosnoKanri ON HT_MosnoKanri (
     saibanymd                                                , /* 採番日 */
     mosno8keta                                               , /* 申込番号（８桁） */
     saibankahikbn                                              /* 採番可否区分 */
) ;
