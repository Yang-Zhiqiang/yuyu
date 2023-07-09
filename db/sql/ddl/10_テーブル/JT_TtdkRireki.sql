CREATE TABLE JT_TtdkRireki (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     ttdkrrkskbtkey                                     VARCHAR     (18)                                                      NOT NULL  ,  /* 手続履歴識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     jimukakuteiumukbn                                  VARCHAR     (1)                                                                 ,  /* 事務確定有無区分 */
     seikyuurirekino                                    NUMBER      (3)                                                                 ,  /* 請求履歴番号 */
     shrsikibetukey                                     VARCHAR     (18)                                                                ,  /* 支払識別キー */
     sateisyouninskbtkey                                VARCHAR     (18)                                                                ,  /* 査定承認識別キー */
     syanaicomment                                      VARCHAR     (1600)                                                              ,  /* 社内用コメント */
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

ALTER TABLE JT_TtdkRireki ADD CONSTRAINT PK_TtdkRireki PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     ttdkrrkskbtkey                                             /* 手続履歴識別キー */
) ;

CREATE INDEX IX1_TtdkRireki ON JT_TtdkRireki (
     syoriYmd                                                   /* 処理年月日 */
) ;
