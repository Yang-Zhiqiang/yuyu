CREATE VIEW IW_KhNkShrTokuyakuHenkouWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     nkshrtkykhnkkbn ,         /* 年金支払特約変更区分 */
     nkshrtkyknksyukbn ,         /* 年金支払特約年金種類区分 */
     nkshrtkyknksyukkn ,         /* 年金支払特約年金期間 */
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
FROM IW_KhNkShrTokuyakuHenkouWk_Z;