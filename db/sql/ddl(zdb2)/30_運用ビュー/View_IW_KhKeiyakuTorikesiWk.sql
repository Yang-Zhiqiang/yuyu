CREATE VIEW IW_KhKeiyakuTorikesiWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     kyktrkskbn ,         /* 契約取消区分 */
     sibouymd ,         /* 死亡日 */
     kaijyokessaiymd ,         /* 解除決裁日 */
     kaijyotuutiymd ,         /* 解除通知日 */
     syoruiukeymd ,         /* 書類受付日 */
     hubikanryouymd ,         /* 不備完了日 */
     sinsagendokknkbn ,         /* 審査限度期間区分 */
     rikoukityuutuudannissuu ,         /* 履行期中断日数 */
     soukinsakisiteikbn ,         /* 送金先指定区分 */
     soukinsakinmkn ,         /* 送金先氏名（カナ） */
     soukinsakinmkj ,         /* 送金先氏名（漢字） */
     soukinsakiyno ,         /* 送金先郵便番号 */
     soukinsakiadr1kj ,         /* 送金先住所１（漢字） */
     soukinsakiadr2kj ,         /* 送金先住所２（漢字） */
     soukinsakiadr3kj ,         /* 送金先住所３（漢字） */
     kyksyaszknmkn ,         /* 契約者相続人氏名（カナ） */
     kyksyaszknmkj ,         /* 契約者相続人氏名（漢字） */
     kyksyaszkyno ,         /* 契約者相続人郵便番号 */
     kyksyaszkadr1kj ,         /* 契約者相続人住所１（漢字） */
     kyksyaszkadr2kj ,         /* 契約者相続人住所２（漢字） */
     kyksyaszkadr3kj ,         /* 契約者相続人住所３（漢字） */
     yenshrtkumu ,         /* 円支払特約有無 */
     inputshrhousiteikbn ,         /* 入力用支払方法指定区分 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzdoukbn ,         /* 口座名義人同一区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     kykmnmeigibangou ,         /* 契約者ＭＮ名義番号 */
     uktmnmeigibangou ,         /* 受取人ＭＮ名義番号 */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     soukinsakikbn           /* 送金先区分 */
FROM IW_KhKeiyakuTorikesiWk_Z;