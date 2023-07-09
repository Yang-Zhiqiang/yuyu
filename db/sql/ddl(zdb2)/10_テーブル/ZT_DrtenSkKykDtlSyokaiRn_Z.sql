CREATE TABLE ZT_DrtenSkKykDtlSyokaiRn_Z (
     zrnsakuseiym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）作成年月 */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrntntusycd                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）担当者コード */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkykymwareki4keta                                CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年月（和暦）（４桁） */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnatesakinm                                       GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）宛先名 */
     zrnhassinka                                        GRAPHIC     (31)                                                      NOT NULL  ,  /* （連携用）発信課 */
     zrntelno15keta                                     GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）電話番号（１５桁） */
     zrnbsyymwareki4keta                                CHAR        (4)                                                       NOT NULL  ,  /* （連携用）募集年月（和暦）（４桁） */
     zrntntusynm                                        GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）担当者名 */
     zrnkydatkikbnkj                                    GRAPHIC     (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分（漢字） */
     zrnkyknmkj20                                       GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（２０桁） */
     zrnskymdwareki                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）失効年月日（和暦） */
     zrnhrkkaisuukj                                     GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）払込回数（漢字） */
     zrnhrkkeirokj                                      GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）払込経路（漢字） */
     zrnp11keta                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保険料（１１桁） */
     zrnskhr                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）失効時返戻金 */
     zrnjizensyoukaiyouhyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）事前照会要表示 */
     zrntntusygyouhaiinfo                               GRAPHIC     (4)                                                       NOT NULL  ,  /* （連携用）担当者業廃情報 */
     zrnhrkkeirobtjhmidasi                              GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）払込経路別情報見出し */
     zrnhrkkeirobtjh                                    GRAPHIC     (60)                                                      NOT NULL  ,  /* （連携用）払込経路別情報 */
     zrnhknsyuruimei                                    GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）保険種類名 */
     zrnbkofccd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）バックオフィスコード */
     zrndbskyoteiymd                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）ＤＢ削除予定年月 */
     zrnminyukaisuu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）未入回数 */
     zrnjikaipjyuutouym                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）次回Ｐ充当年月 */
     zrnvitkaiinno                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）Ｖｉｔ会員番号 */
     zrnvitkykym                                        CHAR        (4)                                                       NOT NULL  ,  /* （連携用）Ｖｉｔ契約年月 */
     zrnvitskymd                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）Ｖｉｔ失効年月日 */
     zrnvithrkkaisuu                                    GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）Ｖｉｔ払込回数 */
     zrnvithrkkeiro                                     GRAPHIC     (3)                                                       NOT NULL  ,  /* （連携用）Ｖｉｔ払込経路 */
     zrnzkomivitriyoury                                 DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）税込Ｖｉｔ利用料 */
     zrnvitnyknkaisuu                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）Ｖｉｔ入金回数 */
     zrnvitbikou                                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）Ｖｉｔ備考 */
     zrnyobiv25                                         CHAR        (25)                                                      NOT NULL     /* （連携用）予備項目Ｖ２５ */
)
;

ALTER TABLE ZT_DrtenSkKykDtlSyokaiRn_Z ADD CONSTRAINT PK_DrtenSkKykDtlSyokaiRn PRIMARY KEY (
     zrnsakuseiym                                             , /* （連携用）作成年月 */
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrntntusycd                                              , /* （連携用）担当者コード */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
