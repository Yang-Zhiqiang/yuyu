CREATE TABLE ZT_UriageSousinRn (
     zrncreditkessaiyouno                               CHAR        (26)                                                      NOT NULL  ,  /* （連携用）クレジットカード決済用番号 */
     zrnauthorikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）オーソリ区分 */
     zrnuriageseikyuuymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）売上請求年月日 */
     zrnrsgaku                                          NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）領収金額 */
     zrnfukusuukameitennokey                            CHAR        (7)                                                       NOT NULL  ,  /* （連携用）複数加盟店番号設定キー情報 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnrecordno                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）レコード番号 */
     zrnuriagetaisyouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）売上対象年月 */
     zrnyobiv33                                         CHAR        (33)                                                      NOT NULL     /* （連携用）予備項目Ｖ３３ */
)
;

ALTER TABLE ZT_UriageSousinRn ADD CONSTRAINT PK_UriageSousinRn PRIMARY KEY (
     zrncreditkessaiyouno                                     , /* （連携用）クレジットカード決済用番号 */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnuriageseikyuuymd                                      , /* （連携用）売上請求年月日 */
     zrnrsgaku                                                , /* （連携用）領収金額 */
     zrnrecordno                                                /* （連携用）レコード番号 */
) ;
