CREATE TABLE AM_TblsSearchPattern_Z (
     baseTableId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* （ベース）テーブルID */
     baseSearchDdId                                     VARCHAR     (50)                                                      NOT NULL  ,  /* （ベース）検索項目ID */
     baseSearchPtnNm                                    VARCHAR     (62)                                                      NOT NULL  ,  /* （ベース）検索パターン名 */
     sortNo                                             DECIMAL     (3)                                                                 ,  /* ソート番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_TblsSearchPattern_Z ADD CONSTRAINT AM_searchPatternPk PRIMARY KEY (
     baseTableId                                              , /* （ベース）テーブルID */
     baseSearchDdId                                           , /* （ベース）検索項目ID */
     baseSearchPtnNm                                            /* （ベース）検索パターン名 */
) ;
