CREATE TABLE ZT_DSeisanShrTysySyuseiRn (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnseisandshrymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）精算Ｄ支払年月日 */
     zrnseisandkgk11                                    NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）精算Ｄ金額Ｎ１１ */
     zrntyouseidkgk11                                   NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）調整Ｄ金額Ｎ１１ */
     zrnyobiv19                                         CHAR        (19)                                                      NOT NULL     /* （連携用）予備項目Ｖ１９ */
)
;

ALTER TABLE ZT_DSeisanShrTysySyuseiRn ADD CONSTRAINT PK_DSeisanShrTysySyuseiRn PRIMARY KEY (
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
