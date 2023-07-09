CREATE TABLE HT_CreditCardJyouhou_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     cardbrandkbn                                       VARCHAR     (2)                                                                 ,  /* カードブランド区分 */
     credittrkhoukbn                                    VARCHAR     (1)                                                                 ,  /* クレジットカード登録方法区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_CreditCardJyouhou_Z ADD CONSTRAINT PK_CreditCardJyouhou PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
