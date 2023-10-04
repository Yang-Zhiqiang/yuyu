package yuyu.batch.hozen.khinterf.khtesuryoinfosks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_Tesuuryou;
import yuyu.def.db.meta.QIT_TesuuryouSyouhn;


/**
 * 契約保全 インターフェイス （契約ＭＦヒストリーＦ）手数料情報作成機能DAOクラス
 */
public class KhTesuryoInfoSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<TesuuryouInfosByKakutyoujobcditemsExBean> getTesuuryouInfosByKakutyoujobcditems(
        String pKakutyoujobcd, BizDate pSyoriYmd, BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {

        QIT_Tesuuryou qIT_Tesuuryou = new QIT_Tesuuryou("qIT_Tesuuryou");

        QIT_TesuuryouSyouhn qIT_TesuuryouSyouhn = new QIT_TesuuryouSyouhn("qIT_TesuuryouSyouhn");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        String strSql =$SELECT + $NEW(TesuuryouInfosByKakutyoujobcditemsExBean.class,
            qIT_Tesuuryou,
            qIT_TesuuryouSyouhn,
            qIT_KykKihon,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_KykDairiten,
            qIT_KykSonotaTkyk) +
            $FROM(qIT_Tesuuryou,
                qIT_TesuuryouSyouhn,
                qIT_KykKihon,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KykDairiten,
                qIT_KykSonotaTkyk) +
                $WHERE + qIT_Tesuuryou.syoriYmd.eq(pSyoriYmd) +
                $AND + $(qIT_Tesuuryou.tsrysyorikbn.in(C_TsrysyoriKbn.SINKEIYAKUSEIRITU,
                    C_TsrysyoriKbn.SEINENGAPPISEI,
                    C_TsrysyoriKbn.GENGAKU,
                    C_TsrysyoriKbn.KAIJO,
                    C_TsrysyoriKbn.MUKOU,
                    C_TsrysyoriKbn.KEIZOKUPNYUUKIN,
                    C_TsrysyoriKbn.IKKATUNYUUKIN,
                    C_TsrysyoriKbn.SYOUMETUGOKZPNYUUKIN,
                    C_TsrysyoriKbn.NYUUKINTORIKESI,
                    C_TsrysyoriKbn.HRIKAIHEN,
                    C_TsrysyoriKbn.SIKKOU,
                    C_TsrysyoriKbn.KAIYAKU) +
                    $OR + $(qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.SIBOU) +
                        $AND+ qIT_Tesuuryou.mikeikapariflg.eq(C_UmuKbn.ARI)) +
                        $OR + $(qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.KEIYAKUTORIKESI) +
                            $AND+ qIT_Tesuuryou.bosyuuym.ge(pBosyuuym)) +
                            $OR + $(qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.CLGOFF) +
                                $AND+ qIT_Tesuuryou.bosyuuym.ge(pBosyuuym))
                    ) +
                    $AND + qIT_TesuuryouSyouhn.syono.eq(qIT_Tesuuryou.syono) +
                    $AND + qIT_TesuuryouSyouhn.tsrysyorikbn.eq(qIT_Tesuuryou.tsrysyorikbn) +
                    $AND + qIT_TesuuryouSyouhn.renno.eq(qIT_Tesuuryou.renno) +
                    $AND + qIT_TesuuryouSyouhn.syutkkbn.eq(pSyutkkbn) +
                    $AND + qIT_KykKihon.syono.eq(qIT_Tesuuryou.syono) +
                    $AND + qIT_KykSya.syono.eq(qIT_Tesuuryou.syono) +
                    $AND + qIT_HhknSya.syono.eq(qIT_Tesuuryou.syono) +
                    $AND + qIT_KykDairiten.syono.eq(qIT_Tesuuryou.syono) +
                    $AND + qIT_KykDairiten.drtenrenno.eq(1) +
                    $AND + qIT_KykSonotaTkyk.syono.eq(qIT_Tesuuryou.syono) +
                    $ORDER_BY(qIT_Tesuuryou.syono.asc(),
                        qIT_Tesuuryou.gyoumuKousinTime.asc());

        ExDBResults<TesuuryouInfosByKakutyoujobcditemsExBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, TesuuryouInfosByKakutyoujobcditemsExBean.class)
            .bind(qIT_Tesuuryou, qIT_TesuuryouSyouhn, qIT_KykKihon, qIT_KykSya, qIT_HhknSya, qIT_KykDairiten, qIT_KykSonotaTkyk).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }


    public List<IT_KhHenkouRireki> getKhHenkouRirekisBySyonoHenkousikibetukeyGyoumuKousinKinouTableidHenkoukoumokuid(String pSyono,
        String pHenkousikibetukey, String pGyoumuKousinKinou, String pTableid, String pHenkoukoumokuid) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String strSql = $SELECT + qIT_KhHenkouRireki +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pHenkoukoumokuid) +
            $ORDER_BY(qIT_KhHenkouRireki.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouRireki).getResultList();

    }
}