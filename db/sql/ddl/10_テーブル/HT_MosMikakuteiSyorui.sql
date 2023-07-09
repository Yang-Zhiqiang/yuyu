CREATE TABLE HT_MosMikakuteiSyorui (
     documentid                                         VARCHAR     (24)                                                      NOT NULL  ,  /* ドキュメントＩＤ */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_MosMikakuteiSyorui ADD CONSTRAINT PK_MosMikakuteiSyorui PRIMARY KEY (
     documentid                                                 /* ドキュメントＩＤ */
) ;

CREATE INDEX IX1_MosMikakuteiSyorui ON HT_MosMikakuteiSyorui (
     mosno                                                      /* 申込番号 */
) ;
