CREATE TABLE HW_SyuHukugouSikkanZhkWk (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hknnendo                                           NUMBER      (2)                                                       NOT NULL  ,  /* 保険年度 */
     ijitoukeidaihyousyurui                             VARCHAR     (2)                                                                 ,  /* 医事統計用代表種類 */
     kyknendo                                           VARCHAR     (4)                                                                 ,  /* 契約年度 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     kykage                                             NUMBER      (3)                                                                 ,  /* 加入年齢 */
     toutatunenrei                                      NUMBER      (3)                                                                 ,  /* 到達年齢 */
     atukaibetu                                         VARCHAR     (1)                                                                 ,  /* 扱別 */
     ijitoukeisinsahouhou                               VARCHAR     (2)                                                                 ,  /* 医事統計用診査方法 */
     ketteikekkaa                                       VARCHAR     (1)                                                                 ,  /* 決定結果Ａ */
     sibousrank                                         VARCHAR     (2)                                                                 ,  /* 死亡Ｓランク */
     jissituhosyousrank                                 VARCHAR     (2)                                                                 ,  /* 実質保障Ｓランク */
     sirajikykkbn                                       VARCHAR     (1)                                                                 ,  /* 白地契約区分 */
     hrkhouhoukbn                                       VARCHAR     (1)                                                                 ,  /* 払込方法区分 */
     ijitoukeihokensyuruikbn                            VARCHAR     (2)                                                                 ,  /* 医事統計用保険種類区分 */
     daisiincd                                          VARCHAR     (1)                                                                 ,  /* 大死因コード */
     tyuusiincd                                         VARCHAR     (2)                                                                 ,  /* 中死因コード */
     siincd                                             VARCHAR     (3)                                                                 ,  /* 死因コード */
     nenreihousikikbn                                   VARCHAR     (1)                                                                 ,  /* 年令方式区分 */
     hhknsykgycd                                        VARCHAR     (3)                                                                 ,  /* 被保険者職業コード */
     hhkntodouhukencd                                   VARCHAR     (2)                                                                 ,  /* 被保険者都道府県コード */
     botaisisyaeigyouhonbu                              VARCHAR     (3)                                                                 ,  /* 母体支社営業本部 */
     sisyaeigyoubu                                      VARCHAR     (3)                                                                 ,  /* 支社営業部 */
     aatsukaishasoshikicd                               VARCHAR     (7)                                                                 ,  /* Ａ扱者組織コード */
     hhknnensyuukbn                                     VARCHAR     (2)                                                                 ,  /* 被保険者年収区分 */
     hanbaikeirokbn                                     VARCHAR     (1)                                                                 ,  /* 販売経路区分 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     tratkiagcd                                         VARCHAR     (7)                                                                 ,  /* 取扱代理店コード */
     bosyuudairitenatkikeitaikbn                        VARCHAR     (1)                                                                 ,  /* 募集代理店扱形態区分 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     hrktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 払込通貨種類 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     initsbjiyensitihsytkhukaumu                        VARCHAR     (1)                                                                 ,  /* 初期死亡時円換算最低保証特約付加有無 */
     jyudkaigomeharaitkhukaumu                          VARCHAR     (1)                                                                 ,  /* 重度介護前払特約付加有無 */
     ijitoukeizennoukbn                                 VARCHAR     (1)                                                                 ,  /* 医事統計用前納区分 */
     dai1hknkkn                                         NUMBER      (2)                                                                 ,  /* 第１保険期間 */
     ijitoukeitikshrtkykkbn                             VARCHAR     (1)                                                                 ,  /* 医事統計用定期支払特約区分 */
     ijitoukeikeikan                                    NUMBER      (7,6)                                                               ,  /* 医事統計用経過Ｎ */
     ijitoukeisiboun                                    NUMBER      (5)                                                                 ,  /* 医事統計用死亡Ｎ */
     ijitoukeikeikas                                    NUMBER      (14,5)                                                              ,  /* 医事統計用経過Ｓ */
     ijitoukeisibous                                    NUMBER      (9)                                                                 ,  /* 医事統計用死亡Ｓ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HW_SyuHukugouSikkanZhkWk ADD CONSTRAINT PK_SyuHukugouSikkanZhkWk PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     hknnendo                                                   /* 保険年度 */
) ;

CREATE INDEX IX1_SyuHukugouSikkanZhkWk ON HW_SyuHukugouSikkanZhkWk (
     hknnendo                                                 , /* 保険年度 */
     ijitoukeidaihyousyurui                                   , /* 医事統計用代表種類 */
     kyknendo                                                 , /* 契約年度 */
     hhknsei                                                  , /* 被保険者性別 */
     kykage                                                   , /* 加入年齢 */
     toutatunenrei                                            , /* 到達年齢 */
     atukaibetu                                               , /* 扱別 */
     ijitoukeisinsahouhou                                     , /* 医事統計用診査方法 */
     ketteikekkaa                                             , /* 決定結果Ａ */
     sibousrank                                               , /* 死亡Ｓランク */
     jissituhosyousrank                                       , /* 実質保障Ｓランク */
     sirajikykkbn                                             , /* 白地契約区分 */
     hrkhouhoukbn                                             , /* 払込方法区分 */
     ijitoukeihokensyuruikbn                                  , /* 医事統計用保険種類区分 */
     daisiincd                                                , /* 大死因コード */
     tyuusiincd                                               , /* 中死因コード */
     siincd                                                   , /* 死因コード */
     nenreihousikikbn                                         , /* 年令方式区分 */
     hhknsykgycd                                              , /* 被保険者職業コード */
     hhkntodouhukencd                                         , /* 被保険者都道府県コード */
     botaisisyaeigyouhonbu                                    , /* 母体支社営業本部 */
     sisyaeigyoubu                                            , /* 支社営業部 */
     aatsukaishasoshikicd                                     , /* Ａ扱者組織コード */
     hhknnensyuukbn                                           , /* 被保険者年収区分 */
     hanbaikeirokbn                                           , /* 販売経路区分 */
     oyadrtencd                                               , /* 親代理店コード */
     tratkiagcd                                               , /* 取扱代理店コード */
     bosyuudairitenatkikeitaikbn                              , /* 募集代理店扱形態区分 */
     kyktuukasyu                                              , /* 契約通貨種類 */
     hrktuukasyu                                              , /* 払込通貨種類 */
     syouhncd                                                 , /* 商品コード */
     initsbjiyensitihsytkhukaumu                              , /* 初期死亡時円換算最低保証特約付加有無 */
     jyudkaigomeharaitkhukaumu                                , /* 重度介護前払特約付加有無 */
     ijitoukeizennoukbn                                       , /* 医事統計用前納区分 */
     dai1hknkkn                                               , /* 第１保険期間 */
     ijitoukeitikshrtkykkbn                                     /* 医事統計用定期支払特約区分 */
) ;
