CREATE VIEW SV_BikinIdouMeisai AS
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
    A.haitoukinuketorihoukbn AS haitoukinuketorihoukbn,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.drtencd AS drtencd,
    B.drtenkanrisosikicd AS drtenkanrisosikicd,
    B.daibosyuucd AS daibosyuucd,
    B.drtenbunumu AS drtenbunumu,
    C.kyksakuinmeino AS kyksakuinmeino,
    C.kkkyktdk AS kkkyktdk,
    C.kykseiymd AS kykseiymd,
    D.ketkekkacd AS ketkekkacd,
    D.palketsyacd AS palketsyacd,
    E.initsbjiyensitihsytkhukaumu AS initsbjiyensitihsytkhukaumu,
    E.initsbjiyenkasaiteihsygk AS initsbjiyenkasaiteihsygk,
    E.initsbjiyenkasaiteihsygk$ AS initsbjiyenkasaiteihsygk$,
    E.jyudkaigomeharaitkhukaumu AS jyudkaigomeharaitkhukaumu,
    E.targettkhkumu AS targettkhkumu,
    E.targettkykkykhenkoymd AS targettkykkykhenkoymd,
    E.targettkmokuhyouti AS targettkmokuhyouti,
    E.targettkykkijyungk AS targettkykkijyungk,
    E.targettkykkijyungk$ AS targettkykkijyungk$,
    E.teikishrtkykhukaumu AS teikishrtkykhukaumu,
    F.kessankijyunymd AS kessankijyunymd,
    F.bkncdkbn AS bkncdkbn,
    F.bknkktymd AS bknkktymd,
    F.renno AS renno,
    F.bknrigikbn AS bknrigikbn,
    F.henkousikibetukey AS henkousikibetukey,
    CAST(NULL AS CHAR(18)) AS skno,
    F.calckijyunymd AS calckijyunymd,
    F.bkngk AS bkngk,
    F.bkngk$ AS bkngk$,
    F.bknjkukbn AS bknjkukbn,
    F.shrsyoriymd AS shrsyoriymd,
    F.tyakkinymd AS tyakkinymd,
    F.shrtuukasyu AS shrtuukasyu,
    F.shrkwsratekjnymd AS shrkwsratekjnymd,
    F.shrkwsrate AS shrkwsrate,
    CAST(NULL AS DECIMAL(13)) AS sitihsyutkyumaeyenhknkngk,
    CAST(NULL AS CHAR(3)) AS sitihsyutkyumaeyenhknkngk$,
    CAST(NULL AS CHAR(1)) AS siinkbn,
    F.gyoumuKousinKinou AS gyoumuKousinKinou,
    F.gyoumuKousinTime AS gyoumuKousinTime,
    G.syoruiukeymd AS syoruiukeymd,
    H.yendthnkymd AS yendthnkymd,
    I.jkipjytym AS jkipjytym,
    J.zennoukaisiymd AS zennoukaisiymd,
    J.zennoukikan AS zennoukikan,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon_Z A
LEFT OUTER JOIN
    IT_KykDairiten_Z B
ON
    A.syono = B.syono
    AND B.drtenrenno = 1
LEFT OUTER JOIN
    IT_KykSya_Z C
ON
    A.syono = C.syono
LEFT OUTER JOIN
    IT_ItekiToukeiInfo_Z D
ON
    A.syono = D.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk_Z E
ON
    A.syono = E.syono
LEFT OUTER JOIN
    IT_KhBikinkanri_Z F
ON
    A.syono = F.syono
LEFT OUTER JOIN
    IT_KhShrRireki_Z G
ON
    F.syono = G.syono AND 
    F.henkousikibetukey = G.henkousikibetukey
LEFT OUTER JOIN
    IT_KykSyouhn_Z  H
ON
    A.syono = H.syono
LEFT OUTER JOIN
    IT_AnsyuKihon_Z  I
ON
    A.syono = I.syono
