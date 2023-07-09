CREATE TABLE AS_Category (
     categoryId                                         varchar     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     subSystemId                                        varchar     (50)                                                                ,  /* サブシステムＩＤ                                      */
     categoryNm                                         varchar     (30)                                                                ,  /* カテゴリ名                                         */
     sortNo                                             decimal     (3)                                                                 ,  /* ソート番号                                         */
     linkImage                                          varchar     (100)                                                               ,  /* リンクイメージ                                       */
     titleStyle                                         varchar     (30)                                                                ,  /* タイトルスタイル                                      */
     menuHyoujiKahi                                     decimal     (1)                                                                 ,  /* メニュー表示可否                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_Category ADD CONSTRAINT AS_CategoryPk PRIMARY KEY (
     categoryId                                                 /* カテゴリＩＤ                                         */
) ;
