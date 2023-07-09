CREATE TABLE BM_ChkNenkinSaiteiS_Z (
     nenkinkkn                                          DECIMAL     (2)                                                       NOT NULL  ,  /* 年金期間 */
     nenkinsyu                                          VARCHAR     (4)                                                       NOT NULL  ,  /* 年金種類 */
     saiteis                                            DECIMAL     (13)                                                                ,  /* 最低Ｓ */
     saiteis$                                           VARCHAR     (10)                                                                ,  /* 最低Ｓ(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkNenkinSaiteiS_Z ADD CONSTRAINT PK_ChkNenkinSaiteiS PRIMARY KEY (
     nenkinkkn                                                , /* 年金期間 */
     nenkinsyu                                                  /* 年金種類 */
) ;
