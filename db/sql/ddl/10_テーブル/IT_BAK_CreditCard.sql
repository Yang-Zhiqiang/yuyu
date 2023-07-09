CREATE TABLE IT_BAK_CreditCard (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー                                        */
     kokno                                              VARCHAR     (10)                                                                ,  /* 顧客番号                                          */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード                                      */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１                                   */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２                                   */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３                                   */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４                                   */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限                                  */
     creditmeiginmkn                                    VARCHAR     (192)                                                               ,  /* クレジットカード名義人氏名（カナ）                             */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_BAK_CreditCard ADD CONSTRAINT PK_BAK_CreditCard PRIMARY KEY (
     kbnkey                                                   , /* 区分キー                                           */
     syono                                                    , /* 証券番号                                           */
     trkssikibetukey                                            /* 取消識別キー                                         */
) ;
