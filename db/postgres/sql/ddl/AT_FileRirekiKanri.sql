CREATE TABLE AT_FileRirekiKanri (
     historyId                                          varchar     (100)                                                     NOT NULL  ,  /* 履歴ID                                          */
     hozonHousiki                                       decimal     (20)                                                      NOT NULL  ,  /* 保存方式                                          */
     hozonSaki                                          varchar     (100)                                                               ,  /* 保存先                                           */
     namingPattern                                      varchar     (100)                                                               ,  /* ネイミングパターン                                     */
     rirekiSakujyoJyouken                               varchar     (200)                                                               ,  /* 履歴削除条件                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_FileRirekiKanri ADD CONSTRAINT AT_FileRirekiKanriPk PRIMARY KEY (
     historyId                                                  /* 履歴ID                                           */
) ;
