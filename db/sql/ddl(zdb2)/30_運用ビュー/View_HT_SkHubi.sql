CREATE VIEW HT_SkHubi AS SELECT
     mosno ,         /* 申込番号 */
     hubisikibetukey ,         /* 不備識別キー */
     jimutetuzukinm ,         /* 事務手続名 */
     rnrkskhaneikbn ,         /* 連絡先反映区分 */
     utdskknnm1kj ,         /* 打出機関名１（漢字） */
     utdskknnm2kj ,         /* 打出機関名２（漢字） */
     tuutisakitantounmkj ,         /* 通知先担当者名（漢字） */
     tuutikyokasyanmkj ,         /* 通知許可者名（漢字） */
     commentarea ,         /* コメント欄 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkHubi_Z;