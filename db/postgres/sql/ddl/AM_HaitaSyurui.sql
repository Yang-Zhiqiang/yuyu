CREATE TABLE AM_HaitaSyurui (
     haitaSyuruiCd                                      varchar     (20)                                                      NOT NULL  ,  /* 排他種類コード                                       */
     haitaSyuruiNm                                      varchar     (30)                                                                ,  /* 排他種類名                                         */
     haitaKeyKousei                                     varchar     (50)                                                                ,  /* 排他キー構成                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AM_HaitaSyurui ADD CONSTRAINT AM_HaitaSyuruiPk PRIMARY KEY (
     haitaSyuruiCd                                              /* 排他種類コード                                        */
) ;
