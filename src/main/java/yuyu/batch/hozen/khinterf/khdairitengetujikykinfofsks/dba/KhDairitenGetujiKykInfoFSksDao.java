package yuyu.batch.hozen.khinterf.khdairitengetujikykinfofsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;

import com.google.common.collect.Collections2;

/**
 * 契約保全 インターフェイス 普保Ⅱ代理店月次契約情報Ｆ作成DAOクラス
 */
public class KhDairitenGetujiKykInfoFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    public ExDBResults<DairitenGetujiKykInfosBean> getDairitenGetujiKykInfos(String pKakutyouJobCd) {

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        String subQuery = $SELECT + $NEW(DairitenGetujiKykInfosBean.class,
            qIT_KykDairiten,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSonotaTkyk,
            qIT_HhknSya,
            qIT_KykSya,
            qIT_AnsyuKihon) +
            $FROM(qIT_KykDairiten,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_HhknSya,
                qIT_KykSya,
                qIT_AnsyuKihon) +
                $WHERE + qIT_KykDairiten.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykDairiten.drtenrenno.eq(1) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSonotaTkyk.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykSya.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_HhknSya.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono);

        ExDBResults<DairitenGetujiKykInfosBean> exDBResults = exDBEntityManager.createJPQL(subQuery,
            DairitenGetujiKykInfosBean.class).bind(qIT_KykDairiten, qIT_KykKihon, qIT_KykSyouhn,
                qIT_KykSonotaTkyk, qIT_HhknSya, qIT_KykSya, qIT_AnsyuKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekiInfos(IT_KykKihon pKykKihon, String pGyoumuKousinKinou) {

        List<IT_KhTtdkRireki> khTtdkRirekiLst = pKykKihon.getKhTtdkRirekis();

        khTtdkRirekiLst = new ArrayList<IT_KhTtdkRireki>(Collections2.filter(khTtdkRirekiLst,
            new FilterKhTtdkRireki1(pGyoumuKousinKinou)));

        SortIT_KhTtdkRireki sortIT_KhTtdkRireki = new SortIT_KhTtdkRireki();

        khTtdkRirekiLst = sortIT_KhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(khTtdkRirekiLst);

        return khTtdkRirekiLst;
    }

    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(
        String pSyono,
        C_SeikyuuSyubetu pSeikyuusyubetu,
        C_UmuKbn pTorikesiflg) {

        List<JT_SkKihon> jT_SkKihonList =
            siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyono, pSeikyuusyubetu, pTorikesiflg);

        return jT_SkKihonList;
    }

    public List<KhHenkouUktkBean> getKhHenkouUktkBySyono(String pSyono){

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $NEW(KhHenkouUktkBean.class,
            qIT_KhHenkouUktk.uktksyorikbn,
            qIT_KhHenkouUktk.uktkjyoutaikbn) +
            $FROM (qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + $(qIT_KhHenkouUktk.uktkjyoutaikbn.ne(C_UktkJyoutaiKbn.SYORIZUMI) +
                $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.ne(C_UktkJyoutaiKbn.TORIKESI));

        return exDBEntityManager.createJPQL(strSql, KhHenkouUktkBean.class).bind(qIT_KhHenkouUktk).getResultList();
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekiBySyonoJyutoustartym(String pSyono, BizDateYM pJyutoustartym) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM (qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + $(qIT_NyknJissekiRireki.jyutoustartym.gt(pJyutoustartym)) +
            $AND + $(qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.BLNK));

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResultList();
    }


    public List<IT_KhHenkouRireki> getKhHenkouRirekisBySyonoGyoumuKousinKinouTableidHenkoukoumokuid(String pSyono,
        String pGyoumuKousinKinou, String pTableid, String pHenkoukoumokuid) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");
        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String strSql = $SELECT + qIT_KhHenkouRireki +
            $FROM(qIT_KhHenkouRireki,qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey) +
            $AND + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pHenkoukoumokuid);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki,qIT_KhHenkouRireki).getResultList();

    }

}
