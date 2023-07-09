CREATE VIEW ZT_BosyuuninRn AS SELECT
     zrnbosyuunincd ,         /* （連携用）募集人コード */
     zrnbosyuuninnm ,         /* （連携用）募集人名 */
     zrnkanjibosyuuninnm ,         /* （連携用）漢字募集人名 */
     zrnitakuymd ,         /* （連携用）委託年月日 */
     zrndairitencd1 ,         /* （連携用）代理店コード（１） */
     zrndairitencd2 ,         /* （連携用）代理店コード（２） */
     zrndairitencd3 ,         /* （連携用）代理店コード（３） */
     zrndairitenkanrisskcd1 ,         /* （連携用）代理店管理組織コード（１） */
     zrndairitenkanrisskcd2 ,         /* （連携用）代理店管理組織コード（２） */
     zrndairitenkanrisskcd3 ,         /* （連携用）代理店管理組織コード（３） */
     zrnbosyuukbn ,         /* （連携用）募集人区分 */
     zrnbosyuunintourokuymd ,         /* （連携用）募集人登録年月日 */
     zrnbosyuuninkahikbn ,         /* （連携用）募集可否区分 */
     zrnbosyuuningyouhaiymd ,         /* （連携用）募集人業廃年月日 */
     zrnhengakutourokuymd ,         /* （連携用）変額保険資格登録年月日 */
     zrnhengakumassyouymd ,         /* （連携用）変額保険資格登録抹消年月日 */
     zrnbosyuuseiymd ,         /* （連携用）募集人生年月日 */
     zrnitakukaiyakuymd ,         /* （連携用）委託解約日 */
     zrndaihyoubosyuunincd ,         /* （連携用）代表募集人コード */
     zrnbosyuutourokuno ,         /* （連携用）募集人登録番号 */
     zrnyobiv5           /* （連携用）予備項目Ｖ５ */
FROM ZT_BosyuuninRn_Z;