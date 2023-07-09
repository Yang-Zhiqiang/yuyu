CREATE VIEW ZT_DshrToukeiLoadingRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyuukourecordlength ,         /* （連携用）有効レコード長 */
     zrnrdwarea ,         /* （連携用）ＲＤＷ領域 */
     zrndshrym ,         /* （連携用）Ｄ支払年月 */
     zrnkeiyakunendo ,         /* （連携用）契約年度 */
     zrnannaikigetu ,         /* （連携用）案内期月 */
     zrnhknsyruikbn ,         /* （連携用）保険種類区分 */
     zrnsegcd ,         /* （連携用）セグメントコード */
     zrnshrriyuukbn ,         /* （連携用）支払理由区分 */
     zrnannaikbn ,         /* （連携用）案内区分 */
     zrnduketorihouhoukbn ,         /* （連携用）Ｄ受取方法区分 */
     zrnsyoumetukbn ,         /* （連携用）消滅区分 */
     zrnbikinhyj ,         /* （連携用）備金表示 */
     zrnskskbn ,         /* （連携用）作成区分 */
     zrnsrkensuu ,         /* （連携用）数理用件数 */
     zrnsrhsys ,         /* （連携用）数理用保障Ｓ */
     zrntoujigyounendod ,         /* （連携用）当事業年度Ｄ */
     zrntoujigyounendohasseidrsk ,         /* （連携用）当事業年度発生Ｄ利息 */
     zrnzenjigyounendomatudzndk ,         /* （連携用）前事業年度末Ｄ残高 */
     zrnyokujigyounendod ,         /* （連携用）翌事業年度Ｄ */
     zrnhushrtoujigyounendod           /* （連携用）不支払当事業年度Ｄ */
FROM ZT_DshrToukeiLoadingRn_Z;