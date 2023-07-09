CREATE VIEW AS_Sequence AS SELECT
     id ,         /* ＩＤ */
     name ,         /* 名前 */
     startWith ,         /* 初期値 */
     increase ,         /* 増分値 */
     maxValue ,         /* 最大値 */
     cacheSize ,         /* キャッシュサイズ */
     padding ,         /* ゼロパディング有無 */
     length ,         /* 桁数 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AS_Sequence_Z;