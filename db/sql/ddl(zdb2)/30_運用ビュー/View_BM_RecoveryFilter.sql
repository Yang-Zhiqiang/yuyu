CREATE VIEW BM_RecoveryFilter AS SELECT
     recoveryfilterid ,         /* リカバリフィルタＩＤ */
     recoveryfilternm ,         /* リカバリフィルタ名 */
     recoveryfilterkeykmid1 ,         /* リカバリフィルタキー項目ＩＤ１ */
     recoveryfilterkeykmid2 ,         /* リカバリフィルタキー項目ＩＤ２ */
     recoveryfilterkeykmid3 ,         /* リカバリフィルタキー項目ＩＤ３ */
     recoveryfilterkeykmid4 ,         /* リカバリフィルタキー項目ＩＤ４ */
     recoveryfilterkeykmid5 ,         /* リカバリフィルタキー項目ＩＤ５ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_RecoveryFilter_Z;