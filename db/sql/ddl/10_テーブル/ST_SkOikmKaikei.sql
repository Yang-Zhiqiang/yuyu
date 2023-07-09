CREATE TABLE ST_SkOikmKaikei (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              NUMBER      (2)                                                       NOT NULL  ,  /* 枝番号 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     huridenatesakicd                                   VARCHAR     (3)                                                                 ,  /* 振替伝票宛先部課コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     dengaikagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（外貨） */
     dengaikagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（外貨）(通貨型) */
     denkawaserate                                      NUMBER      (7,4)                                                               ,  /* 伝票用為替レート */
     denyenkagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（円） */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型) */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     seg2cd                                             VARCHAR     (20)                                                                ,  /* セグメント２コード */
     kessantyouseikbn                                   VARCHAR     (1)                                                                 ,  /* 決算調整区分 */
     naibukeiyakukbn                                    VARCHAR     (1)                                                                 ,  /* 内部契約区分 */
     tekiyoukbn                                         VARCHAR     (1)                                                                 ,  /* 摘要区分 */
     densyorikbn                                        VARCHAR     (4)                                                                 ,  /* 伝票処理区分 */
     aatsukaishasuitososhikicd                          VARCHAR     (7)                                                                 ,  /* Ａ扱者出納組織コード */
     hnknriyuukbn                                       VARCHAR     (1)                                                                 ,  /* 返金理由区分 */
     fstpryosyuymd                                      VARCHAR     (8)                                                                 ,  /* 初回Ｐ領収日 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     syusyouhncd                                        VARCHAR     (4)                                                                 ,  /* 主契約商品コード */
     ryouritusdno                                       VARCHAR     (3)                                                                 ,  /* 料率世代番号 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     sdpdkbn                                            VARCHAR     (1)                                                                 ,  /* Ｓ建Ｐ建区分 */
     aatsukaishasoshikicd                               VARCHAR     (7)                                                                 ,  /* Ａ扱者組織コード */
     aatkisyadaibosyuucd                                VARCHAR     (6)                                                                 ,  /* Ａ扱者代表募集人コード */
     aatkisyabosyuucd                                   VARCHAR     (6)                                                                 ,  /* Ａ扱者募集人コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ST_SkOikmKaikei ADD CONSTRAINT PK_SkOikmKaikei PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;

CREATE INDEX IX1_SkOikmKaikei ON ST_SkOikmKaikei (
     denymd                                                   , /* 伝票日付 */
     syoriYmd                                                 , /* 処理年月日 */
     densyorikbn                                                /* 伝票処理区分 */
) ;
