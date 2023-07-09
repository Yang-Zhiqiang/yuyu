CREATE VIEW AT_HolidayGroup AS SELECT
     holidayGroupCd ,         /* 休日グループコード */
     holidayGroupNm ,         /* 休日グループ名 */
     holidayGroupDescription ,         /* 休日グループ備考 */
     sysSiyouKbn ,         /* システム使用区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_HolidayGroup_Z;