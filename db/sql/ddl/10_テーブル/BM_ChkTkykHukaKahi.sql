CREATE TABLE BM_ChkTkykHukaKahi (
     tksyouhncd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* 特約商品コード                                       */
     syusyouhncd                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 主契約商品コード                                      */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自                                  */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至                                  */
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード                                       */
     hukakahikbn                                        NUMBER      (2)                                                                 ,  /* 付加可否区分                                        */
     tkbairituhugou                                     VARCHAR     (2)                                                                 ,  /* 特約倍率符号                                        */
     tkbairitu                                          NUMBER      (8,5)                                                               ,  /* 特約倍率                                          */
     tkhukahissuumu                                     VARCHAR     (1)                                                                 ,  /* 特約付加必須有無                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkTkykHukaKahi ADD CONSTRAINT PK_ChkTkykHukaKahi PRIMARY KEY (
     tksyouhncd                                               , /* 特約商品コード                                        */
     syusyouhncd                                              , /* 主契約商品コード                                       */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自                                   */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至                                   */
     channelcd                                                  /* チャネルコード                                        */
) ;
