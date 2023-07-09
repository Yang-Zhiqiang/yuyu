CREATE TABLE ZT_UriageKekkaRn (
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrnauthorikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）オーソリ区分 */
     zrnuriageseikyuutorihikicd                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）売上請求取引コード */
     zrnyobiv14                                         CHAR        (14)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１４ */
     zrnuriagetaisyouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）売上対象年月 */
     zrnuriageymd6keta                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）売上年月日（６桁） */
     zrncreditkigyoucd                                  CHAR        (5)                                                       NOT NULL  ,  /* （連携用）クレジット企業コード */
     zrncreditkessaiyouno                               CHAR        (26)                                                      NOT NULL  ,  /* （連携用）クレジットカード決済用番号 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnrecordno                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）レコード番号 */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３ */
     zrncardyuukoukigen                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）カード有効期限 */
     zrnseikyuukngk                                     NUMBER      (13)                                                      NOT NULL  ,  /* （連携用）請求金額 */
     zrnyobiv5                                          CHAR        (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ５ */
     zrncreditkaiinnokami6keta                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）クレジット会員番号（上６桁） */
     zrnyobiv6                                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ６ */
     zrncreditkaiinnosimo4keta                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）クレジット会員番号（下４桁） */
     zrnuriageseikyuuerrorcd                            CHAR        (3)                                                       NOT NULL  ,  /* （連携用）売上請求エラーコード */
     zrnhurikaekekkacd                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）振替結果コード */
     zrnfukusuukameitennokey                            CHAR        (7)                                                       NOT NULL  ,  /* （連携用）複数加盟店番号設定キー情報 */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL     /* （連携用）予備項目Ｖ１ */
)
;

ALTER TABLE ZT_UriageKekkaRn ADD CONSTRAINT PK_UriageKekkaRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrncreditkessaiyouno                                     , /* （連携用）クレジットカード決済用番号 */
     zrnuriageymd6keta                                        , /* （連携用）売上年月日（６桁） */
     zrnrecordno                                              , /* （連携用）レコード番号 */
     zrnseikyuukngk                                             /* （連携用）請求金額 */
) ;
