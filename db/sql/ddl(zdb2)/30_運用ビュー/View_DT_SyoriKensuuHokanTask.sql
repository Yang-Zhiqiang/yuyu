CREATE VIEW DT_SyoriKensuuHokanTask AS SELECT
     kensuuHokanYmd ,         /* 件数保管日 */
     jimutetuzukicd ,         /* 事務手続コード */
     tskid ,         /* タスクＩＤ */
     accountId ,         /* アカウントＩＤ */
     zenjituzanKensuu ,         /* 前日残件数 */
     zanKensuu ,         /* 残件数 */
     kanryoKensuu ,         /* 完了件数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM DT_SyoriKensuuHokanTask_Z;