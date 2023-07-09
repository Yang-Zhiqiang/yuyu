CREATE VIEW AT_RinjiKadouTaisyoSosiki AS SELECT
     kadouSosikiCd ,         /* 稼働組織コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_RinjiKadouTaisyoSosiki_Z;