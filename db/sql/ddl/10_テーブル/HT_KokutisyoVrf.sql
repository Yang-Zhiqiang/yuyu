CREATE TABLE HT_KokutisyoVrf (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日                                           */
     sintyou                                            NUMBER      (3)                                                                 ,  /* 身長                                            */
     taijyuu                                            NUMBER      (3)                                                                 ,  /* 体重                                            */
     kituenkbn                                          VARCHAR     (1)                                                                 ,  /* 喫煙区分                                          */
     kituenhon                                          NUMBER      (2)                                                                 ,  /* 喫煙本数                                          */
     kijikbn                                            VARCHAR     (1)                                                                 ,  /* 記事区分                                          */
     kzkkijikbn                                         VARCHAR     (1)                                                                 ,  /* 家族記事区分                                        */
     hbcmnt                                             VARCHAR     (768)                                                               ,  /* 不備コメント                                        */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_KokutisyoVrf ADD CONSTRAINT PK_KokutisyoVrf PRIMARY KEY (
     mosno                                                      /* 申込番号                                           */
) ;
