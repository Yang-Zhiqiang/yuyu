CREATE TABLE AT_FileHozon (
     uniqueId                                           varchar     (100)                                                     NOT NULL  ,  /* ユニークID                                        */
     fileContents                                       bytea                                                                           ,  /* ファイル内容                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_FileHozon ADD CONSTRAINT AT_FileHozonPk PRIMARY KEY (
     uniqueId                                                   /* ユニークID                                         */
) ;
