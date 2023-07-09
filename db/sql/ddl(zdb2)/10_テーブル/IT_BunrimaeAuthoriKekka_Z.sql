CREATE TABLE IT_BunrimaeAuthoriKekka_Z (
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     datajyusinymd                                      VARCHAR     (14)                                                      NOT NULL  ,  /* データ受信日 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     kaiintourokukbn                                    VARCHAR     (1)                                                                 ,  /* 会員登録区分 */
     creditcardno                                       VARCHAR     (16)                                                                ,  /* クレジットカード番号 */
     cardyuukoukigen4keta                               VARCHAR     (4)                                                                 ,  /* クレジットカード有効期限（４桁） */
     authorigk7keta                                     VARCHAR     (7)                                                                 ,  /* オーソリ金額（７桁） */
     authorikekkaerrorcd                                VARCHAR     (14)                                                                ,  /* オーソリ結果エラーコード */
     bluegateerrorcd                                    VARCHAR     (8)                                                                 ,  /* ＢｌｕｅＧａｔｅエラーコード */
     hisimukekaisyacd                                   VARCHAR     (11)                                                                ,  /* 被仕向会社コード */
     wentryuserid                                       VARCHAR     (8)                                                                 ,  /* ＷエントリユーザＩＤ */
     errorcomment                                       VARCHAR     (40)                                                                ,  /* エラーコメント */
     niniinfo                                           VARCHAR     (40)                                                                ,  /* 任意情報 */
     datasyorijyoukyou                                  VARCHAR     (1)                                                                 ,  /* データ処理状況 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BunrimaeAuthoriKekka_Z ADD CONSTRAINT PK_BunrimaeAuthoriKekka PRIMARY KEY (
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     datajyusinymd                                              /* データ受信日 */
) ;
