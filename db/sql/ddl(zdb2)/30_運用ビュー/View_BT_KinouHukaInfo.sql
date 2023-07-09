CREATE VIEW BT_KinouHukaInfo AS SELECT
     kinouId ,         /* 機能ＩＤ */
     tjttrkskahi ,         /* 当日取消可否 */
     kensuuhyoujijyun ,         /* 件数表示順 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_KinouHukaInfo_Z;