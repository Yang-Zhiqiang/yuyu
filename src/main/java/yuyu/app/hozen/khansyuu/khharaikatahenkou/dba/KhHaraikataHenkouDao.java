package yuyu.app.hozen.khansyuu.khharaikatahenkou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_YykIdouNaiyoHrhnk;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.predicate.FilterKariukekinByKrkseisanzumiflgNyknaiyoukbn;
import yuyu.def.hozen.sorter.SortIT_AnsyuRireki;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全 払方変更機能DAOクラス
 */
public class KhHaraikataHenkouDao {
    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public IT_KykKihon getKykKihon(String pSyono) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        return kykKihon;
    }

    public List<IT_AnsyuRireki> getAnsyuRirekis(String pSyono, C_AnnaijkKbn pAnnaijkKbn) {
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        if(ansyuKihon != null){
            List<IT_AnsyuRireki> ansyuRirekiList = ansyuKihon.getAnsyuRirekisByAnnaijkkbn(pAnnaijkKbn);

            SortIT_AnsyuRireki sortIT_AnsyuRireki = new SortIT_AnsyuRireki();

            ansyuRirekiList = sortIT_AnsyuRireki.OrderIT_AnsyuRirekiByJyuutouymDesc(ansyuRirekiList);

            return ansyuRirekiList;
        }
        return new ArrayList<IT_AnsyuRireki>();
    }

    public IW_KhHaraikataHenkouWk getKhHaraikataHenkouWk(String pKouteiKanriId) {
        return hozenDomManager.getKhHaraikataHenkouWk(pKouteiKanriId);
    }

    public Long getYykIdouUktkCount(String pSyono, String pKinouId) {

        QIT_YykIdouUktk qIT_YykIdouUktk = new QIT_YykIdouUktk("qIT_YykIdouUktk");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_YykIdouUktk) +
            $WHERE + qIT_YykIdouUktk.syono.eq(pSyono) +
            $AND + qIT_YykIdouUktk.kinouId.eq(pKinouId) +
            $AND + qIT_YykIdouUktk.yykidousyorikbn.eq(C_YykidousyoriKbn.UKE);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_YykIdouUktk).getSingleResult();

    }

    public List<IT_YykIdouUktk> getYykIdouUktks(IT_KykKihon pKykKihon, C_YykidousyoriKbn pYykidousyoriKbn) {
        return pKykKihon.getYykIdouUktksByYykidousyorikbn(pYykidousyoriKbn);
    }

    public IT_YykIdouUktk createYykIdouUktk(IT_KykKihon pKykKihon) {
        return pKykKihon.createYykIdouUktk();
    }

    public IT_YykIdouNaiyoHrhnk createYykIdouNaiyoHrhnk(IT_KykKihon pKykKihon) {
        return pKykKihon.createYykIdouNaiyoHrhnk();
    }

    public List<IT_KykSyouhn> getKykSyouhns1(IT_KykKihon pKykKihon) {
        return pKykKihon.getKykSyouhns();
    }

    public List<IT_KykSyouhn> getKykSyouhns2(IT_KykKihon pKykKihon, C_SyutkKbn pSyutkKbn) {
        return pKykKihon.getKykSyouhnsBySyutkkbn(pSyutkKbn);
    }

    public List<IT_KykSyouhn> getKykSyouhns3(IT_KykKihon pKykKihon, String pSyouhncd, Integer pSyouhnsdno,
        Integer pKyksyouhnrenno) {
        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhns();

        return new ArrayList<IT_KykSyouhn>(Collections2.filter(kykSyouhnList,
            new FilterKykSyouhn1(pSyouhncd, pSyouhnsdno, pKyksyouhnrenno)));
    }

    public Long getAnsyuRirekiSum(String pSyono, BizDateYM pJyuutouYm) {
        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql = $SELECT + $SUM + $(qIT_AnsyuRireki.jyutoukaisuum) +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(pSyono) +
            $AND + qIT_AnsyuRireki.annaijkkbn.eq(C_AnnaijkKbn.ANNAI) +
            $AND + qIT_AnsyuRireki.jyuutouym.ge(pJyuutouYm);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AnsyuRireki).getSingleResult();
    }

    public List<IT_SyouhnTokujou> getSyouhnTokujous(IT_KykKihon pKykKihon) {
        return pKykKihon.getSyouhnTokujous();
    }

    public void insert(IT_KhDenpyoData pKhDenpyoData){
        hozenDomManager.insert(pKhDenpyoData);
    }

    public List<IT_Kariukekin> getKariukekins1(IT_KykKihon pKykKihon, BizDate pRyosyuymd) {
        List<IT_Kariukekin> kariukekinList = pKykKihon.getKariukekins();

        return new ArrayList<IT_Kariukekin>(Collections2.filter(kariukekinList,
            new FilterKariukekin1(pRyosyuymd, C_NyknaiyouKbn.HARAIHENYOUP, C_Krkseisanzumiflg.SUMI)));
    }

    public Integer getNyknJissekiRirekiMaxRenno(String pSyono, BizDateYM pJyutoustartym){
        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki("qIT_NyknJissekiRireki");

        String strSql = $SELECT + $MAX(qIT_NyknJissekiRireki.renno) +
            $FROM(qIT_NyknJissekiRireki) +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + qIT_NyknJissekiRireki.jyutoustartym.eq(pJyutoustartym) +
            $GROUP_BY +qIT_NyknJissekiRireki.syono + "," +
            qIT_NyknJissekiRireki.jyutoustartym;

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getSingleResult();
    }

    public IT_NyknJissekiRireki createNyknJissekiRireki(IT_KykKihon pKykKihon){
        return pKykKihon.createNyknJissekiRireki();
    }

    public List<IT_Kariukekin> getKariukekins2(IT_KykKihon pKykKihon) {
        List<IT_Kariukekin> kariukekinList = pKykKihon.getKariukekins();

        return new ArrayList<IT_Kariukekin>(Collections2.filter(kariukekinList,
            new FilterKariukekinByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg.SUMI, C_NyknaiyouKbn.HARAIHENYOUP)));
    }

    public Integer getKariukekinMaxKrkno(String pSyono) {
        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + $MAX(qIT_Kariukekin.krkno) +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $GROUP_BY + qIT_Kariukekin.syono;

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Kariukekin).getSingleResult();
    }

    public IT_Kariukekin createKariukekin(IT_KykKihon pKykKihon) {
        return pKykKihon.createKariukekin();
    }

    public void setKouza(IT_KykKihon pKykKihon, IT_Kouza pKouza) {
        pKykKihon.setKouza(pKouza);
    }

    public IT_Kouza createKouza(IT_KykKihon pKykKihon) {
        return pKykKihon.createKouza();
    }

    public void setDattaiUktk(IT_AnsyuKihon pAnsyuKihon, IT_DattaiUktk pDattaiUktk) {
        pAnsyuKihon.setDattaiUktk(pDattaiUktk);
    }

    public void update(IT_KykKihon pKykKihon) {
        hozenDomManager.update(pKykKihon);
    }

    public void update(IT_AnsyuKihon pAnsyuKihon) {
        hozenDomManager.update(pAnsyuKihon);
    }

    public IT_KhTtdkRireki createKhTtdkRireki(IT_KykKihon pKykKihon) {
        return pKykKihon.createKhTtdkRireki();
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {
        return hozenDomManager.getAnsyuKihon(pSyono);
    }

    public void delete(IW_KhHaraikataHenkouWk pKhHaraikataHenkouWk) {
        hozenDomManager.delete(pKhHaraikataHenkouWk);
    }

    public void insert(IW_KhHaraikataHenkouWk pKhHaraikataHenkouWk) {
        hozenDomManager.insert(pKhHaraikataHenkouWk);
    }

    public void update(IW_KhHaraikataHenkouWk pKhHaraikataHenkouWk) {
        hozenDomManager.update(pKhHaraikataHenkouWk);
    }

    public List<KariukekinMinRyosyuymdSumKrkgkBean> getKariukekinMinRyosyuymdSumKrkgk(String pSyono) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + $NEW(KariukekinMinRyosyuymdSumKrkgkBean.class,
            $MIN(qIT_Kariukekin.ryosyuymd),
            $MAX(qIT_Kariukekin.ryosyuymd),
            qIT_Kariukekin.krkgk.getTypeFieldName(),
            $SUM + $(qIT_Kariukekin.krkgk.getValueFieldName()),
            $MAX(qIT_Kariukekin.hasseidenymd)) +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $AND + qIT_Kariukekin.nyknaiyoukbn.eq(C_NyknaiyouKbn.HARAIHENYOUP) +
            $AND + qIT_Kariukekin.krkseisanzumiflg.ne(C_Krkseisanzumiflg.SUMI) +
            $GROUP_BY + qIT_Kariukekin.syono + ", " +
            qIT_Kariukekin.krkgk.getTypeFieldName();

        return exDBEntityManager.createJPQL(strSql, KariukekinMinRyosyuymdSumKrkgkBean.class).bind(qIT_Kariukekin)
            .getResultList();
    }

    public BT_GyoumuKouteiInfo getGyoumuKouteiInfo(String pKouteiKanriId) {
        return bizDomManager.getGyoumuKouteiInfo(pKouteiKanriId);
    }

    public List<String> getSyonos(String pSyono, BizDate pKouryokuHasseiYmd) {
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + qIT_KykSyouhn.syono +
            $FROM(qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syono.eq(pSyono) +
            $AND + qIT_KykSyouhn.kouryokuhasseiymd.gt(pKouryokuHasseiYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhn).getResultList();
    }

    public void flush() {
        hozenDomManager.flush();
    }
}
