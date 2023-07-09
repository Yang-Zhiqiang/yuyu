CREATE VIEW IT_HurikomiIraiTuuti AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tyouhyouymd ,         /* 帳票作成日 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsinadr4kj ,         /* 通信先住所４（漢字） */
     kyknmkj ,         /* 契約者名（漢字） */
     kyknmkn ,         /* 契約者名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     jyuutouym ,         /* 充当年月 */
     jyutoukaisuuy ,         /* 充当回数（年） */
     jyutoukaisuum ,         /* 充当回数（月） */
     yykknmnryymd ,         /* 猶予期間満了日 */
     ryosyugk ,         /* 領収金額（１０桁） */
     ryosyugk$ ,         /* 領収金額（１０桁）(通貨型) */
     hrkkigenymd ,         /* 払込期限日 */
     nipyykknmnryymd ,         /* 第２回保険料猶予期間満了日 */
     banknmkj ,         /* 銀行名（漢字） */
     sitennmkj ,         /* 支店名（漢字） */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     injiptnkbn ,         /* 印字パターン区分 */
     tuutikbn ,         /* 通知区分 */
     hurikomisyono ,         /* 振込用証券番号 */
     drtencd ,         /* 代理店コード */
     drtennmkj ,         /* 代理店名（漢字） */
     rtratkicd ,         /* （帳票用）取扱コード */
     rtyouhyoucd ,         /* （帳票用）帳票コード */
     tyhyrenrakusikibetukbn ,         /* 帳票連絡先識別区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_HurikomiIraiTuuti_Z;