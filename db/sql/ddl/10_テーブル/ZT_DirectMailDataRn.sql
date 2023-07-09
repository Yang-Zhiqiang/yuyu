CREATE TABLE ZT_DirectMailDataRn (
     zrnhokenkbnnys                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険区分（名寄せ） */
     zrnsakuinmeinonys                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）索引名番号（名寄せ） */
     zrnsyainnm                                         CHAR        (41)                                                      NOT NULL  ,  /* （連携用）社員名 */
     zrnsyainseiymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）社員生年月日 */
     zrnkanjisyainnm                                    VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）漢字社員名 */
     zrntsinkihontikucd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通信先基本地区コード */
     zrnnaimitureigaihyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）内密例外表示 */
     zrndrtenhyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）代理店表示 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkanjitsinkaiadr                                 VARCHAR     (62)                                                      NOT NULL  ,  /* （連携用）漢字通信先下位住所 */
     zrnsouhuhunoukbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）送付不能区分 */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnhknnm                                           VARCHAR     (40)                                                      NOT NULL  ,  /* （連携用）保険名称 */
     zrnnenhousiki                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年齢方式 */
     zrnkzktrkarihyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ご家族登録有表示 */
     zrnaatkioybsydrtencd                               CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者親募集代理店コード */
     zrnbatkioybsydrtencd                               CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ｂ扱者親募集代理店コード */
     zrnyobiv250x1                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿１ */
     zrnyobiv250x2                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿２ */
     zrnyobiv250x3                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿３ */
     zrnyobiv250x4                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿４ */
     zrnyobiv250x5                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿５ */
     zrnyobiv250x6                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿６ */
     zrnyobiv250x7                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿７ */
     zrnyobiv250x8                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿８ */
     zrnyobiv250x9                                      CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿９ */
     zrnyobiv250x10                                     CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿１０ */
     zrnyobiv250x11                                     CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿１１ */
     zrnyobiv250x12                                     CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿１２ */
     zrnyobiv250x13                                     CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿１３ */
     zrnyobiv250x14                                     CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０＿１４ */
     zrnyobiv122                                        CHAR        (122)                                                     NOT NULL     /* （連携用）予備項目Ｖ１２２ */
)
;

ALTER TABLE ZT_DirectMailDataRn ADD CONSTRAINT PK_DirectMailDataRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
