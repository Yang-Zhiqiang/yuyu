CREATE TABLE BW_UserIdKanrenWk_Z (
     idkbn                                              VARCHAR     (2)                                                       NOT NULL  ,  /* ＩＤ区分 */
     idcd                                               VARCHAR     (6)                                                       NOT NULL  ,  /* ＩＤコード */
     userId                                             VARCHAR     (30)                                                                ,  /* ユーザーＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BW_UserIdKanrenWk_Z ADD CONSTRAINT PK_UserIdKanrenWk PRIMARY KEY (
     idkbn                                                    , /* ＩＤ区分 */
     idcd                                                       /* ＩＤコード */
) ;

CREATE INDEX IX1_UserIdKanrenWk ON BW_UserIdKanrenWk_Z (
     userId                                                     /* ユーザーＩＤ */
) ;
