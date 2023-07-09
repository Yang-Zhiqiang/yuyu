CREATE VIEW IT_KhHenkouUktkMkhgkHnk AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     hozenhenkouuktkrenno ,         /* 保全変更受付連番 */
     targettkmokuhyouti ,         /* ターゲット特約目標値 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhHenkouUktkMkhgkHnk_Z;