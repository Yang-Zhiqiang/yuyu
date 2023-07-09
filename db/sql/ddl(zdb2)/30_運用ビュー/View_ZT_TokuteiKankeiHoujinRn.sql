CREATE VIEW ZT_TokuteiKankeiHoujinRn AS SELECT
     zrnkinyuukikancd ,         /* （連携用）金融機関コード */
     zrnmeisaibangou ,         /* （連携用）明細番号 */
     zrnmarukinhyouji ,         /* （連携用）マル金表示 */
     zrntkhjnkjdrtennm ,         /* （連携用）特定関係法人漢字代理店名 */
     zrndairitenbetutuuban ,         /* （連携用）代理店別通番 */
     zrnkanjitokuteikankeinm ,         /* （連携用）漢字特定関係法人名 */
     zrntokuteikankeihoujinnm ,         /* （連携用）特定関係法人名 */
     zrnkousinymd ,         /* （連携用）更新年月日 */
     zrnyobiv79           /* （連携用）予備項目Ｖ７９ */
FROM ZT_TokuteiKankeiHoujinRn_Z;