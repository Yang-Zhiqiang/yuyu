CREATE VIEW ZT_TuutirirekiMeisaiFTy AS SELECT
     ztytuutirirekino ,         /* （中継用）通知履歴番号 */
     ztytuutisakuseiymd ,         /* （中継用）通知作成年月日 */
     ztytuutisakuseino ,         /* （中継用）通知作成番号 */
     ztytuutisyuruicd ,         /* （中継用）通知種類コード */
     ztyhyoujiyoutuutisksymd ,         /* （中継用）表示用通知作成年月日 */
     ztyyobiv11 ,         /* （中継用）予備項目Ｖ１１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_TuutirirekiMeisaiFTy_Z;