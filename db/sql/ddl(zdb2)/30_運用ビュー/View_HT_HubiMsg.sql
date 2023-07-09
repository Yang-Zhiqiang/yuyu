CREATE VIEW HT_HubiMsg AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     messageId ,         /* メッセージＩＤ */
     hubimsg ,         /* 不備メッセージ */
     hubisyubetukbn ,         /* 不備種別区分 */
     hubisyubetusyousaikbn ,         /* 不備種別詳細区分 */
     hituyousyoruicd ,         /* 必要書類コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_HubiMsg_Z;