CREATE VIEW BM_FundIndexGessyoCf AS SELECT
     unitfundkbn ,         /* ユニットファンド区分 */
     fundhyoukaymd ,         /* ファンド評価年月日　　　　 */
     segkey ,         /* ＳＥＧＫＥＹ　　　　　　　　 */
     gscfhkkkgahurikaegaku ,         /* 月初ＣＦ保険関係ＧＡ振替額 */
     gscfhkkkgahurikaegaku$ ,         /* 月初ＣＦ保険関係ＧＡ振替額(通貨型) */
     gkgscfhkkkgahurikaegaku ,         /* （外貨）月初ＣＦ保険関係ＧＡ振替額 */
     gkgscfhkkkgahurikaegaku$ ,         /* （外貨）月初ＣＦ保険関係ＧＡ振替額(通貨型) */
     gscfhkkksahurikaegaku ,         /* 月初ＣＦ保険関係ＳＡ振替額 */
     gscfhkkksahurikaegaku$ ,         /* 月初ＣＦ保険関係ＳＡ振替額(通貨型) */
     gkgscfhkkksahurikaegaku ,         /* （外貨）月初ＣＦ保険関係ＳＡ振替額 */
     gkgscfhkkksahurikaegaku$ ,         /* （外貨）月初ＣＦ保険関係ＳＡ振替額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_FundIndexGessyoCf_Z;