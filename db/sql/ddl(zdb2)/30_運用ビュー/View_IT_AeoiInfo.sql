CREATE VIEW IT_AeoiInfo AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     renno ,         /* 連番 */
     aeoisyoriymd ,         /* ＡＥＯＩ処理年月日 */
     aeoisyorikbn ,         /* ＡＥＯＩ処理区分 */
     aeoikouryokusttymd ,         /* ＡＥＯＩ効力開始年月日 */
     aeoisyorisosikicd ,         /* ＡＥＯＩ処理組織コード */
     aeoitaisyousyakbn ,         /* ＡＥＯＩ対象者区分 */
     aeoikekkakbn ,         /* ＡＥＯＩ結果区分 */
     aeoihoujinsyuruikbn ,         /* ＡＥＯＩ法人種類区分 */
     aeoikouryokuendymd ,         /* ＡＥＯＩ効力終了年月日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_AeoiInfo_Z;