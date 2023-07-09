CREATE VIEW SV_SibourituToukeiSeibigo AS
SELECT
    A.syono AS syono,
    B.syutkkbn AS syutkkbn,
    B.syouhncd AS syouhncd,
    B.syouhnsdno AS syouhnsdno,
    B.kyksyouhnrenno AS kyksyouhnrenno,
    A.hrkkaisuu AS hrkkaisuu,
    A.sdpdkbn AS sdpdkbn,
    A.hrkp AS hrkp,
    A.hrkp$ AS hrkp$,
    A.bosyuuym AS bosyuuym,
    A.hhknsykgycd AS hhknsykgycd,
    B.syoumetujiyuu AS syoumetujiyuu,
    B.yendthnkymd AS yendthnkymd,
    C.drtencd AS drtencd,
    C.drtenkanrisosikicd AS drtenkanrisosikicd,
    C.daibosyuucd AS daibosyuucd,
    C.drtenbunumu AS drtenbunumu,
    D.syoriYmd AS syoriYmd,
    D.henkousikibetukey AS henkousikibetukey,
    D.gyoumuKousinKinou AS gyoumuKousinKinou,
    D.gyoumuKousinTime AS gyoumuKousinTime,
    D.syorikbn AS syorikbn,
    CAST(NULL AS CHAR(1)) AS shrkekkakbn,
    J.shrymd AS tyakkinymd,
    CAST(NULL AS CHAR(2)) AS seikyuusyubetu,
    E.initsbjiyensitihsytkhukaumu AS initsbjiyensitihsytkhukaumu,
    E.initsbjiyenkasaiteihsygk AS initsbjiyenkasaiteihsygk,
    E.initsbjiyenkasaiteihsygk$ AS initsbjiyenkasaiteihsygk$,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon A
LEFT OUTER JOIN
    IT_KykSyouhn B
ON
    A.syono = B.syono
LEFT OUTER JOIN
    IT_KykDairiten C
ON
    A.syono = C.syono
    AND C.drtenrenno = 1
LEFT OUTER JOIN
    IT_KhTtdkRireki D
ON
    A.syono = D.syono
LEFT OUTER JOIN
    IT_KhShrRireki J
ON
    D.syono = J.syono
    AND D.henkousikibetukey = J.henkousikibetukey
LEFT OUTER JOIN
    IT_KykSonotaTkyk E
ON
    A.syono = E.syono
UNION ALL
SELECT
    A.syono AS syono,
    B.syutkkbn AS syutkkbn,
    B.syouhncd AS syouhncd,
    B.syouhnsdno AS syouhnsdno,
    B.kyksyouhnrenno AS kyksyouhnrenno,
    A.hrkkaisuu AS hrkkaisuu,
    A.sdpdkbn AS sdpdkbn,
    A.hrkp AS hrkp,
    A.hrkp$ AS hrkp$,
    A.bosyuuym AS bosyuuym,
    A.hhknsykgycd AS hhknsykgycd,
    B.syoumetujiyuu AS syoumetujiyuu,
    B.yendthnkymd AS yendthnkymd,
    C.drtencd AS drtencd,
    C.drtenkanrisosikicd AS drtenkanrisosikicd,
    C.daibosyuucd AS daibosyuucd,
    C.drtenbunumu AS drtenbunumu,
    F.shrsyoriymd AS syoriYmd,
    CAST(NULL AS CHAR(18)) AS henkousikibetukey,
    F.kossyoricd AS gyoumuKousinKinou,
    F.gyoumuKousinTime AS gyoumuKousinTime,
    CAST(NULL AS CHAR(2)) AS syorikbn,
    F.shrkekkakbn AS shrkekkakbn,
    F.tyakkinymd AS tyakkinymd,
    E.seikyuusyubetu AS seikyuusyubetu,
    I.initsbjiyensitihsytkhukaumu AS initsbjiyensitihsytkhukaumu,
    I.initsbjiyenkasaiteihsygk AS initsbjiyenkasaiteihsygk,
    I.initsbjiyenkasaiteihsygk$ AS initsbjiyenkasaiteihsygk$,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon A
LEFT OUTER JOIN
    IT_KykSyouhn B
ON
    A.syono = B.syono
LEFT OUTER JOIN
    IT_KykDairiten C
ON
    A.syono = C.syono
    AND C.drtenrenno = 1
LEFT OUTER JOIN
    JT_SkKihon E
ON
    A.syono = E.syono
LEFT OUTER JOIN
    JT_SiRireki F
ON
    E.syono = F.syono
    AND E.skno = F.skno
LEFT OUTER JOIN
    (SELECT X.* FROM JT_Sk X 
     INNER JOIN
     (SELECT skno, syono, max(seikyuurirekino) AS maxno 
      FROM JT_Sk GROUP BY skno, syono
     ) Y 
     ON X.skno = Y.skno 
     AND X.syono = Y.syono 
     AND X.seikyuurirekino = Y.maxno
    ) G
ON
    E.syono = G.syono
    AND E.skno = G.skno
LEFT OUTER JOIN
    JT_SiDetail H
ON
    E.syono = H.syono
    AND E.skno = H.skno
    AND G.seikyuurirekino = H.seikyuurirekino
    AND H.kyhkg <> 0
LEFT OUTER JOIN
    IT_KykSonotaTkyk I
ON
    A.syono = I.syono
;
