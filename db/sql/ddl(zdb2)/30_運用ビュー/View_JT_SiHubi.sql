CREATE VIEW JT_SiHubi AS SELECT
     hubisikibetukey ,         /* 不備識別キー */
     syono ,         /* 証券番号 */
     jimutetuzukinm ,         /* 事務手続名 */
     renrakusakinmkj ,         /* 連絡先氏名（漢字） */
     renrakuyno ,         /* 連絡先郵便番号 */
     renrakusakiadr1kj ,         /* 連絡先住所１（漢字） */
     renrakusakiadr2kj ,         /* 連絡先住所２（漢字） */
     renrakusakiadr3kj ,         /* 連絡先住所３（漢字） */
     renrakusakitelno ,         /* 連絡先電話番号 */
     renrakuarea ,         /* 連絡欄 */
     hassinsakifsthubihasinymd1 ,         /* 発信先別初回不備発信日１ */
     hassinsakifsthubihasinymd2 ,         /* 発信先別初回不備発信日２ */
     hasinsakibetuhubihasinymd3 ,         /* 発信先別初回不備発信日３ */
     hassinsakikaisuu1 ,         /* 発信先別発信回数１ */
     hassinsakikaisuu2 ,         /* 発信先別発信回数２ */
     hasinsakibetuhasinkaisuu3 ,         /* 発信先別発信回数３ */
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
FROM JT_SiHubi_Z;