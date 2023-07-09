CREATE TABLE AT_HolidayYoyaku_Z (
     holidayGroupCd                                     VARCHAR     (20)                                                      NOT NULL  ,  /* 休日グループコード */
     holidayCd                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 休日コード */
     legalHolidayKbn                                    VARCHAR     (1)                                                                 ,  /* 法定休日区分 */
     tekiyouYmdFrom                                     VARCHAR     (8)                                                                 ,  /* 適用年月日（自） */
     tekiyouYmdTo                                       VARCHAR     (8)                                                                 ,  /* 適用年月日（至） */
     holidayPattern                                     VARCHAR     (20)                                                                ,  /* 休日パターン */
     holidayPatternParam                                VARCHAR     (20)                                                                ,  /* 休日パターンパラメータ */
     holidayPatternNm                                   VARCHAR     (42)                                                                ,  /* 休日パターン名 */
     holidayPatternDescription                          VARCHAR     (202)                                                               ,  /* 休日パターン備考 */
     yoyakuKbn                                          VARCHAR     (1)                                                                 ,  /* 予約区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_HolidayYoyaku_Z ADD CONSTRAINT AT_HolidayYoyakuPk PRIMARY KEY (
     holidayGroupCd                                           , /* 休日グループコード */
     holidayCd                                                  /* 休日コード */
) ;
