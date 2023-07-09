CREATE VIEW ZT_SisuuRendouRn AS SELECT
     zrntorikomiyousisuukbn ,         /* （連携用）取込用指数区分 */
     zrnsisuukouhyouymd ,         /* （連携用）指数公表日 */
     zrntorikomiyousisuu ,         /* （連携用）取込用指数 */
     zrnsisuucalckijyunymd ,         /* （連携用）指数計算基準日 */
     zrnyobin11x40 ,         /* （連携用）予備項目Ｎ１１＿４０ */
     zrnyobiv71           /* （連携用）予備項目Ｖ７１ */
FROM ZT_SisuuRendouRn_Z;