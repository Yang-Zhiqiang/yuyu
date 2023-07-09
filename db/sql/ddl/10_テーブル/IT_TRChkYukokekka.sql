CREATE TABLE IT_TRChkYukokekka (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日                                         */
     yuukoutrrenno                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 有効性確認結果TR連番                                   */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１                                   */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２                                   */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３                                   */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４                                   */
     cardnokosumu                                       VARCHAR     (1)                                                                 ,  /* カード番号更新有無                                     */
     cardykkigenkosumu                                  VARCHAR     (1)                                                                 ,  /* カード有効期限更新有無                                   */
     newcreditcardno1                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号１                              */
     newcreditcardno2                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号２                              */
     newcreditcardno3                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号３                              */
     newcreditcardno4                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号４                              */
     newcreditcardykkigen                               VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード有効期限                             */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_TRChkYukokekka ADD CONSTRAINT PK_TRChkYukokekka PRIMARY KEY (
     syono                                                    , /* 証券番号                                           */
     syoriYmd                                                 , /* 処理年月日                                          */
     yuukoutrrenno                                              /* 有効性確認結果TR連番                                    */
) ;
