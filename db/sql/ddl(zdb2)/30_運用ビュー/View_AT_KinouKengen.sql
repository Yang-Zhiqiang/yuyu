CREATE VIEW AT_KinouKengen AS SELECT
     kinouId ,         /* 機能ＩＤ */
     kinouModeId ,         /* 機能モードＩＤ */
     roleCd ,         /* ロールコード */
     siborikomiId ,         /* 絞込みＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_KinouKengen_Z;