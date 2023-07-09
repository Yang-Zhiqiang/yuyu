CREATE VIEW AT_KadouTimeGroup AS SELECT
     kadouTimeGroupCd ,         /* 稼働時間グループコード */
     kadouTimeGroupNm ,         /* 稼働時間グループ名 */
     kadouTimeGroupDescription ,         /* 稼働時間グループ備考 */
     holidayGroupCd ,         /* 休日グループコード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_KadouTimeGroup_Z;