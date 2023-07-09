CREATE TABLE ZT_ZennouHoyuuIdouKykDtlRn (
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrnkeijyouym                                       CHAR        (6)                                                       NOT NULL  ,  /* （連携用）計上年月 */
     zrnsyoricd                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）処理コード */
     zrnhenkousyoriymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）変更処理年月日 */
     zrndenymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）伝票日付 */
     zrnzennoucalckijyunymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）前納計算基準年月日 */
     zrnkykmfksnctr                                     NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）契約ＭＦ更新ＣＴＲ */
     zrnzennoubikinkbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）前納備金区分 */
     zrnyobiv10                                         CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０ */
     zrndatakanrino                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）データ管理番号 */
     zrnsyukeiyakusyuruicdv2                            CHAR        (2)                                                       NOT NULL  ,  /* （連携用）主契約種類コードＶ２ */
     zrnkbnkeiriyousegmentcd                            CHAR        (4)                                                       NOT NULL  ,  /* （連携用）区分経理用セグメントコード */
     zrnzennoutoukeilistkbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）前納統計リスト区分 */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnzennouwrbkrt                                    NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）前納割引率 */
     zrntkyrt1                                          NUMBER      (7,6)                                                     NOT NULL  ,  /* （連携用）適用利率１ */
     zrntndzndkhikakukbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）当年度残高比較区分 */
     zrnyobiv5                                          CHAR        (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ５ */
     zrnzennoukaisiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）前納開始年月日 */
     zrnzennoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）前納区分 */
     zrnzennoukikan                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）前納期間 */
     zrnzennounyuukinymd                                CHAR        (8)                                                       NOT NULL  ,  /* （連携用）前納入金年月日 */
     zrnzennounyuukinkgk                                NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）前納入金額 */
     zrnyobiv5x2                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ５＿２ */
     zrnansyuyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnyobiv10x2                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿２ */
     zrntoukimatuzennouzndk                             NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当期末前納残高金額 */
     zrntoukijyuutoup                                   NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当期充当保険料 */
     zrntoukizennouseisangk                             NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当期前納精算額 */
     zrntoukizennounyuukinkgk                           NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）当期前納入金額 */
     zrnyokukinenbaraip                                 NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）翌期年払Ｐ */
     zrnwrbkrttkyrttekiyouzndk                          NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）割引利率適用残高 */
     zrnyobin11                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnyobin11x3                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿３ */
     zrnyobin11x4                                       NUMBER      (11)                                                      NOT NULL     /* （連携用）予備項目Ｎ１１＿４ */
)
;

ALTER TABLE ZT_ZennouHoyuuIdouKykDtlRn ADD CONSTRAINT PK_ZennouHoyuuIdouKykDtlRn PRIMARY KEY (
     zrndatakanrino                                           , /* （連携用）データ管理番号 */
     zrnsyoricd                                               , /* （連携用）処理コード */
     zrnkykmfksnctr                                             /* （連携用）契約ＭＦ更新ＣＴＲ */
) ;
