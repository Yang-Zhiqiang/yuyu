CREATE VIEW ZT_BikinKeiyakuSeisandRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyuukourecordlength ,         /* （連携用）有効レコード長 */
     zrnrdwarea ,         /* （連携用）ＲＤＷ領域 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnbikinkbn ,         /* （連携用）備金区分 */
     zrnbikinnendokbn ,         /* （連携用）備金年度区分 */
     zrnseisand ,         /* （連携用）精算Ｄ */
     zrntumitaterisoku ,         /* （連携用）積立利息 */
     zrnsyuruicd1 ,         /* （連携用）種類コード１ */
     zrnsyuruicd3 ,         /* （連携用）種類コード３ */
     zrnsrkijyunym ,         /* （連携用）数理用基準年月 */
     zrnkbnkeiriyousegmentkbn ,         /* （連携用）区分経理用セグメント区分 */
     zrnkbnkeiriyourgnbnskkbn ,         /* （連携用）区分経理用利源分析区分 */
     zrnsyuruicd2 ,         /* （連携用）種類コード２ */
     zrnkariwariatedganrikin ,         /* （連携用）仮割当Ｄ元利金 */
     zrnkariwariatedrisoku ,         /* （連携用）仮割当Ｄ利息 */
     zrnsyukeiyakusyuruicdv2 ,         /* （連携用）主契約種類コードＶ２ */
     zrnkeiyakunendo ,         /* （連携用）契約年度 */
     zrndaihyouyoteiriritu ,         /* （連携用）代表予定利率 */
     zrnharaikatakbn ,         /* （連携用）払方区分 */
     zrnyobiv32           /* （連携用）予備項目Ｖ３２ */
FROM ZT_BikinKeiyakuSeisandRn_Z;