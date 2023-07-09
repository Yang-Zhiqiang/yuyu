CREATE VIEW IT_KhHubi AS SELECT
     hubisikibetukey ,         /* 不備識別キー */
     syono ,         /* 証券番号 */
     jimuttdknm ,         /* 契約管理事務手続名 */
     renrakusakinmkj ,         /* 連絡先氏名（漢字） */
     renrakuyno ,         /* 連絡先郵便番号 */
     renrakusakiadr1kj ,         /* 連絡先住所１（漢字） */
     renrakusakiadr2kj ,         /* 連絡先住所２（漢字） */
     renrakusakiadr3kj ,         /* 連絡先住所３（漢字） */
     renrakusakitelno ,         /* 連絡先電話番号 */
     renrakuarea ,         /* 連絡欄 */
     hubianswerkjt ,         /* 不備回答期日 */
     sksreadymd ,         /* 請求書読込日 */
     hassinsakifsthubihasinymd1 ,         /* 発信先別初回不備発信日１ */
     hassinsakifsthubihasinymd2 ,         /* 発信先別初回不備発信日２ */
     hassinsakikaisuu1 ,         /* 発信先別発信回数１ */
     hassinsakikaisuu2 ,         /* 発信先別発信回数２ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhHubi_Z;