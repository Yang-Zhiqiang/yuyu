package yuyu.batch.hozen.khansyuu.khkoujyosyoumeisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KoujyoSymNaiyouD;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KoujyoSymKanri;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyou;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KoujyoSym;

import com.google.common.collect.Collections2;

/**
 * 契約保全 案内収納 控除証明書作成機能DAOクラス
 */
public class KhKoujyosyoumeiSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<KoujyoSymSakuseiTaisyouDataBean> getKoujyoSymSakuseiTaisyouDataBean(String pIbKakutyoujobcd,
        BizDateY pSyoumeinnd, String pKbnkey) {
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");
        QIT_KoujyoSymKanri qIT_KoujyoSymKanri = new QIT_KoujyoSymKanri("qIT_KoujyoSymKanri");
        QIT_KoujyoSymNaiyou qIT_KoujyoSymNaiyou = new QIT_KoujyoSymNaiyou("qIT_KoujyoSymNaiyou");

        String subqueryStr1 = $SELECT + qIT_NyknJissekiRireki.syono +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.kbnkey.eq(qIT_AnsyuKihon.kbnkey) +
            $AND + qIT_NyknJissekiRireki.syono.eq(qIT_AnsyuKihon.syono);

        String subqueryStr2 = $SELECT + qIT_KoujyoSymKanri.syono +
            $FROM(qIT_KoujyoSymKanri) +
            $WHERE + qIT_KoujyoSymKanri.kbnkey.eq(qIT_KykSyouhn.kbnkey) +
            $AND + qIT_KoujyoSymKanri.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KoujyoSymKanri.nendo.eq(pSyoumeinnd.toString());

        String subqueryStr3 = $SELECT + qIT_KoujyoSymKanri.syono +
            $FROM(qIT_KoujyoSymKanri) +
            $WHERE + qIT_KoujyoSymKanri.kbnkey.eq(qIT_KykSyouhn.kbnkey) +
            $AND + qIT_KoujyoSymKanri.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KoujyoSymKanri.nendo.eq(pSyoumeinnd.toString()) +
            $AND + qIT_KoujyoSymKanri.lastsyoumeiendym.substring(1, 6).lt(pSyoumeinnd.toString() + "12");

        String subqueryStr4 = $SELECT + qIT_KoujyoSymNaiyou.syono +
            $FROM(qIT_KoujyoSymNaiyou, qIT_KoujyoSymKanri, qIT_NyknJissekiRireki) +
            $WHERE + qIT_KoujyoSymNaiyou.kbnkey.eq(qIT_KykSyouhn.kbnkey) +
            $AND + qIT_KoujyoSymNaiyou.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KoujyoSymNaiyou.kbnkey.eq(qIT_NyknJissekiRireki.kbnkey) +
            $AND + qIT_KoujyoSymNaiyou.syono.eq(qIT_NyknJissekiRireki.syono) +
            $AND + qIT_KoujyoSymNaiyou.jyutoustartym.eq(qIT_NyknJissekiRireki.jyutoustartym) +
            $AND + qIT_KoujyoSymNaiyou.nyknjskrrkrenno.eq(qIT_NyknJissekiRireki.renno) +
            $AND + qIT_KoujyoSymNaiyou.kbnkey.eq(qIT_KoujyoSymKanri.kbnkey) +
            $AND + qIT_KoujyoSymNaiyou.syono.eq(qIT_KoujyoSymKanri.syono) +
            $AND + qIT_KoujyoSymNaiyou.koujyosyoumeinnd.eq(qIT_KoujyoSymKanri.nendo) +
            $AND + qIT_KoujyoSymNaiyou.syoumeiendym.gt(qIT_KoujyoSymKanri.lastsyoumeiendym) +
            $AND + qIT_KoujyoSymNaiyou.koujyosyoumeinnd.eq(pSyoumeinnd.toString()) +
            $AND + qIT_KoujyoSymNaiyou.sakujyoflg.eq(C_Delflag.BLNK) +
            $AND + qIT_NyknJissekiRireki.nyktrksflg.eq(C_Nyktrksflg.BLNK);

        String kbnkeyQueryStr = "";
        if(!BizUtil.isBlank(pKbnkey)) {
            kbnkeyQueryStr = $AND + qIT_AnsyuKihon.kbnkey.eq(pKbnkey);
        }

        String queryStr = $SELECT + $NEW(KoujyoSymSakuseiTaisyouDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_KykSyouhn.kykjyoutai,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykSyouhn.yuukousyoumetukbn,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName()) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_AnsyuKihon) +
                $WHERE + qIT_KykKihon.kbnkey.eq(qIT_AnsyuKihon.kbnkey) +
                $AND + qIT_KykKihon.syono.eq(qIT_AnsyuKihon.syono) +
                $AND + qIT_KykSyouhn.kbnkey.eq(qIT_KykKihon.kbnkey) +
                $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
                kbnkeyQueryStr +
                $AND + qIT_KykKihon.hrkkaisuu.in(
                    C_Hrkkaisuu.TUKI, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.NEN) +
                    $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                    $AND + $(
                        $(qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                            $AND + $(
                                $($(qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                                    $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK) +
                                    $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.ZENNOU)) +
                                    $AND + $($(qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.TUKI) +
                                        $AND + qIT_AnsyuKihon.jkipjytym.substring(1, 6).gt(pSyoumeinnd.toString() + "09")) +
                                        $OR + $($(qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.HALFY)) +
                                            $OR + $(qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.NEN)))) +
                                            $AND + $EXISTS(subqueryStr1)
                                    ) +
                                    $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HARAIMAN) +
                                    $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.PMEN)
                                )
                            ) +
                            $OR + $(qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU) +
                                $AND + $(qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.KAIYAKU) +
                                    $OR + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM) +
                                    $OR + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM) +
                                    $OR + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.PMNYSYMET_MSSN)))
                        ) +
                        $AND + $(
                            $NOT_EXISTS(subqueryStr2) +
                            $OR + $(qIT_KykSyouhn.yuukousyoumetukbn.ne(C_YuukousyoumetuKbn.SYOUMETU) +
                                $AND + qIT_KykSyouhn.kykjyoutai.ne(C_Kykjyoutai.HARAIMAN) +
                                $AND + qIT_KykSyouhn.kykjyoutai.ne(C_Kykjyoutai.PMEN) +
                                $AND + $EXISTS(subqueryStr3)) +
                                $OR + $EXISTS(subqueryStr4));
        ExDBResults<KoujyoSymSakuseiTaisyouDataBean> exDBResults = exDBEntityManager.createJPQL(queryStr,
            KoujyoSymSakuseiTaisyouDataBean.class).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_AnsyuKihon,
                qIT_NyknJissekiRireki, qIT_KoujyoSymKanri,qIT_KoujyoSymNaiyou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBResults;
    }

    public IT_KykKihon getKykKihon(String pSyono) {
        return hozenDomManager.getKykKihon(pSyono);
    }

    public IT_KoujyoSymKanri getKoujyoSymKanri(IT_KykKihon pKykKihon, String pSyoumeinnd) {
        return pKykKihon.getKoujyoSymKanriByNendo(pSyoumeinnd);
    }

    public List<IT_KoujyoSymNaiyou> getKoujyoSymNaiyou(IT_KykKihon pKykKihon, String pSyoumeinnd) {
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = pKykKihon.getKoujyoSymNaiyous();

        return new ArrayList<IT_KoujyoSymNaiyou>(Collections2.filter(koujyoSymNaiyouLst,
            new FilterKoujyoSymNaiyou1(pSyoumeinnd)));
    }

    public void addUpdateEntity(EntityUpdater<IT_KykKihon> pEntityUpdater, AbstractExDBEntity<?, ?> pKykKihon) {
        pEntityUpdater.add((IT_KykKihon) pKykKihon);
    }

    public IT_KoujyoSymKanri createKoujyoSymKanri(IT_KykKihon pKykKihon) {
        return pKykKihon.createKoujyoSymKanri();
    }

    public List<IT_KoujyoSymNaiyouD> getKoujyoSymNaiyouD(IT_KykKihon pKykKihon, String pSyoumeinnd) {
        List<IT_KoujyoSymNaiyouD> koujyoSymNaiyouDLst = pKykKihon.getKoujyoSymNaiyouDs();

        return new ArrayList<IT_KoujyoSymNaiyouD>(Collections2.filter(koujyoSymNaiyouDLst,
            new FilterKoujyoSymNaiyouD1(pSyoumeinnd)));
    }

    public List<IT_KoujyoSym> getKoujyoSym(IT_KykKihon pKykKihon, String pSyoumeinnd) {
        List<IT_KoujyoSym> koujyoSymLst = pKykKihon.getKoujyoSyms();

        List<IT_KoujyoSym> newKoujyoSymLst = new ArrayList<IT_KoujyoSym>(Collections2.filter(koujyoSymLst,
            new FilterKoujyoSym1(pSyoumeinnd)));

        SortIT_KoujyoSym sortIT_KoujyoSym = new SortIT_KoujyoSym();

        newKoujyoSymLst = sortIT_KoujyoSym.OrderIT_KoujyoSymByTyouhyouymdDesc(newKoujyoSymLst);

        return newKoujyoSymLst;

    }
}
