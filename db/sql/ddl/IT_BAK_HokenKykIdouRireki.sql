CREATE TABLE IT_BAK_HokenKykIdouRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     idouymd                                            VARCHAR     (8)                                                                 ,  /* 異動日 */
     idoujiyuukbn                                       VARCHAR     (3)                                                                 ,  /* 異動事由区分 */
     ttdkrenno                                          NUMBER      (2)                                                                 ,  /* 手続連番 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hhknnen                                            NUMBER      (3)                                                                 ,  /* 被保険者年齢 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     aisyoumeikbn                                       VARCHAR     (3)                                                                 ,  /* 愛称名区分 */
     zougenkbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 増減区分 */
     hokenkngk                                          NUMBER      (13)                                                                ,  /* 保険金額 */
     hokenkngk$                                         VARCHAR     (10)                                                                ,  /* 保険金額(通貨型) */
     hokenryou                                          NUMBER      (13)                                                                ,  /* 保険料 */
     hokenryou$                                         VARCHAR     (10)                                                                ,  /* 保険料(通貨型) */
     ptumitatekin                                       NUMBER      (13)                                                                ,  /* 保険料積立金 */
     ptumitatekin$                                      VARCHAR     (10)                                                                ,  /* 保険料積立金(通貨型) */
     kaiyakuhrgoukei                                    NUMBER      (13)                                                                ,  /* 解約返戻金合計 */
     kaiyakuhrgoukei$                                   VARCHAR     (10)                                                                ,  /* 解約返戻金合計(通貨型) */
     kaiyakuhr                                          NUMBER      (13)                                                                ,  /* 解約返戻金 */
     kaiyakuhr$                                         VARCHAR     (10)                                                                ,  /* 解約返戻金(通貨型) */
     mikeikap                                           NUMBER      (13)                                                                ,  /* 未経過保険料 */
     mikeikap$                                          VARCHAR     (10)                                                                ,  /* 未経過保険料(通貨型) */
     zennouseisankgk                                    NUMBER      (13)                                                                ,  /* 前納精算金額 */
     zennouseisankgk$                                   VARCHAR     (10)                                                                ,  /* 前納精算金額(通貨型) */
     idouhokenkngk                                      NUMBER      (13)                                                                ,  /* 異動保険金額 */
     idouhokenkngk$                                     VARCHAR     (10)                                                                ,  /* 異動保険金額(通貨型) */
     idouptumitatekin                                   NUMBER      (13)                                                                ,  /* 異動保険料積立金 */
     idouptumitatekin$                                  VARCHAR     (10)                                                                ,  /* 異動保険料積立金(通貨型) */
     idoukiykhnrikn                                     NUMBER      (13)                                                                ,  /* 異動解約返戻金 */
     idoukiykhnrikn$                                    VARCHAR     (10)                                                                ,  /* 異動解約返戻金(通貨型) */
     hknkkn                                             NUMBER      (2)                                                                 ,  /* 保険期間 */
     yoteiriritu                                        NUMBER      (5,4)                                                               ,  /* 予定利率 */
     tumitatekinkbn                                     VARCHAR     (2)                                                                 ,  /* 積立金区分 */
     kykidouharaikatakbn                                VARCHAR     (1)                                                                 ,  /* 保険契約異動情報払方区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_HokenKykIdouRireki ADD CONSTRAINT PK_BAK_HokenKykIdouRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     henkousikibetukey                                        , /* 変更識別キー */
     zougenkbn                                                  /* 増減区分 */
) ;
