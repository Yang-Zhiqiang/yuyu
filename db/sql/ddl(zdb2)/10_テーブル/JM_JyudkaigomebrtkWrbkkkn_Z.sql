CREATE TABLE JM_JyudkaigomebrtkWrbkkkn_Z (
     hhknnen                                            DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢 */
     seibetu                                            VARCHAR     (1)                                                       NOT NULL  ,  /* 性別 */
     waribikikikan                                      DECIMAL     (6,3)                                                               ,  /* 割引期間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JM_JyudkaigomebrtkWrbkkkn_Z ADD CONSTRAINT PK_JyudkaigomebrtkWrbkkkn PRIMARY KEY (
     hhknnen                                                  , /* 被保険者年齢 */
     seibetu                                                    /* 性別 */
) ;
