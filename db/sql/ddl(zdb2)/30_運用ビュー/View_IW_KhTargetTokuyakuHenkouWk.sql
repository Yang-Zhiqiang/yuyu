CREATE VIEW IW_KhTargetTokuyakuHenkouWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     targettkykkykhenkoymd ,         /* ターゲット特約契約変更日 */
     targettkykhnkkbn ,         /* ターゲット特約変更区分 */
     targettkmokuhyouti ,         /* ターゲット特約目標値 */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     hassoukbn ,         /* 発送区分 */
     kanryotuutioutkbn ,         /* 完了通知出力区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhTargetTokuyakuHenkouWk_Z;