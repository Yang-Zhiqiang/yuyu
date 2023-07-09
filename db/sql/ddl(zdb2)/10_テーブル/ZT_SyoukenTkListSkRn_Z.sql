CREATE TABLE ZT_SyoukenTkListSkRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrnatesakitantnm                                   GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）宛先担当室名(組織名) */
     zrnhozonkkn                                        GRAPHIC     (4)                                                       NOT NULL  ,  /* （連携用）保存期間 */
     zrntyouhyouymdwa                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（和暦） */
     zrnsagyoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）作業区分 */
     zrnyobiv25                                         CHAR        (25)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ２５ */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhhknnmkj                                        GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrntksysyorinaiyou1                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容１ */
     zrntksysyorinaiyou2                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容２ */
     zrntksysyorinaiyou3                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容３ */
     zrntksysyorinaiyou4                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容４ */
     zrntksysyorinaiyou5                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容５ */
     zrntksysyorinaiyou6                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容６ */
     zrntksysyorinaiyou7                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容７ */
     zrntksysyorinaiyou8                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容８ */
     zrntksysyorinaiyou9                                GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容９ */
     zrntksysyorinaiyou10                               GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容１０ */
     zrntksysyorinaiyou11                               GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容１１ */
     zrntksysyorinaiyou12                               GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容１２ */
     zrntksysyorinaiyou13                               GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容１３ */
     zrntksysyorinaiyou14                               GRAPHIC     (10)                                                      NOT NULL  ,  /* （連携用）特殊処理内容１４ */
     zrnbikouupside                                     GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）備考上段 */
     zrnbikoudownside                                   GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）備考下段 */
     zrnyobiv37                                         CHAR        (37)                                                      NOT NULL     /* （連携用）予備項目Ｖ３７ */
)
;

ALTER TABLE ZT_SyoukenTkListSkRn_Z ADD CONSTRAINT PK_SyoukenTkListSkRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
