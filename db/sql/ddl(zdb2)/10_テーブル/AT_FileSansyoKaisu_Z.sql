CREATE TABLE AT_FileSansyoKaisu_Z (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     sansyoucount                                       DECIMAL     (2)                                                                 ,  /* 参照回数 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_FileSansyoKaisu_Z ADD CONSTRAINT AT_FileSansyoKaisuPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;

CREATE UNIQUE INDEX AT_FileSansyoKaisuUIdx1 ON AT_FileSansyoKaisu_Z (
     uniqueId                                                 , /* ユニークＩＤ */
     sansyoucount                                               /* 参照回数 */
) ;
