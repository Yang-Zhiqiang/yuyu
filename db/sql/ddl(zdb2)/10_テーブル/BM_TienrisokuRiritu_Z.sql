CREATE TABLE BM_TienrisokuRiritu_Z (
     tekiyoukknfrom                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（自） */
     tekiyoukknkto                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（至） */
     tienrisokuriritu                                   DECIMAL     (5,4)                                                               ,  /* 遅延利息利率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_TienrisokuRiritu_Z ADD CONSTRAINT PK_TienrisokuRiritu PRIMARY KEY (
     tekiyoukknfrom                                           , /* 適用期間（自） */
     tekiyoukknkto                                              /* 適用期間（至） */
) ;
