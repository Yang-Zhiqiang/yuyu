CREATE VIEW BT_HituyouSyoruiKanri AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syoruiCd ,         /* 書類コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_HituyouSyoruiKanri_Z;