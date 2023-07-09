CREATE VIEW ZT_DSeisanShrTysySyuseiRn AS SELECT
     zrnsyono ,         /* （連携用）証券番号 */
     zrnseisandshrymd ,         /* （連携用）精算Ｄ支払年月日 */
     zrnseisandkgk11 ,         /* （連携用）精算Ｄ金額Ｎ１１ */
     zrntyouseidkgk11 ,         /* （連携用）調整Ｄ金額Ｎ１１ */
     zrnyobiv19           /* （連携用）予備項目Ｖ１９ */
FROM ZT_DSeisanShrTysySyuseiRn_Z;