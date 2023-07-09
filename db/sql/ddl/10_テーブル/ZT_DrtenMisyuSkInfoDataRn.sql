CREATE TABLE ZT_DrtenMisyuSkInfoDataRn (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrnkykymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約年月日 */
     zrnhnsyugknjkyksynm                                VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）編集後漢字契約者名 */
     zrnknjhhknmei                                      VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字被保険者名 */
     zrnkykjyutikbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）契約状態区分 */
     zrntsinkihontikucd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）通信先基本地区コード */
     zrnkanjitsinkaiadr                                 VARCHAR     (62)                                                      NOT NULL  ,  /* （連携用）漢字通信先下位住所 */
     zrntsintelno                                       CHAR        (14)                                                      NOT NULL  ,  /* （連携用）通信先電話番号 */
     zrndai2tsintelno                                   CHAR        (14)                                                      NOT NULL  ,  /* （連携用）第２通信先電話番号 */
     zrnkzhurikaebankcd                                 CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口座振替銀行番号 */
     zrnkzhurikaesitencd                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）口座振替支店番号 */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano                                CHAR        (7)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号 */
     zrnkzhurikaemeiginm                                CHAR        (30)                                                      NOT NULL  ,  /* （連携用）口座振替名義人名 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnyobiv6x5                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ６＿５ */
     zrn1kaip                                           NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）１回分保険料 */
     zrnnexthurikaeyoteigk                              NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）次回振替予定金額 */
     zrnhrkyykknmnryymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）払込猶予期間満了日 */
     zrnskymd                                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）失効年月日 */
     zrnjhurikstkkahikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）自動振替貸付可否区分 */
     zrnhukkatumoskahikbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）復活申込可否区分 */
     zrnttdkkigenymd                                    CHAR        (8)                                                       NOT NULL  ,  /* （連携用）手続き期限年月日 */
     zrnhukkatukanoukknmnryymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）復活可能期間満了年月日 */
     zrnkeikatukisuu3keta                               CHAR        (3)                                                       NOT NULL  ,  /* （連携用）経過月数（３桁） */
     zrnmisyuuhasseiym                                  CHAR        (6)                                                       NOT NULL  ,  /* （連携用）未収発生年月 */
     zrnmisyuujiyuu                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）未収事由 */
     zrnhanteiymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）判定年月日 */
     zrnyobin11                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１ */
     zrnyobin11x2                                       NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿２ */
     zrnnexthurikaeymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）次回振替年月日 */
     zrnyobiv8x3                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ８＿３ */
     zrnikkatubaraikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）一括払回数 */
     zrnyobiv55                                         CHAR        (55)                                                      NOT NULL     /* （連携用）予備項目Ｖ５５ */
)
;

ALTER TABLE ZT_DrtenMisyuSkInfoDataRn ADD CONSTRAINT PK_DrtenMisyuSkInfoDataRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrnhanteiymd                                               /* （連携用）判定年月日 */
) ;
