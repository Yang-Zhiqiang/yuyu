CREATE VIEW AT_MyMenu AS SELECT
     userId ,         /* ユーザーＩＤ */
     subSystemId ,         /* サブシステムＩＤ */
     categoryId ,         /* カテゴリＩＤ */
     kinouId ,         /* 機能ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_MyMenu_Z;