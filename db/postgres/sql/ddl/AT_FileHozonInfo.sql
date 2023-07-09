CREATE TABLE AT_FileHozonInfo (
     uniqueId                                           varchar     (100)                                                     NOT NULL  ,  /* ユニークID                                        */
     fileNm                                             varchar     (100)                                                               ,  /* ファイル名                                         */
     fileSyuruiCd                                       varchar     (3)                                                                 ,  /* ファイル種類コード                                     */
     fileStatusKbn                                      varchar     (1)                                                                 ,  /* ファイルステータス区分                                   */
     haitaKey                                           varchar     (200)                                                               ,  /* 排他キー                                          */
     tourokuTime                                        varchar     (20)                                                                ,  /* 登録時間                                          */
     sakuseiKinouId                                     varchar     (50)                                                                ,  /* 作成機能ID                                        */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AT_FileHozonInfo ADD CONSTRAINT AT_FileHozonInfoPk PRIMARY KEY (
     uniqueId                                                   /* ユニークID                                         */
) ;
