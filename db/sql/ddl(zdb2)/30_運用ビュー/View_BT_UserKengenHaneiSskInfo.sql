CREATE VIEW BT_UserKengenHaneiSskInfo AS SELECT
     sosikicdkami3 ,         /* 組織コード上３桁 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_UserKengenHaneiSskInfo_Z;