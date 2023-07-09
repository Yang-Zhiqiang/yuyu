CREATE VIEW BT_TuutirirekiMeisaiHokan AS SELECT
     tuutirirekirenno ,         /* 通知履歴連番 */
     tuutirirekino ,         /* 通知履歴番号 */
     tuutisakuseiymd ,         /* 通知作成年月日 */
     tuutisakuseino ,         /* 通知作成番号 */
     tuutisyuruicd ,         /* 通知種類コード */
     hyoujiyoutuutisakuseiymd ,         /* 表示用通知作成年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_TuutirirekiMeisaiHokan_Z;