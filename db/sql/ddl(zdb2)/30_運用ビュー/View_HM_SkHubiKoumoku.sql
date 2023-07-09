CREATE VIEW HM_SkHubiKoumoku AS SELECT
     syoruiCd ,         /* 書類コード */
     skhubikoumokucd ,         /* 新契約不備項目コード */
     skhubikoumoku ,         /* 新契約不備項目 */
     hyoujijyun ,         /* 表示順 */
     hyoujikahikbn ,         /* 表示可否区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SkHubiKoumoku_Z;