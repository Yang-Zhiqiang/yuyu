CREATE TABLE IT_ZennouHoyuuIdouKykDtl (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     sakuseiymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* 作成年月日 */
     syoricd                                            VARCHAR     (4)                                                       NOT NULL  ,  /* 処理コード */
     kykmfksnctr                                        NUMBER      (7)                                                       NOT NULL  ,  /* 契約ＭＦ更新ＣＴＲ */
     henkousyoriymd                                     VARCHAR     (8)                                                                 ,  /* 変更処理年月日 */
     zennoukessanrecordkbn                              VARCHAR     (1)                                                                 ,  /* 前納決算レコード区分 */
     keijyouym                                          NUMBER      (6)                                                                 ,  /* 計上年月 */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     zennoucalckijyunymd                                VARCHAR     (8)                                                                 ,  /* 前納計算基準年月日 */
     zennoubikinkbn                                     VARCHAR     (1)                                                                 ,  /* 前納備金区分 */
     syukeiyakusyuruicd                                 VARCHAR     (2)                                                                 ,  /* 主契約種類コード */
     kbnkeirisegcd                                      VARCHAR     (20)                                                                ,  /* 区分経理用セグメントコード */
     zennoutoukeilistkbn                                VARCHAR     (1)                                                                 ,  /* 前納統計リスト区分 */
     keiyakuymd                                         VARCHAR     (8)                                                                 ,  /* 契約年月日 */
     zennouwrbkrt                                       NUMBER      (7,6)                                                               ,  /* 前納割引率 */
     tndmatutkyrt                                       NUMBER      (7,6)                                                               ,  /* 当年度末適用利率 */
     tndzndkhikakukbn                                   VARCHAR     (1)                                                                 ,  /* 当年度残高比較区分 */
     zennoukaisiymd                                     VARCHAR     (8)                                                                 ,  /* 前納開始年月日 */
     zennoukbn                                          VARCHAR     (1)                                                                 ,  /* 前納区分 */
     zennoukikan                                        VARCHAR     (2)                                                                 ,  /* 前納期間 */
     zennounyuukinymd                                   VARCHAR     (8)                                                                 ,  /* 前納入金年月日 */
     zennounyuukinkgk                                   NUMBER      (13)                                                                ,  /* 前納入金額 */
     zennounyuukinkgk$                                  VARCHAR     (10)                                                                ,  /* 前納入金額(通貨型) */
     toukimatuzennouzndk                                NUMBER      (11)                                                                ,  /* 当期末前納残高金額 */
     toukimatuzennouzndk$                               VARCHAR     (10)                                                                ,  /* 当期末前納残高金額(通貨型) */
     toukijyuutoup                                      NUMBER      (11)                                                                ,  /* 当期充当Ｐ */
     toukijyuutoup$                                     VARCHAR     (10)                                                                ,  /* 当期充当Ｐ(通貨型) */
     toukizennouseisangk                                NUMBER      (11)                                                                ,  /* 当期前納精算額 */
     toukizennouseisangk$                               VARCHAR     (10)                                                                ,  /* 当期前納精算額(通貨型) */
     toukizennounyuukinkgk                              NUMBER      (11)                                                                ,  /* 当期前納入金額 */
     toukizennounyuukinkgk$                             VARCHAR     (10)                                                                ,  /* 当期前納入金額(通貨型) */
     yokukinenbaraip                                    NUMBER      (11)                                                                ,  /* 翌期年払Ｐ */
     yokukinenbaraip$                                   VARCHAR     (10)                                                                ,  /* 翌期年払Ｐ(通貨型) */
     wrbkrttkyrt                                        NUMBER      (11)                                                                ,  /* 割引利率適用残高 */
     wrbkrttkyrt$                                       VARCHAR     (10)                                                                ,  /* 割引利率適用残高(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_ZennouHoyuuIdouKykDtl ADD CONSTRAINT PK_ZennouHoyuuIdouKykDtl PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     sakuseiymd                                               , /* 作成年月日 */
     syoricd                                                  , /* 処理コード */
     kykmfksnctr                                                /* 契約ＭＦ更新ＣＴＲ */
) ;
