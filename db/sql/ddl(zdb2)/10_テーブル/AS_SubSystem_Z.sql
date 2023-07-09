CREATE TABLE AS_SubSystem_Z (
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     subSystemNm                                        VARCHAR     (102)                                                               ,  /* サブシステム名 */
     sortNo                                             DECIMAL     (3)                                                                 ,  /* ソート番号 */
     linkImage                                          VARCHAR     (100)                                                               ,  /* リンクイメージ */
     hyoudaiImage                                       VARCHAR     (100)                                                               ,  /* 表題イメージ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_SubSystem_Z ADD CONSTRAINT AS_SubSystemPk PRIMARY KEY (
     subSystemId                                                /* サブシステムＩＤ */
) ;
