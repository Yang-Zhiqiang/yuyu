CREATE TABLE ZT_SyuHukugouSikkanDataRn_Z (
     zrnijitoukeidaihyousyurui                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）医事統計用代表種類 */
     zrnkeiyakunendo                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年度 */
     zrnhknnendo                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険年度 */
     zrnhhknseikbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別区分 */
     zrnkykage                                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）加入年齢 */
     zrntoutatunenrei                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）到達年齢 */
     zrnatukaibetu                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）扱別 */
     zrnsinsahouhou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）診査方法 */
     zrnketteikekkakbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）決定結果区分 */
     zrnsibousrank                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）死亡Ｓランク */
     zrnjissituhosyousrank                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）実質保障Ｓランク */
     zrnsirajikykkbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）白地契約区分 */
     zrnhrkhuhukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込方法区分 */
     zrnhknsyurui2keta                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類（２桁） */
     zrndaisiincd                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）大死因コード */
     zrntyuusiincd                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）中死因コード */
     zrnsyousiincd                                      CHAR        (3)                                                       NOT NULL  ,  /* （連携用）小死因コード */
     zrnnenreihousikikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年令方式区分 */
     zrnsykgycd                                         CHAR        (3)                                                       NOT NULL  ,  /* （連携用）職業コード */
     zrntodouhukencd                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）都道府県コード */
     zrnbotaisisyaeigyouhonbu                           CHAR        (3)                                                       NOT NULL  ,  /* （連携用）母体支社営業本部 */
     zrnsisyaeigyoubu                                   CHAR        (3)                                                       NOT NULL  ,  /* （連携用）支社営業部 */
     zrnaatukaisosikicd                                 CHAR        (7)                                                       NOT NULL  ,  /* （連携用）Ａ扱者組織コード */
     zrnnensyuukbn                                      CHAR        (1)                                                       NOT NULL  ,  /* （連携用）年収区分 */
     zrnhanbaikeirokbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）販売経路区分 */
     zrnoyadairitencd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）親代理店コード */
     zrntratkidrtencd                                   CHAR        (7)                                                       NOT NULL  ,  /* （連携用）取扱代理店コード */
     zrnbsudirtnatkikeitaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）募集代理店扱形態区分 */
     zrnkyktuuka                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約通貨 */
     zrnhrktuuka                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込通貨 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnsyksbyensitihsyutyhkumu                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）初期死亡時円換算最低保証特約付加有無 */
     zrnjyudkaigomehrtkhkumu                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）重度介護前払特約付加有無 */
     zrnijitoukeizennoukbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）医事統計用前納区分 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnijitoukeitikshrtkykkbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）医事統計用定期支払特約区分 */
     zrnyobiv31                                         CHAR        (31)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ３１ */
     zrnijitoukeikeikan                                 DECIMAL     (11,3)                                                    NOT NULL  ,  /* （連携用）医事統計用経過Ｎ */
     zrnijitoukeisiboun                                 DECIMAL     (5)                                                       NOT NULL  ,  /* （連携用）医事統計用死亡Ｎ */
     zrnijitoukeikeikas                                 DECIMAL     (11,1)                                                    NOT NULL  ,  /* （連携用）医事統計用経過Ｓ */
     zrnijitoukeisibous                                 DECIMAL     (9)                                                       NOT NULL  ,  /* （連携用）医事統計用死亡Ｓ */
     zrnyobiv20                                         CHAR        (20)                                                      NOT NULL     /* （連携用）予備項目Ｖ２０ */
)
;

ALTER TABLE ZT_SyuHukugouSikkanDataRn_Z ADD CONSTRAINT PK_SyuHukugouSikkanDataRn PRIMARY KEY (
     zrnijitoukeidaihyousyurui                                , /* （連携用）医事統計用代表種類 */
     zrnkeiyakunendo                                          , /* （連携用）契約年度 */
     zrnhknnendo                                              , /* （連携用）保険年度 */
     zrnhhknseikbn                                            , /* （連携用）被保険者性別区分 */
     zrnkykage                                                , /* （連携用）加入年齢 */
     zrntoutatunenrei                                         , /* （連携用）到達年齢 */
     zrnatukaibetu                                            , /* （連携用）扱別 */
     zrnsinsahouhou                                           , /* （連携用）診査方法 */
     zrnketteikekkakbn                                        , /* （連携用）決定結果区分 */
     zrnsibousrank                                            , /* （連携用）死亡Ｓランク */
     zrnjissituhosyousrank                                    , /* （連携用）実質保障Ｓランク */
     zrnsirajikykkbn                                          , /* （連携用）白地契約区分 */
     zrnhrkhuhukbn                                            , /* （連携用）払込方法区分 */
     zrnhknsyurui2keta                                        , /* （連携用）保険種類（２桁） */
     zrndaisiincd                                             , /* （連携用）大死因コード */
     zrntyuusiincd                                            , /* （連携用）中死因コード */
     zrnsyousiincd                                            , /* （連携用）小死因コード */
     zrnnenreihousikikbn                                      , /* （連携用）年令方式区分 */
     zrnsykgycd                                               , /* （連携用）職業コード */
     zrntodouhukencd                                          , /* （連携用）都道府県コード */
     zrnbotaisisyaeigyouhonbu                                 , /* （連携用）母体支社営業本部 */
     zrnsisyaeigyoubu                                         , /* （連携用）支社営業部 */
     zrnaatukaisosikicd                                       , /* （連携用）Ａ扱者組織コード */
     zrnnensyuukbn                                            , /* （連携用）年収区分 */
     zrnhanbaikeirokbn                                        , /* （連携用）販売経路区分 */
     zrnoyadairitencd                                         , /* （連携用）親代理店コード */
     zrntratkidrtencd                                         , /* （連携用）取扱代理店コード */
     zrnbsudirtnatkikeitaikbn                                 , /* （連携用）募集代理店扱形態区分 */
     zrnkyktuuka                                              , /* （連携用）契約通貨 */
     zrnhrktuuka                                              , /* （連携用）払込通貨 */
     zrnhknsyukigou                                           , /* （連携用）保険種類記号 */
     zrnsyksbyensitihsyutyhkumu                               , /* （連携用）初期死亡時円換算最低保証特約付加有無 */
     zrnjyudkaigomehrtkhkumu                                  , /* （連携用）重度介護前払特約付加有無 */
     zrnijitoukeizennoukbn                                    , /* （連携用）医事統計用前納区分 */
     zrndai1hknkkn                                            , /* （連携用）第１保険期間 */
     zrnijitoukeitikshrtkykkbn                                  /* （連携用）医事統計用定期支払特約区分 */
) ;
