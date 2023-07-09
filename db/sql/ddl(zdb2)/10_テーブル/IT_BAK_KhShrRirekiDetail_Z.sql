CREATE TABLE IT_BAK_KhShrRirekiDetail_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyksyouhnrenno                                     DECIMAL     (2)                                                       NOT NULL  ,  /* 契約商品連番 */
     syushrgk                                           DECIMAL     (13)                                                                ,  /* 主たる支払額 */
     syushrgk$                                          VARCHAR     (10)                                                                ,  /* 主たる支払額(通貨型) */
     shrtstmttkin                                       DECIMAL     (13)                                                                ,  /* 支払対象積立金 */
     shrtstmttkin$                                      VARCHAR     (10)                                                                ,  /* 支払対象積立金(通貨型) */
     shrtstmttkinhngkbbn                                DECIMAL     (13)                                                                ,  /* 支払対象積立金（変額部分） */
     shrtstmttkinhngkbbn$                               VARCHAR     (10)                                                                ,  /* 支払対象積立金（変額部分）(通貨型) */
     sjkkktyouseigk                                     DECIMAL     (13)                                                                ,  /* 市場価格調整額 */
     sjkkktyouseigk$                                    VARCHAR     (10)                                                                ,  /* 市場価格調整額(通貨型) */
     kaiyakusjkkktyouseiritu                            DECIMAL     (11,10)                                                             ,  /* 解約市場価格調整率 */
     kaiyakusjkkktyouseiriritu                          DECIMAL     (5,4)                                                               ,  /* 解約時市場価格調整用利率 */
     kaiyakukjgk                                        DECIMAL     (13)                                                                ,  /* 解約控除額 */
     kaiyakukjgk$                                       VARCHAR     (10)                                                                ,  /* 解約控除額(通貨型) */
     kaiyakukoujyoritu                                  DECIMAL     (5,4)                                                               ,  /* 解約控除率 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     teiritutmttkngk                                    DECIMAL     (13)                                                                ,  /* 定率積立金額 */
     teiritutmttkngk$                                   VARCHAR     (10)                                                                ,  /* 定率積立金額(通貨型) */
     sisuurendoutmttkngk                                DECIMAL     (13)                                                                ,  /* 指数連動積立金額 */
     sisuurendoutmttkngk$                               VARCHAR     (10)                                                                   /* 指数連動積立金額(通貨型) */
)
;

ALTER TABLE IT_BAK_KhShrRirekiDetail_Z ADD CONSTRAINT PK_BAK_KhShrRirekiDetail PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     henkousikibetukey                                        , /* 変更識別キー */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                             /* 契約商品連番 */
) ;
