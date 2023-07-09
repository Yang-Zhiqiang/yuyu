CREATE TABLE BT_DenpyoData (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              NUMBER      (2)                                                       NOT NULL  ,  /* 枝番号 */
     keirisyono                                         VARCHAR     (20)                                                                ,  /* 経理用証券番号 */
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
     huridenskskbn                                      VARCHAR     (1)                                                                 ,  /* 振替伝票作成区分 */
     denhnknhoukbn                                      VARCHAR     (1)                                                                 ,  /* 伝票用返金方法区分 */
     denshrhoukbn                                       VARCHAR     (2)                                                                 ,  /* 伝票用支払方法区分 */
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
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     aatsukaishasoshikicd                               VARCHAR     (7)                                                                 ,  /* Ａ扱者組織コード */
     aatkisyadaibosyuucd                                VARCHAR     (6)                                                                 ,  /* Ａ扱者代表募集人コード */
     syusyouhncd                                        VARCHAR     (4)                                                                 ,  /* 主契約商品コード */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     sdpdkbn                                            VARCHAR     (1)                                                                 ,  /* Ｓ建Ｐ建区分 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     mosymd                                             VARCHAR     (8)                                                                 ,  /* 申込日 */
     hnknriyuukbn                                       VARCHAR     (1)                                                                 ,  /* 返金理由区分 */
     fstpryosyuymd                                      VARCHAR     (8)                                                                 ,  /* 初回Ｐ領収日 */
     aatkisyabosyuucd                                   VARCHAR     (6)                                                                 ,  /* Ａ扱者募集人コード */
     ryouritusdno                                       VARCHAR     (3)                                                                 ,  /* 料率世代番号 */
     kakokawaserateshiteiflg                            CHAR        (1)                                                                 ,  /* 過去為替レート指定フラグ */
     kakokawaserateshiteiymd                            VARCHAR     (8)                                                                 ,  /* 過去為替レート指定年月日 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     keiyakutuukagk                                     NUMBER      (13)                                                                ,  /* 契約通貨金額 */
     keiyakutuukagk$                                    VARCHAR     (10)                                                                ,  /* 契約通貨金額(通貨型) */
     dengyoumucd                                        VARCHAR     (5)                                                                 ,  /* 伝票用業務コード */
     kawasetekiyokbn                                    VARCHAR     (3)                                                                 ,  /* 為替適用区分 */
     denkarikanjyono                                    VARCHAR     (5)                                                                 ,  /* 伝票用仮勘定番号 */
     taisyakutyouseiflg                                 CHAR        (1)                                                                 ,  /* 貸借調整フラグ */
     hijynbrsikinidouyoukbn                             VARCHAR     (1)                                                                 ,  /* 平準払資金移動要区分 */
     hijynbrsikinidougk                                 NUMBER      (13)                                                                ,  /* 平準払資金移動金額 */
     hijynbrsikinidougk$                                VARCHAR     (10)                                                                ,  /* 平準払資金移動金額(通貨型) */
     densyorisyousaikbn                                 VARCHAR     (4)                                                                 ,  /* 伝票用処理詳細区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_DenpyoData ADD CONSTRAINT PK_DenpyoData PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;

CREATE INDEX IX1_DenpyoData ON BT_DenpyoData (
     syoriYmd                                                 , /* 処理年月日 */
     kanjyoukmkcd                                               /* 勘定科目コード */
) ;

CREATE INDEX IX2_DenpyoData ON BT_DenpyoData (
     denymd                                                   , /* 伝票日付 */
     syoriYmd                                                 , /* 処理年月日 */
     densyorikbn                                                /* 伝票処理区分 */
) ;

CREATE INDEX IX3_DenpyoData ON BT_DenpyoData (
     keirisyono                                                 /* 経理用証券番号 */
) ;
