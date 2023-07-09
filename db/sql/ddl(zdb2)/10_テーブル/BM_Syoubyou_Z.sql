CREATE TABLE BM_Syoubyou_Z (
     syoubyoucd                                         VARCHAR     (6)                                                       NOT NULL  ,  /* 傷病コード */
     syoubyounm                                         VARCHAR     (62)                                                                ,  /* 傷病名 */
     syoubyoucdtyuubunruikbn                            VARCHAR     (2)                                                                 ,  /* 傷病コード中分類区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_Syoubyou_Z ADD CONSTRAINT PK_Syoubyou PRIMARY KEY (
     syoubyoucd                                                 /* 傷病コード */
) ;
