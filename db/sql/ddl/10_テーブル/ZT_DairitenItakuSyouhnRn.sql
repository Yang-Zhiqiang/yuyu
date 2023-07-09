CREATE TABLE ZT_DairitenItakuSyouhnRn (
     zrndairitencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード */
     zrndrtsyouhinsikibetukbnstr                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）代理店商品識別区分（文字列） */
     zrndrthrkhouhoukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）代理店払込方法区分 */
     zrndrtplannmkbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）代理店プラン名区分 */
     zrnitakuhknhnbkaisiymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）委託保険販売開始年月日 */
     zrnitakuhknhnbsyuuryouymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）委託保険販売終了年月日 */
     zrnyobiv22                                         CHAR        (22)                                                      NOT NULL     /* （連携用）予備項目Ｖ２２ */
)
;

ALTER TABLE ZT_DairitenItakuSyouhnRn ADD CONSTRAINT PK_DairitenItakuSyouhnRn PRIMARY KEY (
     zrndairitencd                                            , /* （連携用）代理店コード */
     zrndrtsyouhinsikibetukbnstr                              , /* （連携用）代理店商品識別区分（文字列） */
     zrndrthrkhouhoukbn                                       , /* （連携用）代理店払込方法区分 */
     zrndrtplannmkbn                                          , /* （連携用）代理店プラン名区分 */
     zrnitakuhknhnbkaisiymd                                     /* （連携用）委託保険販売開始年月日 */
) ;
