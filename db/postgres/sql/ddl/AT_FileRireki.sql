CREATE TABLE AT_FileRireki (
     historyId                                          varchar     (100)                                                     NOT NULL  ,  /* 履歴ID                                          */
     fileNm                                             varchar     (100)                                                     NOT NULL  ,  /* ファイル名                                         */
     fileSize                                           decimal     (12)                                                      NOT NULL  ,  /* ファイルサイズ                                       */
     fileContents                                       bytea                                                                           ,  /* ファイル内容                                        */
     tourokuTime                                        varchar     (20)                                                      NOT NULL  ,  /* 登録時間                                          */
     fileNmSuffix                                       decimal     (9)                                                       NOT NULL  ,  /* ファイル名サフィックス                                   */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_FileRireki ADD CONSTRAINT AT_FileRirekiPk PRIMARY KEY (
     historyId                                                , /* 履歴ID                                           */
     fileNm                                                   , /* ファイル名                                          */
     tourokuTime                                              , /* 登録時間                                           */
     fileNmSuffix                                               /* ファイル名サフィックス                                    */
) ;
