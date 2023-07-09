CREATE VIEW BM_YoteiRirituRendouSeigyo AS SELECT
     yoteirirituhanteidfrom ,         /* 予定利率作成判定日（自） */
     yoteirirituhanteidto ,         /* 予定利率作成判定日（至） */
     syouhncd ,         /* 商品コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_YoteiRirituRendouSeigyo_Z;