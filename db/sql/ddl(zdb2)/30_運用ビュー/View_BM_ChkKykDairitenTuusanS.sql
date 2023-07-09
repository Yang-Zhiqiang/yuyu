CREATE VIEW BM_ChkKykDairitenTuusanS AS SELECT
     kihonssyuruikbn ,         /* 基本Ｓ種類区分 */
     gnds ,         /* 限度Ｓ */
     gnds$ ,         /* 限度Ｓ(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkKykDairitenTuusanS_Z;