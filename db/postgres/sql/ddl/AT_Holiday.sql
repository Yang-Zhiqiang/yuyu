CREATE TABLE AT_Holiday (
     holidayGroupCd                                     varchar     (20)                                                      NOT NULL  ,  /* 休日グループコード                                     */
     holidayCd                                          varchar     (20)                                                      NOT NULL  ,  /* 休日コード                                         */
     legalHolidayKbn                                    decimal     (1)                                                                 ,  /* 法定休日区分                                        */
     tekiyouYmdFrom                                     varchar     (8)                                                                 ,  /* 適用年月日（自）                                      */
     tekiyouYmdTo                                       varchar     (8)                                                                 ,  /* 適用年月日（至）                                      */
     holidayPattern                                     varchar     (20)                                                                ,  /* 休日パターン                                        */
     holidayPatternParam                                varchar     (20)                                                                ,  /* 休日パターンパラメータ                                   */
     holidayPatternNm                                   varchar     (40)                                                                ,  /* 休日パターン名                                       */
     holidayPatternDescription                          varchar     (200)                                                               ,  /* 休日パターン備考                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_Holiday ADD CONSTRAINT AT_HolidayPk PRIMARY KEY (
     holidayGroupCd                                           , /* 休日グループコード                                      */
     holidayCd                                                  /* 休日コード                                          */
) ;
