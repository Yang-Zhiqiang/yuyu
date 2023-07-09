CREATE VIEW IW_KhHubiWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     renrakusakinmkj ,         /* 連絡先氏名（漢字） */
     renrakuyno ,         /* 連絡先郵便番号 */
     renrakusakiadr1kj ,         /* 連絡先住所１（漢字） */
     renrakusakiadr2kj ,         /* 連絡先住所２（漢字） */
     renrakusakiadr3kj ,         /* 連絡先住所３（漢字） */
     renrakusakitelno ,         /* 連絡先電話番号 */
     renrakuarea ,         /* 連絡欄 */
     hubianswerkjt ,         /* 不備回答期日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhHubiWk_Z;