CREATE TABLE IT_ZennouKessan_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     sakuseiymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* 作成年月日 */
     kbnkeirisegcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 区分経理用セグメントコード */
     zennoukbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 前納区分 */
     zennoutoukeilistkbn                                VARCHAR     (1)                                                       NOT NULL  ,  /* 前納統計リスト区分 */
     zennoustartym                                      VARCHAR     (6)                                                       NOT NULL  ,  /* 前納開始年月 */
     zennoukaisiymd                                     VARCHAR     (8)                                                                 ,  /* 前納開始年月日 */
     zennoukaisijizndk                                  DECIMAL     (11)                                                                ,  /* 前納開始時残高 */
     zennoukaisijizndk$                                 VARCHAR     (10)                                                                ,  /* 前納開始時残高(通貨型) */
     keiyakuymd                                         VARCHAR     (8)                                                                 ,  /* 契約年月日 */
     zennouwrbkrt                                       DECIMAL     (7,6)                                                               ,  /* 前納割引率 */
     rthndzndk1                                         DECIMAL     (11)                                                                ,  /* 利率変動時残高１ */
     rthndzndk1$                                        VARCHAR     (10)                                                                ,  /* 利率変動時残高１(通貨型) */
     tkyrt1                                             DECIMAL     (7,6)                                                               ,  /* 適用利率１ */
     rthndymd1                                          VARCHAR     (8)                                                                 ,  /* 利率変動年月日１ */
     rthndzndk2                                         DECIMAL     (11)                                                                ,  /* 利率変動時残高２ */
     rthndzndk2$                                        VARCHAR     (10)                                                                ,  /* 利率変動時残高２(通貨型) */
     tkyrt2                                             DECIMAL     (7,6)                                                               ,  /* 適用利率２ */
     rthndymd2                                          VARCHAR     (8)                                                                 ,  /* 利率変動年月日２ */
     rthndzndk3                                         DECIMAL     (11)                                                                ,  /* 利率変動時残高３ */
     rthndzndk3$                                        VARCHAR     (10)                                                                ,  /* 利率変動時残高３(通貨型) */
     tkyrt3                                             DECIMAL     (7,6)                                                               ,  /* 適用利率３ */
     rthndymd3                                          VARCHAR     (8)                                                                 ,  /* 利率変動年月日３ */
     rthndzndk4                                         DECIMAL     (11)                                                                ,  /* 利率変動時残高４ */
     rthndzndk4$                                        VARCHAR     (10)                                                                ,  /* 利率変動時残高４(通貨型) */
     tkyrt4                                             DECIMAL     (7,6)                                                               ,  /* 適用利率４ */
     rthndymd4                                          VARCHAR     (8)                                                                 ,  /* 利率変動年月日４ */
     tndmatuzndk                                        DECIMAL     (11)                                                                ,  /* 当年度末残高 */
     tndmatuzndk$                                       VARCHAR     (10)                                                                ,  /* 当年度末残高(通貨型) */
     tndmatutkyrt                                       DECIMAL     (7,6)                                                               ,  /* 当年度末適用利率 */
     zennounyuukinymd                                   VARCHAR     (8)                                                                 ,  /* 前納入金年月日 */
     tndzndkhikakukbn                                   VARCHAR     (1)                                                                 ,  /* 当年度残高比較区分 */
     zennoukikan                                        VARCHAR     (2)                                                                 ,  /* 前納期間 */
     yobi01xv1                                          VARCHAR     (1)                                                                 ,  /* 予備０１＿Ｖ１ */
     bosyuukeitaikbn                                    VARCHAR     (2)                                                                 ,  /* 募集形態区分 */
     yobi02xv11                                         VARCHAR     (11)                                                                ,  /* 予備０２＿Ｖ１１ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_ZennouKessan_Z ADD CONSTRAINT PK_ZennouKessan PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     sakuseiymd                                               , /* 作成年月日 */
     kbnkeirisegcd                                            , /* 区分経理用セグメントコード */
     zennoukbn                                                , /* 前納区分 */
     zennoutoukeilistkbn                                      , /* 前納統計リスト区分 */
     zennoustartym                                              /* 前納開始年月 */
) ;
