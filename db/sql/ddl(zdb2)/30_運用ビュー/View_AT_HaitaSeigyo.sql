CREATE VIEW AT_HaitaSeigyo AS SELECT
     haitaSyuruiCd ,         /* 排他種類コード */
     haitaKey ,         /* 排他キー */
     haitamotoKinouId ,         /* 排他元機能ＩＤ */
     haitaUserId ,         /* 排他ユーザーＩＤ */
     haitaKaisiTime ,         /* 排他開始時間 */
     haitaUniqueKey ,         /* 排他ユニークキー */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_HaitaSeigyo_Z;