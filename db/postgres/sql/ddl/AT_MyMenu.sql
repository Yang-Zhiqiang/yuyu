CREATE TABLE AT_MyMenu (
     userId                                             varchar     (30)                                                      NOT NULL  ,  /* ユーザーID                                        */
     subSystemId                                        varchar     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     categoryId                                         varchar     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_MyMenu ADD CONSTRAINT AT_MyMenuPk PRIMARY KEY (
     userId                                                   , /* ユーザーID                                         */
     kinouId                                                    /* 機能ＩＤ                                           */
) ;
