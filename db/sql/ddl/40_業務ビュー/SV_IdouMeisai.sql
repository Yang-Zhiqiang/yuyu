CREATE VIEW SV_IdouMeisai AS
SELECT
    A.syono AS syono,
    A.sdpdkbn AS sdpdkbn,
    A.hrkp AS hrkp,
    A.hrkp$ AS hrkp$,
    A.bosyuuym AS bosyuuym,
    A.skeikeijyouym AS skeikeijyouym,
    A.hhknsykgycd AS hhknsykgycd,
    A.drtenkanritodoufukencd AS drtenkanritodoufukencd,
    A.cifcd AS cifcd,
    A.fstpnyknymd AS fstpnyknymd,
    A.hrkkaisuu AS hrkkaisuu,
    A.hrkkeiro AS hrkkeiro,
    A.seirituymd AS seirituymd,
    A.haitoukinuketorihoukbn AS haitoukinuketorihoukbn,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.syutkkbn AS syutkkbn,
    B.syouhncd AS syouhncd,
    B.syoumetujiyuu AS syoumetujiyuu,
    B.yendthnkymd AS yendthnkymd,
    C.drtencd AS drtencd,
    C.drtenkanrisosikicd AS drtenkanrisosikicd,
    C.daibosyuucd AS daibosyuucd,
    C.drtenbunumu AS drtenbunumu,
    D.kyksakuinmeino AS kyksakuinmeino,
    D.kkkyktdk AS kkkyktdk,
    D.kykseiymd AS kykseiymd,
    E.henkousikibetukey AS henkousikibetukey,
    E.syoriYmd AS syoriYmd,
    E.gyoumuKousinKinou AS gyoumuKousinKinou,
    E.gyoumuKousinTime AS gyoumuKousinTime,
    CAST(NULL AS CHAR(1)) AS shrkekkakbn,
    E.syorikbn AS syorikbn,
    F.syushrgkkei AS syushrgkkei,
    F.syushrgkkei$ AS syushrgkkei$,
    F.shrymd AS tyakkinymd,
    F.syoruiukeymd AS syoruiukeymd,
    CAST(NULL AS CHAR(8)) AS hubikanryouymd,
    F.kouryokuhasseiymd AS kouryokuhasseiymd,
    F.shrtuukasyu AS shrtuukasyu,
    CAST(NULL AS CHAR(18)) AS skno,
    CAST(NULL AS CHAR(2)) AS seikyuusyubetu,
    G.ketkekkacd AS ketkekkacd,
    G.palketsyacd AS palketsyacd,
    H.yenshrtkhkumu AS yenshrtkhkumu,
    H.initsbjiyensitihsytkhukaumu AS initsbjiyensitihsytkhukaumu,
    H.initsbjiyenkasaiteihsygk AS initsbjiyenkasaiteihsygk,
    H.initsbjiyenkasaiteihsygk$ AS initsbjiyenkasaiteihsygk$,
    H.jyudkaigomeharaitkhukaumu AS jyudkaigomeharaitkhukaumu,
    H.targettkhkumu AS targettkhkumu,
    H.targettkykkykhenkoymd AS targettkykkykhenkoymd,
    H.targettkmokuhyouti AS targettkmokuhyouti,
    H.targettkykkijyungk AS targettkykkijyungk,
    H.targettkykkijyungk$ AS targettkykkijyungk$,
    H.teikishrtkykhukaumu AS teikishrtkykhukaumu,
    CAST(NULL AS CHAR(1)) AS siinkbn,
    CAST(NULL AS DECIMAL(13))  AS sitihsyutkyumaeyenhknkngk,
    CAST(NULL AS CHAR(3)) AS sitihsyutkyumaeyenhknkngk$,
    I.jkipjytym AS jkipjytym,
    J.zennoukaisiymd AS zennoukaisiymd,
    J.zennoukikan AS zennoukikan,
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
    IT_KykSya D
ON
    A.syono = D.syono
LEFT OUTER JOIN
    IT_KhTtdkRireki E
ON
    A.syono = E.syono
LEFT OUTER JOIN
    IT_KhShrRireki F
ON
    E.syono = F.syono
    AND E.henkousikibetukey = F.henkousikibetukey
LEFT OUTER JOIN
    IT_ItekiToukeiInfo G
ON
    A.syono = G.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk H
