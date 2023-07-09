CREATE VIEW AT_AppIdentifier AS SELECT
     identifier ,         /* 識別子 */
     touchTime ,         /* タッチ時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_AppIdentifier_Z;