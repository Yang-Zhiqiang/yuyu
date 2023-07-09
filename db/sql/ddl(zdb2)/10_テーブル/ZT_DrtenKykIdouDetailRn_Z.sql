CREATE TABLE ZT_DrtenKykIdouDetailRn_Z (
     zrnkinyuukikancd                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）金融機関コード */
     zrnkinyuukikansitencd                              CHAR        (4)                                                       NOT NULL  ,  /* （連携用）金融機関支店コード */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnbosyuunincd                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集人コード */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnidouhasseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）異動発生年月日 */
     zrnkykmfksnctrlkh                                  DECIMAL     (7)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ更新ＣＴＲ（保全） */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrnidoukbn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）異動区分 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnkydatkikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnjikaipjyuutouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）次回Ｐ充当年月 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnanniskcd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）案内先コード */
     zrndntcd                                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）団体コ－ド */
     zrnharaikomip                                      DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）払込Ｐ */
     zrnkjsyagaihknnm                                   GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）漢字社外向け保険名 */
     zrntelno                                           CHAR        (14)                                                      NOT NULL  ,  /* （連携用）電話番号 */
     zrnhensyuubosyuudrtennm                            GRAPHIC     (27)                                                      NOT NULL  ,  /* （連携用）編集後漢字募集代理店名 */
     zrnkyknmkjdirtnkykido                              GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（代理店契約異動明細） */
     zrnkjdntnm                                         GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）漢字団体名 */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrnoyabosyuudairitencd                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）親募集代理店コード */
     zrnbsydrtenkanrisosikicd                           CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店管理組織コード */
     zrnbosyuudairitengyousyukbn                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）募集代理店業種区分 */
     zrnbosyuudrtennmkj                                 GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）募集代理店名（漢字） */
     zrndoujitusyoricount                               CHAR        (3)                                                       NOT NULL  ,  /* （連携用）同日処理回数 */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人契約表示 */
     zrnhjnnmkj                                         GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）法人名（漢字） */
     zrnsyuhrkkaisuukbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）表示用主契約払込回数区分 */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnyobiv103                                        CHAR        (103)                                                     NOT NULL     /* （連携用）予備項目Ｖ１０３ */
)
;

ALTER TABLE ZT_DrtenKykIdouDetailRn_Z ADD CONSTRAINT PK_DrtenKykIdouDetailRn PRIMARY KEY (
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrnbosyuunincd                                           , /* （連携用）募集人コード */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnidouhasseiymd                                         , /* （連携用）異動発生年月日 */
     zrnidoukbn                                                 /* （連携用）異動区分 */
) ;
