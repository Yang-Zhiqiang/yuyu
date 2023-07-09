CREATE TABLE BM_ZennouTumitateRitu (
     tekiyoukknfrom                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（自） */
     tekiyoukknkto                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 適用期間（至） */
     zennoutumitateritu                                 NUMBER      (7,6)                                                               ,  /* 前納積立率 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_ZennouTumitateRitu ADD CONSTRAINT PK_ZennouTumitateRitu PRIMARY KEY (
     tekiyoukknfrom                                           , /* 適用期間（自） */
     tekiyoukknkto                                              /* 適用期間（至） */
) ;
