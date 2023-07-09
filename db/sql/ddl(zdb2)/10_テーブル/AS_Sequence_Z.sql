CREATE TABLE AS_Sequence_Z (
     id                                                 VARCHAR     (100)                                                     NOT NULL  ,  /* ＩＤ */
     name                                               VARCHAR     (202)                                                     NOT NULL  ,  /* 名前 */
     startWith                                          DECIMAL     (18)                                                      NOT NULL  ,  /* 初期値 */
     increase                                           DECIMAL     (9)                                                       NOT NULL  ,  /* 増分値 */
     maxValue                                           DECIMAL     (18)                                                      NOT NULL  ,  /* 最大値 */
     cacheSize                                          DECIMAL     (3)                                                       NOT NULL  ,  /* キャッシュサイズ */
     padding                                            VARCHAR     (1)                                                       NOT NULL  ,  /* ゼロパディング有無 */
     length                                             DECIMAL     (2)                                                       NOT NULL  ,  /* 桁数 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_Sequence_Z ADD CONSTRAINT AS_SequencePk PRIMARY KEY (
     id                                                         /* ＩＤ */
) ;
