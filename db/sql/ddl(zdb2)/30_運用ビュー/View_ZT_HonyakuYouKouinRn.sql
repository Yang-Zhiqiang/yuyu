CREATE VIEW ZT_HonyakuYouKouinRn AS SELECT
     zrnkinyuukikancd ,         /* （連携用）金融機関コード */
     zrnkouincd ,         /* （連携用）行員コード */
     zrnbosyuunincd           /* （連携用）募集人コード */
FROM ZT_HonyakuYouKouinRn_Z;