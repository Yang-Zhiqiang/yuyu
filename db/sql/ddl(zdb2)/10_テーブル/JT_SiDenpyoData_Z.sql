CREATE TABLE JT_SiDenpyoData_Z (
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 枝番号 */
     densyskbn                                          VARCHAR     (2)                                                                 ,  /* 伝票用システム区分 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     huridenatesakicd                                   VARCHAR     (3)                                                                 ,  /* 振替伝票宛先部課コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     dengaikagk                                         DECIMAL     (13)                                                                ,  /* 伝票金額（外貨） */
     dengaikagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（外貨）(通貨型) */
     denkawaserate                                      DECIMAL     (7,4)                                                               ,  /* 伝票用為替レート */
     denyenkagk                                         DECIMAL     (13)                                                                ,  /* 伝票金額（円） */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型) */
     huridenskskbn                                      VARCHAR     (1)                                                                 ,  /* 振替伝票作成区分 */
     denhnknhoukbn                                      VARCHAR     (1)                                                                 ,  /* 伝票用返金方法区分 */
     denshrhoukbn                                       VARCHAR     (2)                                                                 ,  /* 伝票用支払方法区分 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     seg2cd                                             VARCHAR     (20)                                                                ,  /* セグメント２コード */
     kakokawaserateshiteiflg                            CHAR        (1)                                                                 ,  /* 過去為替レート指定フラグ */
     kakokawaserateshiteiymd                            VARCHAR     (8)                                                                 ,  /* 過去為替レート指定年月日 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     keiyakutuukagk                                     DECIMAL     (13)                                                                ,  /* 契約通貨金額 */
     keiyakutuukagk$                                    VARCHAR     (10)                                                                ,  /* 契約通貨金額(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     dengyoumucd                                        VARCHAR     (5)                                                                 ,  /* 伝票用業務コード */
     syusyouhncd                                        VARCHAR     (4)                                                                 ,  /* 主契約商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                                 ,  /* 商品世代番号 */
     kawasetekiyokbn                                    VARCHAR     (3)                                                                 ,  /* 為替適用区分 */
     denkarikanjyono                                    VARCHAR     (5)                                                                 ,  /* 伝票用仮勘定番号 */
     taisyakutyouseiflg                                 CHAR        (1)                                                                 ,  /* 貸借調整フラグ */
     densyorisyousaikbn                                 VARCHAR     (4)                                                                    /* 伝票用処理詳細区分 */
)
;

ALTER TABLE JT_SiDenpyoData_Z ADD CONSTRAINT PK_SiDenpyoData PRIMARY KEY (
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;

CREATE INDEX IX1_SiDenpyoData ON JT_SiDenpyoData_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;
