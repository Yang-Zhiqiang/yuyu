CREATE TABLE JT_SiRireki (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     shrsikibetukey                                     VARCHAR     (18)                                                      NOT NULL  ,  /* 支払識別キー */
     seikyuurirekino                                    NUMBER      (3)                                                                 ,  /* 請求履歴番号 */
     shrkekkakbn                                        VARCHAR     (1)                                                                 ,  /* 支払結果区分 */
     shrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* 支払処理日 */
     tyakkinymd                                         VARCHAR     (8)                                                                 ,  /* 着金日 */
     shrgkkei                                           NUMBER      (13)                                                                ,  /* 支払額合計 */
     shrgkkei$                                          VARCHAR     (10)                                                                ,  /* 支払額合計(通貨型) */
     zeitratkikbn                                       VARCHAR     (1)                                                                 ,  /* 税取扱区分 */
     torikesiflg                                        VARCHAR     (1)                                                                 ,  /* 取消フラグ */
     torikesiymd                                        VARCHAR     (8)                                                                 ,  /* 取消日 */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JT_SiRireki ADD CONSTRAINT PK_SiRireki PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     shrsikibetukey                                             /* 支払識別キー */
) ;

CREATE INDEX IX1_SiRireki ON JT_SiRireki (
     shrsyoriymd                                                /* 支払処理日 */
) ;
