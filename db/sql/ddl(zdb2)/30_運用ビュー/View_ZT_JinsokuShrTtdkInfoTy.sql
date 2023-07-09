CREATE VIEW ZT_JinsokuShrTtdkInfoTy AS SELECT
     ztysyorisosikicd ,         /* （中継用）処理組織コード */
     ztysyoricd ,         /* （中継用）処理コード */
     ztyhknknshrsntkno ,         /* （中継用）保険金支払処理選択番号 */
     ztysyoruiukeymd ,         /* （中継用）書類受付日 */
     ztysyoriymd ,         /* （中継用）処理年月日 */
     ztydenymd ,         /* （中継用）伝票日付 */
     ztysyoruikeikaeigyoubisuu ,         /* （中継用）書類受付経過営業日数 */
     ztysyorikeikaeigyoubisuu ,         /* （中継用）処理経過営業日数 */
     ztytoritugisosikicd ,         /* （中継用）取次組織コード */
     ztytanmatusyuruikbn ,         /* （中継用）端末種類区分 */
     ztysyono ,         /* （中継用）証券番号 */
     ztykeiyakuymd ,         /* （中継用）契約日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_JinsokuShrTtdkInfoTy_Z;