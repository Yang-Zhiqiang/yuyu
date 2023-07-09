CREATE VIEW IT_HengakuUnit AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     unitfundkbn ,         /* ユニットファンド区分 */
     henkousikibetukey ,         /* 変更識別キー */
     unitkouryokuhasseiymd ,         /* ユニット効力発生日 */
     unitkouryokuendymd ,         /* ユニット効力終了日 */
     unitsuu ,         /* ユニット数 */
     fundhaibunwariai ,         /* ファンド配分割合 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_HengakuUnit_Z;