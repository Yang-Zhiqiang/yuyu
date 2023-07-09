CREATE TABLE ZT_DshrToukeiLoadingTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              NUMBER      (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztydshrym                                          VARCHAR     (6)                                                                 ,  /* （中継用）Ｄ支払年月 */
     ztykeiyakunendo                                    VARCHAR     (4)                                                                 ,  /* （中継用）契約年度 */
     ztyannaikigetu                                     VARCHAR     (2)                                                                 ,  /* （中継用）案内期月 */
     ztyhknsyruikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）保険種類区分 */
     ztysegcd                                           VARCHAR     (4)                                                                 ,  /* （中継用）セグメントコード */
     ztyshrriyuukbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）支払理由区分 */
     ztyannaikbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）案内区分 */
     ztyduketorihouhoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）Ｄ受取方法区分 */
     ztysyoumetukbn                                     VARCHAR     (2)                                                                 ,  /* （中継用）消滅区分 */
     ztybikinhyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）備金表示 */
     ztyskskbn                                          VARCHAR     (1)                                                                 ,  /* （中継用）作成区分 */
     ztysrkensuu                                        NUMBER      (7)                                                                 ,  /* （中継用）数理用件数 */
     ztysrhsys                                          NUMBER      (15)                                                                ,  /* （中継用）数理用保障Ｓ */
     ztytoujigyounendod                                 NUMBER      (13)                                                                ,  /* （中継用）当事業年度Ｄ */
     ztytoujigyounendohasseidrsk                        NUMBER      (13)                                                                ,  /* （中継用）当事業年度発生Ｄ利息 */
     ztyzenjigyounendomatudzndk                         NUMBER      (13)                                                                ,  /* （中継用）前事業年度末Ｄ残高 */
     ztyyokujigyounendod                                NUMBER      (13)                                                                ,  /* （中継用）翌事業年度Ｄ */
     ztyhushrtoujigyounendod                            NUMBER      (13)                                                                ,  /* （中継用）不支払当事業年度Ｄ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_DshrToukeiLoadingTy ADD CONSTRAINT PK_DshrToukeiLoadingTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
