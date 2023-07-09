CREATE TABLE AM_TblsTarget_Z (
     baseTableId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* （ベース）テーブルID */
     baseTableNm                                        VARCHAR     (402)                                                               ,  /* （ベース）テーブル名 */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_TblsTarget_Z ADD CONSTRAINT AM_searchTablePk PRIMARY KEY (
     baseTableId                                                /* （ベース）テーブルID */
) ;
