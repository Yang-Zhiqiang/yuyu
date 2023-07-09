CREATE TABLE IT_ChkYukokekkaData (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分                                   */
     yuukoukekkarenno                                   VARCHAR     (20)                                                      NOT NULL  ,  /* 有効性確認結果データ連番                                  */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日                                         */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号                                          */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１                                   */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２                                   */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３                                   */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４                                   */
     inputyuukoukigen                                   VARCHAR     (32)                                                                ,  /* 入力有効期限                                        */
     yuukoutaisyouym                                    VARCHAR     (6)                                                                 ,  /* 有効性確認対象年月                                     */
     cardnokosumu                                       VARCHAR     (1)                                                                 ,  /* カード番号更新有無                                     */
     cardykkigenkosumu                                  VARCHAR     (1)                                                                 ,  /* カード有効期限更新有無                                   */
     newcreditcardno1                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号１                              */
     newcreditcardno2                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号２                              */
     newcreditcardno3                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号３                              */
     newcreditcardno4                                   VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード番号４                              */
     newcreditcardykkigen                               VARCHAR     (32)                                                                ,  /* （変更後）クレジットカード有効期限                             */
     yuukouhanteikekka                                  VARCHAR     (1)                                                                 ,  /* 有効性判定結果                                       */
     errorflg                                           VARCHAR     (1)                                                                 ,  /* エラーフラグ                                        */
     creditbrerrorcd                                    VARCHAR     (3)                                                                 ,  /* クレジット払エラーコード                                  */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_ChkYukokekkaData ADD CONSTRAINT PK_ChkYukokekkaData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分                                    */
     yuukoukekkarenno                                           /* 有効性確認結果データ連番                                   */
) ;

CREATE INDEX IX1_ChkYukokekkaData ON IT_ChkYukokekkaData (
     syoriYmd                                                   /* 処理年月日                                          */
) ;
