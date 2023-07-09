CREATE TABLE IT_TRAuthoriKekka (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日                                         */
     authorikktrrenno                                   VARCHAR     (20)                                                      NOT NULL  ,  /* オーソリ結果TR連番                                    */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１                                   */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２                                   */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３                                   */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４                                   */
     authorijkkbn                                       VARCHAR     (1)                                                                 ,  /* オーソリ状況区分                                      */
     authoritrkkbn                                      VARCHAR     (1)                                                                 ,  /* オーソリ登録区分                                      */
     authorigk                                          NUMBER      (13)                                                                ,  /* オーソリ金額                                        */
     authorigk$                                         VARCHAR     (10)                                                                ,  /* オーソリ金額(通貨型)                                   */
     authorikanryoymd                                   VARCHAR     (8)                                                                 ,  /* オーソリ完了日                                       */
     syouninno                                          VARCHAR     (6)                                                                 ,  /* 承認番号                                          */
     tanmatusyorino                                     VARCHAR     (7)                                                                 ,  /* 端末処理通番                                        */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_TRAuthoriKekka ADD CONSTRAINT PK_TRAuthoriKekka PRIMARY KEY (
     syono                                                    , /* 証券番号                                           */
     syoriYmd                                                 , /* 処理年月日                                          */
     authorikktrrenno                                           /* オーソリ結果TR連番                                     */
) ;
