CREATE VIEW JT_SkByoumei AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     uketukeno ,         /* 受付番号 */
     renno ,         /* 連番 */
     byoumeitourokuno ,         /* 病名登録番号 */
     byoumeikn ,         /* 病名（カナ） */
     byoumeikj ,         /* 病名（漢字） */
     gankbn ,         /* がん区分 */
     sandaisippeikbn ,         /* ３大疾病区分 */
     nanadaisippeikbn ,         /* ７大疾病区分 */
     kansensyoukbn ,         /* 感染症区分 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SkByoumei_Z;