CREATE VIEW SV_HoyuuMeisai AS
SELECT
    A.kbnkey,
    A.syono,
    A.sdpdkbn,
    A.hrkp,
    A.hrkp$,
    A.bosyuuym,
    A.skeikeijyouym,
    A.hhknsykgycd,
    A.drtenkanritodoufukencd,
    A.cifcd,
    A.fstpnyknymd,
    A.hrkkaisuu,
    A.hrkkeiro,
    A.haitoukinuketorihoukbn,
    A.tikiktbrisyuruikbn,
    B.drtencd,
    B.drtenkanrisosikicd,
    B.daibosyuucd,
    B.drtenbunumu,
    C.kyksakuinmeino,
    C.kkkyktdk,
    C.kykseiymd,
    D.ketkekkacd,
    D.palketsyacd,
    E.yenshrtkhkumu,
    E.initsbjiyensitihsytkhukaumu,
    E.initsbjiyenkasaiteihsygk,
    E.initsbjiyenkasaiteihsygk$,
    E.jyudkaigomeharaitkhukaumu,
    E.targettkhkumu,
    E.targettkykkykhenkoymd,
    E.targettkmokuhyouti,
    E.targettkykkijyungk,
    E.targettkykkijyungk$,
    E.teikishrtkykhukaumu,
    F.yendthnkymd,
    G.jkipjytym,
    H.zennoukaisiymd,
    H.zennoukikan,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon A
LEFT OUTER JOIN
    IT_KykDairiten B
ON
    A.syono = B.syono
    AND B.drtenrenno = 1
LEFT OUTER JOIN
    IT_KykSya C
ON
    A.syono = C.syono
LEFT OUTER JOIN
    IT_ItekiToukeiInfo D
ON
    A.syono = D.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk E
ON
    A.syono = E.syono
LEFT OUTER JOIN
    IT_KykSyouhn F
ON
    A.syono = F.syono
LEFT OUTER JOIN
    IT_AnsyuKihon G
ON
    A.syono = G.syono
LEFT OUTER JOIN
    IT_Zennou H
ON
    A.syono = H.syono
    AND H.renno = 1
;
