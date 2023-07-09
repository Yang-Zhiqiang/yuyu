CREATE TABLE AS_SubSystem (
     subSystemId                                        varchar     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     subSystemNm                                        varchar     (50)                                                                ,  /* サブシステム名                                       */
     sortNo                                             decimal     (3)                                                                 ,  /* ソート番号                                         */
     linkImage                                          varchar     (100)                                                               ,  /* リンクイメージ                                       */
     hyoudaiImage                                       varchar     (100)                                                               ,  /* 表題イメージ                                        */
     menuHyoujiKahi                                     decimal     (1)                                                                 ,  /* メニュー表示可否                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_SubSystem ADD CONSTRAINT AS_SubSystemPk PRIMARY KEY (
     subSystemId                                                /* サブシステムＩＤ                                       */
) ;
