CREATE TABLE AT_FileHozon (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ                                        */
     fileContents                                       BLOB                                                                            ,  /* ファイル内容                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_FileHozon ADD CONSTRAINT AT_FileHozonPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ                                         */
) ;
