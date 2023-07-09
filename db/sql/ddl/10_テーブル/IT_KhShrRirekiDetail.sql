CREATE TABLE IT_KhShrRirekiDetail (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyksyouhnrenno                                     NUMBER      (2)                                                       NOT NULL  ,  /* 契約商品連番 */
     syushrgk                                           NUMBER      (13)                                                                ,  /* 主たる支払額 */
     syushrgk$                                          VARCHAR     (10)                                                                ,  /* 主たる支払額(通貨型) */
     shrtstmttkin                                       NUMBER      (13)                                                                ,  /* 支払対象積立金 */
     shrtstmttkin$                                      VARCHAR     (10)                                                                ,  /* 支払対象積立金(通貨型) */
     shrtstmttkinhngkbbn                                NUMBER      (13)                                                                ,  /* 支払対象積立金（変額部分） */
     shrtstmttkinhngkbbn$                               VARCHAR     (10)                                                                ,  /* 支払対象積立金（変額部分）(通貨型) */
     sjkkktyouseigk                                     NUMBER      (13)                                                                ,  /* 市場価格調整額 */
     sjkkktyouseigk$                                    VARCHAR     (10)                                                                ,  /* 市場価格調整額(通貨型) */
     kaiyakusjkkktyouseiritu                            NUMBER      (11,10)                                                             ,  /* 解約市場価格調整率 */
     kaiyakusjkkktyouseiriritu                          NUMBER      (5,4)                                                               ,  /* 解約時市場価格調整用利率 */
     kaiyakukjgk                                        NUMBER      (13)                                                                ,  /* 解約控除額 */
     kaiyakukjgk$                                       VARCHAR     (10)                                                                ,  /* 解約控除額(通貨型) */
     kaiyakukoujyoritu                                  NUMBER      (5,4)                                                               ,  /* 解約控除率 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     teiritutmttkngk                                    NUMBER      (13)                                                                ,  /* 定率積立金額 */
     teiritutmttkngk$                                   VARCHAR     (10)                                                                ,  /* 定率積立金額(通貨型) */
     sisuurendoutmttkngk                                NUMBER      (13)                                                                ,  /* 指数連動積立金額 */
     sisuurendoutmttkngk$                               VARCHAR     (10)                                                                   /* 指数連動積立金額(通貨型) */
)
;

ALTER TABLE IT_KhShrRirekiDetail ADD CONSTRAINT PK_KhShrRirekiDetail PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                        , /* 変更識別キー */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                             /* 契約商品連番 */
) ;

CREATE INDEX IX1_KhShrRirekiDetail ON IT_KhShrRirekiDetail (
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                        , /* 変更識別キー */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                             /* 契約商品連番 */
) ;
