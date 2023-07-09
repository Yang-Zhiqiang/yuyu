CREATE TABLE AS_FileServerInfo_Z (
     setteiNo                                           DECIMAL     (5)                                                       NOT NULL  ,  /* 設定番号 */
     tekiyouYmdFrom                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 適用年月日（自） */
     setteiNm                                           VARCHAR     (202)                                                               ,  /* 設定名 */
     setuzokusakiDomain                                 VARCHAR     (100)                                                               ,  /* 接続先ドメイン */
     setuzokusakiIpAddress                              VARCHAR     (15)                                                                ,  /* 接続先ＩＰアドレス */
     setuzokusakiPortNo                                 VARCHAR     (5)                                                                 ,  /* 接続先ポート番号 */
     setuzokuUser                                       VARCHAR     (100)                                                               ,  /* 接続ユーザー */
     setuzokuPassword                                   VARCHAR     (128)                                                               ,  /* 接続先パスワード */
     angoukaKbn                                         VARCHAR     (1)                                                                 ,  /* 暗号化区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_FileServerInfo_Z ADD CONSTRAINT AS_FileServerInfoPk PRIMARY KEY (
     setteiNo                                                 , /* 設定番号 */
     tekiyouYmdFrom                                             /* 適用年月日（自） */
) ;
