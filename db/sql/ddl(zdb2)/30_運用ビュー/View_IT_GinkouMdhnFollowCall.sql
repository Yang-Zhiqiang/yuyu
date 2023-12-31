CREATE VIEW IT_GinkouMdhnFollowCall AS SELECT
     kbnkey ,         /* 区分キー */
     syoriYmd ,         /* 処理年月日 */
     syono ,         /* 証券番号 */
     kyksakuinmeino ,         /* 契約者索引名番号 */
     kykseiymd ,         /* 契約者生年月日 */
     kyknmkj ,         /* 契約者名（漢字） */
     kyknmkn ,         /* 契約者名（カナ） */
     tsintelno ,         /* 通信先電話番号 */
     followcallsyorikbn ,         /* フォローコール処理区分 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     bsyujdrtencd1 ,         /* 募集時代理店コード１ */
     bsyujbosyuucd1 ,         /* 募集時募集人コード１ */
     bsyujdrtencd2 ,         /* 募集時代理店コード２ */
     bsyujbosyuucd2 ,         /* 募集時募集人コード２ */
     bsyujdrtencd3 ,         /* 募集時代理店コード３ */
     bsyujbosyuucd3 ,         /* 募集時募集人コード３ */
     bsyujdrtencd4 ,         /* 募集時代理店コード４ */
     bsyujbosyuucd4 ,         /* 募集時募集人コード４ */
     bsyujdrtencd5 ,         /* 募集時代理店コード５ */
     bsyujbosyuucd5 ,         /* 募集時募集人コード５ */
     saisindrtencd ,         /* 最新代理店コード */
     saisinbosyuucd ,         /* 最新募集人コード */
     syouhnnm ,         /* 商品名 */
     kykymd ,         /* 契約日 */
     jkipjytym ,         /* 次回Ｐ充当年月 */
     annaigk ,         /* 案内金額 */
     annaigk$ ,         /* 案内金額(通貨型) */
     hrkkeiro ,         /* 払込経路 */
     fchrkkaisuu ,         /* フォローコール払込回数 */
     anniskcd ,         /* 案内先コード */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknnmkn ,         /* 被保険者名（カナ） */
     hhknsei ,         /* 被保険者性別 */
     hhknseiymd ,         /* 被保険者生年月日 */
     minyuym ,         /* 未入年月 */
     kyknmhnykkbn ,         /* 契約者名翻訳結果区分 */
     hhknnmhnykkbn ,         /* 被保険者名翻訳結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_GinkouMdhnFollowCall_Z;