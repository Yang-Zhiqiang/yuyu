CREATE TABLE ZT_SinninTouhyouRn (
     zrnhokenkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険区分 */
     zrnkyknaiyoukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約内容区分 */
     zrnhokenkbnnys                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険区分（名寄せ） */
     zrnsakuinmeinonys                                  CHAR        (10)                                                      NOT NULL  ,  /* （連携用）索引名番号（名寄せ） */
     zrnsyainnm                                         CHAR        (41)                                                      NOT NULL  ,  /* （連携用）社員名 */
     zrnkanjisyainnm                                    VARCHAR     (35)                                                      NOT NULL  ,  /* （連携用）漢字社員名 */
     zrnsyainseiymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）社員生年月日 */
     zrntsinkihontikucd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通信先基本地区コード */
     zrnkanjitsinkaiadr                                 VARCHAR     (62)                                                      NOT NULL  ,  /* （連携用）漢字通信先下位住所 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrntksyuannaikykkbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特殊案内契約区分 */
     zrnsouhuhunoukbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）送付不能区分 */
     zrnnaimitureigaihyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）内密例外表示 */
     zrnsyuukinsisya                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）集金支社 */
     zrnsyuukintntusycd                                 CHAR        (6)                                                       NOT NULL  ,  /* （連携用）集金担当者個人コード */
     zrnokyakusamano                                    CHAR        (10)                                                      NOT NULL  ,  /* （連携用）お客様番号 */
     zrnnaibukojincd                                    CHAR        (6)                                                       NOT NULL  ,  /* （連携用）内部個人コード */
     zrnhokenkbnsyainno                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険区分（社員ＮＯ） */
     zrnsakuinmeinosyainno                              CHAR        (10)                                                      NOT NULL  ,  /* （連携用）索引名番号（社員ＮＯ） */
     zrnbsyym                                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集年月 */
     zrnprivacyhogoyouhyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）プライバシー保護要表示 */
     zrnkaigaitokoukykhyj                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）海外渡航契約表示 */
     zrnnaibukbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）内部区分 */
     zrnkyktsnatkitkyktrkjtkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約通算扱特約登録状態区分 */
     zrnalcardhkkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＡＬカード発行区分 */
     zrnbsydrtenkbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集代理店区分 */
     zrnvitkaiinno                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）Ｖｉｔ会員番号 */
     zrnyobiv60                                         CHAR        (60)                                                      NOT NULL     /* （連携用）予備項目Ｖ６０ */
)
;

ALTER TABLE ZT_SinninTouhyouRn ADD CONSTRAINT PK_SinninTouhyouRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
