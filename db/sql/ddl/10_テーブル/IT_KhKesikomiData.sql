CREATE TABLE IT_KhKesikomiData (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     nyuukinkakusyouno                                  VARCHAR     (20)                                                      NOT NULL  ,  /* 入金確証番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     nyuuryokukbn                                       VARCHAR     (1)                                                                 ,  /* 入力区分 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     nyuukinkakusyounrkymd                              VARCHAR     (8)                                                                 ,  /* 入金確証入力年月日 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     nykdenymd                                          VARCHAR     (8)                                                                 ,  /* 入金伝票日付 */
     nyuukinkakusyounrkno                               VARCHAR     (8)                                                                 ,  /* 入金確証入力番号 */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分 */
     suitono                                            VARCHAR     (2)                                                                 ,  /* 出納番号 */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード */
     karikanjyono                                       VARCHAR     (2)                                                                 ,  /* 仮勘定番号 */
     kzhurikaebankcd                                    VARCHAR     (4)                                                                 ,  /* 口座振替銀行コード */
     hrkmyousinkkbn                                     VARCHAR     (1)                                                                 ,  /* 振込用紙入金区分 */
     suitososhikicd                                     VARCHAR     (7)                                                                 ,  /* 出納組織コード */
     creditcardhrkskmkbn                                VARCHAR     (2)                                                                 ,  /* クレ払消込区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     syuudaikocd                                        VARCHAR     (2)                                                                    /* 収納代行社コード */
)
;

ALTER TABLE IT_KhKesikomiData ADD CONSTRAINT PK_KhKesikomiData PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     nyuukinkakusyouno                                        , /* 入金確証番号 */
     syono                                                      /* 証券番号 */
) ;
