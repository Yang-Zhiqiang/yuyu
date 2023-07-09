CREATE VIEW ZT_ZitkAzukarikinSrRendouTy AS SELECT
     ztysequenceno ,         /* （中継用）シーケンス番号 */
     ztyyuukourecordlength ,         /* （中継用）有効レコード長 */
     ztyrdwarea ,         /* （中継用）ＲＤＷ領域 */
     ztysyono ,         /* （中継用）証券番号 */
     ztyjynbknkbn ,         /* （中継用）準備金区分 */
     ztykbnkeiriyousegmentcd ,         /* （中継用）区分経理用セグメントコード */
     ztytndmatuzndk ,         /* （中継用）当年度末残高 */
     ztyyoteirisoku ,         /* （中継用）予定利息 */
     ztykeiyakunendo ,         /* （中継用）契約年度 */
     ztysuuriyouyobin4 ,         /* （中継用）数理用予備項目Ｎ４ */
     ztysuuriyouyobin8 ,         /* （中継用）数理用予備項目Ｎ８ */
     ztyyobin11 ,         /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2 ,         /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobiv93 ,         /* （中継用）予備項目Ｖ９３ */
     ztyraysystemhyj ,         /* （中継用）ＲＡＹシステム表示 */
     ztytndmatuzndkgaika ,         /* （中継用）当年度末残高（外貨） */
     ztyyobiv3 ,         /* （中継用）予備項目Ｖ３ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_ZitkAzukarikinSrRendouTy_Z;