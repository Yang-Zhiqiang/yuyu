CREATE TABLE HT_Houjyou (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     syosaikbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 初診再診区分                                        */
     sinsakbn                                           VARCHAR     (2)                                                                 ,  /* 診査区分                                          */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日                                           */
     sintyou                                            NUMBER      (3)                                                                 ,  /* 身長                                            */
     taijyuu                                            NUMBER      (3)                                                                 ,  /* 体重                                            */
     kituenkbn                                          VARCHAR     (1)                                                                 ,  /* 喫煙区分                                          */
     kituenhon                                          NUMBER      (2)                                                                 ,  /* 喫煙本数                                          */
     sinsaicd                                           VARCHAR     (12)                                                                ,  /* 診査医コード                                        */
     sinsaymd                                           VARCHAR     (8)                                                                 ,  /* 診査日                                           */
     sinsatime                                          VARCHAR     (2)                                                                 ,  /* 診査時刻                                          */
     takuoukbn                                          VARCHAR     (2)                                                                 ,  /* 宅診往診区分                                        */
     sinsabakbn                                         VARCHAR     (2)                                                                 ,  /* 診査場所区分                                        */
     hbcmnt                                             VARCHAR     (768)                                                               ,  /* 不備コメント                                        */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_Houjyou ADD CONSTRAINT PK_Houjyou PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     syosaikbn                                                  /* 初診再診区分                                         */
) ;
