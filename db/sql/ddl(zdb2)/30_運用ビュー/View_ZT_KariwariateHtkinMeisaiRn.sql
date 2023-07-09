CREATE VIEW ZT_KariwariateHtkinMeisaiRn AS SELECT
     zrnsequenceno ,         /* （連携用）シーケンス番号 */
     zrnyuukourecordlength ,         /* （連携用）有効レコード長 */
     zrnrdwarea ,         /* （連携用）ＲＤＷ領域 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnhrkkeirokbn ,         /* （連携用）払込経路区分 */
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrnznnndkrkskrwratdruigk ,         /* （連携用）前年度繰越仮割当Ｄ累計額 */
     zrntounendokariwariated ,         /* （連携用）当年度仮割当Ｄ */
     zrntndmatukrkskrwratdruigk ,         /* （連携用）当年度末仮割当Ｄ累計額 */
     zrnkariwariatedrisoku ,         /* （連携用）仮割当Ｄ利息 */
     zrnhsys ,         /* （連携用）保障Ｓ */
     zrnyobiv3 ,         /* （連携用）予備項目Ｖ３ */
     zrnsrutiwake ,         /* （連携用）数理用内訳 */
     zrnsrkijyunym ,         /* （連携用）数理用基準年月 */
     zrnkbnkeiriyousegmentkbn ,         /* （連携用）区分経理用セグメント区分 */
     zrnkbnkeiriyourgnbnskkbn ,         /* （連携用）区分経理用利源分析区分 */
     zrnseisikiwariatenendohyj ,         /* （連携用）正式割当年度表示 */
     zrnmankitouraiym ,         /* （連携用）満期到来年月 */
     zrnsyukeiyakusyuruicdv2 ,         /* （連携用）主契約種類コードＶ２ */
     zrnkeiyakunendo ,         /* （連携用）契約年度 */
     zrndaihyouyoteiriritu ,         /* （連携用）代表予定利率 */
     zrnharaikatakbn ,         /* （連携用）払方区分 */
     zrnyobiv20           /* （連携用）予備項目Ｖ２０ */
FROM ZT_KariwariateHtkinMeisaiRn_Z;