CREATE VIEW IW_KhSeinengappiSeiTeiseiWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     newhhknseiymd ,         /* 変更後被保険者生年月日 */
     newhhknsei ,         /* 変更後被保険者性別 */
     yenshrtkhkumu ,         /* 円支払特約付加有無 */
     inputshrhousiteikbn ,         /* 入力用支払方法指定区分 */
     soukinsakikbn ,         /* 送金先区分 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzdoukbn ,         /* 口座名義人同一区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     hassoukbn ,         /* 発送区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     syorikbn           /* 処理区分 */
FROM IW_KhSeinengappiSeiTeiseiWk_Z;