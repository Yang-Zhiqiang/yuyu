CREATE VIEW SV_SibourituRendou AS
SELECT
    A.mosno,
    A.syono,
    A.seiritukbn,
    B.kykymd,
    B.sknnkaisiymd,
    B.bosyuuym,
    B.sntkhoukbn,
    B.haitoukbn,
    B.kyktuukasyu,
    B.hrkkaisuu,
    B.hrkkeiro,
    B.hhknseiymd,
    B.hhknnen,
    B.hhknsei,
    B.hhknsykgycd,
    B.hhknnensyuukbn,
    C.sintyou,
    C.taijyuu,
    D.oyadrtencd,
    D.tratkiagcd,
    D.daibosyuucd,
    D.drtenkanrisosikicd,
    D.bunwari,
    E.kykkaksyrui,
    F.ketkekkacd,
    F.ketriyuucd1,
    F.ketriyuucd2,
    F.ketriyuucd3,
    F.ketriyuucd4,
    F.palketsyacd,
    G.hhkntodouhukencd,
    H.initsbjiyensitihsytkhukaumu,
    H.initsbjiyenkasaiteihsygk,
    H.initsbjiyenkasaiteihsygk$,
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
    HT_Kokutisyo C
ON
    A.mosno = C.mosno
LEFT OUTER JOIN
    HT_MosDairiten D
ON
    A.mosno = D.mosno AND
    D.renno = 1
LEFT OUTER JOIN
    (SELECT X.* FROM HT_KykKak X 
     INNER JOIN
     (SELECT mosno, max(renno) AS maxno 
      FROM HT_KykKak GROUP BY mosno
     ) Y 
     ON X.mosno = Y.mosno 
     AND X.renno = Y.maxno
    ) E
ON
    A.mosno = E.mosno
LEFT OUTER JOIN
    (SELECT X.* FROM HT_DakuhiKettei X 
     INNER JOIN
     (SELECT mosno, max(dakuhiktrenno) AS maxno 
      FROM HT_DakuhiKettei GROUP BY mosno
     ) Y 
     ON X.mosno = Y.mosno 
     AND X.dakuhiktrenno = Y.maxno
    ) F
ON
    A.mosno = F.mosno
LEFT OUTER JOIN
    HT_IjitoukeiMeisai G
ON
    A.syono = G.syono AND
    G.renno8keta = 1
LEFT OUTER JOIN
    IT_KykSonotaTkyk H
ON
    A.syono = H.syono
;
