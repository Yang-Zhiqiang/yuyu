CREATE TABLE HT_HubiMsg_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     messageId                                          VARCHAR     (7)                                                                 ,  /* メッセージＩＤ */
     hubimsg                                            VARCHAR     (302)                                                               ,  /* 不備メッセージ */
     hubisyubetukbn                                     VARCHAR     (1)                                                                 ,  /* 不備種別区分 */
     hubisyubetusyousaikbn                              VARCHAR     (2)                                                                 ,  /* 不備種別詳細区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hituyousyoruicd                                    VARCHAR     (5)                                                                    /* 必要書類コード */
)
;

ALTER TABLE HT_HubiMsg_Z ADD CONSTRAINT PK_HubiMsg PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;
