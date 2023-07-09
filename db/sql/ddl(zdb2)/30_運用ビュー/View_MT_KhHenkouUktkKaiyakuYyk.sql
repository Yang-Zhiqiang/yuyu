CREATE VIEW MT_KhHenkouUktkKaiyakuYyk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     hozenhenkouuktkrenno ,         /* 保全変更受付連番 */
     inputshrhousiteikbn ,         /* 入力用支払方法指定区分 */
     yenshrtkhkumu ,         /* 円支払特約付加有無 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzdoukbn ,         /* 口座名義人同一区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_KhHenkouUktkKaiyakuYyk_Z;