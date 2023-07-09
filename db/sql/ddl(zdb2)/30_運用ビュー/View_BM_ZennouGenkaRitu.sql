CREATE VIEW BM_ZennouGenkaRitu AS SELECT
     zennounensuu ,         /* 前納年数 */
     tekiyoukknfrom ,         /* 適用期間（自） */
     tekiyoukknkto ,         /* 適用期間（至） */
     zennougenkaritu ,         /* 前納現価率 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ZennouGenkaRitu_Z;