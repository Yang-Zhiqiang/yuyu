CREATE TABLE ZT_AcsAdrNmRn (
     zrnkihontikucd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）基本地区コード */
     zrnkihontikucdsyoumetukbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）基本地区コード消滅理由区分 */
     zrnkjadr                                           VARCHAR     (50)                                                      NOT NULL  ,  /* （連携用）漢字住所 */
     zrnkjtodouhukennmketasuu                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）漢字都道府県名桁数 */
     zrnkjsikugunnmketasuu                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）漢字市区郡名桁数 */
     zrnkjsikutyousonnmketasuu                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）漢字市区町村名桁数 */
     zrnkjtyousonnmketasuu                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）漢字町村名桁数 */
     zrnkjkyoutotuusyounmketasuu                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）漢字京都市内通称町名桁数 */
     zrnkjadrketasuu                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）漢字住所桁数 */
     zrnknadr                                           CHAR        (100)                                                     NOT NULL  ,  /* （連携用）カナ住所 */
     zrnkntodouhukennmketasuu                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）カナ都道府県名桁数 */
     zrnknsikugunnmketasuu                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）カナ市区郡名桁数 */
     zrnknsikutyousonnmketasuu                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）カナ市区町村名桁数 */
     zrnkntyousonnmketasuu                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）カナ町村名桁数 */
     zrnknkyoutotuusyounmketasuu                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）カナ京都市内通称町名桁数 */
     zrnknadrketasuu                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）カナ住所桁数 */
     zrntodouhukencd                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）都道府県コード */
     zrngyouseikukakucd                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）行政区画コード */
     zrnikoumaekihontikucd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）移行前基本地区コード */
     zrnnewynohyouji                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）新郵便番号表示 */
     zrnyobiv14                                         CHAR        (14)                                                      NOT NULL     /* （連携用）予備項目Ｖ１４ */
)
;

ALTER TABLE ZT_AcsAdrNmRn ADD CONSTRAINT PK_AcsAdrNmRn PRIMARY KEY (
     zrnkihontikucd                                             /* （連携用）基本地区コード */
) ;
