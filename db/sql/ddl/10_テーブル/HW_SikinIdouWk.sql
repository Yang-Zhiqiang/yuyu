CREATE TABLE HW_SikinIdouWk (
     nyksyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 入金処理日 */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     sikinidoumotohonkouzacd                            VARCHAR     (3)                                                                 ,  /* 資金移動元本口座コード */
     sikinidousakihonkouzacd                            VARCHAR     (3)                                                                 ,  /* 資金移動先本口座コード */
     sikinidougaku                                      NUMBER      (13)                                                                ,  /* 資金移動額 */
     sikinidougaku$                                     VARCHAR     (10)                                                                ,  /* 資金移動額(通貨型) */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HW_SikinIdouWk ADD CONSTRAINT PK_SikinIdouWk PRIMARY KEY (
     nyksyoriymd                                              , /* 入金処理日 */
     itirenno                                                   /* 一連番号 */
) ;

CREATE INDEX IX1_SikinIdouWk ON HW_SikinIdouWk (
     syoriYmd                                                 , /* 処理年月日 */
     sikinidoumotohonkouzacd                                  , /* 資金移動元本口座コード */
     sikinidousakihonkouzacd                                    /* 資金移動先本口座コード */
) ;
