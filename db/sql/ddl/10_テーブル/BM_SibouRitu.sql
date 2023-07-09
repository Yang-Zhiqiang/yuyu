CREATE TABLE BM_SibouRitu (
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     seibetu                                            VARCHAR     (1)                                                       NOT NULL  ,  /* 性別 */
     nenrei                                             NUMBER      (3)                                                       NOT NULL  ,  /* 年齢 */
     sibouritu1                                         NUMBER      (12,10)                                                             ,  /* 死亡率１ */
     sibouritu2                                         NUMBER      (12,10)                                                             ,  /* 死亡率２ */
     kaiyakuritu1                                       NUMBER      (12,10)                                                             ,  /* 解約率１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_SibouRitu ADD CONSTRAINT PK_SibouRitu PRIMARY KEY (
     ryouritusdno                                             , /* 料率世代番号 */
     seibetu                                                  , /* 性別 */
     nenrei                                                     /* 年齢 */
) ;
