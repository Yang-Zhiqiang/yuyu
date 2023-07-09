CREATE VIEW SV_KiykHnriknSutugk AS
SELECT
    A.kbnkey,
    A.syono,
    A.hrkkaisuu,
    A.hrkkeiro,
    A.fstpnyknymd,
    A.skeikeijyouym,
    B.kykseiymd,
    B.kyksei,
    C.jkipjytym,
    D.teikishrtkykhukaumu,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon A
LEFT OUTER JOIN    
    IT_KykSya B
ON
    A.syono = B.syono
LEFT OUTER JOIN    
    IT_AnsyuKihon C
ON
    A.syono = C.syono
LEFT OUTER JOIN
    IT_KykSonotaTkyk D
ON
    A.syono = D.syono
;