ON
    A.syono = H.syono
LEFT OUTER JOIN
    IT_AnsyuKihon I
ON
    A.syono = I.syono
LEFT OUTER JOIN
    IT_Zennou J
ON
    A.syono = J.syono
    AND J.renno = 1
UNION ALL
SELECT
    A.syono AS syono,
    A.sdpdkbn AS sdpdkbn,
    A.hrkp AS hrkp,
    A.hrkp$ AS hrkp$,
    A.bosyuuym AS bosyuuym,
    A.skeikeijyouym AS skeikeijyouym,
    A.hhknsykgycd AS hhknsykgycd,
    A.drtenkanritodoufukencd AS drtenkanritodoufukencd,
    A.cifcd AS cifcd,
    A.fstpnyknymd AS fstpnyknymd,
    A.hrkkaisuu AS hrkkaisuu,
    A.hrkkeiro AS hrkkeiro,
    A.seirituymd AS seirituymd,
    A.haitoukinuketorihoukbn AS haitoukinuketorihoukbn,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.syutkkbn AS syutkkbn,
    B.syouhncd AS syouhncd,
    B.syoumetujiyuu AS syoumetujiyuu,
    B.yendthnkymd AS yendthnkymd,
    C.drtencd AS drtencd,
    C.drtenkanrisosikicd AS drtenkanrisosikicd,
    C.daibosyuucd AS daibosyuucd,
    C.drtenbunumu AS drtenbunumu,
    D.kyksakuinmeino AS kyksakuinmeino,
    D.kkkyktdk AS kkkyktdk,
    D.kykseiymd AS kykseiymd,
    CAST(NULL AS CHAR(18)) AS henkousikibetukey,
    F.shrsyoriymd AS syoriYmd,
    F.kossyoricd AS gyoumuKousinKinou,
    F.gyoumuKousinTime AS gyoumuKousinTime,
    F.shrkekkakbn AS shrkekkakbn,
    CAST(NULL AS CHAR(2)) AS syorikbn,
    H.kyhkg AS syushrgkkei,
    H.kyhkg$ AS syushrgkkei$,
    F.tyakkinymd AS tyakkinymd,
    G.syoruiukeymd AS syoruiukeymd,
    G.hubikanryouymd AS hubikanryouymd,
    CAST(NULL AS CHAR(8)) AS kouryokuhasseiymd,
    G.shrtuukasyu AS shrtuukasyu,
    E.skno AS skno,
    E.seikyuusyubetu AS seikyuusyubetu,
    I.ketkekkacd AS ketkekkacd,
    I.palketsyacd AS palketsyacd,
    J.yenshrtkhkumu AS yenshrtkhkumu,
    J.initsbjiyensitihsytkhukaumu AS initsbjiyensitihsytkhukaumu,
    J.initsbjiyenkasaiteihsygk AS initsbjiyenkasaiteihsygk,
    J.initsbjiyenkasaiteihsygk$ AS initsbjiyenkasaiteihsygk$,
    J.jyudkaigomeharaitkhukaumu AS jyudkaigomeharaitkhukaumu,
    J.targettkhkumu AS targettkhkumu,
    J.targettkykkykhenkoymd AS targettkykkykhenkoymd,
    J.targettkmokuhyouti AS targettkmokuhyouti,
    J.targettkykkijyungk AS targettkykkijyungk,
    J.targettkykkijyungk$ AS targettkykkijyungk$,
    J.teikishrtkykhukaumu AS teikishrtkykhukaumu,
    G.siinkbn AS siinkbn,
    H.sitihsyutkyumaeyenhknkngk AS sitihsyutkyumaeyenhknkngk,
    H.sitihsyutkyumaeyenhknkngk$ AS sitihsyutkyumaeyenhknkngk$,
    K.jkipjytym AS jkipjytym,
    L.zennoukaisiymd AS zennoukaisiymd,
    L.zennoukikan AS zennoukikan,
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
    IT_KykSya D
ON
    A.syono = D.syono
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
    IT_ItekiToukeiInfo I
ON
    A.syono = I.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk J
ON
    A.syono = J.syono
LEFT OUTER JOIN
    IT_AnsyuKihon K
ON
    A.syono = K.syono
LEFT OUTER JOIN
    IT_Zennou L
ON
    A.syono = L.syono
    AND L.renno = 1
;
