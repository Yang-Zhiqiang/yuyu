CREATE TABLE JT_SateiJyuukasituChkInfo (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     juukasitucheckkbn1                                 VARCHAR     (1)                                                                 ,  /* 重過失チェック区分１                                    */
     juukasitucheckcomment1                             VARCHAR     (32)                                                                ,  /* 重過失チェックコメント１                                  */
     juukasitucheckkbn2                                 VARCHAR     (1)                                                                 ,  /* 重過失チェック区分２                                    */
     juukasitucheckcomment2                             VARCHAR     (32)                                                                ,  /* 重過失チェックコメント２                                  */
     juukasitucheckkbn3                                 VARCHAR     (1)                                                                 ,  /* 重過失チェック区分３                                    */
     juukasitucheckcomment3                             VARCHAR     (32)                                                                ,  /* 重過失チェックコメント３                                  */
     juukasitucheckkbn4                                 VARCHAR     (1)                                                                 ,  /* 重過失チェック区分４                                    */
     juukasitucheckcomment4                             VARCHAR     (32)                                                                ,  /* 重過失チェックコメント４                                  */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_SateiJyuukasituChkInfo ADD CONSTRAINT PK_SateiJyuukasituChkInfo PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                            /* 請求履歴番号                                         */
) ;
