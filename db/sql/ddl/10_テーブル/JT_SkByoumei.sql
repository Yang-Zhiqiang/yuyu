CREATE TABLE JT_SkByoumei (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     uketukeno                                          NUMBER      (2)                                                       NOT NULL  ,  /* 受付番号                                          */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     byoumeitourokuno                                   VARCHAR     (6)                                                                 ,  /* 病名登録番号                                        */
     byoumeikn                                          VARCHAR     (60)                                                                ,  /* 病名（カナ）                                        */
     byoumeikj                                          VARCHAR     (100)                                                               ,  /* 病名（漢字）                                        */
     gankbn                                             VARCHAR     (1)                                                                 ,  /* がん区分                                          */
     sandaisippeikbn                                    VARCHAR     (1)                                                                 ,  /* ３大疾病区分                                        */
     nanadaisippeikbn                                   VARCHAR     (1)                                                                 ,  /* ７大疾病区分                                        */
     kansensyoukbn                                      VARCHAR     (1)                                                                 ,  /* 感染症区分                                         */
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

ALTER TABLE JT_SkByoumei ADD CONSTRAINT PK_SkByoumei PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                          , /* 請求履歴番号                                         */
     uketukeno                                                , /* 受付番号                                           */
     renno                                                      /* 連番                                             */
) ;
