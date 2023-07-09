CREATE VIEW HT_GaibuQrYoyaku AS SELECT
     syoriYmd ,         /* 処理年月日 */
     skeijimukbn ,         /* 新契約事務区分 */
     hknsyuruino ,         /* 保険種類番号 */
     sakuseikensuu ,         /* 作成件数 */
     qrsakuseiymd ,         /* ＱＲ作成日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_GaibuQrYoyaku_Z;