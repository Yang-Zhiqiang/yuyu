CREATE TABLE HW_HrkmNyknTaisyouWk_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     hrkmirninnm                                        VARCHAR     (194)                                                               ,  /* 振込依頼人名 */
     rsgaku                                             DECIMAL     (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     rsgakuen                                           DECIMAL     (13)                                                                ,  /* 領収金額（円） */
     rsgakuen$                                          VARCHAR     (10)                                                                ,  /* 領収金額（円）(通貨型) */
     hrkmtsry                                           DECIMAL     (13)                                                                ,  /* 振込手数料 */
     hrkmtsry$                                          VARCHAR     (10)                                                                ,  /* 振込手数料(通貨型) */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hrkmnykndatarenmotoKbn                             VARCHAR     (1)                                                                    /* 振込入金データ連携元区分 */
)
;

ALTER TABLE HW_HrkmNyknTaisyouWk_Z ADD CONSTRAINT PK_HrkmNyknTaisyouWk PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;
