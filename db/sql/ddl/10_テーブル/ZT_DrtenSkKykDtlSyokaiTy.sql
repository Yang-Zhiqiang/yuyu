CREATE TABLE ZT_DrtenSkKykDtlSyokaiTy (
     ztysakuseiym                                       VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）作成年月 */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztytntusycd                                        VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）担当者コード */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztykykymwareki4keta                                VARCHAR     (4)                                                                 ,  /* （中継用）契約年月（和暦）（４桁） */
     ztycifcd                                           VARCHAR     (15)                                                                ,  /* （中継用）ＣＩＦコード */
     ztyatesakinm                                       VARCHAR     (20)                                                                ,  /* （中継用）宛先名 */
     ztyhassinka                                        VARCHAR     (31)                                                                ,  /* （中継用）発信課 */
     ztytelno15keta                                     VARCHAR     (15)                                                                ,  /* （中継用）電話番号（１５桁） */
     ztybsyymwareki4keta                                VARCHAR     (4)                                                                 ,  /* （中継用）募集年月（和暦）（４桁） */
     ztytntusynm                                        VARCHAR     (10)                                                                ,  /* （中継用）担当者名 */
     ztykydatkikbnkj                                    VARCHAR     (1)                                                                 ,  /* （中継用）共同扱区分（漢字） */
     ztykyknmkj20                                       VARCHAR     (20)                                                                ,  /* （中継用）契約者名（漢字）（２０桁） */
     ztyskymdwareki                                     VARCHAR     (6)                                                                 ,  /* （中継用）失効年月日（和暦） */
     ztyhrkkaisuukj                                     VARCHAR     (3)                                                                 ,  /* （中継用）払込回数（漢字） */
     ztyhrkkeirokj                                      VARCHAR     (3)                                                                 ,  /* （中継用）払込経路（漢字） */
     ztyp11keta                                         NUMBER      (11)                                                                ,  /* （中継用）保険料（１１桁） */
     ztyskhr                                            NUMBER      (11)                                                                ,  /* （中継用）失効時返戻金 */
     ztyjizensyoukaiyouhyj                              VARCHAR     (1)                                                                 ,  /* （中継用）事前照会要表示 */
     ztytntusygyouhaiinfo                               VARCHAR     (4)                                                                 ,  /* （中継用）担当者業廃情報 */
     ztyhrkkeirobtjhmidasi                              VARCHAR     (5)                                                                 ,  /* （中継用）払込経路別情報見出し */
     ztyhrkkeirobtjh                                    VARCHAR     (60)                                                                ,  /* （中継用）払込経路別情報 */
     ztyhknsyuruimei                                    VARCHAR     (30)                                                                ,  /* （中継用）保険種類名 */
     ztybkofccd                                         VARCHAR     (3)                                                                 ,  /* （中継用）バックオフィスコード */
     ztydbskyoteiymd                                    VARCHAR     (6)                                                                 ,  /* （中継用）ＤＢ削除予定年月 */
     ztyminyukaisuu                                     VARCHAR     (3)                                                                 ,  /* （中継用）未入回数 */
     ztyjikaipjyuutouym                                 VARCHAR     (6)                                                                 ,  /* （中継用）次回Ｐ充当年月 */
     ztyvitkaiinno                                      VARCHAR     (10)                                                                ,  /* （中継用）Ｖｉｔ会員番号 */
     ztyvitkykym                                        VARCHAR     (4)                                                                 ,  /* （中継用）Ｖｉｔ契約年月 */
     ztyvitskymd                                        VARCHAR     (6)                                                                 ,  /* （中継用）Ｖｉｔ失効年月日 */
     ztyvithrkkaisuu                                    VARCHAR     (3)                                                                 ,  /* （中継用）Ｖｉｔ払込回数 */
     ztyvithrkkeiro                                     VARCHAR     (3)                                                                 ,  /* （中継用）Ｖｉｔ払込経路 */
     ztyzkomivitriyoury                                 NUMBER      (11)                                                                ,  /* （中継用）税込Ｖｉｔ利用料 */
     ztyvitnyknkaisuu                                   VARCHAR     (3)                                                                 ,  /* （中継用）Ｖｉｔ入金回数 */
     ztyvitbikou                                        VARCHAR     (20)                                                                ,  /* （中継用）Ｖｉｔ備考 */
     ztyyobiv25                                         VARCHAR     (25)                                                                   /* （中継用）予備項目Ｖ２５ */
)
;

ALTER TABLE ZT_DrtenSkKykDtlSyokaiTy ADD CONSTRAINT PK_DrtenSkKykDtlSyokaiTy PRIMARY KEY (
     ztysakuseiym                                             , /* （中継用）作成年月 */
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztytntusycd                                              , /* （中継用）担当者コード */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
