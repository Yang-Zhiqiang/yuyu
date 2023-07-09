CREATE TABLE BM_SjkkkTyouseiyouRiritu2 (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     sjkkktyouseiriritutkybr1                           VARCHAR     (3)                                                       NOT NULL  ,  /* 市場価格調整用利率適用分類１ */
     sjkkktyouseiriritutkybr2                           VARCHAR     (3)                                                       NOT NULL  ,  /* 市場価格調整用利率適用分類２ */
     kijyunfromymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 基準日自 */
     kijyuntoymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 基準日至 */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     sjkkktyouseiyouriritu                              NUMBER      (5,4)                                                               ,  /* 市場価格調整用利率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_SjkkkTyouseiyouRiritu2 ADD CONSTRAINT PK_SjkkkTyouseiyouRiritu2 PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     sjkkktyouseiriritutkybr1                                 , /* 市場価格調整用利率適用分類１ */
     sjkkktyouseiriritutkybr2                                 , /* 市場価格調整用利率適用分類２ */
     kijyunfromymd                                            , /* 基準日自 */
     kijyuntoymd                                                /* 基準日至 */
) ;
