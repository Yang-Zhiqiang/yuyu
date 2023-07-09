CREATE VIEW MT_DsTourokuUkKanri AS SELECT
     syono ,         /* 証券番号 */
     dsttdksyubetukbn ,         /* ＤＳ手続種別区分 */
     datarenno ,         /* データ連番 */
     dskokno ,         /* ＤＳ顧客番号 */
     mosno ,         /* 申込番号 */
     tourokustatus ,         /* 登録ステータス */
     dsjimukaisiymd ,         /* ＤＳ事務開始日 */
     dsjimukanryouymd ,         /* ＤＳ事務完了日 */
     dstourokukanryouymd ,         /* ＤＳ登録完了日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsTourokuUkKanri_Z;