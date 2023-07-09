CREATE TABLE AS_FileServerInfo (
     setteiNo                                           decimal     (5)                                                       NOT NULL  ,  /* 設定番号                                          */
     tekiyouYmdFrom                                     varchar     (8)                                                       NOT NULL  ,  /* 適用年月日（自）                                      */
     setteiNm                                           varchar     (100)                                                               ,  /* 設定名                                           */
     setuzokusakiDomain                                 varchar     (100)                                                               ,  /* 接続先ドメイン                                       */
     setuzokusakiIpAddress                              varchar     (15)                                                                ,  /* 接続先IPアドレス                                     */
     setuzokusakiPortNo                                 varchar     (5)                                                                 ,  /* 接続先ポート番号                                      */
     setuzokuUser                                       varchar     (100)                                                               ,  /* 接続ユーザー                                        */
     setuzokuPassword                                   varchar     (128)                                                               ,  /* 接続先パスワード                                      */
     angoukaKbn                                         decimal     (1)                                                                 ,  /* 暗号化区分                                         */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_FileServerInfo ADD CONSTRAINT AS_FileServerInfoPk PRIMARY KEY (
     setteiNo                                                 , /* 設定番号                                           */
     tekiyouYmdFrom                                             /* 適用年月日（自）                                       */
) ;
