CREATE VIEW IT_ZennouTtdkKanryouTuuti AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tyouhyouymd ,         /* 帳票作成日 */
     zennoustartym ,         /* 前納開始年月 */
     zennousyorikbn ,         /* 前納処理区分 */
     zennounyuukinsyoriymd ,         /* 前納入金処理日 */
     zennounyuukindenymd ,         /* 前納入金伝票日付 */
     ryosyuymd ,         /* 領収日 */
     zennoukikan ,         /* 前納期間 */
     zennounyuukinkgk ,         /* 前納入金額 */
     zennounyuukinkgk$ ,         /* 前納入金額(通貨型) */
     annaisaikaiym ,         /* 案内再開年月 */
     hrkkaisuu ,         /* 払込回数 */
     hrkkeiro ,         /* 払込経路 */
     jkipjytym ,         /* 次回Ｐ充当年月 */
     kyknmkj ,         /* 契約者名（漢字） */
     kykseiymd ,         /* 契約者生年月日 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknseiymd ,         /* 被保険者生年月日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_ZennouTtdkKanryouTuuti_Z;