CREATE TABLE JT_SkKkn_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     uketukeno                                          DECIMAL     (2)                                                       NOT NULL  ,  /* 受付番号 */
     kyuuhukbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 給付区分 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     kikanfrom                                          VARCHAR     (8)                                                                 ,  /* 期間自 */
     kikanto                                            VARCHAR     (8)                                                                 ,  /* 期間至 */
     syujyututourokuno                                  VARCHAR     (9)                                                                 ,  /* 手術登録番号 */
     kjcd1                                              VARCHAR     (32)                                                                ,  /* Ｋ・Ｊコード１ */
     kjcd2                                              VARCHAR     (32)                                                                ,  /* Ｋ・Ｊコード２ */
     kjcd3                                              VARCHAR     (32)                                                                ,  /* Ｋ・Ｊコード３ */
     syujyutunmkn                                       VARCHAR     (642)                                                               ,  /* 手術名（カナ） */
     syujyutunmkj                                       VARCHAR     (642)                                                               ,  /* 手術名（漢字） */
     jyouken                                            VARCHAR     (102)                                                               ,  /* 条件 */
     syujyutubunruicd                                   VARCHAR     (3)                                                                 ,  /* 手術分類コード */
     syujyutuhousiki                                    VARCHAR     (2)                                                                 ,  /* 手術方式 */
     sensingijuturyou                                   DECIMAL     (11)                                                                ,  /* 先進医療技術料 */
     sensingijuturyou$                                  VARCHAR     (10)                                                                ,  /* 先進医療技術料(通貨型) */
     sensinitijikinshrumukbn                            VARCHAR     (1)                                                                 ,  /* 先進医療一時金支払有無区分 */
     sandaisippeihknshrriyuukbn                         VARCHAR     (1)                                                                 ,  /* ３大疾病保険金支払理由区分 */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_SkKkn_Z ADD CONSTRAINT PK_SkKkn PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                          , /* 請求履歴番号 */
     uketukeno                                                , /* 受付番号 */
     kyuuhukbn                                                , /* 給付区分 */
     renno                                                      /* 連番 */
) ;
