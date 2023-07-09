CREATE TABLE ZT_GinkouMdhnMisyuuInfoFRn (
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrnyobiv63                                         CHAR        (63)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６３ */
     zrndatakbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）データ区分 */
     zrndatasakuseiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）データ作成日 */
     zrnhknkaisyacd                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険会社コード */
     zrnhknsyuruicd                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類コード */
     zrnsyonosyuban                                     CHAR        (12)                                                      NOT NULL  ,  /* （連携用）証券番号主番 */
     zrnsyonoedaban                                     CHAR        (5)                                                       NOT NULL  ,  /* （連携用）証券番号枝番 */
     zrnmisyuutatekaekbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）未収立替区分 */
     zrnmisyuutatekaeym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）未収立替発生年月 */
     zrnmisyuukg                                        CHAR        (10)                                                      NOT NULL  ,  /* （連携用）未収金額 */
     zrnbnkaisuu                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）分割回数 */
     zrnmisyuujiyuu                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）未収事由 */
     zrnjikaidatakousinymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）次回データ更新日 */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnyobiv28                                         CHAR        (28)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２８ */
     zrnkosyaareav40                                    CHAR        (40)                                                      NOT NULL     /* （連携用）個社領域Ｖ４０ */
)
;

ALTER TABLE ZT_GinkouMdhnMisyuuInfoFRn ADD CONSTRAINT PK_GinkouMdhnMisyuuInfoFRn PRIMARY KEY (
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrndatasakuseiymd                                        , /* （連携用）データ作成日 */
     zrnsyonosyuban                                             /* （連携用）証券番号主番 */
) ;
