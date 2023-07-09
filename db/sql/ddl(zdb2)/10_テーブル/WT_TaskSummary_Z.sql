CREATE TABLE WT_TaskSummary_Z (
     flowId                                             VARCHAR     (19)                                                      NOT NULL  ,  /* フローＩＤ */
     iwfTskId                                           VARCHAR     (50)                                                      NOT NULL  ,  /* IWFタスクＩＤ */
     tokenId                                            VARCHAR     (19)                                                      NOT NULL  ,  /* トークンＩＤ */
     flowName                                           VARCHAR     (10000)                                                             ,  /* フロー名 */
     iwfTskNm                                           VARCHAR     (25)                                                                ,  /* IWFタスク名 */
     taskCreateTime                                     VARCHAR     (23)                                                      NOT NULL  ,  /* タスク生成時間 */
     taskStartTime                                      VARCHAR     (23)                                                                ,  /* タスク開始時間 */
     taskEndTime                                        VARCHAR     (23)                                                                ,  /* タスク終了時間 */
     actorId                                            VARCHAR     (255)                                                               ,  /* アクターＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE WT_TaskSummary_Z ADD CONSTRAINT PK_TaskSummary PRIMARY KEY (
     flowId                                                   , /* フローＩＤ */
     iwfTskId                                                 , /* IWFタスクＩＤ */
     tokenId                                                  , /* トークンＩＤ */
     taskCreateTime                                             /* タスク生成時間 */
) ;
