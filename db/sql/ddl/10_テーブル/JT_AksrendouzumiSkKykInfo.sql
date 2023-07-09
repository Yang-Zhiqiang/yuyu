CREATE TABLE JT_AksrendouzumiSkKykInfo (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuusyubetu                                     VARCHAR     (2)                                                                 ,  /* 請求種別                                          */
     shrkekkakbn                                        VARCHAR     (1)                                                                 ,  /* 支払結果区分                                        */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日                                         */
     sibouymd                                           VARCHAR     (8)                                                                 ,  /* 死亡日                                           */
     geninkbn                                           VARCHAR     (2)                                                                 ,  /* 原因区分                                          */
     syoruiimagerendousuu                               NUMBER      (5)                                                                 ,  /* 書類イメージ連動数                                     */
     ankenimgjygntyoukahyj                              VARCHAR     (1)                                                                 ,  /* 案件イメージ上限数超過表示                                 */
     tiffhenkankekkakbn                                 VARCHAR     (1)                                                                 ,  /* ＴＩＦＦ変換結果区分                                    */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_AksrendouzumiSkKykInfo ADD CONSTRAINT PK_AksrendouzumiSkKykInfo PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                      /* 証券番号                                           */
) ;
