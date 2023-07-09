CREATE TABLE IT_CreditCardInfo (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     credityuukoukakym                                  VARCHAR     (6)                                                                 ,  /* クレジットカード有効確認年月 */
     credityuukoukakkekka                               VARCHAR     (1)                                                                 ,  /* クレジットカード有効確認結果 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_CreditCardInfo ADD CONSTRAINT PK_CreditCardInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;
