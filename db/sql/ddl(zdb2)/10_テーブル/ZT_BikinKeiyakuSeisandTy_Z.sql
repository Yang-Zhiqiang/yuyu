CREATE TABLE ZT_BikinKeiyakuSeisandTy_Z (
     ztysequenceno                                      DECIMAL     (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              DECIMAL     (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztybikinkbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）備金区分 */
     ztybikinnendokbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）備金年度区分 */
     ztyseisand                                         DECIMAL     (11)                                                                ,  /* （中継用）精算Ｄ */
     ztytumitaterisoku                                  DECIMAL     (11)                                                                ,  /* （中継用）積立利息 */
     ztysyuruicd1                                       VARCHAR     (1)                                                                 ,  /* （中継用）種類コード１ */
     ztysyuruicd3                                       VARCHAR     (2)                                                                 ,  /* （中継用）種類コード３ */
     ztysrkijyunym                                      VARCHAR     (6)                                                                 ,  /* （中継用）数理用基準年月 */
     ztykbnkeiriyousegmentkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用セグメント区分 */
     ztykbnkeiriyourgnbnskkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用利源分析区分 */
     ztysyuruicd2                                       VARCHAR     (1)                                                                 ,  /* （中継用）種類コード２ */
     ztykariwariatedganrikin                            DECIMAL     (11)                                                                ,  /* （中継用）仮割当Ｄ元利金 */
     ztykariwariatedrisoku                              DECIMAL     (11)                                                                ,  /* （中継用）仮割当Ｄ利息 */
     ztysyukeiyakusyuruicdv2                            VARCHAR     (2)                                                                 ,  /* （中継用）主契約種類コードＶ２ */
     ztykeiyakunendo                                    VARCHAR     (4)                                                                 ,  /* （中継用）契約年度 */
     ztydaihyouyoteiriritu                              DECIMAL     (5,4)                                                               ,  /* （中継用）代表予定利率 */
     ztyharaikatakbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）払方区分 */
     ztyyobiv32                                         VARCHAR     (32)                                                                ,  /* （中継用）予備項目Ｖ３２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_BikinKeiyakuSeisandTy_Z ADD CONSTRAINT PK_BikinKeiyakuSeisandTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
