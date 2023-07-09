CREATE VIEW WM_TorikomiSyouBunrui AS SELECT
     syzkSyouBunruiId ,         /* 所属小分類ＩＤ */
     syzkSyouBunruiNm ,         /* 所属小分類名 */
     syzkDaiBunruiId ,         /* 所属大分類ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WM_TorikomiSyouBunrui_Z;