CREATE VIEW SV_TuujyuHitusyyugk AS
SELECT
    A.kbnkey,
    A.syono,
    A.hrkkaisuu,
    A.hrkkeiro,
    A.skeikeijyouym,
    B.syutkkbn,
    B.syouhncd,
    B.syouhnsdno,
    B.kyksyouhnrenno,
    B.yendthnkymd,
    C.haitoukbn,
    C.syuusinhknumu,
    C.seg1cd,
    C.dai1hknkkn,
    C.mvatekikkn,
    D.initsbjiyensitihsytkhukaumu,
    D.initsbjiyenkasaiteihsygk,
    D.initsbjiyenkasaiteihsygk$,
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
    BM_SyouhnZokusei C
ON
    B.syouhncd = C.syouhncd
    AND B.syouhnsdno = C.syouhnsdno
LEFT OUTER JOIN
    IT_KykSonotaTkyk D
ON
    A.syono = D.syono
;
