CREATE VIEW AM_Batch AS SELECT
     kinouId ,         /* 機能ＩＤ */
     batchClass ,         /* バッチクラス */
     paramBeanClass ,         /* パラメータビーンクラス */
     tajuukidouKahiKbn ,         /* 多重起動可否区分 */
     batchMode ,         /* バッチ起動モード */
     tyuudanKahi ,         /* 中断可否 */
     onlineHeisouKahiKbn ,         /* オンライン並走可否区分 */
     batchHeisouKbn ,         /* バッチ並走区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_Batch_Z;