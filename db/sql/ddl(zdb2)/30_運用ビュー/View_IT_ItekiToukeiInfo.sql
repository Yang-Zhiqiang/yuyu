CREATE VIEW IT_ItekiToukeiInfo AS SELECT
     syono ,         /* 証券番号 */
     ketkekkacd ,         /* 決定結果コード */
     palketsyacd ,         /* ＰＡＬ決定者コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_ItekiToukeiInfo_Z;