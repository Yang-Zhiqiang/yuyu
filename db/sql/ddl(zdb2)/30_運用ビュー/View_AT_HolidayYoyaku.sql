CREATE VIEW AT_HolidayYoyaku AS SELECT
     holidayGroupCd ,         /* 休日グループコード */
     holidayCd ,         /* 休日コード */
     legalHolidayKbn ,         /* 法定休日区分 */
     tekiyouYmdFrom ,         /* 適用年月日（自） */
     tekiyouYmdTo ,         /* 適用年月日（至） */
     holidayPattern ,         /* 休日パターン */
     holidayPatternParam ,         /* 休日パターンパラメータ */
     holidayPatternNm ,         /* 休日パターン名 */
     holidayPatternDescription ,         /* 休日パターン備考 */
     yoyakuKbn ,         /* 予約区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AT_HolidayYoyaku_Z;