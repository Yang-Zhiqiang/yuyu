CREATE TABLE HT_BosSyouhn (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     ryouritusdno                                       VARCHAR     (3)                                                                 ,  /* 料率世代番号 */
     syutkkbn                                           VARCHAR     (1)                                                                 ,  /* 主契約特約区分 */
     sknenkinsyu                                        VARCHAR     (2)                                                                 ,  /* 新契約年金種類 */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     seitoukihons                                       NUMBER      (13)                                                                ,  /* 正当基本Ｓ */
     seitoukihons$                                      VARCHAR     (10)                                                                ,  /* 正当基本Ｓ(通貨型) */
     syutkp                                             NUMBER      (13)                                                                ,  /* 主契約・特約Ｐ */
     syutkp$                                            VARCHAR     (10)                                                                ,  /* 主契約・特約Ｐ(通貨型) */
     hrktuukasyutkp                                     NUMBER      (13)                                                                ,  /* 払込通貨主契約・特約Ｐ */
     hrktuukasyutkp$                                    VARCHAR     (10)                                                                ,  /* 払込通貨主契約・特約Ｐ(通貨型) */
     tkjyp                                              NUMBER      (13)                                                                ,  /* 特条保険料 */
     tkjyp$                                             VARCHAR     (10)                                                                ,  /* 特条保険料(通貨型) */
     katakbn                                            VARCHAR     (2)                                                                 ,  /* 型区分 */
     kyhkatakbn                                         VARCHAR     (2)                                                                 ,  /* 給付型区分 */
     syukyhkinkatakbn                                   VARCHAR     (1)                                                                 ,  /* 手術給付金型区分 */
     khnkyhkgbairitukbn                                 VARCHAR     (1)                                                                 ,  /* 基本給付金額倍率区分 */
     rokudaildkbn                                       VARCHAR     (1)                                                                 ,  /* ６大生活習慣病追加給付型区分 */
     hknkkn                                             NUMBER      (2)                                                                 ,  /* 保険期間 */
     hrkkkn                                             NUMBER      (2)                                                                 ,  /* 払込期間 */
     hknkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 保険期間歳満期区分 */
     hrkkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 払込期間歳満期区分 */
     dai1hknkkn                                         NUMBER      (2)                                                                 ,  /* 第１保険期間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_BosSyouhn ADD CONSTRAINT PK_BosSyouhn PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     syouhncd                                                   /* 商品コード */
) ;
