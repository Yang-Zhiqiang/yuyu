CREATE TABLE ZT_HknkykIdouInfoRn (
     zrnkyktuukasyu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約通貨種類 */
     zrnidouymd                                         CHAR        (8)                                                       NOT NULL  ,  /* （連携用）異動日 */
     zrnidoujiyuukbnzfi                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）異動事由区分（資産運用） */
     zrndatakanrino                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）データ管理番号 */
     zrnrenno                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）連番 */
     zrnkeiyakuymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約日 */
     zrnhhknnen2                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）被保険者年齢Ｃ２ */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別 */
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnaisyoumeikbn                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）愛称名区分 */
     zrnzougenkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）増減区分 */
     zrnhokenkngk13                                     NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）保険金額Ｎ１３ */
     zrnp13                                             NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）保険料Ｎ１３ */
     zrnptumitatekin13                                  NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）保険料積立金Ｎ１３ */
     zrnkiykhnrikn13                                    NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）解約返戻金Ｎ１３ */
     zrnidouhokenkngk                                   NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）異動保険金額 */
     zrnidoup                                           NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）異動保険料 */
     zrnidouptumitatekin                                NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）異動保険料積立金 */
     zrnidoukiykhnrikn                                  NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）異動解約返戻金 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnyoteiriritun5                                   NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）予定利率Ｎ５ */
     zrntumitatekinkbn                                  CHAR        (2)                                                       NOT NULL     /* （連携用）積立金区分 */
)
;

ALTER TABLE ZT_HknkykIdouInfoRn ADD CONSTRAINT PK_HknkykIdouInfoRn PRIMARY KEY (
     zrnkyktuukasyu                                           , /* （連携用）契約通貨種類 */
     zrnidouymd                                               , /* （連携用）異動日 */
     zrnidoujiyuukbnzfi                                       , /* （連携用）異動事由区分（資産運用） */
     zrndatakanrino                                           , /* （連携用）データ管理番号 */
     zrnrenno                                                 , /* （連携用）連番 */
     zrntumitatekinkbn                                          /* （連携用）積立金区分 */
) ;
