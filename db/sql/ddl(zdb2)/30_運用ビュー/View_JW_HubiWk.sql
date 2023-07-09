CREATE VIEW JW_HubiWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     renrakusakinmkj ,         /* 連絡先氏名（漢字） */
     renrakuyno ,         /* 連絡先郵便番号 */
     renrakusakiadr1kj ,         /* 連絡先住所１（漢字） */
     renrakusakiadr2kj ,         /* 連絡先住所２（漢字） */
     renrakusakiadr3kj ,         /* 連絡先住所３（漢字） */
     renrakusakitelno ,         /* 連絡先電話番号 */
     renrakuarea ,         /* 連絡欄 */
     sisyacd ,         /* 支社コード */
     sisyanm ,         /* 支社名 */
     toiawasesosikinmkj ,         /* 問合せ先組織名（漢字） */
     toiawasetelno ,         /* 問合せ先電話番号 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JW_HubiWk_Z;