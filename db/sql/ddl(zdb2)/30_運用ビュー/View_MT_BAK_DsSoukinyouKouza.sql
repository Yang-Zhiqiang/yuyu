CREATE VIEW MT_BAK_DsSoukinyouKouza AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     syono ,         /* 証券番号 */
     kzsyuruikbn ,         /* 口座種類区分 */
     trkssikibetukey ,         /* 取消識別キー */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzdoukbn ,         /* 口座名義人同一区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_BAK_DsSoukinyouKouza_Z;