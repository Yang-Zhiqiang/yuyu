CREATE TABLE HT_MosSyouhn_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                                 ,  /* 商品世代番号 */
     ryouritusdno                                       VARCHAR     (3)                                                                 ,  /* 料率世代番号 */
     syutkkbn                                           VARCHAR     (1)                                                                 ,  /* 主契約特約区分 */
     yoteiriritu                                        DECIMAL     (5,4)                                                               ,  /* 予定利率 */
     sknenkinsyu                                        VARCHAR     (2)                                                                 ,  /* 新契約年金種類 */
     kihons                                             DECIMAL     (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     seitoukihons                                       DECIMAL     (13)                                                                ,  /* 正当基本Ｓ */
     seitoukihons$                                      VARCHAR     (10)                                                                ,  /* 正当基本Ｓ(通貨型) */
     syutkp                                             DECIMAL     (13)                                                                ,  /* 主契約・特約Ｐ */
     syutkp$                                            VARCHAR     (10)                                                                ,  /* 主契約・特約Ｐ(通貨型) */
     hrktuukasyutkp                                     DECIMAL     (13)                                                                ,  /* 払込通貨主契約・特約Ｐ */
     hrktuukasyutkp$                                    VARCHAR     (10)                                                                ,  /* 払込通貨主契約・特約Ｐ(通貨型) */
     tkjyp                                              DECIMAL     (13)                                                                ,  /* 特条保険料 */
     tkjyp$                                             VARCHAR     (10)                                                                ,  /* 特条保険料(通貨型) */
     katakbn                                            VARCHAR     (2)                                                                 ,  /* 型区分 */
     kyhkatakbn                                         VARCHAR     (2)                                                                 ,  /* 給付型区分 */
     syukyhkinkatakbn                                   VARCHAR     (1)                                                                 ,  /* 手術給付金型区分 */
     khnkyhkgbairitukbn                                 VARCHAR     (1)                                                                 ,  /* 基本給付金額倍率区分 */
     rokudaildkbn                                       VARCHAR     (1)                                                                 ,  /* ６大生活習慣病追加給付型区分 */
     hknkkn                                             DECIMAL     (2)                                                                 ,  /* 保険期間 */
     hrkkkn                                             DECIMAL     (2)                                                                 ,  /* 払込期間 */
     hknkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 保険期間歳満期区分 */
     hrkkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 払込期間歳満期区分 */
     dai1hknkkn                                         DECIMAL     (2)                                                                 ,  /* 第１保険期間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     tumitateriritu                                     DECIMAL     (5,4)                                                               ,  /* 積立利率 */
     tmttknzoukaritujygn                                DECIMAL     (5,4)                                                               ,  /* 積立金増加率上限 */
     setteibairitu                                      DECIMAL     (3,2)                                                               ,  /* 設定倍率 */
     kihons2                                            DECIMAL     (13)                                                                ,  /* 基本Ｓ_2 */
     kihons2$                                           VARCHAR     (10)                                                                ,  /* 基本Ｓ_2(通貨型) */
     hrktuukasyutkp2                                    DECIMAL     (13)                                                                ,  /* 払込通貨主契約・特約Ｐ＿２ */
     hrktuukasyutkp2$                                   VARCHAR     (10)                                                                ,  /* 払込通貨主契約・特約Ｐ＿２(通貨型) */
     loadinghnkgtumitateriritu                          DECIMAL     (5,4)                                                               ,  /* ローディング変更後積立利率 */
     rendouritu                                         DECIMAL     (5,4)                                                               ,  /* 連動率 */
     teikisiharaikin                                    DECIMAL     (13)                                                                ,  /* 定期支払金 */
     teikisiharaikin$                                   VARCHAR     (10)                                                                   /* 定期支払金(通貨型) */
)
;

ALTER TABLE HT_MosSyouhn_Z ADD CONSTRAINT PK_MosSyouhn PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     syouhncd                                                   /* 商品コード */
) ;
