CREATE VIEW ZT_JinsokuShrTtdkInfoRn AS SELECT
     zrnsyorisosikicd ,         /* （連携用）処理組織コード */
     zrnsyoricd ,         /* （連携用）処理コード */
     zrnhknknshrsntkno ,         /* （連携用）保険金支払処理選択番号 */
     zrnsyoruiukeymd ,         /* （連携用）書類受付日 */
     zrnsyoriymd ,         /* （連携用）処理年月日 */
     zrndenymd ,         /* （連携用）伝票日付 */
     zrnsyoruikeikaeigyoubisuu ,         /* （連携用）書類受付経過営業日数 */
     zrnsyorikeikaeigyoubisuu ,         /* （連携用）処理経過営業日数 */
     zrntoritugisosikicd ,         /* （連携用）取次組織コード */
     zrntanmatusyuruikbn ,         /* （連携用）端末種類区分 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnkeiyakuymd          /* （連携用）契約日 */
FROM ZT_JinsokuShrTtdkInfoRn_Z;