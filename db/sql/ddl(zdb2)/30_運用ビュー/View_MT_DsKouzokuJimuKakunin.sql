CREATE VIEW MT_DsKouzokuJimuKakunin AS SELECT
     hasseiymd ,         /* 発生日 */
     dskzkjmkknhsjykbn ,         /* ＤＳ後続事務確認発生事由区分 */
     syono ,         /* 証券番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsKouzokuJimuKakunin_Z;