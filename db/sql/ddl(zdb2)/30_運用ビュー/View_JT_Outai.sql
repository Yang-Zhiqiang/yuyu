CREATE VIEW JT_Outai AS SELECT
     syono ,         /* 証券番号 */
     renno ,         /* 連番 */
     nayoseyouhi ,         /* 名寄せ要否 */
     mousideninkbn ,         /* 申出人区分 */
     syuhiyouhi ,         /* 守秘要否 */
     mousideninnmkj ,         /* 申出人名（漢字） */
     souhusakikbn ,         /* 送付先区分 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     betukyksuu ,         /* 別契約数 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_Outai_Z;