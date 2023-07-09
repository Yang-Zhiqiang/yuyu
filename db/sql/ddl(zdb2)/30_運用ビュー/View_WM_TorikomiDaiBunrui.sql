CREATE VIEW WM_TorikomiDaiBunrui AS SELECT
     syzkDaiBunruiId ,         /* 所属大分類ＩＤ */
     syzkDaiBunruiNm ,         /* 所属大分類名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WM_TorikomiDaiBunrui_Z;