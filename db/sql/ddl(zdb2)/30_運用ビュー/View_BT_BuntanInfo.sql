CREATE VIEW BT_BuntanInfo AS SELECT
     drtencd ,         /* 代理店コード */
     dairitensyouhincd ,         /* 代理店商品コード */
     tesuuryoubuntandrtencd ,         /* 手数料分担相手代理店コード */
     tesuuryoubuntanstartym ,         /* 手数料分担開始年月 */
     tesuuryoubuntanendym ,         /* 手数料分担終了年月 */
     tesuuryoubuntanwariai ,         /* 手数料分担割合 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_BuntanInfo_Z;