CREATE TABLE ZT_SyainMeiboRn_Z (
     zrnhokenkbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険区分 */
     zrnsyainmeibokbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）社員名簿用区分 */
     zrnkyksyaskinmeino                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）契約者索引名番号 */
     zrnsyainnm                                         CHAR        (41)                                                      NOT NULL  ,  /* （連携用）社員名 */
     zrnkanjisyainnm                                    GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）漢字社員名 */
     zrnsyainseiymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）社員生年月日 */
     zrntsinkihontikucd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通信先基本地区コード */
     zrnkanjitsinkaiadr                                 GRAPHIC     (62)                                                      NOT NULL  ,  /* （連携用）漢字通信先下位住所 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhrkkeirokbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路区分 */
     zrntksyuannaikykkbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）特殊案内契約区分 */
     zrnsouhuhunoukbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）送付不能区分 */
     zrnsyainmeibos                                     DECIMAL     (13)                                                      NOT NULL  ,  /* （連携用）社員名簿用Ｓ */
     zrnsyainmeibop                                     DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）社員名簿用Ｐ */
     zrnsyainmeibosyouyop                               DECIMAL     (11)                                                      NOT NULL  ,  /* （連携用）社員名簿用賞与払Ｐ */
     zrnyofuritysytzumihyouji                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）預振抽出済表示 */
     zrnnayosekihontikucd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）名寄せ用基本地区コード */
     zrnyobiv10                                         CHAR        (10)                                                      NOT NULL     /* （連携用）予備項目Ｖ１０ */
)
;

ALTER TABLE ZT_SyainMeiboRn_Z ADD CONSTRAINT PK_SyainMeiboRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
