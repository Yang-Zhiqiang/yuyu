CREATE TABLE ZT_SyoukenTkListShRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrnatesakitantnm                                   GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）宛先担当室名(組織名) */
     zrnhozonkkn                                        GRAPHIC     (4)                                                       NOT NULL  ,  /* （連携用）保存期間 */
     zrntyouhyouymdwa                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（和暦） */
     zrnyobiv26                                         CHAR        (26)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２６ */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkyknmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字） */
     zrnhhknnmkj                                        GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnsyorinm                                         GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）処理名(機能名) */
     zrnsyorisyouninsyacd                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）処理承認者コード */
     zrnsyorisyouninsyanm                               GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）処理承認者名 */
     zrnjigosagyounaiyo1                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１ */
     zrnjigosagyounaiyo2                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容２ */
     zrnjigosagyounaiyo3                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容３ */
     zrnjigosagyounaiyo4                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容４ */
     zrnjigosagyounaiyo5                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容５ */
     zrnjigosagyounaiyo6                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容６ */
     zrnjigosagyounaiyo7                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容７ */
     zrnjigosagyounaiyo8                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容８ */
     zrnjigosagyounaiyo9                                GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容９ */
     zrnjigosagyounaiyo10                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１０ */
     zrnjigosagyounaiyo11                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１１ */
     zrnjigosagyounaiyo12                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１２ */
     zrnjigosagyounaiyo13                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１３ */
     zrnjigosagyounaiyo14                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１４ */
     zrnjigosagyounaiyo15                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１５ */
     zrnjigosagyounaiyo16                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）事後作業内容１６ */
     zrnyobiv31                                         CHAR        (31)                                                      NOT NULL     /* （連携用）予備項目Ｖ３１ */
)
;

ALTER TABLE ZT_SyoukenTkListShRn_Z ADD CONSTRAINT PK_SyoukenTkListShRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
