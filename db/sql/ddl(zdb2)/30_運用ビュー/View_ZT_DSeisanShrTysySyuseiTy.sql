CREATE VIEW ZT_DSeisanShrTysySyuseiTy AS SELECT
     ztysyono ,         /* （中継用）証券番号 */
     ztyseisandshrymd ,         /* （中継用）精算Ｄ支払年月日 */
     ztyseisandkgk11 ,         /* （中継用）精算Ｄ金額Ｎ１１ */
     ztytyouseidkgk11 ,         /* （中継用）調整Ｄ金額Ｎ１１ */
     ztyyobiv19 ,         /* （中継用）予備項目Ｖ１９ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_DSeisanShrTysySyuseiTy_Z;