CREATE TABLE ZT_SyoukenTkListShTy_Z (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztyatesakitantnm                                   VARCHAR     (42)                                                                ,  /* （中継用）宛先担当室名(組織名) */
     ztyhozonkkn                                        VARCHAR     (10)                                                                ,  /* （中継用）保存期間 */
     ztytyouhyouymdwa                                   VARCHAR     (24)                                                                ,  /* （中継用）帳票作成日（和暦） */
     ztyyobiv26                                         VARCHAR     (26)                                                                ,  /* （中継用）予備項目Ｖ２６ */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztykyknmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）契約者名（漢字） */
     ztyhhknnmkj                                        VARCHAR     (32)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztysyorinm                                         VARCHAR     (42)                                                                ,  /* （中継用）処理名(機能名) */
     ztysyorisyouninsyacd                               VARCHAR     (6)                                                                 ,  /* （中継用）処理承認者コード */
     ztysyorisyouninsyanm                               VARCHAR     (32)                                                                ,  /* （中継用）処理承認者名 */
     ztyjigosagyounaiyo1                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１ */
     ztyjigosagyounaiyo2                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容２ */
     ztyjigosagyounaiyo3                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容３ */
     ztyjigosagyounaiyo4                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容４ */
     ztyjigosagyounaiyo5                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容５ */
     ztyjigosagyounaiyo6                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容６ */
     ztyjigosagyounaiyo7                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容７ */
     ztyjigosagyounaiyo8                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容８ */
     ztyjigosagyounaiyo9                                VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容９ */
     ztyjigosagyounaiyo10                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１０ */
     ztyjigosagyounaiyo11                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１１ */
     ztyjigosagyounaiyo12                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１２ */
     ztyjigosagyounaiyo13                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１３ */
     ztyjigosagyounaiyo14                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１４ */
     ztyjigosagyounaiyo15                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１５ */
     ztyjigosagyounaiyo16                               VARCHAR     (34)                                                                ,  /* （中継用）事後作業内容１６ */
     ztyyobiv31                                         VARCHAR     (31)                                                                ,  /* （中継用）予備項目Ｖ３１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SyoukenTkListShTy_Z ADD CONSTRAINT PK_SyoukenTkListShTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
