CREATE TABLE ZT_SisuuRendouRn (
     zrntorikomiyousisuukbn                             CHAR        (1)                                                       NOT NULL  ,  /* （連携用）取込用指数区分 */
     zrnsisuukouhyouymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）指数公表日 */
     zrntorikomiyousisuu                                NUMBER      (11,5)                                                    NOT NULL  ,  /* （連携用）取込用指数 */
     zrnsisuucalckijyunymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）指数計算基準日 */
     zrnyobin11x40                                      NUMBER      (11,5)                                                    NOT NULL  ,  /* （連携用）予備項目Ｎ１１＿４０ */
     zrnyobiv71                                         CHAR        (71)                                                      NOT NULL     /* （連携用）予備項目Ｖ７１ */
)
;

ALTER TABLE ZT_SisuuRendouRn ADD CONSTRAINT PK_SisuuRendouRn PRIMARY KEY (
     zrntorikomiyousisuukbn                                   , /* （連携用）取込用指数区分 */
     zrnsisuukouhyouymd                                         /* （連携用）指数公表日 */
) ;
