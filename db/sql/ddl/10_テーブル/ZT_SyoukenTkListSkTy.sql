CREATE TABLE ZT_SyoukenTkListSkTy (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztyatesakitantnm                                   VARCHAR     (20)                                                                ,  /* （中継用）宛先担当室名(組織名) */
     ztyhozonkkn                                        VARCHAR     (4)                                                                 ,  /* （中継用）保存期間 */
     ztytyouhyouymdwa                                   VARCHAR     (11)                                                                ,  /* （中継用）帳票作成日（和暦） */
     ztysagyoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）作業区分 */
     ztyyobiv25                                         VARCHAR     (25)                                                                ,  /* （中継用）予備項目Ｖ２５ */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhhknnmkj                                        VARCHAR     (15)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztytksysyorinaiyou1                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容１ */
     ztytksysyorinaiyou2                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容２ */
     ztytksysyorinaiyou3                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容３ */
     ztytksysyorinaiyou4                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容４ */
     ztytksysyorinaiyou5                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容５ */
     ztytksysyorinaiyou6                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容６ */
     ztytksysyorinaiyou7                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容７ */
     ztytksysyorinaiyou8                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容８ */
     ztytksysyorinaiyou9                                VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容９ */
     ztytksysyorinaiyou10                               VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容１０ */
     ztytksysyorinaiyou11                               VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容１１ */
     ztytksysyorinaiyou12                               VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容１２ */
     ztytksysyorinaiyou13                               VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容１３ */
     ztytksysyorinaiyou14                               VARCHAR     (10)                                                                ,  /* （中継用）特殊処理内容１４ */
     ztybikouupside                                     VARCHAR     (8)                                                                 ,  /* （中継用）備考上段 */
     ztybikoudownside                                   VARCHAR     (8)                                                                 ,  /* （中継用）備考下段 */
     ztyyobiv37                                         VARCHAR     (37)                                                                ,  /* （中継用）予備項目Ｖ３７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SyoukenTkListSkTy ADD CONSTRAINT PK_SyoukenTkListSkTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
