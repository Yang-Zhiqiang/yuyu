CREATE VIEW IW_KhJyuusyoHenkouWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     dai2tsintelno ,         /* 第２通信先電話番号 */
     shsnmkj ,         /* 送付先氏名（漢字） */
     shskyno ,         /* 送付先郵便番号 */
     shsadr1kj ,         /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj ,         /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj ,         /* 送付先住所３（漢字）（３０桁） */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     tyhysakuseiyhkbn ,         /* 帳票作成要否区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhJyuusyoHenkouWk_Z;