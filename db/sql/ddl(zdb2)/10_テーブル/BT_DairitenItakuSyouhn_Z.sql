CREATE TABLE BT_DairitenItakuSyouhn_Z (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     drtsyouhinsikibetukbnstr                           VARCHAR     (2)                                                       NOT NULL  ,  /* 代理店商品識別区分（文字列） */
     drthrkhouhoukbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 代理店払込方法区分 */
     drtplannmkbn                                       VARCHAR     (2)                                                       NOT NULL  ,  /* 代理店プラン名区分 */
     itakuhknhnbkaisiymd                                VARCHAR     (8)                                                       NOT NULL  ,  /* 委託保険販売開始年月日 */
     itakuhknhnbsyuuryouymd                             VARCHAR     (8)                                                                 ,  /* 委託保険販売終了年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_DairitenItakuSyouhn_Z ADD CONSTRAINT PK_DairitenItakuSyouhn PRIMARY KEY (
     drtencd                                                  , /* 代理店コード */
     drtsyouhinsikibetukbnstr                                 , /* 代理店商品識別区分（文字列） */
     drthrkhouhoukbn                                          , /* 代理店払込方法区分 */
     drtplannmkbn                                             , /* 代理店プラン名区分 */
     itakuhknhnbkaisiymd                                        /* 委託保険販売開始年月日 */
) ;
