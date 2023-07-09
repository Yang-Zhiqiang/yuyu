CREATE TABLE ZT_TumitateYosokuRn (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnkeiyakuymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約日 */
     zrntysytymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）抽出日 */
     zrnkyktuukasyu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約通貨種類 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrntmttknsyuruikbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）積立金種類区分 */
     zrnsisuukbn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）指数区分 */
     zrntmttknysktaisyoukensuu                          NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）積立金予測対象件数 */
     zrnkyktuukakyktmttkngk                             NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）契約通貨建契約時積立金額 */
     zrnkyktuukakisitmttkngk                            NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）契約通貨建期始積立金額 */
     zrnkyktuukaysktmttkngk                             NUMBER      (13,2)                                                    NOT NULL     /* （連携用）契約通貨建予測積立金額 */
)
;

ALTER TABLE ZT_TumitateYosokuRn ADD CONSTRAINT PK_TumitateYosokuRn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号 */
     zrnkeiyakuymd                                            , /* （連携用）契約日 */
     zrntysytymd                                              , /* （連携用）抽出日 */
     zrnkyktuukasyu                                           , /* （連携用）契約通貨種類 */
     zrnhknkkn                                                , /* （連携用）保険期間 */
     zrntmttknsyuruikbn                                       , /* （連携用）積立金種類区分 */
     zrnsisuukbn                                                /* （連携用）指数区分 */
) ;
