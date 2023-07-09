CREATE TABLE BW_HtkinSikinIdouWk_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kijyunymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 基準年月日 */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     seisikiwariategaku                                 DECIMAL     (13)                                                                ,  /* 正式割当額 */
     seisikiwariategaku$                                VARCHAR     (10)                                                                ,  /* 正式割当額(通貨型) */
     sikinidoukawaserate                                DECIMAL     (7,4)                                                               ,  /* 資金移動用為替レート */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     seg1cd                                             VARCHAR     (20)                                                                   /* セグメント１コード */
)
;

ALTER TABLE BW_HtkinSikinIdouWk_Z ADD CONSTRAINT PK_HtkinSikinIdouWk PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     kijyunymd                                                  /* 基準年月日 */
) ;
