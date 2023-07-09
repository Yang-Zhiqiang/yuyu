CREATE TABLE AT_KobetuInfo (
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ                                        */
     infoSeqNo                                          VARCHAR     (10)                                                      NOT NULL  ,  /* 情報連番                                          */
     hyoujiYmdFrom                                      VARCHAR     (8)                                                                 ,  /* 表示年月日（自）                                      */
     hyoujiYmdTo                                        VARCHAR     (8)                                                                 ,  /* 表示年月日（至）                                      */
     hyoujiNaiyou                                       VARCHAR     (200)                                                               ,  /* 表示内容                                          */
     infoSikibetuId                                     VARCHAR     (5)                                                                 ,  /* 情報識別ＩＤ                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_KobetuInfo ADD CONSTRAINT AT_KobetuInfoPk PRIMARY KEY (
     userId                                                   , /* ユーザーＩＤ                                         */
     infoSeqNo                                                  /* 情報連番                                           */
) ;
