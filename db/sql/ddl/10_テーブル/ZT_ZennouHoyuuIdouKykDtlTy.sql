CREATE TABLE ZT_ZennouHoyuuIdouKykDtlTy (
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
     ztyrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）レコード区分 */
     ztykeijyouym                                       VARCHAR     (6)                                                                 ,  /* （中継用）計上年月 */
     ztysyoricd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）処理コード */
     ztyhenkousyoriymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）変更処理年月日 */
     ztydenymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）伝票日付 */
     ztyzennoucalckijyunymd                             VARCHAR     (8)                                                                 ,  /* （中継用）前納計算基準年月日 */
     ztykykmfksnctr                                     NUMBER      (7)                                                       NOT NULL  ,  /* （中継用）契約ＭＦ更新ＣＴＲ */
     ztyzennoubikinkbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）前納備金区分 */
     ztyyobiv10                                         VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０ */
     ztydatakanrino                                     VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）データ管理番号 */
     ztysyukeiyakusyuruicdv2                            VARCHAR     (2)                                                                 ,  /* （中継用）主契約種類コードＶ２ */
     ztykbnkeiriyousegmentcd                            VARCHAR     (4)                                                                 ,  /* （中継用）区分経理用セグメントコード */
     ztyzennoutoukeilistkbn                             VARCHAR     (1)                                                                 ,  /* （中継用）前納統計リスト区分 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyzennouwrbkrt                                    NUMBER      (7,6)                                                               ,  /* （中継用）前納割引率 */
     ztytkyrt1                                          NUMBER      (7,6)                                                               ,  /* （中継用）適用利率１ */
     ztytndzndkhikakukbn                                VARCHAR     (1)                                                                 ,  /* （中継用）当年度残高比較区分 */
     ztyyobiv5                                          VARCHAR     (5)                                                                 ,  /* （中継用）予備項目Ｖ５ */
     ztyzennoukaisiymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）前納開始年月日 */
     ztyzennoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）前納区分 */
     ztyzennoukikan                                     VARCHAR     (2)                                                                 ,  /* （中継用）前納期間 */
     ztyzennounyuukinymd                                VARCHAR     (8)                                                                 ,  /* （中継用）前納入金年月日 */
     ztyzennounyuukinkgk                                NUMBER      (11)                                                                ,  /* （中継用）前納入金額 */
     ztyyobiv5x2                                        VARCHAR     (5)                                                                 ,  /* （中継用）予備項目Ｖ５＿２ */
     ztyansyuyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyyobiv10x2                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿２ */
     ztytoukimatuzennouzndk                             NUMBER      (11)                                                                ,  /* （中継用）当期末前納残高金額 */
     ztytoukijyuutoup                                   NUMBER      (11)                                                                ,  /* （中継用）当期充当保険料 */
     ztytoukizennouseisangk                             NUMBER      (11)                                                                ,  /* （中継用）当期前納精算額 */
     ztytoukizennounyuukinkgk                           NUMBER      (11)                                                                ,  /* （中継用）当期前納入金額 */
     ztyyokukinenbaraip                                 NUMBER      (11)                                                                ,  /* （中継用）翌期年払Ｐ */
     ztywrbkrttkyrttekiyouzndk                          NUMBER      (11)                                                                ,  /* （中継用）割引利率適用残高 */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿３ */
     ztyyobin11x4                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿４ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_ZennouHoyuuIdouKykDtlTy ADD CONSTRAINT PK_ZennouHoyuuIdouKykDtlTy PRIMARY KEY (
     ztydatakanrino                                           , /* （中継用）データ管理番号 */
     ztysyoricd                                               , /* （中継用）処理コード */
     ztykykmfksnctr                                             /* （中継用）契約ＭＦ更新ＣＴＲ */
) ;
