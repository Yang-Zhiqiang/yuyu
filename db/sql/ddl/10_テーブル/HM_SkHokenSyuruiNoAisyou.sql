CREATE TABLE HM_SkHokenSyuruiNoAisyou (
     hknsyuruino                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 保険種類番号 */
     hknsyuruinosdfrom                                  NUMBER      (3)                                                       NOT NULL  ,  /* 保険種類番号世代自 */
     hknsyuruinosdto                                    NUMBER      (3)                                                       NOT NULL  ,  /* 保険種類番号世代至 */
     hknsyuruinobetukey1                                VARCHAR     (5)                                                       NOT NULL  ,  /* 保険種類番号別キー１ */
     aisyoumeichannelkbn                                VARCHAR     (2)                                                       NOT NULL  ,  /* 愛称名チャネル区分 */
     aisyoumeikbn                                       VARCHAR     (3)                                                                 ,  /* 愛称名区分 */
     aisyoumei                                          VARCHAR     (60)                                                                ,  /* 愛称名 */
     husyoudakumanualinfo                               VARCHAR     (50)                                                                ,  /* 不承諾手続きマニュアル情報 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HM_SkHokenSyuruiNoAisyou ADD CONSTRAINT PK_SkHokenSyuruiNoAisyou PRIMARY KEY (
     hknsyuruino                                              , /* 保険種類番号 */
     hknsyuruinosdfrom                                        , /* 保険種類番号世代自 */
     hknsyuruinosdto                                          , /* 保険種類番号世代至 */
     hknsyuruinobetukey1                                      , /* 保険種類番号別キー１ */
     aisyoumeichannelkbn                                        /* 愛称名チャネル区分 */
) ;
