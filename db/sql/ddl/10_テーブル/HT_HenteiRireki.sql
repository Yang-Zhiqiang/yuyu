CREATE TABLE HT_HenteiRireki (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     henteiymd                                          VARCHAR     (8)                                                                 ,  /* 変更訂正日                                         */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_HenteiRireki ADD CONSTRAINT PK_HenteiRireki PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     renno                                                      /* 連番                                             */
) ;
