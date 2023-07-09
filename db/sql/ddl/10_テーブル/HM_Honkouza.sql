CREATE TABLE HM_Honkouza (
     honkouzacd                                         VARCHAR     (3)                                                       NOT NULL  ,  /* 本口座コード */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     sikinidousakibankcd                                VARCHAR     (4)                                                                 ,  /* 資金移動先銀行コード */
     sikinidousakisitencd                               VARCHAR     (3)                                                                 ,  /* 資金移動先支店コード */
     sikinidousakikouzano                               VARCHAR     (12)                                                                ,  /* 資金移動先口座番号 */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HM_Honkouza ADD CONSTRAINT PK_Honkouza PRIMARY KEY (
     honkouzacd                                                 /* 本口座コード */
) ;
