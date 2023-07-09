CREATE TABLE ZT_YuseiMinyuKykDtlSyokaiRn_Z (
     zrnsakuseiym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）作成年月 */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrntntusycd                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）担当者コード */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnpjyuutouyymmwareki4keta                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）保険料充当年月（和暦）（４桁） */
     zrnkykymwareki4keta                                CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年月（和暦）（４桁） */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnatesakinm                                       GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）宛先名 */
     zrnminyuujyutuymdyofuri                            GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）未入充当年月（預振） */
     zrnminyuujyutuymdyofuriigi                         GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）未入充当年月（預振以外） */
     zrnhassinka                                        GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）発信課 */
     zrntelno15keta                                     GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）電話番号（１５桁） */
     zrnbsyymwareki4keta                                CHAR        (4)                                                       NOT NULL  ,  /* （連携用）募集年月（和暦）（４桁） */
     zrntntusynm                                        GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）担当者名 */
     zrnkydatkikbnkj                                    GRAPHIC     (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分（漢字） */
     zrnkyknmkj20                                       GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（２０桁） */
     zrnhjnkykhyj                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）法人契約表示 */
     zrnhrkkaisuukj                                     GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）払込回数（漢字） */
     zrnhrkkeirokj                                      GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）払込経路（漢字） */
     zrnp11keta                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保険料（１１桁） */
     zrnknkimnyuuryukj                                  GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）今回未入理由（漢字） */
     zrnjikaiminyuuji                                   GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）次回未入時 */
     zrntntusygyouhaiinfo                               GRAPHIC     (4)                                                       NOT NULL  ,  /* （連携用）担当者業廃情報 */
     zrnhrkkeirobtjhmidasi                              GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）払込経路別情報見出し */
     zrnhrkkeirobtjh                                    GRAPHIC     (60)                                                      NOT NULL  ,  /* （連携用）払込経路別情報 */
     zrnhknsyuruimei                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）保険種類名 */
     zrnbkofccd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）バックオフィスコード */
     zrndbskyoteiymd                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）ＤＢ削除予定年月 */
     zrnyobiv23                                         CHAR        (23)                                                      NOT NULL     /* （連携用）予備項目Ｖ２３ */
)
;

ALTER TABLE ZT_YuseiMinyuKykDtlSyokaiRn_Z ADD CONSTRAINT PK_YuseiMinyuKykDtlSyokaiRn PRIMARY KEY (
     zrnsakuseiym                                             , /* （連携用）作成年月 */
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrntntusycd                                              , /* （連携用）担当者コード */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
