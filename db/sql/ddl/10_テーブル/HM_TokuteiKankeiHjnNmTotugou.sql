CREATE TABLE HM_TokuteiKankeiHjnNmTotugou (
     tkhjnkinyuucd                                      VARCHAR     (4)                                                       NOT NULL  ,  /* 特定関係法人金融機関コード                                 */
     meisaino                                           NUMBER      (5)                                                       NOT NULL  ,  /* 明細番号                                          */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     totugoutkhjnnmkj                                   VARCHAR     (500)                                                               ,  /* 突合用特定関係法人名（漢字）                                */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HM_TokuteiKankeiHjnNmTotugou ADD CONSTRAINT PK_TokuteiKankeiHjnNmTotugou PRIMARY KEY (
     tkhjnkinyuucd                                            , /* 特定関係法人金融機関コード                                  */
     meisaino                                                 , /* 明細番号                                           */
     renno                                                      /* 連番                                             */
) ;
