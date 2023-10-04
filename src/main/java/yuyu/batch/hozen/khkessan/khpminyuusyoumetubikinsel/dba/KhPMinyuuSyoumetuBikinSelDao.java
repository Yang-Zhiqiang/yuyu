package yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinsel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.db.meta.QIT_AsBikinkanri;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_PMinyuuSyoumetuInfo;

/**
 * 契約保全 決算 Ｐ未入消滅備金抽出機能DAOクラス
 */
public class KhPMinyuuSyoumetuBikinSelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_AsBikinkanri> getAsBikinkanrisByKessankijyunymdBkncdkbn(BizDate pKessanKijyunYmd) {

        QIT_AsBikinkanri qIT_AsBikinkanri = new QIT_AsBikinkanri("qIT_AsBikinkanri");

        String strSql = $SELECT + qIT_AsBikinkanri +
            $FROM(qIT_AsBikinkanri) +
            $WHERE + qIT_AsBikinkanri.kessankijyunymd.eq(pKessanKijyunYmd) +
            $AND + qIT_AsBikinkanri.bkncdkbn.eq(C_BkncdKbn.PMINYUUSYOUMETU);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AsBikinkanri).getResultList();
    }

    public ExDBResults<PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean> getPMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymd(
        String pKakutyoujobcd, BizDate pKsnbiymd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");
        QIT_PMinyuuSyoumetuInfo qIT_PMinyuuSyoumetuInfo = new QIT_PMinyuuSyoumetuInfo("qIT_PMinyuuSyoumetuInfo");

        String strSubSql1 = $SELECT + "1" +  $AS + "syoriUmuKbn" +
            $FROM(qIT_KhShrRireki) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.KAIYAKU) +
            $AND + qIT_KhShrRireki.shrymd.gt(pKsnbiymd) +
            $AND + qIT_KhShrRireki.shrsyoriymd.le(pKsnbiymd);

        String strSubSql2 = $SELECT  + qIT_KhShrRireki.syono +
            $FROM(qIT_KhShrRireki) +
            $WHERE + qIT_KykKihon.syono.eq(qIT_KhShrRireki.syono) +
            $AND + qIT_KhShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.KAIYAKU) +
            $AND + qIT_KhShrRireki.shrymd.gt(pKsnbiymd);

        String strSql = $SELECT + $NEW(PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean.class,
            qIT_KykKihon ,
            qIT_KykSyouhn ,
            qIT_PMinyuuSyoumetuInfo ,
            $(strSubSql1)) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_PMinyuuSyoumetuInfo) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_PMinyuuSyoumetuInfo.syono) +
                $AND + qIT_KykSyouhn.syoumetuymd.le(pKsnbiymd) +
                $AND + $(qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_MSSN) +
                    $OR + $(qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM) +
                        $AND + $EXISTS(strSubSql2)));

        ExDBResults<PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, PMinyuuSyoumetuInfosByKakutyoujobcdKsnbiymdBean.class)
            .bind(qIT_KykKihon, qIT_KykSyouhn, qIT_KhShrRireki,
                qIT_PMinyuuSyoumetuInfo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_AsBikinkanri getAsBikinkanriInfosBySyono(String pSyono) {

        QIT_AsBikinkanri qIT_AsBikinkanri = new QIT_AsBikinkanri("qIT_AsBikinkanri");

        String strSql = $SELECT + qIT_AsBikinkanri +
            $FROM(qIT_AsBikinkanri) +
            $WHERE + qIT_AsBikinkanri.syono.eq(pSyono) +
            $ORDER_BY(qIT_AsBikinkanri.kessankijyunymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AsBikinkanri).setFirstResult(0).setMaxResults(1)
            .getSingleResult();
    }
}