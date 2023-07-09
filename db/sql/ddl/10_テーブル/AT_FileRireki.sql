CREATE TABLE AT_FileRireki (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ                                        */
     historyId                                          VARCHAR     (100)                                                     NOT NULL  ,  /* 履歴ＩＤ                                          */
     fileNm                                             VARCHAR     (100)                                                     NOT NULL  ,  /* ファイル名                                         */
     fileSize                                           NUMBER      (12)                                                      NOT NULL  ,  /* ファイルサイズ                                       */
     fileContents                                       BLOB                                                                            ,  /* ファイル内容                                        */
     tourokuTime                                        VARCHAR     (17)                                                      NOT NULL  ,  /* 登録時間                                          */
     fileNmSuffix                                       NUMBER      (9)                                                       NOT NULL  ,  /* ファイル名サフィックス                                   */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_FileRireki ADD CONSTRAINT AT_FileRirekiPk PRIMARY KEY (
     uniqueId                                                 , /* ユニークＩＤ                                         */
     historyId                                                , /* 履歴ＩＤ                                           */
     tourokuTime                                              , /* 登録時間                                           */
     fileNmSuffix                                               /* ファイル名サフィックス                                    */
) ;
