CREATE VIEW ZT_TuutirirekiMeisaiFRn AS SELECT
     zrntuutirirekino ,         /* （連携用）通知履歴番号 */
     zrntuutisakuseiymd ,         /* （連携用）通知作成年月日 */
     zrntuutisakuseino ,         /* （連携用）通知作成番号 */
     zrntuutisyuruicd ,         /* （連携用）通知種類コード */
     zrnhyoujiyoutuutisksymd ,         /* （連携用）表示用通知作成年月日 */
     zrnyobiv11           /* （連携用）予備項目Ｖ１１ */
FROM ZT_TuutirirekiMeisaiFRn_Z;