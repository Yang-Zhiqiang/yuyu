CREATE VIEW MT_SousaRireki AS SELECT
     ttdksikibetuid ,         /* 手続識別ＩＤ */
     syono ,         /* 証券番号 */
     dskokno ,         /* ＤＳ顧客番号 */
     ttdkstartymd ,         /* 手続開始日付 */
     ttdkstarttime ,         /* 手続開始時刻 */
     ttdkendymd ,         /* 手続終了日付 */
     ttdkendtime ,         /* 手続終了時刻 */
     ttdkkinoukbn ,         /* 手続機能区分 */
     sousarirekijkkbn ,         /* 操作履歴状況区分 */
     sousarirekikekkakbn ,         /* 操作履歴結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_SousaRireki_Z;