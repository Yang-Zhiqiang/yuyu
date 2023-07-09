CREATE TABLE HT_SyouhnTokujyou_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                                 ,  /* 商品世代番号 */
     tknzkkbn                                           VARCHAR     (1)                                                                 ,  /* 特約除き区分 */
     tumahtnpkbn                                        VARCHAR     (1)                                                                 ,  /* 妻不担保区分 */
     kohtnpkbn                                          VARCHAR     (1)                                                                 ,  /* 子不担保区分 */
     seigens                                            DECIMAL     (9)                                                                 ,  /* 制限Ｓ */
     seigens$                                           VARCHAR     (10)                                                                ,  /* 制限Ｓ(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SyouhnTokujyou_Z ADD CONSTRAINT PK_SyouhnTokujyou PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     syouhncd                                                   /* 商品コード */
) ;
