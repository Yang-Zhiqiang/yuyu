package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SegbunruiKbn;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QBM_SegmentSikinidou;
import yuyu.def.db.meta.QBM_SyouhnbetuSegment;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成(平準払入金用)機能DAOクラス。<br />
 */
public class BzSikinIdouListDataSksHijynbrNykDao {

    @Inject
    private ExDBEntityManager em;

    public ExDBResults<HijynbrNykDataBean> getHijynbrNykDataBeans(
        String pKakutyouJobCd,
        BizDate pSyoriYmd) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki2 = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki2");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("qIT_AnsyuKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBM_SyouhnbetuSegment qBM_SyouhnbetuSegment = new QBM_SyouhnbetuSegment("qBM_SyouhnbetuSegment");

        QBM_SegmentSikinidou qBM_SegmentSikinidou = new QBM_SegmentSikinidou("qBM_SegmentSikinidou");

        String subQuery = $SELECT + qIT_NyknJissekiRireki2.syono +
            $FROM + qIT_NyknJissekiRireki2.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(qIT_NyknJissekiRireki2.syono)+
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(qIT_NyknJissekiRireki2.jyutoustartym) +
            $AND + qIT_NyknJissekiRireki.renno.lt(qIT_NyknJissekiRireki2.renno);

        String strSql = $SELECT + $NEW(HijynbrNykDataBean.class,
            qIT_NyknJissekiRireki.syono,
            qIT_NyknJissekiRireki.jyutoustartym,
            qIT_NyknJissekiRireki.renno,
            qIT_NyknJissekiRireki.jyutoukaisuuy,
            qIT_NyknJissekiRireki.jyutoukaisuum,
            qIT_NyknJissekiRireki.nyknaiyoukbn,
            qIT_NyknJissekiRireki.rstuukasyu,
            qIT_KykKihon.hrkp.getTypeFieldName(),
            qIT_KykKihon.hrkp.getValueFieldName(),
            qIT_KykKihon.fstpnyknymd,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykSyouhn.kyktuukasyu,
            qIT_KykSyouhn.hokenryou.getTypeFieldName(),
            qIT_KykSyouhn.hokenryou.getValueFieldName(),
            qIT_KykSyouhn.kykymd,
            qBM_SyouhnbetuSegment.segcd) +
            $FROM + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_AnsyuKihon.IT_AnsyuKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qBM_SyouhnbetuSegment.BM_SyouhnbetuSegment() + "," +
            qBM_SegmentSikinidou.BM_SegmentSikinidou() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_NyknJissekiRireki.syono.eq(qIT_AnsyuKihon.syono) +
            $AND + qIT_NyknJissekiRireki.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnbetuSegment.syouhncd) +
            $AND + qIT_KykSyouhn.kyktuukasyu.eq(qBM_SyouhnbetuSegment.kyktuukasyu) +
            $AND + qBM_SyouhnbetuSegment.segcd.eq(qBM_SegmentSikinidou.segcd) +
            $AND + "(" + qIT_NyknJissekiRireki.nyksyoriymd.eq(pSyoriYmd) +
            $OR + qIT_NyknJissekiRireki.nyktrksymd.eq(pSyoriYmd) +
            $OR + qIT_KykKihon.seirituymd.eq(pSyoriYmd) + ")" +
            $AND + qIT_NyknJissekiRireki.nykkeiro.ne(C_Nykkeiro.HKNKIN) +
            $AND + qIT_NyknJissekiRireki.nykkeiro.ne(C_Nykkeiro.KYHKIN) +
            $AND + "(" + qIT_NyknJissekiRireki.nyknaiyoukbn.ne(C_NyknaiyouKbn.ZENNOUP) +
            $OR + qIT_NyknJissekiRireki.nyktrksflg.ne(C_Nyktrksflg.TORIKESI) + ")" +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
            $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
            $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
            $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qBM_SyouhnbetuSegment.segbunrui1.eq(C_SegbunruiKbn.BLNK) +
            $AND + qBM_SyouhnbetuSegment.segbunrui2.eq(C_SegbunruiKbn.BLNK) +
            $AND + qBM_SegmentSikinidou.hijynnykzndkkouzakbn.eq(C_HijynnykzndkkouzaKbn.YENHONKZ) +
            $AND + $NOT_EXISTS(subQuery) +
            $ORDER_BY(qIT_NyknJissekiRireki.syono.asc(),
                qIT_NyknJissekiRireki.jyutoustartym.asc());

        ExDBResults<HijynbrNykDataBean> exDBResults = em.createJPQL(strSql, HijynbrNykDataBean.class).bind(
            qIT_NyknJissekiRireki,
            qIT_NyknJissekiRireki2,
            qIT_KykKihon,
            qIT_AnsyuKihon,
            qIT_KykSyouhn,
            qBM_SyouhnbetuSegment,
            qBM_SegmentSikinidou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public List<BT_HijynNykSikinIdouListSks> getTrksHijynNykSikinIdouListDataBeans(
        String pSyono,
        BizDateYM pSikinidoupjytymFrom,
        BizDateYM pSikinidoupjytymTo) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks");

        String strSql = $SELECT + qBT_HijynNykSikinIdouListSks +
            $FROM + qBT_HijynNykSikinIdouListSks.BT_HijynNykSikinIdouListSks() +
            $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(pSyono) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.ge(pSikinidoupjytymFrom) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.le(pSikinidoupjytymTo);

        return em.createJPQL(strSql).bind(qBT_HijynNykSikinIdouListSks).getResultList();
    }

    public ExDBResults<HijynbrGengakuDataBean> getHijynbrGengakuDataBeans(
        String pKakutyouJobCd,
        BizDate pSyoriYmd,
        String pGyoumuKousinKinou,
        String pTableId,
        String pKoumokuId) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBM_SyouhnbetuSegment qBM_SyouhnbetuSegment = new QBM_SyouhnbetuSegment("qBM_SyouhnbetuSegment");

        QBM_SegmentSikinidou qBM_SegmentSikinidou = new QBM_SegmentSikinidou("qBM_SegmentSikinidou");

        String strSql = $SELECT + $NEW(HijynbrGengakuDataBean.class,
            qIT_KhTtdkRireki.syono,
            qIT_KhHenkouRireki.bfrnaiyou,
            qIT_KhHenkouRireki.newnaiyou) +
            $FROM +qIT_KhTtdkRireki.IT_KhTtdkRireki() + "," +
            qIT_KhHenkouRireki.IT_KhHenkouRireki() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSyouhn.IT_KykSyouhn() + "," +
            qBM_SyouhnbetuSegment.BM_SyouhnbetuSegment() + "," +
            qBM_SegmentSikinidou.BM_SegmentSikinidou() +
            $WHERE + qIT_KhTtdkRireki.syono.eq(qIT_KhHenkouRireki.syono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.eq(qIT_KhHenkouRireki.henkousikibetukey) +
            $AND +  qIT_KhTtdkRireki.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KykSyouhn.syouhncd.eq(qBM_SyouhnbetuSegment.syouhncd) +
            $AND + qIT_KykSyouhn.kyktuukasyu.eq(qBM_SyouhnbetuSegment.kyktuukasyu) +
            $AND + qBM_SyouhnbetuSegment.segcd.eq(qBM_SegmentSikinidou.segcd) +
            $AND + qIT_KhTtdkRireki.syoriYmd.eq(pSyoriYmd)  +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou)  +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableId)  +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pKoumokuId)  +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK)  +
            $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI)  +
            $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK)  +
            $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY)  +
            $AND + qBM_SyouhnbetuSegment.segbunrui1.eq(C_SegbunruiKbn.BLNK) +
            $AND + qBM_SyouhnbetuSegment.segbunrui2.eq(C_SegbunruiKbn.BLNK) +
            $AND + qBM_SegmentSikinidou.hijynnykzndkkouzakbn.eq(C_HijynnykzndkkouzaKbn.YENHONKZ);

        ExDBResults<HijynbrGengakuDataBean> exDBResults = em.createJPQL(strSql, HijynbrGengakuDataBean.class).bind(
            qIT_KhTtdkRireki,
            qIT_KhHenkouRireki,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qBM_SyouhnbetuSegment,
            qBM_SegmentSikinidou).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;
    }

    public BizDateYM getHokenryouTmttknTmttknTaisyouym(
        String pSyono,
        String pGyoumuKousinKinou) {

        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn("qIT_HokenryouTmttkn");

        String strSql = $SELECT + $MAX(qIT_HokenryouTmttkn.tmttkntaisyouym) +
            $FROM + qIT_HokenryouTmttkn.IT_HokenryouTmttkn() +
            $WHERE + qIT_HokenryouTmttkn.syono.eq(pSyono) +
            $AND + qIT_HokenryouTmttkn.gyoumuKousinKinou.eq(pGyoumuKousinKinou);

        return em.createJPQL(strSql).bind(qIT_HokenryouTmttkn).getSingleResult();
    }

    public List<BT_HijynNykSikinIdouListSks> getGengakuHijynNykSikinIdouListData(
        String pSyono,
        BizDateYM pGengkstartYM) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks");

        String strSql = $SELECT + qBT_HijynNykSikinIdouListSks +
            $FROM + qBT_HijynNykSikinIdouListSks.BT_HijynNykSikinIdouListSks() +
            $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(pSyono) +
            $AND + $(qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUMIRYOU) +
                $OR + $(qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUKANRYOU) +
                    $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.ge(pGengkstartYM)));

        return em.createJPQL(strSql).bind(qBT_HijynNykSikinIdouListSks).getResultList();
    }

    public SikinIdouListSkshijynbrNykDataBean getHijynNykSikinIdouListSksBySyono(String pSyono) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks1 = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks1");

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks2 = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks2");

        String subQuery = $SELECT + $MAX(qBT_HijynNykSikinIdouListSks1.sikinidoupjytym) +
            $FROM + qBT_HijynNykSikinIdouListSks1.BT_HijynNykSikinIdouListSks() +
            $WHERE + qBT_HijynNykSikinIdouListSks1.syono.eq(pSyono) +
            $AND + qBT_HijynNykSikinIdouListSks1.sikinidoujtkbn.ne(C_SikinidouJtKbn.SIKINIDOUTORIKESIKANRYOU);

        String strSql = $SELECT + $NEW(SikinIdouListSkshijynbrNykDataBean.class,
            qBT_HijynNykSikinIdouListSks2.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks2.sikinidoujtkbn) +
            $FROM + qBT_HijynNykSikinIdouListSks2.BT_HijynNykSikinIdouListSks() +
            $WHERE + qBT_HijynNykSikinIdouListSks2.syono.eq(pSyono) +
            $AND + qBT_HijynNykSikinIdouListSks2.sikinidoupjytym + $EQ + $(subQuery);

        return em.createJPQL(strSql, SikinIdouListSkshijynbrNykDataBean.class).setFirstResult(0).setMaxResults(1).bind(
            qBT_HijynNykSikinIdouListSks1, qBT_HijynNykSikinIdouListSks2).getSingleResult();
    }

    public BT_HijynNykSikinIdouListSks getSikinidouTorikesiKanryouData(String pSyono, BizDateYM pSikinidoupjytym) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks(
            "qBT_HijynNykSikinIdouListSks");

        String strSql = $SELECT + qBT_HijynNykSikinIdouListSks +
            $FROM + qBT_HijynNykSikinIdouListSks.BT_HijynNykSikinIdouListSks() +
            $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(pSyono) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.eq(pSikinidoupjytym) +
            $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUTORIKESIKANRYOU);

        return em.createJPQL(strSql).bind(qBT_HijynNykSikinIdouListSks).getSingleResult();
    }
}
