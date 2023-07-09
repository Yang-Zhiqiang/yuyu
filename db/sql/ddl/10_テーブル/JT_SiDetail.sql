CREATE TABLE JT_SiDetail (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     uketukeno                                          NUMBER      (2)                                                       NOT NULL  ,  /* 受付番号                                          */
     syutkkbn                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約特約区分                                       */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     kyhgndkatakbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* 給付限度型区分                                       */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号                                        */
     kyksyouhnrenno                                     NUMBER      (2)                                                       NOT NULL  ,  /* 契約商品連番                                        */
     kyuuhucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 給付コード                                         */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     kyuuhukbn                                          VARCHAR     (2)                                                                 ,  /* 給付区分                                          */
     hokenkinsyuruikbn                                  VARCHAR     (1)                                                                 ,  /* 保険金種類区分                                       */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード                                       */
     checktaisyouumukbn                                 VARCHAR     (1)                                                                 ,  /* チェック対象有無区分                                    */
     nitigakuhokenkngkkbn                               VARCHAR     (1)                                                                 ,  /* 日額・保険金額区分                                     */
     nitigakuhokenkngk                                  NUMBER      (13)                                                                ,  /* 日額・保険金額                                       */
     nitigakuhokenkngk$                                 VARCHAR     (10)                                                                ,  /* 日額・保険金額(通貨型)                                  */
     nissuubairitu                                      NUMBER      (4)                                                                 ,  /* 日数・倍率                                         */
     kyhkintanikbn                                      VARCHAR     (1)                                                                 ,  /* 給付金単位区分                                       */
     kyhkg                                              NUMBER      (13)                                                                ,  /* 給付金額                                          */
     kyhkg$                                             VARCHAR     (10)                                                                ,  /* 給付金額(通貨型)                                     */
     yenkyhgk                                           NUMBER      (13)                                                                ,  /* 円換算給付金額                                       */
     yenkyhgk$                                          VARCHAR     (10)                                                                ,  /* 円換算給付金額(通貨型)                                  */
     sitihsyutkyumaeyenhknkngk                          NUMBER      (13)                                                                ,  /* 最低保証適用前円換算保険金額                                */
     sitihsyutkyumaeyenhknkngk$                         VARCHAR     (10)                                                                ,  /* 最低保証適用前円換算保険金額(通貨型)                           */
     hutanponissuu                                      NUMBER      (2)                                                                 ,  /* 不担保日数                                         */
     shrriyuugaitouymd                                  VARCHAR     (8)                                                                 ,  /* 支払理由該当日                                       */
     hknskgnkkntgtumukbn                                VARCHAR     (1)                                                                 ,  /* 保険金削減期間対象有無区分                                 */
     hokenkinshrwariai                                  NUMBER      (4,3)                                                               ,  /* 保険金支払割合                                       */
     bikoumsg1                                          VARCHAR     (31)                                                                ,  /* 備考ＭＳＧ１                                        */
     bikoumsg2                                          VARCHAR     (31)                                                                ,  /* 備考ＭＳＧ２                                        */
     bikoumsg3                                          VARCHAR     (31)                                                                ,  /* 備考ＭＳＧ３                                        */
     bikoumsg4                                          VARCHAR     (31)                                                                ,  /* 備考ＭＳＧ４                                        */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_SiDetail ADD CONSTRAINT PK_SiDetail PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                          , /* 請求履歴番号                                         */
     uketukeno                                                , /* 受付番号                                           */
     syutkkbn                                                 , /* 主契約特約区分                                        */
     syouhncd                                                 , /* 商品コード                                          */
     kyhgndkatakbn                                            , /* 給付限度型区分                                        */
     syouhnsdno                                               , /* 商品世代番号                                         */
     kyksyouhnrenno                                           , /* 契約商品連番                                         */
     kyuuhucd                                                 , /* 給付コード                                          */
     renno                                                      /* 連番                                             */
) ;
