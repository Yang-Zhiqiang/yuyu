CREATE TABLE BM_FundIndexCfGaku (
     unitfundkbn                                        VARCHAR     (3)                                                       NOT NULL  ,  /* ユニットファンド区分                                    */
     fundhyoukaymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* ファンド評価年月日　　　　                                 */
     segkey                                             VARCHAR     (1)                                                       NOT NULL  ,  /* ＳＥＧＫＥＹ　　　　　　　　                                */
     cfgaku                                             NUMBER      (13)                                                                ,  /* ＣＦ額                                           */
     cfgaku$                                            VARCHAR     (10)                                                                ,  /* ＣＦ額(通貨型)                                      */
     gkcfgaku                                           NUMBER      (13)                                                                ,  /* （外貨）ＣＦ額                                       */
     gkcfgaku$                                          VARCHAR     (10)                                                                ,  /* （外貨）ＣＦ額(通貨型)                                  */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_FundIndexCfGaku ADD CONSTRAINT PK_FundIndexCfGaku PRIMARY KEY (
     unitfundkbn                                              , /* ユニットファンド区分                                     */
     fundhyoukaymd                                            , /* ファンド評価年月日　　　　                                  */
     segkey                                                     /* ＳＥＧＫＥＹ　　　　　　　　                                 */
) ;
