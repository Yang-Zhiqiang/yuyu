CREATE TABLE BM_HutanpoBui_Z (
     htnpbuicd                                          VARCHAR     (3)                                                       NOT NULL  ,  /* 不担保部位コード */
     htnpbuinm                                          VARCHAR     (62)                                                                ,  /* 不担保部位名 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_HutanpoBui_Z ADD CONSTRAINT PK_HutanpoBui PRIMARY KEY (
     htnpbuicd                                                  /* 不担保部位コード */
) ;
