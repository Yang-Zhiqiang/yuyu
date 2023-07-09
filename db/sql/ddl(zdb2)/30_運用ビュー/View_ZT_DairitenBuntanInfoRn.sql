CREATE VIEW ZT_DairitenBuntanInfoRn AS SELECT
     zrndairitencd ,         /* （連携用）代理店コード */
     zrndairitensyouhincd ,         /* （連携用）代理店商品コード */
     zrntesuuryoubuntandrtencd ,         /* （連携用）手数料分担相手代理店コード */
     zrntesuuryoubuntanstartym ,         /* （連携用）手数料分担開始年月 */
     zrntesuuryoubuntanendym ,         /* （連携用）手数料分担終了年月 */
     zrntesuuryoubuntanwariai ,         /* （連携用）手数料分担割合 */
     zrnyobiv67           /* （連携用）予備項目Ｖ６７ */
FROM ZT_DairitenBuntanInfoRn_Z;