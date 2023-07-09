CREATE TABLE HM_SyouhnTaniHonkouza (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     honkouzacd                                         VARCHAR     (3)                                                                 ,  /* 本口座コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HM_SyouhnTaniHonkouza ADD CONSTRAINT PK_SyouhnTaniHonkouza PRIMARY KEY (
     syouhncd                                                   /* 商品コード */
) ;
