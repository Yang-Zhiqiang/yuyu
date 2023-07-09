CREATE TABLE ZT_SeirituInfoRn_Z (
     zrnkijyunym                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）基準年月 */
     zrnseisekiym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）成績計上年月 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhanbainm                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）販売名称 */
     zrnatkisisya                                       CHAR        (3)                                                       NOT NULL  ,  /* （連携用）扱支社 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnsdpdkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｓ建Ｐ建区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrnsinkykryouritukbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）新契約用料率区分 */
     zrnduketorihouhoukbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｄ受取方法区分 */
     zrnkihons9                                         DECIMAL     (9)                                                       NOT NULL  ,  /* （連携用）基本Ｓ（９桁） */
     zrnhsys                                            DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）保障Ｓ */
     zrntkbriknsnhrkp                                   DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）月払換算払込Ｐ */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnkyksyaseikbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者性別区分 */
     zrnhhknnen2keta                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年令（２桁） */
     zrnkyksyanen                                       CHAR        (2)                                                       NOT NULL  ,  /* （連携用）契約者年令 */
     zrnsykgycd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）職業コード */
     zrnkyksyakikykarihyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者既契約有表示 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnsyokaipnyuukinhouhoukbn                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初回Ｐ入金方法区分 */
     zrntoukeiyousinsakbn                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）統計用診査区分 */
     zrnhhknsynensyuukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者年収区分 */
     zrnsyukeiyakup                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）主契約Ｐ */
     zrnbsudirtnatkikeitaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集代理店扱形態区分 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnstdairiseikyuutkykarihyj                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）指定代理請求特約有表示 */
     zrnmannenreihyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）満年令表示 */
     zrnnksyuruikbn1                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年金種類区分（１文字） */
     zrnnstkarihyj                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年金支払特約有表示 */
     zrnaatkioybsydrtencd                               CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者親募集代理店コード */
     zrnbatkioybsydrtencd                               CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ｂ扱者親募集代理店コード */
     zrnsinkeiyakujiyoteiriritu                         DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）新契約時予定利率 */
     zrnsiteituukakihons                                DECIMAL     (13,2)                                                    NOT NULL  ,  /* （連携用）指定通貨建基本Ｓ */
     zrnhrktuukakbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込通貨区分 */
     zrnsiteituukakbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）指定通貨区分 */
     zrnhrktuukatukiknznhrkp                            DECIMAL     (13,2)                                                    NOT NULL  ,  /* （連携用）払込通貨建月換算払込Ｐ */
     zrnsiteituukatukiknznhrkp                          DECIMAL     (13,2)                                                    NOT NULL  ,  /* （連携用）指定通貨建月換算払込Ｐ */
     zrnyennyknrate                                     DECIMAL     (7,4)                                                     NOT NULL  ,  /* （連携用）円入金レート */
     zrngaikanyknrate                                   DECIMAL     (7,4)                                                     NOT NULL  ,  /* （連携用）外貨入金レート */
     zrnjyudkaigomehrtkarihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）重度介護前払特約有表示 */
     zrnsyksbyensitihsyutkykrate                        DECIMAL     (7,4)                                                     NOT NULL  ,  /* （連携用）初期死亡時円換算最低保証特約用為替レート */
     zrnsjkkktyouseiriritu                              DECIMAL     (5,4)                                                     NOT NULL  ,  /* （連携用）市場価格調整用利率 */
     zrntargettkmkht                                    DECIMAL     (3)                                                       NOT NULL  ,  /* （連携用）ターゲット特約目標値 */
     zrnteirituhaibunwari                               CHAR        (3)                                                       NOT NULL  ,  /* （連携用）定率部分配分割合 */
     zrnzenkizennouhyouji                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）全期前納表示 */
     zrnpwaribikikbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ割引区分 */
     zrnpwaribikihanteigk                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）Ｐ割引判定金額 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnkykdrtkykarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約者代理特約有表示 */
     zrnkzktrkservicetrkninzuu                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ご家族登録サービス登録人数 */
     zrnteikisiharaiarihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）定期支払特約有表示 */
     zrnyobiv6                                          CHAR        (6)                                                       NOT NULL     /* （連携用）予備項目Ｖ６ */
)
;

ALTER TABLE ZT_SeirituInfoRn_Z ADD CONSTRAINT PK_SeirituInfoRn PRIMARY KEY (
     zrnkijyunym                                              , /* （連携用）基準年月 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
