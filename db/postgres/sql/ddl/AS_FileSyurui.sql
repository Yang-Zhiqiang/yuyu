CREATE TABLE AS_FileSyurui (
     fileSyuruiCd                                       varchar     (3)                                                       NOT NULL  ,  /* ファイル種類コード                                     */
     fileSyuruiNm                                       varchar     (100)                                                               ,  /* ファイル種類名                                       */
     fileSyuruiKbn                                      varchar     (1)                                                                 ,  /* ファイル種類区分                                      */
     fileNmPattern                                      varchar     (100)                                                               ,  /* ファイル名パターン                                     */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_FileSyurui ADD CONSTRAINT AS_FileSyuruiPk PRIMARY KEY (
     fileSyuruiCd                                               /* ファイル種類コード                                      */
) ;
