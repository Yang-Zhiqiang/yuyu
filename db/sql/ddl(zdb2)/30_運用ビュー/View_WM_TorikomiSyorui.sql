CREATE VIEW WM_TorikomiSyorui AS SELECT
     torikomiSyoruiCd ,         /* 取込書類コード */
     torikomiSyoruiNm ,         /* 取込書類名 */
     torikomiSyoruiRyaku ,         /* 取込書類略称 */
     syzkDaiBunruiId ,         /* 所属大分類ＩＤ */
     syzkSyouBunruiId ,         /* 所属小分類ＩＤ */
     angoukaKbn ,         /* 暗号化区分 */
     angoukaHousikiKbn ,         /* 暗号化方式区分 */
     zipHozonKbn ,         /* ＺＩＰ保存区分 */
     kouteiSeigyoUmuKbn ,         /* 工程制御有無区分 */
     flowId ,         /* フローＩＤ */
     nodeId ,         /* ノードＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM WM_TorikomiSyorui_Z;