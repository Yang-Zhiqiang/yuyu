CREATE VIEW ZT_DairitenSyougouRn AS SELECT
     zrndairitencd ,         /* （連携用）代理店コード */
     zrnkanjihoujinsyougou ,         /* （連携用）漢字法人商号 */
     zrnyobiv13           /* （連携用）予備項目Ｖ１３ */
FROM ZT_DairitenSyougouRn_Z;