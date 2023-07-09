CREATE VIEW BM_HaitouRiritu AS SELECT
     kijyunfromymd ,         /* 基準日自 */
     kijyuntoymd ,         /* 基準日至 */
     haitouriritu ,         /* 配当利率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_HaitouRiritu_Z;