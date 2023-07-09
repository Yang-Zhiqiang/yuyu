CREATE TABLE AM_Batch_Z (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     batchClass                                         VARCHAR     (200)                                                     NOT NULL  ,  /* バッチクラス */
     paramBeanClass                                     VARCHAR     (200)                                                               ,  /* パラメータビーンクラス */
     tajuukidouKahiKbn                                  VARCHAR     (1)                                                       NOT NULL  ,  /* 多重起動可否区分 */
     batchMode                                          VARCHAR     (1)                                                       NOT NULL  ,  /* バッチ起動モード */
     tyuudanKahi                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 中断可否 */
     onlineHeisouKahiKbn                                VARCHAR     (1)                                                                 ,  /* オンライン並走可否区分 */
     batchHeisouKbn                                     VARCHAR     (1)                                                                 ,  /* バッチ並走区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_Batch_Z ADD CONSTRAINT AM_BatchPk PRIMARY KEY (
     kinouId                                                    /* 機能ＩＤ */
) ;
