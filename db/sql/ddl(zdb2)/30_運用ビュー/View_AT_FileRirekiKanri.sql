CREATE VIEW AT_FileRirekiKanri AS SELECT
     historyId ,         /* 履歴ＩＤ */
     hozonHousiki ,         /* 保存方式 */
     hozonSaki ,         /* 保存先 */
     namingPattern ,         /* ネーミングパターン */
     rirekiSakujyoJyouken ,         /* 履歴削除条件 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_FileRirekiKanri_Z;