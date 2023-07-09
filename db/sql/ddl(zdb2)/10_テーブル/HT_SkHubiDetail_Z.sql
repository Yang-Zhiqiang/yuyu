CREATE TABLE HT_SkHubiDetail_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     hubisikibetukey                                    VARCHAR     (20)                                                      NOT NULL  ,  /* 不備識別キー */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     skhubikoumokucd                                    VARCHAR     (2)                                                                 ,  /* 新契約不備項目コード */
     skhubinaiyoucd                                     VARCHAR     (5)                                                                 ,  /* 新契約不備内容コード */
     skseibisijinaiyoucd                                VARCHAR     (2)                                                                 ,  /* 新契約整備指示内容コード */
     tyoubunflg                                         VARCHAR     (1)                                                                 ,  /* 長文フラグ */
     skrenrakujikou                                     VARCHAR     (9346)                                                              ,  /* 新契約連絡事項 */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日 */
     hasinymd                                           VARCHAR     (8)                                                                 ,  /* 発信日 */
     kaisyouymd                                         VARCHAR     (8)                                                                 ,  /* 解消日 */
     hassinsakikbn                                      VARCHAR     (1)                                                                 ,  /* 発信先区分 */
     hasinkyokakbn                                      VARCHAR     (1)                                                                 ,  /* 発信許可区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SkHubiDetail_Z ADD CONSTRAINT PK_SkHubiDetail PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     hubisikibetukey                                          , /* 不備識別キー */
     renno3keta                                                 /* 連番（３桁） */
) ;

CREATE INDEX IX1_SkHubiDetail ON HT_SkHubiDetail_Z (
     hasinymd                                                   /* 発信日 */
) ;
