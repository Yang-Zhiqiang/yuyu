CREATE TABLE WT_KengenSyorui_Z (
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード */
     torikomiSyoruiCd                                   VARCHAR     (30)                                                      NOT NULL  ,  /* 取込書類コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE WT_KengenSyorui_Z ADD CONSTRAINT PK_KengenSyorui PRIMARY KEY (
     roleCd                                                   , /* ロールコード */
     torikomiSyoruiCd                                           /* 取込書類コード */
) ;
