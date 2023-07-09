CREATE TABLE ZT_HonyakuYouKouinRn (
     zrnkinyuukikancd                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）金融機関コード */
     zrnkouincd                                         CHAR        (20)                                                      NOT NULL  ,  /* （連携用）行員コード */
     zrnbosyuunincd                                     CHAR        (6)                                                       NOT NULL     /* （連携用）募集人コード */
)
;

ALTER TABLE ZT_HonyakuYouKouinRn ADD CONSTRAINT PK_HonyakuYouKouinRn PRIMARY KEY (
     zrnkinyuukikancd                                         , /* （連携用）金融機関コード */
     zrnkouincd                                                 /* （連携用）行員コード */
) ;
