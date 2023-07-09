CREATE VIEW ZT_KzhuriSyuunouKekkaTr AS SELECT
     ztrsyono ,         /* （取込用）証券番号 */
     ztrkzhurikaebankcd ,         /* （取込用）口座振替銀行番号 */
     ztrkzhurikaesitencd ,         /* （取込用）口座振替支店番号 */
     ztrkzhurikaeyokinkbn ,         /* （取込用）口座振替預金種目区分 */
     ztrkzhurikaekouzano ,         /* （取込用）口座振替口座番号 */
     ztrhurikaeymd ,         /* （取込用）振替年月日 */
     ztrrsgaku ,         /* （取込用）領収金額 */
     ztrjyuutouym ,         /* （取込用）充当年月 */
     ztrjyuutounensuu ,         /* （取込用）充当年数 */
     ztrjyuutoutukisuu ,         /* （取込用）充当月数 */
     ztrdantaikobetukbn ,         /* （取込用）団体個別区分 */
     ztrnyknaiyoukbn ,         /* （取込用）入金内容区分 */
     ztrhrkkaisuukbn ,         /* （取込用）払込回数区分 */
     ztrkzhurikaetkbtannaihyj ,         /* （取込用）口座振替特別案内表示 */
     ztrhurikaekekkakbn ,         /* （取込用）振替結果区分 */
     ztrkzhurisyuudaikokbn ,         /* （取込用）口座振替収納代行会社区分 */
     ztryobiv13 ,         /* （取込用）予備項目Ｖ１３ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_KzhuriSyuunouKekkaTr_Z;