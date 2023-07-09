CREATE VIEW JM_TokusyuKyuHantei AS SELECT
     byoumeitourokuno ,         /* 病名登録番号 */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     tekiyoukknfrom ,         /* 適用期間（自） */
     tekiyoukknkto ,         /* 適用期間（至） */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_TokusyuKyuHantei_Z;