CREATE VIEW ZT_KzhuriSyuunouKekkaRn AS SELECT
     zrnsyono ,         /* （連携用）証券番号 */
     zrnkzhurikaebankcd ,         /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd ,         /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn ,         /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano ,         /* （連携用）口座振替口座番号 */
     zrnhurikaeymd ,         /* （連携用）振替年月日 */
     zrnrsgaku ,         /* （連携用）領収金額 */
     zrnjyuutouym ,         /* （連携用）充当年月 */
     zrnjyuutounensuu ,         /* （連携用）充当年数 */
     zrnjyuutoutukisuu ,         /* （連携用）充当月数 */
     zrndantaikobetukbn ,         /* （連携用）団体個別区分 */
     zrnnyknaiyoukbn ,         /* （連携用）入金内容区分 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnkzhurikaetkbtannaihyj ,         /* （連携用）口座振替特別案内表示 */
     zrnhurikaekekkakbn ,         /* （連携用）振替結果区分 */
     zrnkzhurisyuudaikokbn ,         /* （連携用）口座振替収納代行会社区分 */
     zrnyobiv13           /* （連携用）予備項目Ｖ１３ */
FROM ZT_KzhuriSyuunouKekkaRn_Z;