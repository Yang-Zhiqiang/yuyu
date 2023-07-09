CREATE VIEW JM_Syujyutu AS SELECT
     syujyututourokuno ,         /* 手術登録番号 */
     kjcd1 ,         /* Ｋ・Ｊコード１ */
     kjcd2 ,         /* Ｋ・Ｊコード２ */
     kjcd3 ,         /* Ｋ・Ｊコード３ */
     syujyutunmkn ,         /* 手術名（カナ） */
     syujyutunmkj ,         /* 手術名（漢字） */
     jyouken ,         /* 条件 */
     syujyutubunruicd ,         /* 手術分類コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JM_Syujyutu_Z;