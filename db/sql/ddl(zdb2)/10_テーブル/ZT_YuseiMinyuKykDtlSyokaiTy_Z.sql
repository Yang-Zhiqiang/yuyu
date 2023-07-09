CREATE TABLE ZT_YuseiMinyuKykDtlSyokaiTy_Z (
     ztysakuseiym                                       VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）作成年月 */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztytntusycd                                        VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）担当者コード */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztypjyuutouyymmwareki4keta                         VARCHAR     (4)                                                                 ,  /* （中継用）保険料充当年月（和暦）（４桁） */
     ztykykymwareki4keta                                VARCHAR     (4)                                                                 ,  /* （中継用）契約年月（和暦）（４桁） */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztyatesakinm                                       VARCHAR     (42)                                                                ,  /* （中継用）宛先名 */
     ztyminyuujyutuymdyofuri                            VARCHAR     (32)                                                                ,  /* （中継用）未入充当年月（預振） */
     ztyminyuujyutuymdyofuriigi                         VARCHAR     (22)                                                                ,  /* （中継用）未入充当年月（預振以外） */
     ztyhassinka                                        VARCHAR     (64)                                                                ,  /* （中継用）発信課 */
     ztytelno15keta                                     VARCHAR     (32)                                                                ,  /* （中継用）電話番号（１５桁） */
     ztybsyymwareki4keta                                VARCHAR     (4)                                                                 ,  /* （中継用）募集年月（和暦）（４桁） */
     ztytntusynm                                        VARCHAR     (22)                                                                ,  /* （中継用）担当者名 */
     ztykydatkikbnkj                                    VARCHAR     (4)                                                                 ,  /* （中継用）共同扱区分（漢字） */
     ztykyknmkj20                                       VARCHAR     (42)                                                                ,  /* （中継用）契約者名（漢字）（２０桁） */
     ztyhjnkykhyj                                       VARCHAR     (1)                                                                 ,  /* （中継用）法人契約表示 */
     ztyhrkkaisuukj                                     VARCHAR     (8)                                                                 ,  /* （中継用）払込回数（漢字） */
     ztyhrkkeirokj                                      VARCHAR     (8)                                                                 ,  /* （中継用）払込経路（漢字） */
     ztyp11keta                                         DECIMAL     (11)                                                                ,  /* （中継用）保険料（１１桁） */
     ztyknkimnyuuryukj                                  VARCHAR     (12)                                                                ,  /* （中継用）今回未入理由（漢字） */
     ztyjikaiminyuuji                                   VARCHAR     (12)                                                                ,  /* （中継用）次回未入時 */
     ztytntusygyouhaiinfo                               VARCHAR     (10)                                                                ,  /* （中継用）担当者業廃情報 */
     ztyhrkkeirobtjhmidasi                              VARCHAR     (12)                                                                ,  /* （中継用）払込経路別情報見出し */
     ztyhrkkeirobtjh                                    VARCHAR     (122)                                                               ,  /* （中継用）払込経路別情報 */
     ztyhknsyuruimei                                    VARCHAR     (62)                                                                ,  /* （中継用）保険種類名 */
     ztybkofccd                                         VARCHAR     (3)                                                                 ,  /* （中継用）バックオフィスコード */
     ztydbskyoteiymd                                    VARCHAR     (6)                                                                 ,  /* （中継用）ＤＢ削除予定年月 */
     ztyyobiv23                                         VARCHAR     (23)                                                                ,  /* （中継用）予備項目Ｖ２３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_YuseiMinyuKykDtlSyokaiTy_Z ADD CONSTRAINT PK_YuseiMinyuKykDtlSyokaiTy PRIMARY KEY (
     ztysakuseiym                                             , /* （中継用）作成年月 */
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztytntusycd                                              , /* （中継用）担当者コード */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
