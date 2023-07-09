CREATE VIEW AT_FileSansyoKaisu AS SELECT
     uniqueId ,         /* ユニークＩＤ */
     sansyoucount ,         /* 参照回数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_FileSansyoKaisu_Z;