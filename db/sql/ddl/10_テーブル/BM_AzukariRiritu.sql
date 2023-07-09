CREATE TABLE BM_AzukariRiritu (
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     tkyfromymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* 適用日自 */
     tkytoymd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 適用日至 */
     azukaririritu                                      NUMBER      (12,10)                                                             ,  /* 預り利率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_AzukariRiritu ADD CONSTRAINT PK_AzukariRiritu PRIMARY KEY (
     tuukasyu                                                 , /* 通貨種類 */
     tkyfromymd                                               , /* 適用日自 */
     tkytoymd                                                   /* 適用日至 */
) ;
