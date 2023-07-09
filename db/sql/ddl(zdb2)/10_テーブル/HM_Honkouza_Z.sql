CREATE TABLE HM_Honkouza_Z (
     honkouzacd                                         VARCHAR     (3)                                                       NOT NULL  ,  /* 本口座コード */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     hyoujijyun                                         DECIMAL     (2)                                                                 ,  /* 表示順 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     sikinidousakibankcd                                VARCHAR     (4)                                                                 ,  /* 資金移動先銀行コード */
     sikinidousakisitencd                               VARCHAR     (3)                                                                 ,  /* 資金移動先支店コード */
     sikinidousakikouzano                               VARCHAR     (12)                                                                   /* 資金移動先口座番号 */
)
;

ALTER TABLE HM_Honkouza_Z ADD CONSTRAINT PK_Honkouza PRIMARY KEY (
     honkouzacd                                                 /* 本口座コード */
) ;
