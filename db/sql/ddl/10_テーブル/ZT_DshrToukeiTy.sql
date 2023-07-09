CREATE TABLE ZT_DshrToukeiTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              NUMBER      (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztymisskbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）ミス区分 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztydshrym                                          VARCHAR     (6)                                                                 ,  /* （中継用）Ｄ支払年月 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztysrsyoumetucd                                    VARCHAR     (4)                                                                 ,  /* （中継用）数理用消滅コード */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztykeiyakunendo                                    VARCHAR     (4)                                                                 ,  /* （中継用）契約年度 */
     ztyannaikigetu                                     VARCHAR     (2)                                                                 ,  /* （中継用）案内期月 */
     ztyshrriyuukbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）支払理由区分 */
     ztyannaikbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）案内区分 */
     ztyduketorihouhoukbn                               VARCHAR     (1)                                                                 ,  /* （中継用）Ｄ受取方法区分 */
     ztybikinhyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）備金表示 */
     ztyskskbn                                          VARCHAR     (1)                                                                 ,  /* （中継用）作成区分 */
     ztysegcd                                           VARCHAR     (4)                                                                 ,  /* （中継用）セグメントコード */
     ztyyobiv3                                          VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３ */
     ztysrkensuu                                        NUMBER      (7)                                                                 ,  /* （中継用）数理用件数 */
     ztysrhsys                                          NUMBER      (15)                                                                ,  /* （中継用）数理用保障Ｓ */
     ztytoujigyounendod                                 NUMBER      (13)                                                                ,  /* （中継用）当事業年度Ｄ */
     ztytoujigyounendohasseidrsk                        NUMBER      (13)                                                                ,  /* （中継用）当事業年度発生Ｄ利息 */
     ztyzenjigyounendomatudzndk                         NUMBER      (13)                                                                ,  /* （中継用）前事業年度末Ｄ残高 */
     ztyyokujigyounendod                                NUMBER      (13)                                                                ,  /* （中継用）翌事業年度Ｄ */
     ztyhushrtoujigyounendod                            NUMBER      (13)                                                                ,  /* （中継用）不支払当事業年度Ｄ */
     ztysyukeiyakusyuruicdv2                            VARCHAR     (2)                                                                 ,  /* （中継用）主契約種類コードＶ２ */
     ztydaihyouyoteiriritu                              NUMBER      (5,4)                                                               ,  /* （中継用）代表予定利率 */
     ztyharaikatakbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）払方区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_DshrToukeiTy ADD CONSTRAINT PK_DshrToukeiTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
