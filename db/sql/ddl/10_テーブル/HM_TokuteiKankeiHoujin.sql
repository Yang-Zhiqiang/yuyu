CREATE TABLE HM_TokuteiKankeiHoujin (
     tkhjnkinyuucd                                      VARCHAR     (4)                                                       NOT NULL  ,  /* 特定関係法人金融機関コード                                 */
     meisaino                                           NUMBER      (5)                                                       NOT NULL  ,  /* 明細番号                                          */
     marukinhyouji                                      VARCHAR     (1)                                                                 ,  /* マル金表示                                         */
     tkhjnkjdrtennm                                     VARCHAR     (40)                                                                ,  /* 特定関係法人漢字代理店名                                  */
     dairitenbtno                                       NUMBER      (4)                                                                 ,  /* 代理店別通番                                        */
     tkhjnnmkj                                          VARCHAR     (100)                                                               ,  /* 特定関係法人名（漢字）                                   */
     tkhjnnmkn                                          VARCHAR     (100)                                                               ,  /* 特定関係法人名（カナ）                                   */
     kosymd                                             VARCHAR     (8)                                                                 ,  /* 更新日                                           */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HM_TokuteiKankeiHoujin ADD CONSTRAINT PK_TokuteiKankeiHoujin PRIMARY KEY (
     tkhjnkinyuucd                                            , /* 特定関係法人金融機関コード                                  */
     meisaino                                                   /* 明細番号                                           */
) ;
