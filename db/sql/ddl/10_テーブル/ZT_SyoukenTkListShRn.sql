CREATE TABLE ZT_SyoukenTkListShRn (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrnatesakitantnm                                   VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）宛先担当室名(組織名) */
     zrnhozonkkn                                        VARCHAR     (4)                                                       NOT NULL  ,  /* （連携用）保存期間 */
     zrntyouhyouymdwa                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（和暦） */
     zrnyobiv26                                         CHAR        (26)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２６ */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkyknmkj                                         VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字） */
     zrnhhknnmkj                                        VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnsyorinm                                         VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）処理名(機能名) */
     zrnsyorisyouninsyacd                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）処理承認者コード */
     zrnsyorisyouninsyanm                               VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）処理承認者名 */
     zrnjigosagyounaiyo1                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１ */
     zrnjigosagyounaiyo2                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容２ */
     zrnjigosagyounaiyo3                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容３ */
     zrnjigosagyounaiyo4                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容４ */
     zrnjigosagyounaiyo5                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容５ */
     zrnjigosagyounaiyo6                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容６ */
     zrnjigosagyounaiyo7                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容７ */
     zrnjigosagyounaiyo8                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容８ */
     zrnjigosagyounaiyo9                                VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容９ */
     zrnjigosagyounaiyo10                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１０ */
     zrnjigosagyounaiyo11                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１１ */
     zrnjigosagyounaiyo12                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１２ */
     zrnjigosagyounaiyo13                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１３ */
     zrnjigosagyounaiyo14                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１４ */
     zrnjigosagyounaiyo15                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１５ */
     zrnjigosagyounaiyo16                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１６ */
     zrnyobiv31                                         CHAR        (31)                                                      NOT NULL     /* （連携用）予備項目Ｖ３１ */
)
;

ALTER TABLE ZT_SyoukenTkListShRn ADD CONSTRAINT PK_SyoukenTkListShRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
