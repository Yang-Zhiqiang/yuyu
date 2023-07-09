CREATE VIEW MT_SousaRirekiSyousai AS SELECT
     ttdksikibetuid ,         /* 手続識別ＩＤ */
     sousarirekirenno ,         /* 操作履歴連番 */
     syoriendymd ,         /* 処理終了日付 */
     syoriendtime ,         /* 処理終了時刻 */
     syorinaiyoukbn ,         /* 処理内容区分 */
     syorisyousai ,         /* 処理詳細 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_SousaRirekiSyousai_Z;