CREATE TABLE ZT_JinsokuShrTtdkInfoRn_Z (
     zrnsyorisosikicd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）処理組織コード */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrnhknknshrsntkno                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険金支払処理選択番号 */
     zrnsyoruiukeymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）書類受付日 */
     zrnsyoriymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理年月日 */
     zrndenymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）伝票日付 */
     zrnsyoruikeikaeigyoubisuu                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）書類受付経過営業日数 */
     zrnsyorikeikaeigyoubisuu                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）処理経過営業日数 */
     zrntoritugisosikicd                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）取次組織コード */
     zrntanmatusyuruikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）端末種類区分 */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkeiyakuymd                                      CHAR        (8)                                                       NOT NULL    /* （連携用）契約日 */
)
;

ALTER TABLE ZT_JinsokuShrTtdkInfoRn_Z ADD CONSTRAINT PK_JinsokuShrTtdkInfoRn PRIMARY KEY (
     zrnsyorisosikicd                                         , /* （連携用）処理組織コード */
     zrnsyoricd                                               , /* （連携用）処理コード */
     zrnhknknshrsntkno                                        , /* （連携用）保険金支払処理選択番号 */
     zrnsyoruiukeymd                                          , /* （連携用）書類受付日 */
     zrnsyoriymd                                              , /* （連携用）処理年月日 */
     zrndenymd                                                , /* （連携用）伝票日付 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
