CREATE VIEW DT_SyoriKensuuHokanJimu AS SELECT
     kensuuHokanYmd ,         /* 件数保管日 */
     jimutetuzukicd ,         /* 事務手続コード */
     accountId ,         /* アカウントＩＤ */
     zenjituzanKensuu ,         /* 前日残件数 */
     zanKensuu ,         /* 残件数 */
     kanryoKensuu ,         /* 完了件数 */
     taskKanryouKensuuarihyouji ,         /* タスク完了件数有表示 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM DT_SyoriKensuuHokanJimu_Z;