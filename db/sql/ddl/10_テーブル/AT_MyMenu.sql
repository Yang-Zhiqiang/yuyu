CREATE TABLE AT_MyMenu (
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ                                        */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     categoryId                                         VARCHAR     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_MyMenu ADD CONSTRAINT AT_MyMenuPk PRIMARY KEY (
     userId                                                   , /* ユーザーＩＤ                                         */
     kinouId                                                    /* 機能ＩＤ                                           */
) ;
