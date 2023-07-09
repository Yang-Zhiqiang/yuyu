CREATE VIEW HM_TokuteiKankeiHoujin AS SELECT
     tkhjnkinyuucd ,         /* 特定関係法人金融機関コード */
     meisaino ,         /* 明細番号 */
     marukinhyouji ,         /* マル金表示 */
     tkhjnkjdrtennm ,         /* 特定関係法人漢字代理店名 */
     dairitenbtno ,         /* 代理店別通番 */
     tkhjnnmkj ,         /* 特定関係法人名（漢字） */
     tkhjnnmkn ,         /* 特定関係法人名（カナ） */
     kosymd ,         /* 更新日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_TokuteiKankeiHoujin_Z;