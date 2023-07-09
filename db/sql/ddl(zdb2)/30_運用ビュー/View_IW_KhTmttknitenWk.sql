CREATE VIEW IW_KhTmttknitenWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     tmttknitenkbn ,         /* 積立金移転区分 */
     uktkkigenymd ,         /* 受付期限日 */
     tmttknitenymd ,         /* 積立金移転日 */
     syoruiukeymd ,         /* 書類受付日 */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     hassoukbn ,         /* 発送区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhTmttknitenWk_Z;