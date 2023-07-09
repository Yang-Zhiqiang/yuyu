CREATE VIEW BM_ChkNenkinSaiteiS AS SELECT
     nenkinkkn ,         /* 年金期間 */
     nenkinsyu ,         /* 年金種類 */
     saiteis ,         /* 最低Ｓ */
     saiteis$ ,         /* 最低Ｓ(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkNenkinSaiteiS_Z;