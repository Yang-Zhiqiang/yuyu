CREATE VIEW BM_Kouin AS SELECT
     kinyuucd ,         /* 金融機関コード */
     kouincd ,         /* 行員コード */
     bosyuucd ,         /* 募集人コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Kouin_Z;