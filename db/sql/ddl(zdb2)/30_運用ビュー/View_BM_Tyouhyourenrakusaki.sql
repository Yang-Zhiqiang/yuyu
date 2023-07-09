CREATE VIEW BM_Tyouhyourenrakusaki AS SELECT
     tyhyrenrakusikibetukbn ,         /* 帳票連絡先識別区分 */
     cctelno ,         /* コールセンター電話番号 */
     ccimagepath ,         /* コールセンター画像パス */
     sapodetelno ,         /* サポートデスク電話番号 */
     sapodeimagepath ,         /* サポートデスク画像パス */
     sapodefaxno ,         /* サポートデスクＦＡＸ番号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Tyouhyourenrakusaki_Z;