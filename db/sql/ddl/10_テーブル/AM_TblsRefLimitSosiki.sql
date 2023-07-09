CREATE TABLE AM_TblsRefLimitSosiki (
     baseTableId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* （ベース）テーブルID */
     baseDdId                                           VARCHAR     (50)                                                      NOT NULL  ,  /* （ベース）項目ID */
     tanmatusettisosikicd                               VARCHAR     (7)                                                       NOT NULL  ,  /* 端末設置組織コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AM_TblsRefLimitSosiki ADD CONSTRAINT AM_TblsLimitRefSosikiPk PRIMARY KEY (
     baseTableId                                              , /* （ベース）テーブルID */
     baseDdId                                                 , /* （ベース）項目ID */
     tanmatusettisosikicd                                       /* 端末設置組織コード */
) ;
