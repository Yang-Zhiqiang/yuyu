CREATE TABLE ZT_GinkouMdhnMisyuuInfoFTy_Z (
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztyyobiv63                                         VARCHAR     (63)                                                                ,  /* （中継用）予備項目Ｖ６３ */
     ztydatakbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）データ区分 */
     ztydatasakuseiymd                                  VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）データ作成日 */
     ztyhknkaisyacd                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険会社コード */
     ztyhknsyuruicd                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類コード */
     ztysyonosyuban                                     VARCHAR     (12)                                                      NOT NULL  ,  /* （中継用）証券番号主番 */
     ztysyonoedaban                                     VARCHAR     (5)                                                                 ,  /* （中継用）証券番号枝番 */
     ztymisyuutatekaekbn                                VARCHAR     (1)                                                                 ,  /* （中継用）未収立替区分 */
     ztymisyuutatekaeym                                 VARCHAR     (6)                                                                 ,  /* （中継用）未収立替発生年月 */
     ztymisyuukg                                        VARCHAR     (10)                                                                ,  /* （中継用）未収金額 */
     ztybnkaisuu                                        VARCHAR     (2)                                                                 ,  /* （中継用）分割回数 */
     ztymisyuujiyuu                                     VARCHAR     (2)                                                                 ,  /* （中継用）未収事由 */
     ztyjikaidatakousinymd                              VARCHAR     (8)                                                                 ,  /* （中継用）次回データ更新日 */
     ztyikkatubaraikbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu                               VARCHAR     (2)                                                                 ,  /* （中継用）一括払回数 */
     ztyyobiv28                                         VARCHAR     (28)                                                                ,  /* （中継用）予備項目Ｖ２８ */
     ztykosyaareav40                                    VARCHAR     (40)                                                                ,  /* （中継用）個社領域Ｖ４０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_GinkouMdhnMisyuuInfoFTy_Z ADD CONSTRAINT PK_GinkouMdhnMisyuuInfoFTy PRIMARY KEY (
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztydatasakuseiymd                                        , /* （中継用）データ作成日 */
     ztysyonosyuban                                             /* （中継用）証券番号主番 */
) ;
