CREATE TABLE HT_JigyouIkkatuNyuukin (
     daimosno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 代表申込番号                                        */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     soukinymd                                          VARCHAR     (8)                                                                 ,  /* 送金日                                           */
     soukincd                                           VARCHAR     (10)                                                                ,  /* 送金コード                                         */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額                                          */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型)                                     */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日                                           */
     rssyouno                                           VARCHAR     (20)                                                                ,  /* 領収証番号                                         */
     zenhnknkbn                                         VARCHAR     (1)                                                                 ,  /* 全額返金区分                                        */
     srgonyknumu                                        VARCHAR     (1)                                                                 ,  /* 成立後入金有無                                       */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月                                          */
     krkno                                              NUMBER      (5)                                                                 ,  /* 仮受番号                                          */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード                                         */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_JigyouIkkatuNyuukin ADD CONSTRAINT PK_JigyouIkkatuNyuukin PRIMARY KEY (
     daimosno                                                 , /* 代表申込番号                                         */
     renno                                                      /* 連番                                             */
) ;
