CREATE TABLE AM_HaitaSyurui (
     haitaSyuruiCd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 排他種類コード                                       */
     haitaSyuruiNm                                      VARCHAR     (30)                                                                ,  /* 排他種類名                                         */
     haitaKeyKousei                                     VARCHAR     (50)                                                                ,  /* 排他キー構成                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AM_HaitaSyurui ADD CONSTRAINT AM_HaitaSyuruiPk PRIMARY KEY (
     haitaSyuruiCd                                              /* 排他種類コード                                        */
) ;
