CREATE VIEW SV_SnkiykSyunyup AS
SELECT 
    A.mosno,
    A.syono,
    A.seiritukbn,
    A.srsyoriymd,
    B.kykymd,
    B.seisekiym,
    B.skeikeijyouym,
    B.kykkbn,
    B.sdpdkbn,
    B.haitoukbn,
    B.hyouteip,
    B.hyouteip$,
    B.kyktuukasyu,
    B.hrktuukasyu,
    B.fstphrkgk,
    B.fstphrkgk$,
    B.hhknseiymd,
    B.hhknnen,
    B.hhknsei,
    B.kykseiymd,
    B.kyknen,
    B.hrkkaisuu,
    B.hrkkeiro,
    B.heijyunp,
    B.heijyunp$,
    B.zennoumousideumu,
    C.tratkiagcd,
    C.daibosyuucd,
    C.drtenkanrisosikicd,
    D.initsbjiyensitihsytkhukaumu,
    D.initsbjiyenkasaiteihsygk,
    D.initsbjiyenkasaiteihsygk$,
    D.teikishrtkykhukaumu,
    B.sisuuhaibunwarikbn,
    B.sisuukbn,
    E.zennoukikan,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    HT_SyoriCTL A
LEFT OUTER JOIN
    HT_MosKihon B
ON
    A.mosno = B.mosno
LEFT OUTER JOIN
    HT_MosDairiten C
ON
    A.mosno = C.mosno
    AND C.renno = 1
LEFT OUTER JOIN
    IT_KykSonotaTkyk D
ON
    A.syono = D.syono
LEFT OUTER JOIN
    IT_Zennou E
ON
    A.syono = E.syono
    AND E.renno = 1
;
