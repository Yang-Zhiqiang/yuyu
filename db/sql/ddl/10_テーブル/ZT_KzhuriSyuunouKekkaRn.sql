CREATE TABLE ZT_KzhuriSyuunouKekkaRn (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrnhurikaeymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）振替年月日 */
     zrnrsgaku                                          NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）領収金額 */
     zrnjyuutouym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）充当年月 */
     zrnjyuutounensuu                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）充当年数 */
     zrnjyuutoutukisuu                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）充当月数 */
     zrndantaikobetukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）団体個別区分 */
     zrnnyknaiyoukbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）入金内容区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnkzhurikaetkbtannaihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替特別案内表示 */
     zrnhurikaekekkakbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）振替結果区分 */
     zrnkzhurisyuudaikokbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替収納代行会社区分 */
     zrnyobiv13                                         CHAR        (13)                                                      NOT NULL     /* （連携用）予備項目Ｖ１３ */
)
;

ALTER TABLE ZT_KzhuriSyuunouKekkaRn ADD CONSTRAINT PK_KzhuriSyuunouKekkaRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnjyuutouym                                               /* （連携用）充当年月 */
) ;
