CREATE TABLE ZT_DairitenBuntanInfoRn_Z (
     zrndairitencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード */
     zrndairitensyouhincd                               CHAR        (5)                                                       NOT NULL  ,  /* （連携用）代理店商品コード */
     zrntesuuryoubuntandrtencd                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）手数料分担相手代理店コード */
     zrntesuuryoubuntanstartym                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）手数料分担開始年月 */
     zrntesuuryoubuntanendym                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）手数料分担終了年月 */
     zrntesuuryoubuntanwariai                           DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）手数料分担割合 */
     zrnyobiv67                                         CHAR        (67)                                                      NOT NULL     /* （連携用）予備項目Ｖ６７ */
)
;

ALTER TABLE ZT_DairitenBuntanInfoRn_Z ADD CONSTRAINT PK_DairitenBuntanInfoRn PRIMARY KEY (
     zrndairitencd                                            , /* （連携用）代理店コード */
     zrndairitensyouhincd                                     , /* （連携用）代理店商品コード */
     zrntesuuryoubuntandrtencd                                , /* （連携用）手数料分担相手代理店コード */
     zrntesuuryoubuntanstartym                                  /* （連携用）手数料分担開始年月 */
) ;
