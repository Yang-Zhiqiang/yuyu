CREATE VIEW MT_DsTorihikiyouAnsyono AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     syono ,         /* 証券番号 */
     tokuteitrhkansyono ,         /* 特定取引用暗証番号 */
     tktrhkansyonoerrorkaisuu ,         /* 特定取引用暗証番号エラー回数 */
     setymd ,         /* 設定年月日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsTorihikiyouAnsyono_Z;