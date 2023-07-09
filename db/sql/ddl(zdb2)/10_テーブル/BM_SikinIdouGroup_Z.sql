CREATE TABLE BM_SikinIdouGroup_Z (
     segcd                                              VARCHAR     (20)                                                      NOT NULL  ,  /* セグメントコード */
     sikinidougroupkbn                                  VARCHAR     (2)                                                                 ,  /* 資金移動グループ区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_SikinIdouGroup_Z ADD CONSTRAINT PK_SikinIdouGroup PRIMARY KEY (
     segcd                                                      /* セグメントコード */
) ;
