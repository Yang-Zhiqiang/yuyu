CREATE TABLE ZT_TuukabetuKyuusibiRn (
     zrntekiyouymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）適用年月日 */
     zrnenkyuusibikbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）円休止日区分 */
     zrnbeidorukyuusibikbn                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）米ドル休止日区分 */
     zrneurkyuusibikbn                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ユーロ休止日区分 */
     zrngoudorukyuusibikbn                              CHAR        (1)                                                       NOT NULL     /* （連携用）豪ドル休止日区分 */
)
;

ALTER TABLE ZT_TuukabetuKyuusibiRn ADD CONSTRAINT PK_TuukabetuKyuusibiRn PRIMARY KEY (
     zrntekiyouymd                                              /* （連携用）適用年月日 */
) ;
