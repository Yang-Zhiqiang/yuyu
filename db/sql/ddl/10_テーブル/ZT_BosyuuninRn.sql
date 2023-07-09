CREATE TABLE ZT_BosyuuninRn (
     zrnbosyuunincd                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）募集人コード */
     zrnbosyuuninnm                                     CHAR        (20)                                                      NOT NULL  ,  /* （連携用）募集人名 */
     zrnkanjibosyuuninnm                                VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字募集人名 */
     zrnitakuymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）委託年月日 */
     zrndairitencd1                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード（１） */
     zrndairitencd2                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード（２） */
     zrndairitencd3                                     CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店コード（３） */
     zrndairitenkanrisskcd1                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店管理組織コード（１） */
     zrndairitenkanrisskcd2                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店管理組織コード（２） */
     zrndairitenkanrisskcd3                             CHAR        (7)                                                       NOT NULL  ,  /* （連携用）代理店管理組織コード（３） */
     zrnbosyuukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集人区分 */
     zrnbosyuunintourokuymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）募集人登録年月日 */
     zrnbosyuuninkahikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集可否区分 */
     zrnbosyuuningyouhaiymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）募集人業廃年月日 */
     zrnhengakutourokuymd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）変額保険資格登録年月日 */
     zrnhengakumassyouymd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）変額保険資格登録抹消年月日 */
     zrnbosyuuseiymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）募集人生年月日 */
     zrnitakukaiyakuymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）委託解約日 */
     zrndaihyoubosyuunincd                              CHAR        (6)                                                       NOT NULL  ,  /* （連携用）代表募集人コード */
     zrnbosyuutourokuno                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）募集人登録番号 */
     zrnyobiv5                                          CHAR        (5)                                                       NOT NULL     /* （連携用）予備項目Ｖ５ */
)
;

ALTER TABLE ZT_BosyuuninRn ADD CONSTRAINT PK_BosyuuninRn PRIMARY KEY (
     zrnbosyuunincd                                             /* （連携用）募集人コード */
) ;
