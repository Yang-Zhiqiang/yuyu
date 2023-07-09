CREATE VIEW IT_BAK_HhknSya AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     kokno ,         /* 顧客番号 */
     hhknsakuinmeino ,         /* 被保険者索引名番号 */
     hhknnmkn ,         /* 被保険者名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknnmkjkhukakbn ,         /* 被保険者名漢字化不可区分 */
     hhknseiymd ,         /* 被保険者生年月日 */
     hhknsei ,         /* 被保険者性別 */
     hhknyno ,         /* 被保険者郵便番号 */
     hhknadr1kn ,         /* 被保険者住所１（カナ） */
     hhknadr1kj ,         /* 被保険者住所１（漢字） */
     hhknadr2kn ,         /* 被保険者住所２（カナ） */
     hhknadr2kj ,         /* 被保険者住所２（漢字） */
     hhknadr3kn ,         /* 被保険者住所３（カナ） */
     hhknadr3kj ,         /* 被保険者住所３（漢字） */
     hhkntelno ,         /* 被保険者電話番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_HhknSya_Z;