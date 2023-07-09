CREATE VIEW IT_Kouza AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     kokno ,         /* 顧客番号 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     sinkeizkkbn ,         /* 新規継続区分 */
     syuudaikocd ,         /* 収納代行社コード */
     kzkykdoukbn ,         /* 口座名義契約者同一人区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_Kouza_Z;