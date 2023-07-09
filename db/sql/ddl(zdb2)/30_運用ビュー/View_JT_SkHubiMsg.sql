CREATE VIEW JT_SkHubiMsg AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     renno3keta ,         /* 連番（３桁） */
     uketukeno ,         /* 受付番号 */
     msgsyubetu ,         /* メッセージ種別 */
     hubimsgid ,         /* 不備メッセージＩＤ */
     hubimsg ,         /* 不備メッセージ */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SkHubiMsg_Z;