CREATE VIEW BM_Tuuka AS SELECT
     tuukasyu ,         /* 通貨種類 */
     ssketasuu ,         /* 小数桁数 */
     tuukasyumei ,         /* 通貨種類正式名 */
     tuukasyuryk ,         /* 通貨種類略称 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Tuuka_Z;