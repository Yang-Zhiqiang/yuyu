CREATE TABLE AT_FileHozonInfo_Z (
     uniqueId                                           VARCHAR     (100)                                                     NOT NULL  ,  /* ユニークＩＤ */
     fileNm                                             VARCHAR     (250)                                                               ,  /* ファイル名 */
     fileSyuruiCd                                       VARCHAR     (5)                                                                 ,  /* ファイル種類コード */
     fileStatusKbn                                      VARCHAR     (1)                                                                 ,  /* ファイルステータス区分 */
     haitaKey                                           VARCHAR     (200)                                                               ,  /* 排他キー */
     tourokuTime                                        VARCHAR     (17)                                                                ,  /* 登録時間 */
     sakuseiKinouId                                     VARCHAR     (50)                                                                ,  /* 作成機能ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_FileHozonInfo_Z ADD CONSTRAINT AT_FileHozonInfoPk PRIMARY KEY (
     uniqueId                                                   /* ユニークＩＤ */
) ;

CREATE INDEX AT_FileHozonInfoIdx1 ON AT_FileHozonInfo_Z (
     fileSyuruiCd                                             , /* ファイル種類コード */
     tourokuTime                                                /* 登録時間 */
) ;
