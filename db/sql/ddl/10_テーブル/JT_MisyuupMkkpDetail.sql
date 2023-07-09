CREATE TABLE JT_MisyuupMkkpDetail (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     datarenno                                          NUMBER      (5)                                                       NOT NULL  ,  /* データ連番 */
     dtlmisyuup                                         NUMBER      (13)                                                                ,  /* 明細未収保険料 */
     dtlmisyuup$                                        VARCHAR     (10)                                                                ,  /* 明細未収保険料(通貨型) */
     dtlmisyuupgaika                                    NUMBER      (13)                                                                ,  /* 明細未収保険料（外貨） */
     dtlmisyuupgaika$                                   VARCHAR     (10)                                                                ,  /* 明細未収保険料（外貨）(通貨型) */
     dtlmisyuupgaikayenknsnkngk                         NUMBER      (13)                                                                ,  /* 明細未収保険料（外貨）円換算金額 */
     dtlmisyuupgaikayenknsnkngk$                        VARCHAR     (10)                                                                ,  /* 明細未収保険料（外貨）円換算金額(通貨型) */
     dtlmisyuupiktnkumu                                 VARCHAR     (1)                                                                 ,  /* 明細未収保険料一括入金有無 */
     dtlmisyuuphrkkaisuu                                VARCHAR     (2)                                                                 ,  /* 明細未収保険料払込回数 */
     dtlmisyuupjtkaisuuy                                NUMBER      (2)                                                                 ,  /* 明細未収保険料充当回数（年） */
     dtlmisyuupjtkaisuum                                NUMBER      (2)                                                                 ,  /* 明細未収保険料充当回数（月） */
     dtlmisyuupjytym                                    VARCHAR     (6)                                                                 ,  /* 明細未収保険料充当年月 */
     dtlmikeikap                                        NUMBER      (13)                                                                ,  /* 明細未経過保険料 */
     dtlmikeikap$                                       VARCHAR     (10)                                                                ,  /* 明細未経過保険料(通貨型) */
     dtlmikeikapgaika                                   NUMBER      (13)                                                                ,  /* 明細未経過保険料（外貨） */
     dtlmikeikapgaika$                                  VARCHAR     (10)                                                                ,  /* 明細未経過保険料（外貨）(通貨型) */
     dtlmikeikapnykdenymd                               VARCHAR     (8)                                                                 ,  /* 明細未経過保険料入金伝票日付 */
     dtlmikeikaphrkkaisuu                               VARCHAR     (2)                                                                 ,  /* 明細未経過保険料払込回数 */
     dtlmikeikapjtkaisuuy                               NUMBER      (2)                                                                 ,  /* 明細未経過保険料充当回数（年） */
     dtlmikeikapjtkaisuum                               NUMBER      (2)                                                                 ,  /* 明細未経過保険料充当回数（月） */
     dtlmikeikapjytym                                   VARCHAR     (6)                                                                 ,  /* 明細未経過保険料充当年月 */
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

ALTER TABLE JT_MisyuupMkkpDetail ADD CONSTRAINT PK_MisyuupMkkpDetail PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                          , /* 請求履歴番号 */
     datarenno                                                  /* データ連番 */
) ;
