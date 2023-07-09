CREATE VIEW HT_KykKak AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     kykkaksyrui ,         /* 契約確認種類 */
     kykkaktantcd ,         /* 契約確認担当者コード */
     kykkakkaisyacd ,         /* 契約確認会社コード */
     kykkakiraiymd ,         /* 契約確認依頼日 */
     kykkakkanytymd ,         /* 契約確認完了予定日 */
     kykkakkekkbn ,         /* 契約確認結果区分 */
     kykkakkanymd ,         /* 契約確認完了日 */
     kykkakcomment ,         /* 契約確認コメント */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_KykKak_Z;