LEFT OUTER JOIN
    IT_Zennou_Z J
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
    A.haitoukinuketorihoukbn AS haitoukinuketorihoukbn,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.drtencd AS drtencd,
    B.drtenkanrisosikicd AS drtenkanrisosikicd,
    B.daibosyuucd AS daibosyuucd,
    B.drtenbunumu AS drtenbunumu,
    C.kyksakuinmeino AS kyksakuinmeino,
    C.kkkyktdk AS kkkyktdk,
    C.kykseiymd AS kykseiymd,
    D.ketkekkacd AS ketkekkacd,
    D.palketsyacd AS palketsyacd,
    E.initsbjiyensitihsytkhukaumu AS initsbjiyensitihsytkhukaumu,
    E.initsbjiyenkasaiteihsygk AS initsbjiyenkasaiteihsygk,
    E.initsbjiyenkasaiteihsygk$ AS initsbjiyenkasaiteihsygk$,
    E.jyudkaigomeharaitkhukaumu AS jyudkaigomeharaitkhukaumu,
    E.targettkhkumu AS targettkhkumu,
    E.targettkykkykhenkoymd AS targettkykkykhenkoymd,
    E.targettkmokuhyouti AS targettkmokuhyouti,
    E.targettkykkijyungk AS targettkykkijyungk,
    E.targettkykkijyungk$ AS targettkykkijyungk$,
    E.teikishrtkykhukaumu AS teikishrtkykhukaumu,
    F.kessankijyunymd AS kessankijyunymd,
    F.bkncdkbn AS bkncdkbn,
    F.bknkktymd AS bknkktymd,
    CAST(NULL AS DECIMAL(2)) AS renno,
    F.bknrigikbn AS bknrigikbn,
    CAST(NULL AS CHAR(18)) AS henkousikibetukey,
    F.skno AS skno,
    F.calckijyunymd AS calckijyunymd,
    F.bkngk AS bkngk,
    F.bkngk$ AS bkngk$,
    F.bknjkukbn AS bknjkukbn,
    COALESCE(F.shrsyoriymd, F.kessankijyunymd) AS shrsyoriymd,
    F.tyakkinymd AS tyakkinymd,
    F.shrtuukasyu AS shrtuukasyu,
    F.shrkwsratekjnymd AS shrkwsratekjnymd,
    F.shrkwsrate AS shrkwsrate,
    F.sitihsyutkyumaeyenhknkngk AS sitihsyutkyumaeyenhknkngk,
    F.sitihsyutkyumaeyenhknkngk$ AS sitihsyutkyumaeyenhknkngk$,
    F.siinkbn AS siinkbn,
    F.gyoumuKousinKinou AS gyoumuKousinKinou,
    F.gyoumuKousinTime AS gyoumuKousinTime,
    G.syoruiukeymd AS syoruiukeymd,
    H.yendthnkymd AS yendthnkymd,
    I.jkipjytym AS jkipjytym,
    J.zennoukaisiymd AS zennoukaisiymd,
    J.zennoukikan AS zennoukikan,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon_Z A
LEFT OUTER JOIN
    IT_KykDairiten_Z B
ON
    A.syono = B.syono
    AND B.drtenrenno = 1
LEFT OUTER JOIN
    IT_KykSya_Z C
ON
    A.syono = C.syono
LEFT OUTER JOIN
    IT_ItekiToukeiInfo_Z D
ON
    A.syono = D.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk_Z E
ON
    A.syono = E.syono
LEFT OUTER JOIN
    JT_SiBikinkanri_Z F
ON
    A.syono = F.syono
LEFT OUTER JOIN
    (SELECT X.* FROM JT_Sk_Z X 
     INNER JOIN 
     (SELECT skno, syono, max(seikyuurirekino) AS maxno 
      FROM JT_Sk_Z GROUP BY skno, syono
     ) Y
     ON X.skno = Y.skno 
     AND X.syono = Y.syono 
     AND X.seikyuurirekino = Y.maxno
    ) G
ON
    F.syono = G.syono
    AND F.skno = G.skno
LEFT OUTER JOIN
    IT_KykSyouhn_Z  H
ON
    A.syono = H.syono
LEFT OUTER JOIN
    IT_AnsyuKihon_Z  I
ON
    A.syono = I.syono
LEFT OUTER JOIN
    IT_Zennou_Z J
ON
    A.syono = J.syono
    AND J.renno = 1
;
