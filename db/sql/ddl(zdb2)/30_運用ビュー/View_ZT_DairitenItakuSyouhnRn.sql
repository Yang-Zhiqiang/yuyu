CREATE VIEW ZT_DairitenItakuSyouhnRn AS SELECT
     zrndairitencd ,         /* （連携用）代理店コード */
     zrndrtsyouhinsikibetukbnstr ,         /* （連携用）代理店商品識別区分（文字列） */
     zrndrthrkhouhoukbn ,         /* （連携用）代理店払込方法区分 */
     zrndrtplannmkbn ,         /* （連携用）代理店プラン名区分 */
     zrnitakuhknhnbkaisiymd ,         /* （連携用）委託保険販売開始年月日 */
     zrnitakuhknhnbsyuuryouymd ,         /* （連携用）委託保険販売終了年月日 */
     zrnyobiv22           /* （連携用）予備項目Ｖ２２ */
FROM ZT_DairitenItakuSyouhnRn_Z;