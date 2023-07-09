CREATE TABLE AT_SequenceValue_Z (
     id                                                 VARCHAR     (100)                                                     NOT NULL  ,  /* ＩＤ */
     keys                                               VARCHAR     (100)                                                     NOT NULL  ,  /* キー */
     currentValue                                       DECIMAL     (18)                                                      NOT NULL  ,  /* 現在値 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_SequenceValue_Z ADD CONSTRAINT AT_SequenceValuePk PRIMARY KEY (
     id                                                       , /* ＩＤ */
     keys                                                       /* キー */
) ;
