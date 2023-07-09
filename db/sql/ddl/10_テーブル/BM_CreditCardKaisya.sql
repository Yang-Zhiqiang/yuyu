CREATE TABLE BM_CreditCardKaisya (
     cardkaisyacd                                       VARCHAR     (2)                                                       NOT NULL  ,  /* カード会社コード */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順 */
     prefixstart                                        VARCHAR     (4)                                                                 ,  /* プレフィックス（開始） */
     prefixend                                          VARCHAR     (4)                                                                 ,  /* プレフィックス（終了） */
     cardnolength                                       NUMBER      (2)                                                                 ,  /* カード番号長 */
     cardkaisyanm                                       VARCHAR     (30)                                                                ,  /* カード会社名 */
     cardkaisyanmryk                                    VARCHAR     (30)                                                                ,  /* カード会社名（略称） */
     creditsyuudaikocd                                  VARCHAR     (2)                                                                 ,  /* クレカ収納代行社コード */
     torihikisakicd                                     VARCHAR     (8)                                                                 ,  /* 取引先コード */
     authoriyuukoukikannissuu                           NUMBER      (2)                                                                 ,  /* オーソリ有効期間日数 */
     tesuuryouryouritu                                  NUMBER      (5,4)                                                               ,  /* 手数料料率 */
     tesuuryouhasuusyorikbn                             VARCHAR     (1)                                                                 ,  /* 手数料端数処理区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_CreditCardKaisya ADD CONSTRAINT PK_CreditCardKaisya PRIMARY KEY (
     cardkaisyacd                                               /* カード会社コード */
) ;
