CREATE VIEW IW_KhSiteidairiTokuyakuWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     stdruktkbn ,         /* 指定代理受取人区分 */
     stdrsknmkn ,         /* 指定代理請求人名（カナ） */
     stdrsknmkj ,         /* 指定代理請求人名（漢字） */
     stdrsknmkjhukakbn ,         /* 指定代理請求人名漢字化不可区分 */
     shsnmkj ,         /* 送付先氏名（漢字） */
     shskyno ,         /* 送付先郵便番号 */
     shsadr1kj ,         /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj ,         /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj ,         /* 送付先住所３（漢字）（３０桁） */
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
FROM IW_KhSiteidairiTokuyakuWk_Z;