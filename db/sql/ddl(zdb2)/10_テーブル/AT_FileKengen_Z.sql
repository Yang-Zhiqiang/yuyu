CREATE TABLE AT_FileKengen_Z (
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード */
     fileSyuruiCd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* ファイル種類コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_FileKengen_Z ADD CONSTRAINT AT_FileKengenPk PRIMARY KEY (
     roleCd                                                   , /* ロールコード */
     fileSyuruiCd                                               /* ファイル種類コード */
) ;
