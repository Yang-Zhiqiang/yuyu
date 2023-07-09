CREATE TABLE AT_FileRirekiKanri (
     historyId                                          VARCHAR     (100)                                                     NOT NULL  ,  /* 履歴ＩＤ                                          */
     hozonHousiki                                       VARCHAR     (20)                                                      NOT NULL  ,  /* 保存方式                                          */
     hozonSaki                                          VARCHAR     (200)                                                               ,  /* 保存先                                           */
     namingPattern                                      VARCHAR     (100)                                                               ,  /* ネーミングパターン                                     */
     rirekiSakujyoJyouken                               VARCHAR     (200)                                                               ,  /* 履歴削除条件                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_FileRirekiKanri ADD CONSTRAINT AT_FileRirekiKanriPk PRIMARY KEY (
     historyId                                                  /* 履歴ＩＤ                                           */
) ;
