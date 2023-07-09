CREATE TABLE AS_Sakujyotaisyo (
     sakujyoTableId                                     varchar     (100)                                                     NOT NULL  ,  /* 削除対象テーブルID                                    */
     sakujyoKbn                                         decimal     (1)                                                                 ,  /* 削除区分                                          */
     sakujyoKey                                         varchar     (30)                                                                ,  /* 削除キー                                          */
     sakujyoKeyKbn                                      decimal     (1)                                                                 ,  /* 削除キー区分                                        */
     hozonKikan                                         decimal     (2)                                                                 ,  /* 保存期間                                          */
     nengappiKbn                                        decimal     (1)                                                                 ,  /* 年月日区分                                         */
     dataTaihiKbn                                       decimal     (1)                                                                 ,  /* データ退避区分                                       */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_Sakujyotaisyo ADD CONSTRAINT AS_SakujyotaisyoPk PRIMARY KEY (
     sakujyoTableId                                             /* 削除対象テーブルID                                     */
) ;
