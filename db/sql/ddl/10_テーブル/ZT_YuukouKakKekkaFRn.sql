CREATE TABLE ZT_YuukouKakKekkaFRn (
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrncreditkessaiyouno                               CHAR        (26)                                                      NOT NULL  ,  /* （連携用）クレジットカード決済用番号 */
     zrndbkeykugirimoji1                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＤＢキー区切り文字１ */
     zrndbkeykugirimoji2                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＤＢキー区切り文字２ */
     zrnyobiv32                                         CHAR        (32)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３２ */
     zrncardno                                          CHAR        (16)                                                      NOT NULL  ,  /* （連携用）カード番号 */
     zrncardyuukoukigen                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）カード有効期限 */
     zrnyuukouhanteikekka                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）有効性判定結果 */
     zrnyobiv59                                         CHAR        (59)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ５９ */
     zrncreditkigyoucd                                  CHAR        (5)                                                       NOT NULL  ,  /* （連携用）クレジット企業コード */
     zrnyobiv53                                         CHAR        (53)                                                      NOT NULL     /* （連携用）予備項目Ｖ５３ */
)
;

ALTER TABLE ZT_YuukouKakKekkaFRn ADD CONSTRAINT PK_YuukouKakKekkaFRn PRIMARY KEY (
     zrncreditkessaiyouno                                       /* （連携用）クレジットカード決済用番号 */
) ;
