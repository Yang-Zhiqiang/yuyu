CREATE TABLE ZT_DrtenKykIdouDetailTy_Z (
     ztykinyuukikancd                                   VARCHAR     (4)                                                                 ,  /* （中継用）金融機関コード */
     ztykinyuukikansitencd                              VARCHAR     (4)                                                                 ,  /* （中継用）金融機関支店コード */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztybosyuunincd                                     VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）募集人コード */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyidouhasseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）異動発生年月日 */
     ztykykmfksnctrlkh                                  DECIMAL     (7)                                                                 ,  /* （中継用）契約ＭＦ更新ＣＴＲ（保全） */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztyidoukbn                                         VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）異動区分 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztykydatkikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）共同扱区分 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyjikaipjyuutouym                                 VARCHAR     (6)                                                                 ,  /* （中継用）次回Ｐ充当年月 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztyanniskcd                                        VARCHAR     (8)                                                                 ,  /* （中継用）案内先コード */
     ztydntcd                                           VARCHAR     (8)                                                                 ,  /* （中継用）団体コ－ド */
     ztyharaikomip                                      DECIMAL     (11)                                                                ,  /* （中継用）払込Ｐ */
     ztykjsyagaihknnm                                   VARCHAR     (82)                                                                ,  /* （中継用）漢字社外向け保険名 */
     ztytelno                                           VARCHAR     (14)                                                                ,  /* （中継用）電話番号 */
     ztyhensyuubosyuudrtennm                            VARCHAR     (56)                                                                ,  /* （中継用）編集後漢字募集代理店名 */
     ztykyknmkjdirtnkykido                              VARCHAR     (42)                                                                ,  /* （中継用）契約者名（漢字）（代理店契約異動明細） */
     ztykjdntnm                                         VARCHAR     (72)                                                                ,  /* （中継用）漢字団体名 */
     ztykzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （中継用）口座振替口座番号 */
     ztyoyabosyuudairitencd                             VARCHAR     (7)                                                                 ,  /* （中継用）親募集代理店コード */
     ztybsydrtenkanrisosikicd                           VARCHAR     (7)                                                                 ,  /* （中継用）募集代理店管理組織コード */
     ztybosyuudairitengyousyukbn                        VARCHAR     (2)                                                                 ,  /* （中継用）募集代理店業種区分 */
     ztybosyuudrtennmkj                                 VARCHAR     (42)                                                                ,  /* （中継用）募集代理店名（漢字） */
     ztydoujitusyoricount                               VARCHAR     (3)                                                                 ,  /* （中継用）同日処理回数 */
     ztyhjnkykhyj                                       VARCHAR     (1)                                                                 ,  /* （中継用）法人契約表示 */
     ztyhjnnmkj                                         VARCHAR     (72)                                                                ,  /* （中継用）法人名（漢字） */
     ztysyuhrkkaisuukbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）表示用主契約払込回数区分 */
     ztyikkatubaraikbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu                               VARCHAR     (2)                                                                 ,  /* （中継用）一括払回数 */
     ztyyobiv103                                        VARCHAR     (103)                                                               ,  /* （中継用）予備項目Ｖ１０３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_DrtenKykIdouDetailTy_Z ADD CONSTRAINT PK_DrtenKykIdouDetailTy PRIMARY KEY (
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztybosyuunincd                                           , /* （中継用）募集人コード */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztyidouhasseiymd                                         , /* （中継用）異動発生年月日 */
     ztyidoukbn                                                 /* （中継用）異動区分 */
) ;
