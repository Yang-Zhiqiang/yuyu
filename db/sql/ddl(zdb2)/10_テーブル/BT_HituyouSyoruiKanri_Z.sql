CREATE TABLE BT_HituyouSyoruiKanri_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_HituyouSyoruiKanri_Z ADD CONSTRAINT PK_HituyouSyoruiKanri PRIMARY KEY (
     kouteikanriid                                            , /* 工程管理ＩＤ */
     syoruiCd                                                   /* 書類コード */
) ;
