CREATE VIEW MT_DsHanyouKokyakuateTuuti2 AS SELECT
     dsdatasakuseiymd ,         /* ＤＳデータ作成日 */
     dskoktuutirenno ,         /* ＤＳ顧客通知連番 */
     dskokno ,         /* ＤＳ顧客番号 */
     dshanyoukokyakuatetuutikbn ,         /* ＤＳ汎用顧客宛通知区分 */
     syono ,         /* 証券番号 */
     dssousinno ,         /* ＤＳ送信番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsHanyouKokyakuateTuuti2_Z;