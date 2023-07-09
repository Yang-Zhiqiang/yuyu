CREATE VIEW ST_ConvertKanjyouKamoku AS SELECT
     kanjyoukmkcd ,         /* 勘定科目コード */
     taisyakukbn ,         /* 貸借区分 */
     convertedkanjyoukmkcd ,         /* 変換後勘定科目コード */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ST_ConvertKanjyouKamoku_Z;