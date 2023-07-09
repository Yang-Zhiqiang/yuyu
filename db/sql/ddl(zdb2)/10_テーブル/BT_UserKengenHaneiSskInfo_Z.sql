CREATE TABLE BT_UserKengenHaneiSskInfo_Z (
     sosikicdkami3                                      VARCHAR     (3)                                                       NOT NULL  ,  /* 組織コード上３桁 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_UserKengenHaneiSskInfo_Z ADD CONSTRAINT PK_UserKengenHaneiSskInfo PRIMARY KEY (
     sosikicdkami3                                              /* 組織コード上３桁 */
) ;
