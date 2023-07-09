CREATE TABLE ZT_TmttHaitoukinMeisaiTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              NUMBER      (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyzennendokurikosid                               NUMBER      (11)                                                                ,  /* （中継用）前年度繰越Ｄ */
     ztytounendod                                       NUMBER      (11)                                                                ,  /* （中継用）当年度Ｄ */
     ztytounendomatutumitated                           NUMBER      (11)                                                                ,  /* （中継用）当年度末積立Ｄ */
     ztytumitaterisoku                                  NUMBER      (11)                                                                ,  /* （中継用）積立利息 */
     ztyhsys                                            NUMBER      (11)                                                                ,  /* （中継用）保障Ｓ */
     ztysyuruicd1                                       VARCHAR     (1)                                                                 ,  /* （中継用）種類コード１ */
     ztysyuruicd3                                       VARCHAR     (2)                                                                 ,  /* （中継用）種類コード３ */
     ztysrutiwake                                       VARCHAR     (2)                                                                 ,  /* （中継用）数理用内訳 */
     ztysrkijyunym                                      VARCHAR     (6)                                                                 ,  /* （中継用）数理用基準年月 */
     ztykbnkeiriyousegmentkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用セグメント区分 */
     ztykbnkeiriyourgnbnskkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用利源分析区分 */
     ztysyuruicd2                                       VARCHAR     (1)                                                                 ,  /* （中継用）種類コード２ */
     ztymankitouraiym                                   VARCHAR     (6)                                                                 ,  /* （中継用）満期到来年月 */
     ztysyukeiyakusyuruicdv2                            VARCHAR     (2)                                                                 ,  /* （中継用）主契約種類コードＶ２ */
     ztykeiyakunendo                                    VARCHAR     (4)                                                                 ,  /* （中継用）契約年度 */
     ztydaihyouyoteiriritu                              NUMBER      (5,4)                                                               ,  /* （中継用）代表予定利率 */
     ztyharaikatakbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）払方区分 */
     ztyyobiv20                                         VARCHAR     (20)                                                                ,  /* （中継用）予備項目Ｖ２０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_TmttHaitoukinMeisaiTy ADD CONSTRAINT PK_TmttHaitoukinMeisaiTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
