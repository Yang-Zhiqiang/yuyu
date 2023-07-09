CREATE VIEW AS_BatchHeisouList AS SELECT
     selfKinouId ,         /* 自機能ＩＤ */
     targetKinouId ,         /* 対象機能ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_BatchHeisouList_Z;