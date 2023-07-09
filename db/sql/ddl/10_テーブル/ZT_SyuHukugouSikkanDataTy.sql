CREATE TABLE ZT_SyuHukugouSikkanDataTy (
     ztyijitoukeidaihyousyurui                          VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）医事統計用代表種類 */
     ztykeiyakunendo                                    VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）契約年度 */
     ztyhknnendo                                        VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）保険年度 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）被保険者性別区分 */
     ztykykage                                          VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）加入年齢 */
     ztytoutatunenrei                                   VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）到達年齢 */
     ztyatukaibetu                                      VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）扱別 */
     ztysinsahouhou                                     VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）診査方法 */
     ztyketteikekkakbn                                  VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）決定結果区分 */
     ztysibousrank                                      VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）死亡Ｓランク */
     ztyjissituhosyousrank                              VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）実質保障Ｓランク */
     ztysirajikykkbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）白地契約区分 */
     ztyhrkhuhukbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）払込方法区分 */
     ztyhknsyurui2keta                                  VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）保険種類（２桁） */
     ztydaisiincd                                       VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）大死因コード */
     ztytyuusiincd                                      VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）中死因コード */
     ztysyousiincd                                      VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）小死因コード */
     ztynenreihousikikbn                                VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）年令方式区分 */
     ztysykgycd                                         VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）職業コード */
     ztytodouhukencd                                    VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）都道府県コード */
     ztybotaisisyaeigyouhonbu                           VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）母体支社営業本部 */
     ztysisyaeigyoubu                                   VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）支社営業部 */
     ztyaatukaisosikicd                                 VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）Ａ扱者組織コード */
     ztynensyuukbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）年収区分 */
     ztyhanbaikeirokbn                                  VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）販売経路区分 */
     ztyoyadairitencd                                   VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）親代理店コード */
     ztytratkidrtencd                                   VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）取扱代理店コード */
     ztybsudirtnatkikeitaikbn                           VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）募集代理店扱形態区分 */
     ztykyktuuka                                        VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）契約通貨 */
     ztyhrktuuka                                        VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）払込通貨 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）保険種類記号 */
     ztysyksbyensitihsyutyhkumu                         VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）初期死亡時円換算最低保証特約付加有無 */
     ztyjyudkaigomehrtkhkumu                            VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）重度介護前払特約付加有無 */
     ztyijitoukeizennoukbn                              VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）医事統計用前納区分 */
     ztydai1hknkkn                                      VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）第１保険期間 */
     ztyijitoukeitikshrtkykkbn                          VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）医事統計用定期支払特約区分 */
     ztyyobiv31                                         VARCHAR     (31)                                                                ,  /* （中継用）予備項目Ｖ３１ */
     ztyijitoukeikeikan                                 NUMBER      (11,3)                                                              ,  /* （中継用）医事統計用経過Ｎ */
     ztyijitoukeisiboun                                 NUMBER      (5)                                                                 ,  /* （中継用）医事統計用死亡Ｎ */
     ztyijitoukeikeikas                                 NUMBER      (11,1)                                                              ,  /* （中継用）医事統計用経過Ｓ */
     ztyijitoukeisibous                                 NUMBER      (9)                                                                 ,  /* （中継用）医事統計用死亡Ｓ */
     ztyyobiv20                                         VARCHAR     (20)                                                                ,  /* （中継用）予備項目Ｖ２０ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SyuHukugouSikkanDataTy ADD CONSTRAINT PK_SyuHukugouSikkanDataTy PRIMARY KEY (
     ztyijitoukeidaihyousyurui                                , /* （中継用）医事統計用代表種類 */
     ztykeiyakunendo                                          , /* （中継用）契約年度 */
     ztyhknnendo                                              , /* （中継用）保険年度 */
     ztyhhknseikbn                                            , /* （中継用）被保険者性別区分 */
     ztykykage                                                , /* （中継用）加入年齢 */
     ztytoutatunenrei                                         , /* （中継用）到達年齢 */
     ztyatukaibetu                                            , /* （中継用）扱別 */
     ztysinsahouhou                                           , /* （中継用）診査方法 */
     ztyketteikekkakbn                                        , /* （中継用）決定結果区分 */
     ztysibousrank                                            , /* （中継用）死亡Ｓランク */
     ztyjissituhosyousrank                                    , /* （中継用）実質保障Ｓランク */
     ztysirajikykkbn                                          , /* （中継用）白地契約区分 */
     ztyhrkhuhukbn                                            , /* （中継用）払込方法区分 */
     ztyhknsyurui2keta                                        , /* （中継用）保険種類（２桁） */
     ztydaisiincd                                             , /* （中継用）大死因コード */
     ztytyuusiincd                                            , /* （中継用）中死因コード */
     ztysyousiincd                                            , /* （中継用）小死因コード */
     ztynenreihousikikbn                                      , /* （中継用）年令方式区分 */
     ztysykgycd                                               , /* （中継用）職業コード */
     ztytodouhukencd                                          , /* （中継用）都道府県コード */
     ztybotaisisyaeigyouhonbu                                 , /* （中継用）母体支社営業本部 */
     ztysisyaeigyoubu                                         , /* （中継用）支社営業部 */
     ztyaatukaisosikicd                                       , /* （中継用）Ａ扱者組織コード */
     ztynensyuukbn                                            , /* （中継用）年収区分 */
     ztyhanbaikeirokbn                                        , /* （中継用）販売経路区分 */
     ztyoyadairitencd                                         , /* （中継用）親代理店コード */
     ztytratkidrtencd                                         , /* （中継用）取扱代理店コード */
     ztybsudirtnatkikeitaikbn                                 , /* （中継用）募集代理店扱形態区分 */
     ztykyktuuka                                              , /* （中継用）契約通貨 */
     ztyhrktuuka                                              , /* （中継用）払込通貨 */
     ztyhknsyukigou                                           , /* （中継用）保険種類記号 */
     ztysyksbyensitihsyutyhkumu                               , /* （中継用）初期死亡時円換算最低保証特約付加有無 */
     ztyjyudkaigomehrtkhkumu                                  , /* （中継用）重度介護前払特約付加有無 */
     ztyijitoukeizennoukbn                                    , /* （中継用）医事統計用前納区分 */
     ztydai1hknkkn                                            , /* （中継用）第１保険期間 */
     ztyijitoukeitikshrtkykkbn                                  /* （中継用）医事統計用定期支払特約区分 */
) ;
