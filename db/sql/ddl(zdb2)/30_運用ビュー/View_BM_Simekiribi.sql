CREATE VIEW BM_Simekiribi AS SELECT
     bosyuuym ,         /* 募集年月 */
     mossimefromymd ,         /* 申込締切日自 */
     mossimetoymd ,         /* 申込締切日至 */
     mosnrksimefromymd ,         /* 申込書入力締切日自 */
     mosnrksimetoymd ,         /* 申込書入力締切日至 */
     kktsimefromymd ,         /* 告知締切日自 */
     kktsimetoymd ,         /* 告知締切日至 */
     hjysimefromymd ,         /* 報状締切日自 */
     hjysimetoymd ,         /* 報状締切日至 */
     nyknsimefromymd ,         /* 入金締切日自 */
     nyknsimetoymd ,         /* 入金締切日至 */
     syorisimefromymd ,         /* 処理締切日自 */
     syorisimetoymd ,         /* 処理締切日至 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Simekiribi_Z;