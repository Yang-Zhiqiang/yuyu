CREATE TABLE ZT_TuutirirekiMeisaiFRn_Z (
     zrntuutirirekino                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）通知履歴番号 */
     zrntuutisakuseiymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通知作成年月日 */
     zrntuutisakuseino                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）通知作成番号 */
     zrntuutisyuruicd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通知種類コード */
     zrnhyoujiyoutuutisksymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）表示用通知作成年月日 */
     zrnyobiv11                                         CHAR        (11)                                                      NOT NULL     /* （連携用）予備項目Ｖ１１ */
)
;

ALTER TABLE ZT_TuutirirekiMeisaiFRn_Z ADD CONSTRAINT PK_TuutirirekiMeisaiFRn PRIMARY KEY (
     zrntuutirirekino                                         , /* （連携用）通知履歴番号 */
     zrntuutisakuseiymd                                       , /* （連携用）通知作成年月日 */
     zrntuutisakuseino                                          /* （連携用）通知作成番号 */
) ;
