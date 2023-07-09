CREATE VIEW ZT_ZitkAzukarikinSrRendouRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyuukourecordlength ,         /* （連携用）有効レコード長 */
     zrnrdwarea ,         /* （連携用）ＲＤＷ領域 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnjynbknkbn ,         /* （連携用）準備金区分 */
     zrnkbnkeiriyousegmentcd ,         /* （連携用）区分経理用セグメントコード */
     zrntndmatuzndk ,         /* （連携用）当年度末残高 */
     zrnyoteirisoku ,         /* （連携用）予定利息 */
     zrnkeiyakunendo ,         /* （連携用）契約年度 */
     zrnsuuriyouyobin4 ,         /* （連携用）数理用予備項目Ｎ４ */
     zrnsuuriyouyobin8 ,         /* （連携用）数理用予備項目Ｎ８ */
     zrnyobin11 ,         /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2 ,         /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobiv93 ,         /* （連携用）予備項目Ｖ９３ */
     zrnraysystemhyj ,         /* （連携用）ＲＡＹシステム表示 */
     zrntndmatuzndkgaika ,         /* （連携用）当年度末残高（外貨） */
     zrnyobiv3           /* （連携用）予備項目Ｖ３ */
FROM ZT_ZitkAzukarikinSrRendouRn_Z;