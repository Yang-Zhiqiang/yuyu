CREATE VIEW AS_KinouModeSiborikomi AS SELECT
     kinouId ,         /* 機能ＩＤ */
     kinouModeId ,         /* 機能モードＩＤ */
     siborikomiId ,         /* 絞込みＩＤ */
     siborikomiNm ,         /* 絞込み名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_KinouModeSiborikomi_Z;