CREATE TABLE JM_SiTyouhyoumsg (
     bunrui1                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 分類１                                           */
     bunrui2                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 分類２                                           */
     tyouhyoulineno                                     NUMBER      (3)                                                       NOT NULL  ,  /* 帳票行番号                                         */
     setteikasyo                                        VARCHAR     (50)                                                                ,  /* 設定箇所                                          */
     tyouhyoumsg                                        VARCHAR     (60)                                                                ,  /* 帳票メッセージ                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JM_SiTyouhyoumsg ADD CONSTRAINT PK_SiTyouhyoumsg PRIMARY KEY (
     bunrui1                                                  , /* 分類１                                            */
     bunrui2                                                  , /* 分類２                                            */
     tyouhyoulineno                                             /* 帳票行番号                                          */
) ;
