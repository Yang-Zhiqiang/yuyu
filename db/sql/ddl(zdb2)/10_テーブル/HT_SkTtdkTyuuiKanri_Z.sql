CREATE TABLE HT_SkTtdkTyuuiKanri_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     skeittdkkinkyuyouhikbn                             VARCHAR     (1)                                                                 ,  /* 新契約手続緊急要否区分 */
     skeittdktyuuiyouhikbn                              VARCHAR     (1)                                                                 ,  /* 新契約手続注意要否区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SkTtdkTyuuiKanri_Z ADD CONSTRAINT PK_SkTtdkTyuuiKanri PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
