CREATE VIEW IT_BAK_KhTtdkRireki AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     henkousikibetukey ,         /* 変更識別キー */
     syoriYmd ,         /* 処理年月日 */
     syorisosikicd ,         /* 処理組織コード */
     shrsyousaiumu ,         /* 支払詳細有無区分 */
     syorikbn ,         /* 処理区分 */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     henkourrkumu ,         /* 変更履歴有無 */
     smbckanriid ,         /* ＳＭＢＣ受付管理ＩＤ */
     nayosekihontblskbtkey ,         /* 名寄せ基本テーブル識別キー */
     kouteikanriid ,         /* 工程管理ＩＤ */
     youkyuuno ,         /* 要求通番 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_KhTtdkRireki_Z;