CREATE VIEW BM_TienrisokuRiritu AS SELECT
     tekiyoukknfrom ,         /* 適用期間（自） */
     tekiyoukknkto ,         /* 適用期間（至） */
     tienrisokuriritu ,         /* 遅延利息利率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_TienrisokuRiritu_Z;