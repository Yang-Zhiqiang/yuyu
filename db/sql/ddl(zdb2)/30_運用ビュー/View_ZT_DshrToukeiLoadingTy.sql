CREATE VIEW ZT_DshrToukeiLoadingTy AS SELECT
     ztysequenceno ,         /* （中継用）シーケンス番号 */
     ztyyuukourecordlength ,         /* （中継用）有効レコード長 */
     ztyrdwarea ,         /* （中継用）ＲＤＷ領域 */
     ztydshrym ,         /* （中継用）Ｄ支払年月 */
     ztykeiyakunendo ,         /* （中継用）契約年度 */
     ztyannaikigetu ,         /* （中継用）案内期月 */
     ztyhknsyruikbn ,         /* （中継用）保険種類区分 */
     ztysegcd ,         /* （中継用）セグメントコード */
     ztyshrriyuukbn ,         /* （中継用）支払理由区分 */
     ztyannaikbn ,         /* （中継用）案内区分 */
     ztyduketorihouhoukbn ,         /* （中継用）Ｄ受取方法区分 */
     ztysyoumetukbn ,         /* （中継用）消滅区分 */
     ztybikinhyj ,         /* （中継用）備金表示 */
     ztyskskbn ,         /* （中継用）作成区分 */
     ztysrkensuu ,         /* （中継用）数理用件数 */
     ztysrhsys ,         /* （中継用）数理用保障Ｓ */
     ztytoujigyounendod ,         /* （中継用）当事業年度Ｄ */
     ztytoujigyounendohasseidrsk ,         /* （中継用）当事業年度発生Ｄ利息 */
     ztyzenjigyounendomatudzndk ,         /* （中継用）前事業年度末Ｄ残高 */
     ztyyokujigyounendod ,         /* （中継用）翌事業年度Ｄ */
     ztyhushrtoujigyounendod ,         /* （中継用）不支払当事業年度Ｄ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_DshrToukeiLoadingTy_Z;