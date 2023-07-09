CREATE TABLE JM_Syujyutu (
     syujyututourokuno                                  VARCHAR     (9)                                                       NOT NULL  ,  /* 手術登録番号                                        */
     kjcd1                                              VARCHAR     (32)                                                                ,  /* Ｋ・Ｊコード１                                       */
     kjcd2                                              VARCHAR     (32)                                                                ,  /* Ｋ・Ｊコード２                                       */
     kjcd3                                              VARCHAR     (32)                                                                ,  /* Ｋ・Ｊコード３                                       */
     syujyutunmkn                                       VARCHAR     (320)                                                               ,  /* 手術名（カナ）                                       */
     syujyutunmkj                                       VARCHAR     (320)                                                               ,  /* 手術名（漢字）                                       */
     jyouken                                            VARCHAR     (50)                                                                ,  /* 条件                                            */
     syujyutubunruicd                                   VARCHAR     (3)                                                                 ,  /* 手術分類コード                                       */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JM_Syujyutu ADD CONSTRAINT PK_Syujyutu PRIMARY KEY (
     syujyututourokuno                                          /* 手術登録番号                                         */
) ;
