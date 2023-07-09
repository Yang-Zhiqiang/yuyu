CREATE VIEW WT_TaskSummary AS SELECT
     flowId ,         /* フローＩＤ */
     iwfTskId ,         /* IWFタスクＩＤ */
     tokenId ,         /* トークンＩＤ */
     flowName ,         /* フロー名 */
     iwfTskNm ,         /* IWFタスク名 */
     taskCreateTime ,         /* タスク生成時間 */
     taskStartTime ,         /* タスク開始時間 */
     taskEndTime ,         /* タスク終了時間 */
     actorId ,         /* アクターＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WT_TaskSummary_Z;