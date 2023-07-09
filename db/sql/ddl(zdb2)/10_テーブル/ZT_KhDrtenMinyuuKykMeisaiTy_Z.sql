CREATE TABLE ZT_KhDrtenMinyuuKykMeisaiTy_Z (
     ztysyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）処理年月日 */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztybosyuunincd                                     VARCHAR     (6)                                                                 ,  /* （中継用）募集人コード */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztypjyuutouyymmwareki4keta                         VARCHAR     (4)                                                                 ,  /* （中継用）保険料充当年月（和暦）（４桁） */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztybosyuudrtennmkj                                 VARCHAR     (42)                                                                ,  /* （中継用）募集代理店名（漢字） */
     ztyminyuujyutuymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）未入充当年月日 */
     ztyhassinka                                        VARCHAR     (64)                                                                ,  /* （中継用）発信課 */
     ztybsyym                                           VARCHAR     (6)                                                                 ,  /* （中継用）募集年月 */
     ztydrtnbsyunnmisyou                                VARCHAR     (22)                                                                ,  /* （中継用）代理店募集人名称（漢字） */
     ztykydatkikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）共同扱区分 */
     ztykyknmkj35                                       VARCHAR     (72)                                                                ,  /* （中継用）契約者名（漢字）（３５桁） */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztyhrkgk                                           DECIMAL     (11)                                                                ,  /* （中継用）払込額 */
     ztyknkimnyuuryu                                    VARCHAR     (1)                                                                 ,  /* （中継用）今回未入理由 */
     ztybosyuuningyouhaiymd                             VARCHAR     (8)                                                                 ,  /* （中継用）募集人業廃年月日 */
     ztykzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （中継用）口座振替口座番号 */
     ztyknyukknmei                                      VARCHAR     (54)                                                                ,  /* （中継用）金融機関名 */
     ztyknyykknstnmei                                   VARCHAR     (50)                                                                ,  /* （中継用）金融機関支店名 */
     ztydantaicd                                        VARCHAR     (8)                                                                 ,  /* （中継用）団体コード */
     ztykjdntnm                                         VARCHAR     (72)                                                                ,  /* （中継用）漢字団体名 */
     zty30ketahknsyuruimei                              VARCHAR     (62)                                                                ,  /* （中継用）３０桁保険種類名 */
     ztybkofccd                                         VARCHAR     (3)                                                                 ,  /* （中継用）バックオフィスコード */
     ztyhjnkykhyj                                       VARCHAR     (1)                                                                 ,  /* （中継用）法人契約表示 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KhDrtenMinyuuKykMeisaiTy_Z ADD CONSTRAINT PK_KhDrtenMinyuuKykMeisaiTy PRIMARY KEY (
     ztysyoriymd                                              , /* （中継用）処理年月日 */
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
