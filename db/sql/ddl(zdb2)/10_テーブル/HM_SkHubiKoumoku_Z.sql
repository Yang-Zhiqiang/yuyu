CREATE TABLE HM_SkHubiKoumoku_Z (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     skhubikoumokucd                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 新契約不備項目コード */
     skhubikoumoku                                      VARCHAR     (62)                                                                ,  /* 新契約不備項目 */
     hyoujijyun                                         DECIMAL     (2)                                                                 ,  /* 表示順 */
     hyoujikahikbn                                      VARCHAR     (1)                                                                 ,  /* 表示可否区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HM_SkHubiKoumoku_Z ADD CONSTRAINT PK_SkHubiKoumoku PRIMARY KEY (
     syoruiCd                                                 , /* 書類コード */
     skhubikoumokucd                                            /* 新契約不備項目コード */
) ;
