CREATE VIEW ZT_TuukabetuKyuusibiRn AS SELECT
     zrntekiyouymd ,         /* （連携用）適用年月日 */
     zrnenkyuusibikbn ,         /* （連携用）円休止日区分 */
     zrnbeidorukyuusibikbn ,         /* （連携用）米ドル休止日区分 */
     zrneurkyuusibikbn ,         /* （連携用）ユーロ休止日区分 */
     zrngoudorukyuusibikbn           /* （連携用）豪ドル休止日区分 */
FROM ZT_TuukabetuKyuusibiRn_Z;