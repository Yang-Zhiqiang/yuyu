CREATE TABLE ZT_IdouTyousyoRn_Z (
     zrnsubsystemid                                     CHAR        (50)                                                      NOT NULL  ,  /* （連携用）サブシステムＩＤ */
     zrnsequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （連携用）シーケンス番号 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnkacd                                            CHAR        (3)                                                       NOT NULL  ,  /* （連携用）課コード */
     zrntantocd                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）担当コード */
     zrnsyorisosikicd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）処理組織コード */
     zrnshrtysysyuruicd                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）支払調書種類コード */
     zrnsyoritaisyoukbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）処理対象区分 */
     zrnbaitaiskshunoriyuukbn1                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）媒体作成不能理由区分１ */
     zrnbaitaiskshunoriyuukbn2                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）媒体作成不能理由区分２ */
     zrnbaitaiskshunoriyuukbn3                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）媒体作成不能理由区分３ */
     zrnbaitaiskshunoriyuukbn4                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）媒体作成不能理由区分４ */
     zrnbaitaiskshunoriyuukbn5                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）媒体作成不能理由区分５ */
     zrnshrtysyjyuusyocd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）支払調書住所コード */
     zrnshrtysyjyuusyo                                  GRAPHIC     (62)                                                      NOT NULL  ,  /* （連携用）支払調書住所 */
     zrnkyknmkj35                                       GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（３５桁） */
     zrnyobiv3                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３ */
     zrnyobiv25                                         CHAR        (25)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２５ */
     zrnoldkykadrcd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）旧契約者住所コード */
     zrnkjoldkykadr                                     GRAPHIC     (62)                                                      NOT NULL  ,  /* （連携用）漢字旧契約者住所 */
     zrnkjoldkyknm35                                    GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）漢字旧契約者名（３５桁） */
     zrnyobiv3x2                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３＿２ */
     zrnyobiv25x1                                       CHAR        (25)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２５＿１ */
     zrnhhknnmkj                                        GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnyobiv3x3                                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ３＿３ */
     zrnyobiv17                                         CHAR        (17)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１７ */
     zrnkyksibouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者死亡年月日 */
     zrnkouryokuhasseiymd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）効力発生日 */
     zrnkyksiboumeihensyoriymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約者死亡名義変更処理年月日 */
     zrnyobiv8                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８ */
     zrnyobiv8x2                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８＿２ */
     zrnyobiv8x3                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８＿３ */
     zrnyobiv8x4                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８＿４ */
     zrnkyksibouhyoukagk                                DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）契約者死亡評価額 */
     zrnkihrkmp                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）既払込保険料 */
     zrnoldkykkihrkmpyouhyj                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）旧契約者既払込保険料要表示 */
     zrnoldkykkihrkmp                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）旧契約者既払込保険料 */
     zrnyobin11                                         DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4                                       DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿４ */
     zrnsakuseiymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）作成日 */
     zrnhuho2kykdisp                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）普保Ⅱ契約表示 */
     zrnshrtysyhknsyukbn                                GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）支払調書保険種類区分 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrntekiyouranhensyuukbn1                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）摘要欄編集区分１ */
     zrntekiyouranhensyuukbn2                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）摘要欄編集区分２ */
     zrntekiyouranhensyuukbn3                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）摘要欄編集区分３ */
     zrntekiyouranhensyuukbn4                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）摘要欄編集区分４ */
     zrntekiyouranhensyuukbn5                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）摘要欄編集区分５ */
     zrnyobiv116                                        CHAR        (116)                                                     NOT NULL     /* （連携用）予備項目Ｖ１１６ */
)
;

ALTER TABLE ZT_IdouTyousyoRn_Z ADD CONSTRAINT PK_IdouTyousyoRn PRIMARY KEY (
     zrnsequenceno                                              /* （連携用）シーケンス番号 */
) ;
