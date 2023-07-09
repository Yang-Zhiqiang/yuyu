CREATE TABLE ZT_KhDrtenMinyuuKykMeisaiRn (
     zrnsyoriymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理年月日 */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrnbosyuunincd                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集人コード */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnpjyuutouyymmwareki4keta                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）保険料充当年月（和暦）（４桁） */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnbosyuudrtennmkj                                 VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）募集代理店名（漢字） */
     zrnminyuujyutuymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）未入充当年月日 */
     zrnhassinka                                        VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）発信課 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrndrtnbsyunnmisyou                                VARCHAR     (10)                                                      NOT NULL  ,  /* （連携用）代理店募集人名称（漢字） */
     zrnkydatkikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分 */
     zrnkyknmkj35                                       VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（３５桁） */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnhrkgk                                           NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）払込額 */
     zrnknkimnyuuryu                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）今回未入理由 */
     zrnbosyuuningyouhaiymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）募集人業廃年月日 */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrnknyukknmei                                      CHAR        (26)                                                      NOT NULL  ,  /* （連携用）金融機関名 */
     zrnknyykknstnmei                                   CHAR        (24)                                                      NOT NULL  ,  /* （連携用）金融機関支店名 */
     zrndantaicd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）団体コード */
     zrnkjdntnm                                         VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）漢字団体名 */
     zrnhknsyuruimei                                    VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）保険種類名 */
     zrnbkofccd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）バックオフィスコード */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL     /* （連携用）法人契約表示 */
)
;

ALTER TABLE ZT_KhDrtenMinyuuKykMeisaiRn ADD CONSTRAINT PK_KhDrtenMinyuuKykMeisaiRn PRIMARY KEY (
     zrnsyoriymd                                              , /* （連携用）処理年月日 */
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
