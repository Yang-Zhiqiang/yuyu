CREATE TABLE AS_FileHozonKikan_Z (
     fileSyuruiCd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* ファイル種類コード */
     hozonKikan                                         DECIMAL     (2)                                                                 ,  /* 保存期間 */
     nengappiKbn                                        VARCHAR     (1)                                                                 ,  /* 年月日区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_FileHozonKikan_Z ADD CONSTRAINT AS_FileHozonKikanPk PRIMARY KEY (
     fileSyuruiCd                                               /* ファイル種類コード */
) ;
