CREATE TABLE AS_FileSyurui_Z (
     fileSyuruiCd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* ファイル種類コード */
     fileSyuruiNm                                       VARCHAR     (202)                                                               ,  /* ファイル種類名 */
     fileSyuruiKbn                                      VARCHAR     (1)                                                                 ,  /* ファイル種類区分 */
     fileNmPattern                                      VARCHAR     (250)                                                               ,  /* ファイル名パターン */
     downloadFileNm                                     VARCHAR     (100)                                                               ,  /* ダウンロードファイル名 */
     fileType                                           VARCHAR     (30)                                                                ,  /* ファイルタイプ */
     dataLayoutBeanClass                                VARCHAR     (200)                                                               ,  /* データレイアウトビーンクラス */
     createEmptyFileUmuKbn                              VARCHAR     (1)                                                                 ,  /* 空ファイル出力有無区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_FileSyurui_Z ADD CONSTRAINT AS_FileSyuruiPk PRIMARY KEY (
     fileSyuruiCd                                               /* ファイル種類コード */
) ;
