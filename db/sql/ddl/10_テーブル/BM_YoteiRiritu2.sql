CREATE TABLE BM_YoteiRiritu2 (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     yoteiriritutkybr1                                  VARCHAR     (3)                                                       NOT NULL  ,  /* 予定利率適用分類１ */
     yoteiriritutkybr2                                  VARCHAR     (3)                                                       NOT NULL  ,  /* 予定利率適用分類２ */
     kijyunfromymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 基準日自 */
     kijyuntoymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 基準日至 */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     yoteiriritu                                        NUMBER      (5,4)                                                               ,  /* 予定利率 */
     tumitateriritu                                     NUMBER      (5,4)                                                               ,  /* 積立利率 */
     tmttknzoukaritujygn                                NUMBER      (5,4)                                                               ,  /* 積立金増加率上限 */
     setteibairitu                                      NUMBER      (3,2)                                                               ,  /* 設定倍率 */
     loadinghnkgtumitateriritu                          NUMBER      (5,4)                                                               ,  /* ローディング変更後積立利率 */
     rendouritu                                         NUMBER      (5,4)                                                               ,  /* 連動率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_YoteiRiritu2 ADD CONSTRAINT PK_YoteiRiritu2 PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     yoteiriritutkybr1                                        , /* 予定利率適用分類１ */
     yoteiriritutkybr2                                        , /* 予定利率適用分類２ */
     kijyunfromymd                                            , /* 基準日自 */
     kijyuntoymd                                                /* 基準日至 */
) ;

CREATE INDEX IX1_YoteiRiritu2 ON BM_YoteiRiritu2 (
     tuukasyu                                                   /* 通貨種類 */
) ;
