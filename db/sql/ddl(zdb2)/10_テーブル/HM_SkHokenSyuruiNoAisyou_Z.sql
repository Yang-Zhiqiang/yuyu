CREATE TABLE HM_SkHokenSyuruiNoAisyou_Z (
     hknsyuruino                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 保険種類番号 */
     hknsyuruinosdfrom                                  DECIMAL     (3)                                                       NOT NULL  ,  /* 保険種類番号世代自 */
     hknsyuruinosdto                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 保険種類番号世代至 */
     hknsyuruinobetukey1                                VARCHAR     (5)                                                       NOT NULL  ,  /* 保険種類番号別キー１ */
     aisyoumeichannelkbn                                VARCHAR     (2)                                                       NOT NULL  ,  /* 愛称名チャネル区分 */
     aisyoumeikbn                                       VARCHAR     (3)                                                                 ,  /* 愛称名区分 */
     aisyoumei                                          VARCHAR     (122)                                                               ,  /* 愛称名 */
     husyoudakumanualinfo                               VARCHAR     (102)                                                               ,  /* 不承諾手続きマニュアル情報 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HM_SkHokenSyuruiNoAisyou_Z ADD CONSTRAINT PK_SkHokenSyuruiNoAisyou PRIMARY KEY (
     hknsyuruino                                              , /* 保険種類番号 */
     hknsyuruinosdfrom                                        , /* 保険種類番号世代自 */
     hknsyuruinosdto                                          , /* 保険種類番号世代至 */
     hknsyuruinobetukey1                                      , /* 保険種類番号別キー１ */
     aisyoumeichannelkbn                                        /* 愛称名チャネル区分 */
) ;
