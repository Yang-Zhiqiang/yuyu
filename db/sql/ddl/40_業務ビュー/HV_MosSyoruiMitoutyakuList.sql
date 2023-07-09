CREATE VIEW HV_MosSyoruiMitoutyakuList AS
SELECT
     HT_HrkmNyknData.syoriYmd,
     HT_HrkmNyknData.itirenno,
     HT_HrkmNyknData.nykmosno,
     HT_HrkmNyknData.bankcd,
     HT_HrkmNyknData.sitencd,
     HT_HrkmNyknData.simukebanknmkn,
     '' AS simukebanknmeiji,
     HT_HrkmNyknData.simuketennmkn,
     '' AS simuketennmeiji,
     HT_HrkmNyknData.azkrhrdsymd AS knjyymd,
     HT_HrkmNyknData.trhkkgk,
     HT_HrkmNyknData.trhkkgk$,
     HT_HrkmNyknData.trhkkgk as dengk,
     HT_HrkmNyknData.trhkkgk$ as dengk$,
     'JPY' AS tuukasyu,
     HT_HrkmNyknData.hrkmirninnm,
     HT_HrkmNyknData.oyadrtencd,
     HT_HrkmNyknData.nyuukinoyadrtennm,
     HT_HrkmNyknData.mostokusokuumu,
     HT_HrkmNyknData.siteituuka,
     HT_HrkmNyknData.hrkmnykndatarenmotoKbn,
     HT_HrkmNyknData.syouhnno,
     HT_HrkmNyknData.nyktyhyoutkbn,
     '' AS kousinsyaId,     /* 更新者ＩＤ     */
     '' AS kousinTime,     /* 更新時間       */
     '' AS kousinKinou,     /* 更新機能       */
     0 AS version          /* バージョン     */
FROM
     HT_HrkmNyknData
WHERE
     HT_HrkmNyknData.densyskbn = '10'
AND
     HT_HrkmNyknData.syorizumiflg = '0'
UNION ALL
SELECT
     HT_GaikaHrkmNyknData.syoriYmd,
     HT_GaikaHrkmNyknData.itirenno,
     HT_GaikaHrkmNyknData.nykmosno,
     HT_GaikaHrkmNyknData.bankcd,
     HT_GaikaHrkmNyknData.sitencd,
     '' AS simukebanknmkn,
      HT_GaikaHrkmNyknData.simukebanknmeiji,
     '' AS simuketennmkn,
     HT_GaikaHrkmNyknData.simuketennmeiji,
     HT_GaikaHrkmNyknData.ksnymd AS knjyymd,
     HT_GaikaHrkmNyknData.trhkkgk,
     HT_GaikaHrkmNyknData.trhkkgk$,
     HT_GaikaHrkmNyknData.dengk,
     HT_GaikaHrkmNyknData.dengk$,
     HT_GaikaHrkmNyknData.tuukasyu,
     HT_GaikaHrkmNyknData.hrkmirninnm,
     HT_GaikaHrkmNyknData.oyadrtencd,
     HT_GaikaHrkmNyknData.nyuukinoyadrtennm,
     HT_GaikaHrkmNyknData.mostokusokuumu,
     HT_GaikaHrkmNyknData.siteituuka,
     HT_GaikaHrkmNyknData.hrkmnykndatarenmotoKbn,
     HT_GaikaHrkmNyknData.syouhnno,
     '1' AS nyktyhyoutkbn,
     '' AS kousinsyaId,     /* 更新者ＩＤ     */
     '' AS kousinTime,     /* 更新時間       */
     '' AS kousinKinou,     /* 更新機能       */
     0 AS version          /* バージョン     */
FROM
     HT_GaikaHrkmNyknData
WHERE
     HT_GaikaHrkmNyknData.densyskbn = '10'
AND
     HT_GaikaHrkmNyknData.syorizumiflg = '0'
;
