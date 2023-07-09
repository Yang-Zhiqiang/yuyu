CREATE VIEW JT_SiJinsokuShrTtdkInfo AS SELECT
     syorisosikicd ,         /* 処理組織コード */
     syoricd ,         /* 処理コード */
     hknknshrsntkno ,         /* 保険金支払処理選択番号 */
     syoruiukeymd ,         /* 書類受付日 */
     syoriYmd ,         /* 処理年月日 */
     denymd ,         /* 伝票日付 */
     syoruikeikaeigyoubisuu ,         /* 書類受付経過営業日数 */
     syorikeikaeigyoubisuu ,         /* 処理経過営業日数 */
     toritugisosikicd ,         /* 取次組織コード */
     tanmatusyuruikbn ,         /* 端末種類区分 */
     syono ,         /* 証券番号 */
     kykymd ,         /* 契約日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SiJinsokuShrTtdkInfo_Z;