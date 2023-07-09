CREATE TABLE BT_HuriDenpyou (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              NUMBER      (2)                                                       NOT NULL  ,  /* 枝番号 */
     torihikino                                         VARCHAR     (7)                                                                 ,  /* 取引番号 */
     keirisyskbn                                        VARCHAR     (2)                                                                 ,  /* 経理システム区分 */
     keirisyono                                         VARCHAR     (20)                                                                ,  /* 経理用証券番号 */
     huridenatesakicd                                   VARCHAR     (3)                                                                 ,  /* 振替伝票宛先部課コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     denkanjokamokucd                                   VARCHAR     (5)                                                                 ,  /* 伝票用勘定科目コード */
     jigyouhiutiwakecd                                  VARCHAR     (7)                                                                 ,  /* 事業費内訳コード */
     jigyouhiutiwakenm                                  VARCHAR     (20)                                                                ,  /* 事業費内訳名 */
     tekiyoucd                                          VARCHAR     (20)                                                                ,  /* 摘要コード */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード */
     denyenkagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（円） */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型) */
     huridenskskbn                                      VARCHAR     (1)                                                                 ,  /* 振替伝票作成区分 */
     denhnknhoukbn                                      VARCHAR     (1)                                                                 ,  /* 伝票用返金方法区分 */
     denshrhoukbn                                       VARCHAR     (2)                                                                 ,  /* 伝票用支払方法区分 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     sougoukobetukbn                                    VARCHAR     (1)                                                                 ,  /* 総合個別区分 */
     furikaedenpyouitirenno                             NUMBER      (3)                                                                 ,  /* 振替伝票一連番号 */
     huridenpyoukyktuukakbn                             VARCHAR     (1)                                                                 ,  /* 振替伝票用契約通貨区分 */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     dengyoumucd                                        VARCHAR     (5)                                                                 ,  /* 伝票用業務コード */
     denkarikanjyono                                    VARCHAR     (5)                                                                 ,  /* 伝票用仮勘定番号 */
     densyorisyousaikbn                                 VARCHAR     (4)                                                                 ,  /* 伝票用処理詳細区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_HuriDenpyou ADD CONSTRAINT PK_HuriDenpyou PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;

CREATE INDEX IX1_HuriDenpyou ON BT_HuriDenpyou (
     syoriYmd                                                 , /* 処理年月日 */
     torihikino                                                 /* 取引番号 */
) ;
