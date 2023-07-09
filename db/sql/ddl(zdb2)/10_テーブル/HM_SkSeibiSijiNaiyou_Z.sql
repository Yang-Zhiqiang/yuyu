CREATE TABLE HM_SkSeibiSijiNaiyou_Z (
     skseibisijinaiyoucd                                VARCHAR     (2)                                                       NOT NULL  ,  /* 新契約整備指示内容コード */
     skseibisijinaiyou                                  VARCHAR     (162)                                                               ,  /* 新契約整備指示内容 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hyoujijyun                                         DECIMAL     (2)                                                                    /* 表示順 */
)
;

ALTER TABLE HM_SkSeibiSijiNaiyou_Z ADD CONSTRAINT PK_SkSeibiSijiNaiyou PRIMARY KEY (
     skseibisijinaiyoucd                                        /* 新契約整備指示内容コード */
) ;
