CREATE TABLE HT_SkCreditCardQrTrkMihanei (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     systemjyusinymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* システム受信日 */
     systemjyusintime                                   VARCHAR     (6)                                                       NOT NULL  ,  /* システム受信時刻 */
     creditqrtrkkbn                                     VARCHAR     (1)                                                                 ,  /* クレジットカードＱＲ登録区分 */
     creditqrsousinkbn                                  VARCHAR     (1)                                                                 ,  /* クレジットカードＱＲ送信区分 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     creditauthorigk                                    NUMBER      (7)                                                                 ,  /* クレジットカードオーソリ金額 */
     creditauthorigk$                                   VARCHAR     (10)                                                                ,  /* クレジットカードオーソリ金額(通貨型) */
     tyuumonno                                          VARCHAR     (50)                                                                ,  /* 注文番号 */
     bluegateshopid                                     VARCHAR     (16)                                                                ,  /* ＢｌｕｅＧａｔｅショップＩＤ */
     kessaisyoriymd                                     VARCHAR     (8)                                                                 ,  /* 決済処理日 */
     creditqrerrorcd                                    VARCHAR     (14)                                                                ,  /* クレジットカードＱＲエラーコード */
     syouninnoseven                                     VARCHAR     (7)                                                                 ,  /* 承認番号（７桁） */
     bluegateerrorcd                                    VARCHAR     (8)                                                                 ,  /* ＢｌｕｅＧａｔｅエラーコード */
     hisimukekaisyacd                                   VARCHAR     (11)                                                                ,  /* 被仕向会社コード */
     bluegatejyusinymdtime                              VARCHAR     (14)                                                                ,  /* ＢｌｕｅＧａｔｅ受付日時 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_SkCreditCardQrTrkMihanei ADD CONSTRAINT PK_SkCreditCardQrTrkMihanei PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     systemjyusinymd                                          , /* システム受信日 */
     systemjyusintime                                         , /* システム受信時刻 */
     creditkessaiyouno                                          /* クレジットカード決済用番号 */
) ;

CREATE INDEX IX1_SkCreditCardQrTrkMihanei ON HT_SkCreditCardQrTrkMihanei (
     nykmosno                                                   /* 入金用申込番号 */
) ;
