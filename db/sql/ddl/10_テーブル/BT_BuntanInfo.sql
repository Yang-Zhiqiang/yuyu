CREATE TABLE BT_BuntanInfo (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     dairitensyouhincd                                  VARCHAR     (5)                                                       NOT NULL  ,  /* 代理店商品コード */
     tesuuryoubuntandrtencd                             VARCHAR     (7)                                                       NOT NULL  ,  /* 手数料分担相手代理店コード */
     tesuuryoubuntanstartym                             VARCHAR     (6)                                                       NOT NULL  ,  /* 手数料分担開始年月 */
     tesuuryoubuntanendym                               VARCHAR     (6)                                                                 ,  /* 手数料分担終了年月 */
     tesuuryoubuntanwariai                              NUMBER      (3)                                                                 ,  /* 手数料分担割合 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_BuntanInfo ADD CONSTRAINT PK_BuntanInfo PRIMARY KEY (
     drtencd                                                  , /* 代理店コード */
     dairitensyouhincd                                        , /* 代理店商品コード */
     tesuuryoubuntandrtencd                                   , /* 手数料分担相手代理店コード */
     tesuuryoubuntanstartym                                     /* 手数料分担開始年月 */
) ;

CREATE INDEX IX1_BuntanInfo ON BT_BuntanInfo (
     drtencd                                                  , /* 代理店コード */
     dairitensyouhincd                                        , /* 代理店商品コード */
     tesuuryoubuntanstartym                                     /* 手数料分担開始年月 */
) ;
