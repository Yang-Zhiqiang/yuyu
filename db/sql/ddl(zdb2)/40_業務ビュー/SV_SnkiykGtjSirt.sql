CREATE VIEW SV_SnkiykGtjSirt AS
SELECT
    A.mosno,
    A.syono,
    A.mosnrkymd,
    A.nyknkwsrate,
    A.seiritukbn,
    A.srsyoriymd,
    B.mosymd,
    B.mossakuseiymd,
    B.mosym,
    B.kykymd,
    B.skykymd,
    B.sknnkaisiymd,
    B.seisekiym,
    B.skeikeijyouym,
    B.kykkbn,
    B.kykdrtkykhukakbn,
    B.stdrsktkyhkkbn,
    B.sdpdkbn,
    B.sntkhoukbn,
    B.haitoukbn,
    B.haitoukinuketorihoukbn,
    B.kyktuukasyu,
    B.hrktuukasyu,
    B.znnkai,
    B.hyouteip,
    B.hyouteip$,
    B.hrkkaisuu,
    B.hrkkeiro,
    B.hhknnmkn,
    B.hhknnmkj,
    B.hhknseiymd,
    B.hhknnen,
    B.hhknsei,
    B.hhknsykgycd,
    B.kyknmkn,
    B.kyknmkj,
    B.kykseiymd,
    B.kyknen,
    B.kyksei,
    B.tsinyno,
    B.kykhonninkakninsyoruikbn,
    B.heijyunp,
    B.heijyunp$,
    B.ikkatubaraikaisuu,
    A.kktymd,
    D.kykkaksyrui,
    E.spgndtknkbn,
    E.nenkkntknkbn,
    E.tsngndtknkbn,
    E.sentakuinfotknkbn,
    E.kakoymdkyytknkbn,
    E.saiteiptknkbn,
    E.signalkaihikbn,
    E.sonotatknkbn,
    F.drtenkanritodoufukencd,
    G.yenshrtkhkumu,
    G.initsbjiyensitihsytkhukaumu,
    G.initsbjiyenkasaiteihsygk,
    G.initsbjiyenkasaiteihsygk$,
    G.jyudkaigomeharaitkhukaumu,
    G.targettkhkumu,
    G.targettkykkykhenkoymd,
    G.targettkmokuhyouti,
    G.targettkykkijyungk,
    G.targettkykkijyungk$,
    G.teikishrtkykhukaumu,
    B.sisuuhaibunwarikbn,
    B.sisuukbn,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    HT_SyoriCTL_Z A
LEFT OUTER JOIN
    HT_MosKihon_Z B
ON
    A.mosno = B.mosno
LEFT OUTER JOIN
    (SELECT X.mosno, X.kykkaksyrui FROM HT_KykKak_Z X
     INNER JOIN 
     (SELECT mosno, max(renno) AS renno 
      FROM HT_KykKak_Z GROUP BY mosno
     ) Y
     ON X.mosno = Y.mosno 
     AND X.renno = Y.renno
    ) D
ON
    A.mosno = D.mosno
LEFT OUTER JOIN
    HT_Tokunin_Z E
ON
    A.mosno = E.mosno
LEFT OUTER JOIN
    IT_KykKihon_Z F
ON
    A.syono = F.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk_Z G
ON
    A.syono = G.syono
;
