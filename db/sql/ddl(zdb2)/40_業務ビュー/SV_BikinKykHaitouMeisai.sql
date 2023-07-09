CREATE VIEW SV_BikinKykHaitouMeisai AS
SELECT
    A.syono AS syono,
    A.hrkkaisuu AS hrkkaisuu,
    A.hrkkeiro AS hrkkeiro,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.kessankijyunymd AS kessankijyunymd,
    B.bkncdkbn AS bkncdkbn,
    B.bknkktymd AS bknkktymd,
    B.renno AS renno,
    CAST(NULL AS CHAR(4)) AS kyuuhucd,
    B.bknrigikbn AS bknrigikbn,
    B.henkousikibetukey AS henkousikibetukey,
    CAST(NULL AS CHAR(18)) AS skno,
    B.calckijyunymd AS calckijyunymd,
    B.kbnkeirisegcd AS kbnkeirisegcd,
    B.bkngk AS bkngk,
    B.bkngk$ AS bkngk$,
    B.kihons AS kihons,
    B.kihons$ AS kihons$,
    CAST(NULL AS CHAR(1)) AS syoriumukbn,
    B.bknjkukbn AS bknjkukbn,
    B.shrsyoriymd AS shrsyoriymd,
    B.tyakkinymd AS tyakkinymd,
    B.shrtuukasyu AS shrtuukasyu,
    B.shrkwsratekjnymd AS shrkwsratekjnymd,
    B.shrkwsrate AS shrkwsrate,
    CAST(NULL AS DECIMAL(13)) AS sitihsyutkyumaeyenhknkngk,
    CAST(NULL AS CHAR(3)) AS sitihsyutkyumaeyenhknkngk$,
    CAST(NULL AS CHAR(1)) AS shrkekkakbn,
    CAST(NULL AS CHAR(1)) AS siinkbn,
    B.gyoumuKousinKinou AS gyoumuKousinKinou,
    B.gyoumuKousinTime AS gyoumuKousinTime,
    C.jkipjytym AS jkipjytym,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon_Z A
LEFT OUTER JOIN
    IT_KhBikinkanri_Z B
ON
    A.syono = B.syono
LEFT OUTER JOIN
    IT_AnsyuKihon_Z C
ON
    A.syono = C.syono
UNION ALL
SELECT
    A.syono AS syono,
    A.hrkkaisuu AS hrkkaisuu,
    A.hrkkeiro AS hrkkeiro,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.kessankijyunymd AS kessankijyunymd,
    B.bkncdkbn AS bkncdkbn,
    B.bknkktymd AS bknkktymd,
    CAST(NULL AS DECIMAL(2)) AS renno,
    B.kyuuhucd AS kyuuhucd,
    B.bknrigikbn AS bknrigikbn,
    CAST(NULL AS CHAR(18)) AS henkousikibetukey,
    B.skno AS skno,
    B.calckijyunymd AS calckijyunymd,
    B.kbnkeirisegcd AS kbnkeirisegcd,
    B.bkngk AS bkngk,
    B.bkngk$ AS bkngk$,
    B.kihons AS kihons,
    B.kihons$ AS kihons$,
    CAST(NULL AS CHAR(1)) AS syoriumukbn,
    B.bknjkukbn AS bknjkukbn,
    COALESCE(B.shrsyoriymd, B.kessankijyunymd) AS shrsyoriymd,
    B.tyakkinymd AS tyakkinymd,
    B.shrtuukasyu AS shrtuukasyu,
    B.shrkwsratekjnymd AS shrkwsratekjnymd,
    B.shrkwsrate AS shrkwsrate,
    B.sitihsyutkyumaeyenhknkngk AS sitihsyutkyumaeyenhknkngk,
    B.sitihsyutkyumaeyenhknkngk$ AS sitihsyutkyumaeyenhknkngk$,
    B.shrkekkakbn AS shrkekkakbn,
    B.siinkbn AS siinkbn,
    B.gyoumuKousinKinou AS gyoumuKousinKinou,
    B.gyoumuKousinTime AS gyoumuKousinTime,
    C.jkipjytym AS jkipjytym,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon_Z A
LEFT OUTER JOIN
    JT_SiBikinkanri_Z B
ON
    A.syono = B.syono
LEFT OUTER JOIN
    IT_AnsyuKihon_Z C
ON
    A.syono = C.syono
UNION ALL
SELECT
    A.syono AS syono,
    A.hrkkaisuu AS hrkkaisuu,
    A.hrkkeiro AS hrkkeiro,
    A.tikiktbrisyuruikbn AS tikiktbrisyuruikbn,
    B.kessankijyunymd AS kessankijyunymd,
    B.bkncdkbn AS bkncdkbn,
    B.bknkktymd AS bknkktymd,
    B.renno AS renno,
    CAST(NULL AS CHAR(4)) AS kyuuhucd,
    CAST(NULL AS CHAR(1)) AS bknrigikbn,
    CAST(NULL AS CHAR(18)) AS henkousikibetukey,
    CAST(NULL AS CHAR(18)) AS skno,
    B.calckijyunymd AS calckijyunymd,
    B.kbnkeirisegcd AS kbnkeirisegcd,
    B.bkngk AS bkngk,
    B.bkngk$ AS bkngk$,
    CAST(NULL AS DECIMAL(13)) AS kihons,
    CAST(NULL AS CHAR(3)) AS kihons$,
    B.syoriumukbn AS syoriumukbn,
    B.bknjkukbn AS bknjkukbn,
    CAST(NULL AS CHAR(8)) AS shrsyoriymd,
    CAST(NULL AS CHAR(8)) AS tyakkinymd,
    B.shrtuukasyu AS shrtuukasyu,
    B.kwsratekjymd AS shrkwsratekjnymd,
    B.kawaserate AS shrkwsrate,
    CAST(NULL AS DECIMAL(13)) AS sitihsyutkyumaeyenhknkngk,
    CAST(NULL AS CHAR(3)) AS sitihsyutkyumaeyenhknkngk$,
    CAST(NULL AS CHAR(1)) AS shrkekkakbn,
    CAST(NULL AS CHAR(1)) AS siinkbn,
    B.gyoumuKousinKinou AS gyoumuKousinKinou,
    B.gyoumuKousinTime AS gyoumuKousinTime,
    C.jkipjytym AS jkipjytym,
    /* 下記共通項目を一時追加する。DOM対応後に削除予定。 */
    '' AS kousinsyaId,    /* 更新者ＩＤ     */
    '' AS kousinTime,    /* 更新時間       */
    '' AS kousinKinou,    /* 更新機能       */
    0 AS version        /* バージョン     */
FROM
    IT_KykKihon_Z A
LEFT OUTER JOIN
    IT_AsBikinkanri_Z B
ON
    A.syono = B.syono
LEFT OUTER JOIN
    IT_AnsyuKihon_Z C
ON
    A.syono = C.syono
;
