CREATE TABLE AS_Category (
     categoryId                                         VARCHAR     (50)                                                      NOT NULL  ,  /* カテゴリＩＤ                                        */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ                                      */
     categoryNm                                         VARCHAR     (30)                                                                ,  /* カテゴリ名                                         */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号                                         */
     linkImage                                          VARCHAR     (100)                                                               ,  /* リンクイメージ                                       */
     titleStyle                                         VARCHAR     (30)                                                                ,  /* タイトルスタイル                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_Category ADD CONSTRAINT AS_CategoryPk PRIMARY KEY (
     categoryId                                                 /* カテゴリＩＤ                                         */
) ;
