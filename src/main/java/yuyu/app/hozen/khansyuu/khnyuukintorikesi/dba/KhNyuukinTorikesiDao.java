package yuyu.app.hozen.khansyuu.khnyuukintorikesi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.def.hozen.manager.HozenDomManager;

import com.google.common.collect.Collections2;

/**
 * 入金取消 入金取消機能DAOのクラスです。<br />
 */
public class KhNyuukinTorikesiDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public KhNyuukinTorikesiDao () {

    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        return ansyuKihon;
    }

    public List<IT_KykSyouhn> getKykSyouhns (IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhns();

        SortKhNyuukinTorikesi sortKhNyuukinTorikesi = new SortKhNyuukinTorikesi();

        kykSyouhnLst = sortKhNyuukinTorikesi.OrderIT_KykSyouhnByKouryokuhasseiymdDesc(kykSyouhnLst);

        return kykSyouhnLst;
    }

    public List<IT_KykSyouhn> getKykSyouhns2 (IT_KykKihon pKykKihon) {

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhns();

        kykSyouhnLst = new ArrayList<IT_KykSyouhn>(Collections2.filter(kykSyouhnLst,
            new FilterKykSyouhn1(C_SyutkKbn.SYU, C_YuukousyoumetuKbn.YUUKOU, C_Kykjyoutai.HRKMTYUU,
                C_Kykjyoutai.IKKATUNK)));

        return kykSyouhnLst;
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekis(IT_KykKihon pKykKihon,BizDateYM pJyuutouym) {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = pKykKihon.getNyknJissekiRirekisByJyutoustartymNyktrksflg(pJyuutouym);

        return nyknJissekiRirekiLst;
    }

    public BM_SyouhnZokusei getSyouhnZokusei(IT_KykSyouhn pKykSyouhn) {

        BM_SyouhnZokusei syouhnZokusei = pKykSyouhn.getSyouhnZokusei();

        return syouhnZokusei;
    }

    public Integer getKariukekinMaxKrkno (String pSyono) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin();

        String quertSql = $SELECT + $MAX(qIT_Kariukekin.krkno) +
            $FROM (qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) ;

        return exDBEntityManager.createJPQL(quertSql).bind(qIT_Kariukekin).getSingleResult();

    }

    public IT_NyknJissekiRireki getNyknJissekiRireki (IT_KykKihon pKykKihon,BizDateYM pJyuutouym, int pRenNo) {

        IT_NyknJissekiRireki nyknJissekiRireki = pKykKihon.getNyknJissekiRirekiByJyutoustartymRenno(pJyuutouym, pRenNo);

        return nyknJissekiRireki;
    }

    public IT_Kariukekin createKariukekin (IT_KykKihon pKykKihon) {

        IT_Kariukekin kariukekin = pKykKihon.createKariukekin();

        return kariukekin;
    }

    public void update (IT_KykKihon pKykKihon) {
        hozenDomManager.update(pKykKihon);
    }

    public void update (IT_AnsyuKihon pAnsyuKihon) {
        hozenDomManager.update(pAnsyuKihon);
    }

    public void insert (IT_KhDenpyoData pKhDenpyoData) {
        hozenDomManager.insert(pKhDenpyoData);
    }

    public IT_KhTtdkRireki createKhTtdkRireki(IT_KykKihon pKykKihon) {

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.createKhTtdkRireki();

        return khTtdkRireki;
    }
}
