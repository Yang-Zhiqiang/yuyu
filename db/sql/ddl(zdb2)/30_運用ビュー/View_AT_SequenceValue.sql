CREATE VIEW AT_SequenceValue AS SELECT
     id ,         /* ＩＤ */
     keys ,         /* キー */
     currentValue ,         /* 現在値 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_SequenceValue_Z;