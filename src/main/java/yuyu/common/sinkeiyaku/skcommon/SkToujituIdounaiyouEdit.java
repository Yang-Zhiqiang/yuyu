package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.util.EntityUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiKekkaBean;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMq;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiYokenBean;
import yuyu.common.biz.bznayose.BzTrksIraiKekkaBean;
import yuyu.common.biz.bznayose.BzTrksIraiMq;
import yuyu.common.biz.bznayose.BzTrksIraiYokenBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBT_TjtIdouNySk;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.sorter.SortHT_DakuhiKettei;

/**
 * 新契約 新契約共通 新契約当日異動内容編集
 */
public class SkToujituIdounaiyouEdit {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    public SkToujituIdounaiyouEdit() {
        super();
    }

    public void setSkIdounaiyouInit() {

    }

    @Transactional
    public SkIdounaiyouBeforeBean setSkIdounaiyouBefore(HT_SyoriCTL pSyoriCTL) {

        if (pSyoriCTL == null || C_UmuKbn.NONE.eq(pSyoriCTL.getMosnrkumu())) {

            return null;
        }

        SkIdounaiyouBeforeBean skIdounaiyouBeforeBean = SWAKInjector.getInstance(SkIdounaiyouBeforeBean.class);
        skIdounaiyouBeforeBean.setSyoriCTL(new HT_SyoriCTL());
        skIdounaiyouBeforeBean.setMosKihon(new HT_MosKihon());
        skIdounaiyouBeforeBean.setMosSyouhn(new HT_MosSyouhn());
        skIdounaiyouBeforeBean.setSbUketorinin1(new HT_Uketorinin());
        skIdounaiyouBeforeBean.setSbUketorinin2(new HT_Uketorinin());
        skIdounaiyouBeforeBean.setSbUketorinin3(new HT_Uketorinin());
        skIdounaiyouBeforeBean.setSbUketorinin4(new HT_Uketorinin());
        skIdounaiyouBeforeBean.setStDrSkUketorinin1(new HT_Uketorinin());
        skIdounaiyouBeforeBean.setMosDairiten1(new HT_MosDairiten());
        skIdounaiyouBeforeBean.setMosDairiten2(new HT_MosDairiten());
        skIdounaiyouBeforeBean.setMosTrkKzk1(new HT_MosTrkKzk());
        skIdounaiyouBeforeBean.setMosTrkKzk2(new HT_MosTrkKzk());
        skIdounaiyouBeforeBean.setKouzaJyouhou(null);
        skIdounaiyouBeforeBean.setSbUktNin(0);
        skIdounaiyouBeforeBean.setStDrSkNin(0);
        skIdounaiyouBeforeBean.setMosDrt(0);
        skIdounaiyouBeforeBean.setMosTrkKzkNin(0);
        skIdounaiyouBeforeBean.setTsnyTuukasyu(C_Tuukasyu.BLNK);
        HT_MosKihon mosKihon = pSyoriCTL.getMosKihon();
        HT_MosSyouhn mosSyouhn = null;
        List<HT_MosSyouhn> mosSyouhnLst;
        HT_Uketorinin sbUketorinin1 = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);
        HT_Uketorinin sbUketorinin2 = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 2);
        HT_Uketorinin sbUketorinin3 = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 3);
        HT_Uketorinin sbUketorinin4 = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 4);
        HT_Uketorinin stDrSkUketorinin1 = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        HT_MosDairiten mosDairiten1 = pSyoriCTL.getMosDairitenByRenno(1);
        HT_MosDairiten mosDairiten2 = pSyoriCTL.getMosDairitenByRenno(2);
        List<HT_MosTrkKzk> mosTrkKzkList = pSyoriCTL.getMosTrkKzks();
        HT_MosTrkKzk mosTrkKzk1 = null;
        HT_MosTrkKzk mosTrkKzk2 = null;
        mosSyouhnLst = pSyoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst != null && mosSyouhnLst.size() != 0) {

            mosSyouhn = mosSyouhnLst.get(0);
        }

        for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                mosTrkKzk1 = mosTrkKzk;
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                mosTrkKzk2 = mosTrkKzk;
            }
        }

        skIdounaiyouBeforeBean.getSyoriCTL().setMosno(pSyoriCTL.getMosno());
        skIdounaiyouBeforeBean.getSyoriCTL().setSeiritukbn(pSyoriCTL.getSeiritukbn());
        skIdounaiyouBeforeBean.getSyoriCTL().setSrsyoriymd(pSyoriCTL.getSrsyoriymd());
        skIdounaiyouBeforeBean.getSyoriCTL().setMfrenflg(pSyoriCTL.getMfrenflg());
        skIdounaiyouBeforeBean.getSyoriCTL().setSyono(pSyoriCTL.getSyono());

        if (mosKihon == null) {

        }
        else {

            skIdounaiyouBeforeBean.getMosKihon().setMosymd(mosKihon.getMosymd());
            skIdounaiyouBeforeBean.getMosKihon().setKykymd(mosKihon.getKykymd());
            skIdounaiyouBeforeBean.getMosKihon().setSknnkaisiymd(mosKihon.getSknnkaisiymd());
            skIdounaiyouBeforeBean.getMosKihon().setKyktuukasyu(mosKihon.getKyktuukasyu());
            skIdounaiyouBeforeBean.getMosKihon().setSntkhoukbn(mosKihon.getSntkhoukbn());
            skIdounaiyouBeforeBean.getMosKihon().setBosyuuym(mosKihon.getBosyuuym());
            skIdounaiyouBeforeBean.getMosKihon().setKykkbn(mosKihon.getKykkbn());
            skIdounaiyouBeforeBean.getMosKihon().setYennykntkhkkbn(mosKihon.getYennykntkhkkbn());
            skIdounaiyouBeforeBean.getMosKihon().setHhknnmkn(mosKihon.getHhknnmkn());
            skIdounaiyouBeforeBean.getMosKihon().setHhknnmkj(mosKihon.getHhknnmkj());
            skIdounaiyouBeforeBean.getMosKihon().setHhknnmkjkhukakbn(mosKihon.getHhknnmkjkhukakbn());
            skIdounaiyouBeforeBean.getMosKihon().setHhknseiymd(mosKihon.getHhknseiymd());
            skIdounaiyouBeforeBean.getMosKihon().setHhknsei(mosKihon.getHhknsei());
            skIdounaiyouBeforeBean.getMosKihon().setHhknyno(mosKihon.getHhknyno());
            skIdounaiyouBeforeBean.getMosKihon().setHhknadr1kj(mosKihon.getHhknadr1kj());
            skIdounaiyouBeforeBean.getMosKihon().setHhknadr2kj(mosKihon.getHhknadr2kj());
            skIdounaiyouBeforeBean.getMosKihon().setHhknadr3kj(mosKihon.getHhknadr3kj());
            skIdounaiyouBeforeBean.getMosKihon().setHhkntelno(mosKihon.getHhkntelno());
            skIdounaiyouBeforeBean.getMosKihon().setHhknsykgycd(mosKihon.getHhknsykgycd());
            skIdounaiyouBeforeBean.getMosKihon().setKyknmkn(mosKihon.getKyknmkn());
            skIdounaiyouBeforeBean.getMosKihon().setKyknmkj(mosKihon.getKyknmkj());
            skIdounaiyouBeforeBean.getMosKihon().setKyknmkjkhukakbn(mosKihon.getKyknmkjkhukakbn());
            skIdounaiyouBeforeBean.getMosKihon().setKykseiymd(mosKihon.getKykseiymd());
            skIdounaiyouBeforeBean.getMosKihon().setTsinyno(mosKihon.getTsinyno());
            skIdounaiyouBeforeBean.getMosKihon().setTsinadr1kj(mosKihon.getTsinadr1kj());
            skIdounaiyouBeforeBean.getMosKihon().setTsinadr2kj(mosKihon.getTsinadr2kj());
            skIdounaiyouBeforeBean.getMosKihon().setTsinadr3kj(mosKihon.getTsinadr3kj());
            skIdounaiyouBeforeBean.getMosKihon().setTsintelno(mosKihon.getTsintelno());
            skIdounaiyouBeforeBean.getMosKihon().setJyudkaigomehrtkhkkbn(mosKihon.getJyudkaigomehrtkhkkbn());
            skIdounaiyouBeforeBean.getMosKihon().setHrkkeiro(mosKihon.getHrkkeiro());

            skIdounaiyouBeforeBean.setTsnSibouS(getTuusanyouSibouS(pSyoriCTL));
            skIdounaiyouBeforeBean.setTsnyouNkGns(getTuusanyouNenkingns(pSyoriCTL));

            BizCurrency tsnyouItijiP = getTuusanyouItijibaraiP(pSyoriCTL);
            skIdounaiyouBeforeBean.setItijiP(tsnyouItijiP);
            skIdounaiyouBeforeBean.setTsnyEnNyknkGk(getTsnyouYenNyknkGk(pSyoriCTL));
        }

        if (mosSyouhn == null) {

        }
        else {

            skIdounaiyouBeforeBean.getMosSyouhn().setSyouhncd(mosSyouhn.getSyouhncd());
            skIdounaiyouBeforeBean.getMosSyouhn().setSyouhnsdno(mosSyouhn.getSyouhnsdno());
            skIdounaiyouBeforeBean.getMosSyouhn().setHrkkkn(mosSyouhn.getHrkkkn());
        }

        if (sbUketorinin1 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getSbUketorinin1().setUktnmkn(sbUketorinin1.getUktnmkn());
            skIdounaiyouBeforeBean.getSbUketorinin1().setUktnmkj(sbUketorinin1.getUktnmkj());
            skIdounaiyouBeforeBean.getSbUketorinin1().setUktnmkjkhukakbn(sbUketorinin1.getUktnmkjkhukakbn());
        }

        if (sbUketorinin2 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getSbUketorinin2().setUktnmkn(sbUketorinin2.getUktnmkn());
            skIdounaiyouBeforeBean.getSbUketorinin2().setUktnmkj(sbUketorinin2.getUktnmkj());
            skIdounaiyouBeforeBean.getSbUketorinin2().setUktnmkjkhukakbn(sbUketorinin2.getUktnmkjkhukakbn());
        }

        if (sbUketorinin3 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getSbUketorinin3().setUktnmkn(sbUketorinin3.getUktnmkn());
            skIdounaiyouBeforeBean.getSbUketorinin3().setUktnmkj(sbUketorinin3.getUktnmkj());
            skIdounaiyouBeforeBean.getSbUketorinin3().setUktnmkjkhukakbn(sbUketorinin3.getUktnmkjkhukakbn());
        }

        if (sbUketorinin4 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getSbUketorinin4().setUktnmkn(sbUketorinin4.getUktnmkn());
            skIdounaiyouBeforeBean.getSbUketorinin4().setUktnmkj(sbUketorinin4.getUktnmkj());
            skIdounaiyouBeforeBean.getSbUketorinin4().setUktnmkjkhukakbn(sbUketorinin4.getUktnmkjkhukakbn());
        }

        if (stDrSkUketorinin1 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getStDrSkUketorinin1().setUktnmkn(stDrSkUketorinin1.getUktnmkn());
            skIdounaiyouBeforeBean.getStDrSkUketorinin1().setUktnmkj(stDrSkUketorinin1.getUktnmkj());
            skIdounaiyouBeforeBean.getStDrSkUketorinin1().setUktnmkjkhukakbn(stDrSkUketorinin1.getUktnmkjkhukakbn());
        }

        if (mosDairiten1 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getMosDairiten1().setTratkiagcd(mosDairiten1.getTratkiagcd());
            skIdounaiyouBeforeBean.getMosDairiten1().setBunwari(mosDairiten1.getBunwari());
            skIdounaiyouBeforeBean.getMosDairiten1().setDrtenkanrisosikicd(mosDairiten1.getDrtenkanrisosikicd());
        }

        if (mosDairiten2 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getMosDairiten2().setTratkiagcd(mosDairiten2.getTratkiagcd());
            skIdounaiyouBeforeBean.getMosDairiten2().setBunwari(mosDairiten2.getBunwari());
            skIdounaiyouBeforeBean.getMosDairiten2().setDrtenkanrisosikicd(mosDairiten2.getDrtenkanrisosikicd());
        }

        if (mosTrkKzk1 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getMosTrkKzk1().setTrkkzknmkn(mosTrkKzk1.getTrkkzknmkn());
            skIdounaiyouBeforeBean.getMosTrkKzk1().setTrkkzknmkj(mosTrkKzk1.getTrkkzknmkj());
            skIdounaiyouBeforeBean.getMosTrkKzk1().setTrkkzknmkjkhukakbn(mosTrkKzk1.getTrkkzknmkjkhukakbn());
        }

        if (mosTrkKzk2 == null) {

        }
        else {

            skIdounaiyouBeforeBean.getMosTrkKzk2().setTrkkzknmkn(mosTrkKzk2.getTrkkzknmkn());
            skIdounaiyouBeforeBean.getMosTrkKzk2().setTrkkzknmkj(mosTrkKzk2.getTrkkzknmkj());
            skIdounaiyouBeforeBean.getMosTrkKzk2().setTrkkzknmkjkhukakbn(mosTrkKzk2.getTrkkzknmkjkhukakbn());
        }

        skIdounaiyouBeforeBean.setSbUktNin(pSyoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT).size());

        skIdounaiyouBeforeBean.setStDrSkNin(pSyoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK).size());

        skIdounaiyouBeforeBean.setMosDrt(pSyoriCTL.getMosDairitens().size());

        skIdounaiyouBeforeBean.setMosTrkKzkNin(pSyoriCTL.getMosTrkKzks().size());

        if (mosSyouhn != null) {
            C_Tuukasyu tsnyTuukasyu = getTsnyouTuukasyu(mosSyouhn.getSyouhncd(), mosKihon);
            skIdounaiyouBeforeBean.setTsnyTuukasyu(tsnyTuukasyu);
        }

        if (mosKihon != null) {
            if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro()) && C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
                HT_KouzaJyouhou kouzaJyouhou = pSyoriCTL.getKouzaJyouhou();

                if (kouzaJyouhou != null) {
                    skIdounaiyouBeforeBean.setKouzaJyouhou(new HT_KouzaJyouhou());
                    skIdounaiyouBeforeBean.getKouzaJyouhou().setBankcd(kouzaJyouhou.getBankcd());
                    skIdounaiyouBeforeBean.getKouzaJyouhou().setSitencd(kouzaJyouhou.getSitencd());
                    skIdounaiyouBeforeBean.getKouzaJyouhou().setYokinkbn(kouzaJyouhou.getYokinkbn());
                    skIdounaiyouBeforeBean.getKouzaJyouhou().setKouzano(kouzaJyouhou.getKouzano());
                    String kzmeigiNmKn = "";
                    if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {
                        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                            kzmeigiNmKn = mosKihon.getHhknnmkn();
                        }
                        else {
                            kzmeigiNmKn = mosKihon.getKyknmkn();
                        }
                    }
                    else {
                        kzmeigiNmKn = kouzaJyouhou.getKzmeiginmkn();
                    }
                    skIdounaiyouBeforeBean.getKouzaJyouhou().setKzmeiginmkn(kzmeigiNmKn);
                    skIdounaiyouBeforeBean.getKouzaJyouhou().setKzkykdoukbn(kouzaJyouhou.getKzkykdoukbn());
                }
            }
        }

        return skIdounaiyouBeforeBean;
    }

    @Transactional
    public boolean skIdounaiyouHenkouCheck(ExDBEntity<?,?> pExDBEntity, SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {

        if (pExDBEntity == null || C_UmuKbn.NONE.equals(((HT_SyoriCTL) pExDBEntity).getMosnrkumu())
            || pSkIdounaiyouBeforeBean == null) {

            return false;
        }

        ExDBEntity<?,?> exDBEntity = new HT_SyoriCTL();
        Set<String> sabunSet = null;
        String hkProperty = "";
        HT_MosTrkKzk hkgoMosTrkKzk1 = null;
        HT_MosTrkKzk hkgoMosTrkKzk2 = null;

        sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getSyoriCTL(), pExDBEntity, exDBEntity);

        for (String sabun : sabunSet) {

            hkProperty = sabun;

            if (HT_SyoriCTL.MOSNO.equals(hkProperty) || HT_SyoriCTL.SEIRITUKBN.equals(hkProperty)
                || HT_SyoriCTL.SRSYORIYMD.equals(hkProperty) || HT_SyoriCTL.MFRENFLG.equals(hkProperty)
                || HT_SyoriCTL.SYONO.equals(hkProperty)) {

                return true;
            }
        }

        HT_MosKihon hkgoMosKihon = ((HT_SyoriCTL) pExDBEntity).getMosKihon();
        exDBEntity = new HT_MosKihon();

        List<HT_MosSyouhn> hkgoMosSyouhnLst = new ArrayList<>();

        if (hkgoMosKihon != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getMosKihon(), hkgoMosKihon, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_MosKihon.MOSYMD.equals(hkProperty)          || HT_MosKihon.KYKYMD.equals(hkProperty)
                    || HT_MosKihon.SKNNKAISIYMD.equals(hkProperty) || HT_MosKihon.KYKTUUKASYU.equals(hkProperty)
                    || HT_MosKihon.SNTKHOUKBN.equals(hkProperty)   || HT_MosKihon.BOSYUUYM.equals(hkProperty)
                    || HT_MosKihon.KYKKBN.equals(hkProperty)       || HT_MosKihon.YENNYKNTKHKKBN.equals(hkProperty)
                    || HT_MosKihon.HHKNNMKN.equals(hkProperty)     || HT_MosKihon.HHKNNMKJ.equals(hkProperty)
                    || HT_MosKihon.HHKNNMKJKHUKAKBN.equals(hkProperty)
                    || HT_MosKihon.HHKNSEIYMD.equals(hkProperty)   || HT_MosKihon.HHKNSEI.equals(hkProperty)
                    || HT_MosKihon.HHKNYNO.equals(hkProperty)      || HT_MosKihon.HHKNADR1KJ.equals(hkProperty)
                    || HT_MosKihon.HHKNADR2KJ.equals(hkProperty)   || HT_MosKihon.HHKNADR3KJ.equals(hkProperty)
                    || HT_MosKihon.HHKNTELNO.equals(hkProperty)    || HT_MosKihon.HHKNSYKGYCD.equals(hkProperty)
                    || HT_MosKihon.KYKNMKN.equals(hkProperty)      || HT_MosKihon.KYKNMKJ.equals(hkProperty)
                    || HT_MosKihon.KYKNMKJKHUKAKBN.equals(hkProperty)
                    || HT_MosKihon.KYKSEIYMD.equals(hkProperty)    || HT_MosKihon.TSINYNO.equals(hkProperty)
                    || HT_MosKihon.TSINADR1KJ.equals(hkProperty)   || HT_MosKihon.TSINADR2KJ.equals(hkProperty)
                    || HT_MosKihon.TSINADR3KJ.equals(hkProperty)   || HT_MosKihon.TSINTELNO.equals(hkProperty)
                    || HT_MosKihon.JYUDKAIGOMEHRTKHKKBN.equals(hkProperty)
                    || HT_MosKihon.HRKKEIRO.equals(hkProperty)) {

                    return true;
                }
            }

            if (pSkIdounaiyouBeforeBean.getTsnSibouS() == null
                || pSkIdounaiyouBeforeBean.getTsnSibouS().compareTo(getTuusanyouSibouS(((HT_SyoriCTL) pExDBEntity))) != 0) {

                return true;
            }

            if (pSkIdounaiyouBeforeBean.getTsnyouNkGns() == null
                || pSkIdounaiyouBeforeBean.getTsnyouNkGns().compareTo(getTuusanyouNenkingns(((HT_SyoriCTL) pExDBEntity))) != 0) {

                return true;
            }

            BizCurrency tsnyouItijiP = getTuusanyouItijibaraiP((HT_SyoriCTL) pExDBEntity);

            BizCurrency tsnyouEnNyknkGk = getTsnyouYenNyknkGk((HT_SyoriCTL) pExDBEntity);

            if (pSkIdounaiyouBeforeBean.getItijiP() == null
                || pSkIdounaiyouBeforeBean.getItijiP().compareTo(tsnyouItijiP) != 0) {

                return true;
            }

            else if (pSkIdounaiyouBeforeBean.getTsnyEnNyknkGk() == null
                || pSkIdounaiyouBeforeBean.getTsnyEnNyknkGk().compareTo(tsnyouEnNyknkGk) != 0) {

                return true;
            }

            hkgoMosSyouhnLst = ((HT_SyoriCTL) pExDBEntity).getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            exDBEntity = new HT_MosSyouhn();

            if (hkgoMosSyouhnLst.size() != 0) {

                sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getMosSyouhn(), hkgoMosSyouhnLst.get(0), exDBEntity);

                for (String sabun : sabunSet) {

                    hkProperty = sabun;

                    if (HT_MosSyouhn.SYOUHNCD.equals(hkProperty) || HT_MosSyouhn.SYOUHNSDNO.equals(hkProperty)
                        || HT_MosSyouhn.HRKKKN.equals(hkProperty)) {

                        return true;
                    }
                }

                if (!getTsnyouTuukasyu(hkgoMosSyouhnLst.get(0).getSyouhncd(), hkgoMosKihon).eq(
                    pSkIdounaiyouBeforeBean.getTsnyTuukasyu())) {
                    return true;
                }
            }

            HT_KouzaJyouhou hkgoKouzaJyouhou = null;
            if (C_Hrkkeiro.KOUHURI.eq(hkgoMosKihon.getHrkkeiro()) && C_Tuukasyu.JPY.eq(hkgoMosKihon.getHrktuukasyu())) {
                hkgoKouzaJyouhou = ((HT_SyoriCTL) pExDBEntity).getKouzaJyouhou();
            }

            HT_KouzaJyouhou hkmaeKouzaJyouhou = pSkIdounaiyouBeforeBean.getKouzaJyouhou();
            exDBEntity = new HT_KouzaJyouhou();

            if (hkgoKouzaJyouhou == null) {
                if (hkmaeKouzaJyouhou != null) {
                    return true;
                }
            }
            else {
                if (hkmaeKouzaJyouhou == null) {
                    return true;
                }
                sabunSet = EntityUtil.diffEntitys(hkmaeKouzaJyouhou, hkgoKouzaJyouhou, exDBEntity);

                for (String sabun : sabunSet) {

                    hkProperty = sabun;

                    if (HT_KouzaJyouhou.BANKCD.equals(hkProperty)
                        || HT_KouzaJyouhou.SITENCD.equals(hkProperty)
                        || HT_KouzaJyouhou.YOKINKBN.equals(hkProperty)
                        || HT_KouzaJyouhou.KOUZANO.equals(hkProperty)
                        || HT_KouzaJyouhou.KZMEIGINMKN.equals(hkProperty)
                        || HT_KouzaJyouhou.KZKYKDOUKBN.equals(hkProperty)) {

                        return true;
                    }
                }
            }
        }

        int hkgoSbUktNin = ((HT_SyoriCTL) pExDBEntity).getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT).size();
        if (pSkIdounaiyouBeforeBean.getSbUktNin() != hkgoSbUktNin) {

            return true;
        }

        int hkgoStDrSkNin = ((HT_SyoriCTL) pExDBEntity).getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK).size();
        if (pSkIdounaiyouBeforeBean.getStDrSkNin() != hkgoStDrSkNin) {

            return true;
        }

        int hkgoMosDrt = ((HT_SyoriCTL) pExDBEntity).getMosDairitens().size();
        if (pSkIdounaiyouBeforeBean.getMosDrt() != hkgoMosDrt) {

            return true;
        }

        int hkgoMosTrkKzkNin = ((HT_SyoriCTL) pExDBEntity).getMosTrkKzks().size();
        if (pSkIdounaiyouBeforeBean.getMosTrkKzkNin() != hkgoMosTrkKzkNin) {

            return true;
        }

        HT_Uketorinin hkgoUketorinin = ((HT_SyoriCTL) pExDBEntity).getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);
        exDBEntity = new HT_Uketorinin();

        if (hkgoUketorinin != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getSbUketorinin1(), hkgoUketorinin, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_Uketorinin.UKTNMKN.equals(hkProperty) || HT_Uketorinin.UKTNMKJ.equals(hkProperty)
                    || HT_Uketorinin.UKTNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        hkgoUketorinin = ((HT_SyoriCTL) pExDBEntity).getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 2);
        exDBEntity = new HT_Uketorinin();

        if (hkgoUketorinin != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getSbUketorinin2(), hkgoUketorinin, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_Uketorinin.UKTNMKN.equals(hkProperty) || HT_Uketorinin.UKTNMKJ.equals(hkProperty)
                    || HT_Uketorinin.UKTNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        hkgoUketorinin = ((HT_SyoriCTL) pExDBEntity).getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 3);
        exDBEntity = new HT_Uketorinin();

        if (hkgoUketorinin != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getSbUketorinin3(), hkgoUketorinin, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_Uketorinin.UKTNMKN.equals(hkProperty) || HT_Uketorinin.UKTNMKJ.equals(hkProperty)
                    || HT_Uketorinin.UKTNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        hkgoUketorinin = ((HT_SyoriCTL) pExDBEntity).getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 4);
        exDBEntity = new HT_Uketorinin();

        if (hkgoUketorinin != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getSbUketorinin4(), hkgoUketorinin, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_Uketorinin.UKTNMKN.equals(hkProperty) || HT_Uketorinin.UKTNMKJ.equals(hkProperty)
                    || HT_Uketorinin.UKTNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        hkgoUketorinin = ((HT_SyoriCTL) pExDBEntity).getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        exDBEntity = new HT_Uketorinin();

        if (hkgoUketorinin != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getStDrSkUketorinin1(), hkgoUketorinin, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_Uketorinin.UKTNMKN.equals(hkProperty) || HT_Uketorinin.UKTNMKJ.equals(hkProperty)
                    || HT_Uketorinin.UKTNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        HT_MosDairiten hkgoMosDairiten = ((HT_SyoriCTL) pExDBEntity).getMosDairitenByRenno(1);
        exDBEntity = new HT_MosDairiten();

        if (hkgoMosDairiten != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getMosDairiten1(), hkgoMosDairiten, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_MosDairiten.TRATKIAGCD.equals(hkProperty)
                    || HT_MosDairiten.BUNWARI.equals(hkProperty)
                    || HT_MosDairiten.DRTENKANRISOSIKICD.equals(hkProperty)) {

                    return true;
                }
            }
        }

        hkgoMosDairiten = ((HT_SyoriCTL) pExDBEntity).getMosDairitenByRenno(2);
        exDBEntity = new HT_MosDairiten();

        if (hkgoMosDairiten != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getMosDairiten2(), hkgoMosDairiten, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_MosDairiten.TRATKIAGCD.equals(hkProperty)
                    || HT_MosDairiten.BUNWARI.equals(hkProperty)
                    || HT_MosDairiten.DRTENKANRISOSIKICD.equals(hkProperty)) {

                    return true;
                }
            }
        }

        List<HT_MosTrkKzk> hkgoMosTrkKzkList = ((HT_SyoriCTL) pExDBEntity).getMosTrkKzks();
        exDBEntity = new HT_MosTrkKzk();

        for (HT_MosTrkKzk mosTrkKzk : hkgoMosTrkKzkList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                hkgoMosTrkKzk1 = mosTrkKzk;
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                hkgoMosTrkKzk2 = mosTrkKzk;
            }
        }

        if (hkgoMosTrkKzk1 != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getMosTrkKzk1(), hkgoMosTrkKzk1, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_MosTrkKzk.TRKKZKNMKN.equals(hkProperty) || HT_MosTrkKzk.TRKKZKNMKJ.equals(hkProperty)
                    || HT_MosTrkKzk.TRKKZKNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        if (hkgoMosTrkKzk2 != null) {

            sabunSet = EntityUtil.diffEntitys(pSkIdounaiyouBeforeBean.getMosTrkKzk2(), hkgoMosTrkKzk2, exDBEntity);

            for (String sabun : sabunSet) {

                hkProperty = sabun;

                if (HT_MosTrkKzk.TRKKZKNMKN.equals(hkProperty) || HT_MosTrkKzk.TRKKZKNMKJ.equals(hkProperty)
                    || HT_MosTrkKzk.TRKKZKNMKJKHUKAKBN.equals(hkProperty)) {

                    return true;
                }
            }
        }

        return false;
    }

    @Transactional
    public SkIdounaiyouKekkaBean skIdounaiyouMQEdit(HT_SyoriCTL pSyoriCTL) {

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);
        BzTrksIraiYokenBean bzTrksIraiYokenBean = SWAKInjector.getInstance(BzTrksIraiYokenBean.class);
        SkIdounaiyouKekkaBean bkIdounaiyouKekkaBean = SWAKInjector.getInstance(SkIdounaiyouKekkaBean.class);
        BzTrksIraiKekkaBean bzTrksIraiKekkaBean = SWAKInjector.getInstance(BzTrksIraiKekkaBean.class);
        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);
        BzTrksIraiMq bzTrksIraiMq  = SWAKInjector.getInstance(BzTrksIraiMq.class);

        bkIdounaiyouKekkaBean.setErrorKbn(C_ErrorKbn.ERROR);
        bkIdounaiyouKekkaBean.setErrorMsgLst(new ArrayList<String>());

        if (pSyoriCTL == null) {

            return bkIdounaiyouKekkaBean;
        }

        bzTrksIraiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        bzTrksIraiYokenBean.setHuho2kykno(pSyoriCTL.getMosno());

        if (keiyakunaiyouHaneiBeanCreate(pSyoriCTL, bzKykNaiyouHaneiYokenBean) == 0) {

            BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean = bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

            bzTrksIraiYokenBean.setYoukyuuno(bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
            bzTrksIraiYokenBean.setKyknaiyouhaneierrkbn(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn());

            if (C_KyknaiyouhaneiErrKbn.SYORIOK.eq(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn())) {

                bizDomManager.insert(bzKykNaiyouHaneiKekkaBean.getTjtidounysk());

                bkIdounaiyouKekkaBean.setErrorKbn(C_ErrorKbn.OK);
                bkIdounaiyouKekkaBean.setYoukyuuno(bzKykNaiyouHaneiKekkaBean.getYoukyuuno());

                List<HT_NayoseKekka> nayoseKekkaList = pSyoriCTL.getNayoseKekkas();

                if (nayoseKekkaList != null && nayoseKekkaList.size() > 0){
                    for (HT_NayoseKekka nk : nayoseKekkaList){

                        if (C_SntkInfoTaisyousyaKbn.HIHOKENSYA.eq(nk.getSntkinfotaisyousyakbn()) &&
                            !C_NayoseJissiKekkaKbn.BLNK.eq(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn()) &&
                            !C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU.eq(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn())){

                            nk.setSakuinnmno(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
                        }

                        if (C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.eq(nk.getSntkinfotaisyousyakbn())){
                            HT_MosKihon moskihon = pSyoriCTL.getMosKihon();
                            if (C_KykKbn.KEIHI_DOUITU.eq(moskihon.getKykkbn())){
                                if (!C_NayoseJissiKekkaKbn.BLNK.eq(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn()) &&
                                    !C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU.eq(bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn())){

                                    nk.setSakuinnmno(bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
                                }
                            }
                            else {
                                if (!C_NayoseJissiKekkaKbn.BLNK.eq(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn()) &&
                                    !C_NayoseJissiKekkaKbn.HINDOOVERSYORIHUNOU.eq(bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn())){
                                    nk.setSakuinnmno(bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
                                }
                            }
                        }
                    }
                }


                return bkIdounaiyouKekkaBean;
            }
            bkIdounaiyouKekkaBean.setErrorKbn(C_ErrorKbn.ERROR);

            if (C_KyknaiyouhaneiErrKbn.SYORIERROR.eq(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn())) {

                bkIdounaiyouKekkaBean.getErrorMsgLst().add(MessageId.EBA1020);

                return bkIdounaiyouKekkaBean;
            }
            else if (C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU.eq(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn())) {

                bzTrksIraiKekkaBean = bzTrksIraiMq.exec(bzTrksIraiYokenBean);

                if (C_JdTrksPalTrksZanKbn.ARI.eq(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn())) {

                    bkIdounaiyouKekkaBean.getErrorMsgLst().add(MessageId.EBA1021);
                }

                else if (C_JdTrksPalTrksZanKbn.KANOUSEIARI.eq(bzTrksIraiKekkaBean.getJdtrkspaltrkszankbn())) {

                    bkIdounaiyouKekkaBean.getErrorMsgLst().add(MessageId.EBA1022);
                }

                else {

                    bkIdounaiyouKekkaBean.getErrorMsgLst().add(MessageId.EBA1020);
                }

                return bkIdounaiyouKekkaBean;
            }
        }

        return bkIdounaiyouKekkaBean;
    }

    @Transactional
    public BT_TjtIdouNySk skIdounaiyouFileEdit(HT_SyoriCTL pSyoriCTL) {

        if (pSyoriCTL == null) {

            return null;
        }

        BT_TjtIdouNySk tjtIdouNySk = toujituIdounaiyouCreate(pSyoriCTL);

        return tjtIdouNySk;
    }

    @Transactional
    public List<SkIdounaiyouTorikesiKekkaBean> skIdounaiyouCancel() {

        List<SkIdounaiyouTorikesiKekkaBean> skIdounaiyouTorikesiKekkaBeanLst = new ArrayList<>();

        return null;
    }

    public BT_TjtIdouNySk skIdounaiyouSakujyoFileEdit(String pMosNo) {

        BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.createIdouSkMeigi();
        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.createIdouSkBosyuudr();
        int renNo = 1;

        List<BT_TjtIdouNySk> tjtIdouNySkList = bizDomManager.getTjtIdouNySksByMosno(pMosNo);
        SortBT_TjtIdouNySk sortBT_TjtIdouNySk = SWAKInjector.getInstance(SortBT_TjtIdouNySk.class);

        if (tjtIdouNySkList != null && tjtIdouNySkList.size() > 0) {

            tjtIdouNySkList = sortBT_TjtIdouNySk.OrderBT_TjtIdouNySkByPkDesc(tjtIdouNySkList);

            renNo = tjtIdouNySkList.get(0).getRenno3keta() + 1;
        }

        tjtIdouNySk.setMosno(pMosNo);
        tjtIdouNySk.setRenno3keta(renNo);
        tjtIdouNySk.setRecordsakujyohyouji(1);
        tjtIdouNySk.setGyoumuKousinKinou(kinou.getKinouId());
        tjtIdouNySk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        tjtIdouNySk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        idouSkMeigi.setMosno(pMosNo);
        idouSkMeigi.setRenno3keta(renNo);

        idouSkBosyuudr.setMosno(pMosNo);
        idouSkBosyuudr.setRenno3keta(renNo);

        BizPropertyInitializer.initialize(tjtIdouNySk);
        BizPropertyInitializer.initialize(idouSkMeigi);
        BizPropertyInitializer.initialize(idouSkBosyuudr);

        return tjtIdouNySk;
    }

    private BT_TjtIdouNySk toujituIdounaiyouCreate(HT_SyoriCTL pSyoriCTL) {

        BT_TjtIdouNySk tjtIdouNySk = new BT_TjtIdouNySk();
        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.createIdouSkMeigi();
        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.createIdouSkBosyuudr();
        HT_MosKihon mosKihon = null;
        List<HT_MosSyouhn> mosSyouhnLst = null;
        HT_Uketorinin uketorinin = null;
        HT_MosDairiten mosDairiten = null;
        HT_MosTrkKzk mosTrkKzk1 = null;
        HT_MosTrkKzk mosTrkKzk2 = null;
        C_MossyoumetuKbn mossyoumetuKbn = C_MossyoumetuKbn.MIKAKUTEI;
        int renNo = 1;
        SortBT_TjtIdouNySk sortBT_TjtIdouNySk = SWAKInjector.getInstance(SortBT_TjtIdouNySk.class);
        SortHT_DakuhiKettei sortHT_DakuhiKettei = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);
        EditPalRenkeiKoumoku palRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

        List<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByMosno(pSyoriCTL.getMosno());

        if (tjtIdouNySkLst != null && tjtIdouNySkLst.size() > 0) {

            tjtIdouNySkLst = sortBT_TjtIdouNySk.OrderBT_TjtIdouNySkByPkDesc(tjtIdouNySkLst);

            renNo = tjtIdouNySkLst.get(0).getRenno3keta() + 1;
        }

        tjtIdouNySk.setMosno(pSyoriCTL.getMosno());
        tjtIdouNySk.setRenno3keta(renNo);
        tjtIdouNySk.setSeiritukbn(pSyoriCTL.getSeiritukbn());
        tjtIdouNySk.setSrsyoriymd(pSyoriCTL.getSrsyoriymd());
        tjtIdouNySk.setMfrenflg(pSyoriCTL.getMfrenflg());
        tjtIdouNySk.setSyono(pSyoriCTL.getSyono());
        tjtIdouNySk.setGyoumuKousinKinou(kinou.getKinouId());
        tjtIdouNySk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        tjtIdouNySk.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        idouSkMeigi.setMosno(pSyoriCTL.getMosno());
        idouSkMeigi.setRenno3keta(renNo);

        idouSkBosyuudr.setMosno(pSyoriCTL.getMosno());
        idouSkBosyuudr.setRenno3keta(renNo);

        mosKihon = pSyoriCTL.getMosKihon();
        if (mosKihon == null) {

            return null;
        }

        tjtIdouNySk.setMosymd(mosKihon.getMosymd());
        tjtIdouNySk.setKykymd(mosKihon.getKykymd());
        tjtIdouNySk.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
        tjtIdouNySk.setKyktuukasyu(mosKihon.getKyktuukasyu());
        tjtIdouNySk.setTsnyounkgns(getTuusanyouNenkingns(pSyoriCTL));
        tjtIdouNySk.setSntkhoukbn(mosKihon.getSntkhoukbn());
        tjtIdouNySk.setBosyuuym(mosKihon.getBosyuuym());

        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

            tjtIdouNySk.setKykhhkndouhyouji(1);
        }
        else {

            tjtIdouNySk.setKykhhkndouhyouji(0);
        }

        tjtIdouNySk.setTsnyousibous(getTuusanyouSibouS(pSyoriCTL));
        tjtIdouNySk.setTsnyouitijip(getTuusanyouItijibaraiP(pSyoriCTL));

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())) {

            tjtIdouNySk.setKaigomaehrtkykumukbn(C_UmuKbn.ARI);
        }
        else {

            tjtIdouNySk.setKaigomaehrtkykumukbn(C_UmuKbn.NONE);
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {

            tjtIdouNySk.setPyennykntkykumukbn(C_UmuKbn.ARI);
        }
        else {

            tjtIdouNySk.setPyennykntkykumukbn(C_UmuKbn.NONE);
        }

        tjtIdouNySk.setTsnyennyknkgk(getTsnyouYenNyknkGk(pSyoriCTL));

        tjtIdouNySk.setHrkkeiro(mosKihon.getHrkkeiro());

        idouSkMeigi.setHhknnmkn(mosKihon.getHhknnmkn());

        if (!C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getHhknnmkjkhukakbn())) {
            idouSkMeigi.setHhknnmkj(mosKihon.getHhknnmkj());
        }
        else {
            idouSkMeigi.setHhknnmkj("");
        }

        idouSkMeigi.setHhknseiymd(mosKihon.getHhknseiymd());
        idouSkMeigi.setHhknsei(mosKihon.getHhknsei());
        idouSkMeigi.setHhknyno(mosKihon.getHhknyno());
        idouSkMeigi.setHhknadr1kj(mosKihon.getHhknadr1kj());
        idouSkMeigi.setHhknadr2kj(mosKihon.getHhknadr2kj());
        idouSkMeigi.setHhknadr3kj(mosKihon.getHhknadr3kj());
        idouSkMeigi.setHhkntelno(mosKihon.getHhkntelno());
        idouSkMeigi.setHhknsykgycd(mosKihon.getHhknsykgycd());
        idouSkMeigi.setKyknmkn(mosKihon.getKyknmkn());

        if (!C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getKyknmkjkhukakbn())) {
            idouSkMeigi.setKyknmkj(mosKihon.getKyknmkj());
        }
        else {
            idouSkMeigi.setKyknmkj("");
        }

        idouSkMeigi.setKykseiymd(mosKihon.getKykseiymd());
        idouSkMeigi.setTsinyno(mosKihon.getTsinyno());
        idouSkMeigi.setTsinadr1kj(mosKihon.getTsinadr1kj());
        idouSkMeigi.setTsinadr2kj(mosKihon.getTsinadr2kj());
        idouSkMeigi.setTsinadr3kj(mosKihon.getTsinadr3kj());
        idouSkMeigi.setTsintelno(mosKihon.getTsintelno());

        mosSyouhnLst = pSyoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.size() != 0) {

            tjtIdouNySk.setSyouhncd(mosSyouhnLst.get(0).getSyouhncd());
            tjtIdouNySk.setSyouhnsdno(mosSyouhnLst.get(0).getSyouhnsdno());
            tjtIdouNySk.setHrkkkn(mosSyouhnLst.get(0).getHrkkkn());
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);
        if (uketorinin != null) {

            idouSkMeigi.setSbuktnmkn1(uketorinin.getUktnmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                idouSkMeigi.setSbuktnmkj1(uketorinin.getUktnmkj());
            }
            else {
                idouSkMeigi.setSbuktnmkj1("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 2);
        if (uketorinin != null) {

            idouSkMeigi.setSbuktnmkn2(uketorinin.getUktnmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                idouSkMeigi.setSbuktnmkj2(uketorinin.getUktnmkj());
            }
            else {
                idouSkMeigi.setSbuktnmkj2("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 3);
        if (uketorinin != null) {

            idouSkMeigi.setSbuktnmkn3(uketorinin.getUktnmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                idouSkMeigi.setSbuktnmkj3(uketorinin.getUktnmkj());
            }
            else {
                idouSkMeigi.setSbuktnmkj3("");
            }

        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 4);
        if (uketorinin != null) {

            idouSkMeigi.setSbuktnmkn4(uketorinin.getUktnmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                idouSkMeigi.setSbuktnmkj4(uketorinin.getUktnmkj());
            }
            else {
                idouSkMeigi.setSbuktnmkj4("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        if (uketorinin != null) {

            idouSkMeigi.setStdrsknmkn(uketorinin.getUktnmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                idouSkMeigi.setStdrsknmkj(uketorinin.getUktnmkj());
            }
            else {
                idouSkMeigi.setStdrsknmkj("");
            }
        }

        BzGetTuukeiBunwari bzGetTuukeiBunwari = getTuukeiBunwari(pSyoriCTL);

        mosDairiten = pSyoriCTL.getMosDairitenByRenno(1);
        if (mosDairiten != null) {

            idouSkBosyuudr.setDairitencd1(bzGetTuukeiBunwari.getDrtencd1());
            idouSkBosyuudr.setBunwari1(bzGetTuukeiBunwari.getBuntanWariai1());
            if (!BizUtil.isBlank(idouSkBosyuudr.getDairitencd1())){
                idouSkBosyuudr.setKanrisosikicd1(mosDairiten.getDrtenkanrisosikicd());
            }
            else {
                idouSkBosyuudr.setKanrisosikicd1("");
            }
        }

        mosDairiten = pSyoriCTL.getMosDairitenByRenno(2);
        if (mosDairiten != null) {

            idouSkBosyuudr.setDairitencd2(bzGetTuukeiBunwari.getDrtencd2());
            idouSkBosyuudr.setBunwari2(bzGetTuukeiBunwari.getBuntanWariai2());
            if (!BizUtil.isBlank(idouSkBosyuudr.getDairitencd2())){
                idouSkBosyuudr.setKanrisosikicd2(mosDairiten.getDrtenkanrisosikicd());
            }
            else {
                idouSkBosyuudr.setKanrisosikicd2("");
            }
        }

        List<HT_MosTrkKzk> mosTrkKzkList = pSyoriCTL.getMosTrkKzks();

        for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                mosTrkKzk1 = mosTrkKzk;
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                mosTrkKzk2 = mosTrkKzk;
            }
        }

        if (mosTrkKzk1 != null) {

            idouSkMeigi.setKzktourokunmkn1(mosTrkKzk1.getTrkkzknmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk1.getTrkkzknmkjkhukakbn())) {

                idouSkMeigi.setKzktourokunmkj1(mosTrkKzk1.getTrkkzknmkj());
            }
            else {
                idouSkMeigi.setKzktourokunmkj1("");
            }
        }

        if (mosTrkKzk2 != null) {

            idouSkMeigi.setKzktourokunmkn2(mosTrkKzk2.getTrkkzknmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk2.getTrkkzknmkjkhukakbn())) {

                idouSkMeigi.setKzktourokunmkj2(mosTrkKzk2.getTrkkzknmkj());
            }
            else {
                idouSkMeigi.setKzktourokunmkj2("");
            }
        }

        List<HT_DakuhiKettei> dakuhiKetteiLst = pSyoriCTL.getDakuhiKetteis();
        if (dakuhiKetteiLst != null && dakuhiKetteiLst.size() > 0) {

            if (dakuhiKetteiLst.size() > 1) {
                dakuhiKetteiLst = sortHT_DakuhiKettei.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);
            }
            mossyoumetuKbn = C_MossyoumetuKbn.valueOf(palRenkeiKoumoku.editMosSyoumetuKbn(pSyoriCTL.getSeiritukbn(),
                dakuhiKetteiLst.get(0).getKetkekkacd()));
        }

        tjtIdouNySk.setMossyoumetukbn(mossyoumetuKbn);

        if (mosSyouhnLst.size() != 0) {
            C_Tuukasyu tsnyTuukasyu = getTsnyouTuukasyu(mosSyouhnLst.get(0).getSyouhncd(), mosKihon);

            tjtIdouNySk.setTsntuukasyu(tsnyTuukasyu);
        }

        if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro()) && C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
            HT_KouzaJyouhou kouzaJyouhou = pSyoriCTL.getKouzaJyouhou();

            if (kouzaJyouhou != null) {
                idouSkMeigi.setBankcd(kouzaJyouhou.getBankcd());
                idouSkMeigi.setSitencd(kouzaJyouhou.getSitencd());
                idouSkMeigi.setYokinkbn(kouzaJyouhou.getYokinkbn());
                idouSkMeigi.setKouzano(kouzaJyouhou.getKouzano());
                String kzmeigiNmKn = "";
                if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {
                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                        kzmeigiNmKn = mosKihon.getHhknnmkn();
                    }
                    else {
                        kzmeigiNmKn = mosKihon.getKyknmkn();
                    }
                }
                else {
                    kzmeigiNmKn = kouzaJyouhou.getKzmeiginmkn();
                }
                idouSkMeigi.setKzmeiginmkn(kzmeigiNmKn);
                idouSkMeigi.setKzkykdoukbn(kouzaJyouhou.getKzkykdoukbn());
            }
        }

        BizPropertyInitializer.initialize(tjtIdouNySk);
        BizPropertyInitializer.initialize(idouSkMeigi);
        BizPropertyInitializer.initialize(idouSkBosyuudr);

        return tjtIdouNySk;

    }

    private int keiyakunaiyouHaneiBeanCreate(HT_SyoriCTL pSyoriCTL, BzKykNaiyouHaneiYokenBean pBzKykNaiyouHaneiYokenBean) {

        HT_MosKihon mosKihon = null;
        List<HT_MosSyouhn> mosSyouhnLst = null;
        HT_Uketorinin uketorinin = null;
        HT_MosTrkKzk mosTrkKzk1 = null;
        HT_MosTrkKzk mosTrkKzk2 = null;
        HT_MosDairiten mosDairiten = null;
        HT_DakuhiKettei dakuhiKettei = null;
        C_MossyoumetuKbn mossyoumetuKbn = C_MossyoumetuKbn.MIKAKUTEI;

        pBzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
        pBzKykNaiyouHaneiYokenBean.setHuho2kykno(pSyoriCTL.getMosno());
        pBzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(0);
        pBzKykNaiyouHaneiYokenBean.setSkseiritukbn(pSyoriCTL.getSeiritukbn());
        pBzKykNaiyouHaneiYokenBean.setSksrsyoriymd(pSyoriCTL.getSrsyoriymd());
        pBzKykNaiyouHaneiYokenBean.setSkmfrenflg(pSyoriCTL.getMfrenflg());
        pBzKykNaiyouHaneiYokenBean.setSksyono(pSyoriCTL.getSyono());

        mosKihon = pSyoriCTL.getMosKihon();

        if (mosKihon == null) {

            return -1;
        }

        pBzKykNaiyouHaneiYokenBean.setSkmosymd(mosKihon.getMosymd());
        pBzKykNaiyouHaneiYokenBean.setSkkykymd(mosKihon.getKykymd());
        pBzKykNaiyouHaneiYokenBean.setSksknnkaisiymd(mosKihon.getSknnkaisiymd());
        pBzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(mosKihon.getKyktuukasyu());
        pBzKykNaiyouHaneiYokenBean.setSktsnnkgns(getTuusanyouNenkingns(pSyoriCTL));
        pBzKykNaiyouHaneiYokenBean.setSksntkhoukbn(mosKihon.getSntkhoukbn());
        pBzKykNaiyouHaneiYokenBean.setSkbosyuuym(mosKihon.getBosyuuym());

        if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

            pBzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(1);
        }
        else {

            pBzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(0);
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getJyudkaigomehrtkhkkbn())) {

            pBzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.ARI);
        }
        else {

            pBzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.NONE);
        }

        if (C_Tkhukaumu.HUKA.eq(mosKihon.getYennykntkhkkbn())) {

            pBzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.ARI);
        }
        else {

            pBzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.NONE);
        }

        pBzKykNaiyouHaneiYokenBean.setHhknnmkn(mosKihon.getHhknnmkn());

        if (!C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getHhknnmkjkhukakbn())) {
            pBzKykNaiyouHaneiYokenBean.setHhknnmkj(mosKihon.getHhknnmkj());
        }
        else {
            pBzKykNaiyouHaneiYokenBean.setHhknnmkj("");
        }

        pBzKykNaiyouHaneiYokenBean.setHhknseiymd(mosKihon.getHhknseiymd());
        pBzKykNaiyouHaneiYokenBean.setHhknsei(mosKihon.getHhknsei());
        pBzKykNaiyouHaneiYokenBean.setHhknyno(mosKihon.getHhknyno());
        pBzKykNaiyouHaneiYokenBean.setHhknadr1kj(mosKihon.getHhknadr1kj());
        pBzKykNaiyouHaneiYokenBean.setHhknadr2kj(mosKihon.getHhknadr2kj());
        pBzKykNaiyouHaneiYokenBean.setHhknadr3kj(mosKihon.getHhknadr3kj());
        pBzKykNaiyouHaneiYokenBean.setHhkntelno(mosKihon.getHhkntelno());
        pBzKykNaiyouHaneiYokenBean.setHhknsykgycd(mosKihon.getHhknsykgycd());
        pBzKykNaiyouHaneiYokenBean.setKyknmkn(mosKihon.getKyknmkn());

        if (!C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getKyknmkjkhukakbn())) {
            pBzKykNaiyouHaneiYokenBean.setKyknmkj(mosKihon.getKyknmkj());
        }
        else {
            pBzKykNaiyouHaneiYokenBean.setKyknmkj("");
        }

        pBzKykNaiyouHaneiYokenBean.setKykseiymd(mosKihon.getKykseiymd());
        pBzKykNaiyouHaneiYokenBean.setTsinyno(mosKihon.getTsinyno());
        pBzKykNaiyouHaneiYokenBean.setTsinadr1kj(mosKihon.getTsinadr1kj());
        pBzKykNaiyouHaneiYokenBean.setTsinadr2kj(mosKihon.getTsinadr2kj());
        pBzKykNaiyouHaneiYokenBean.setTsinadr3kj(mosKihon.getTsinadr3kj());
        pBzKykNaiyouHaneiYokenBean.setTsintelno(mosKihon.getTsintelno());
        pBzKykNaiyouHaneiYokenBean.setSktsnsibous(getTuusanyouSibouS(pSyoriCTL));
        pBzKykNaiyouHaneiYokenBean.setSktsnitijip(getTuusanyouItijibaraiP(pSyoriCTL));

        pBzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(getTsnyouYenNyknkGk(pSyoriCTL));

        pBzKykNaiyouHaneiYokenBean.setSkhrkkeiro(mosKihon.getHrkkeiro());

        mosSyouhnLst = pSyoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (mosSyouhnLst.size() != 0) {

            pBzKykNaiyouHaneiYokenBean.setSksyouhncd(mosSyouhnLst.get(0).getSyouhncd());
            pBzKykNaiyouHaneiYokenBean.setSksyouhnsdno(mosSyouhnLst.get(0).getSyouhnsdno());
            pBzKykNaiyouHaneiYokenBean.setSkhrkkkn(mosSyouhnLst.get(0).getHrkkkn());
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 1);
        if (uketorinin != null) {

            pBzKykNaiyouHaneiYokenBean.setSbuktnmkn1(uketorinin.getUktnmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj1(uketorinin.getUktnmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj1("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 2);
        if (uketorinin != null) {

            pBzKykNaiyouHaneiYokenBean.setSbuktnmkn2(uketorinin.getUktnmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj2(uketorinin.getUktnmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj2("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 3);
        if (uketorinin != null) {

            pBzKykNaiyouHaneiYokenBean.setSbuktnmkn3(uketorinin.getUktnmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj3(uketorinin.getUktnmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj3("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.SBUKT, 4);
        if (uketorinin != null) {

            pBzKykNaiyouHaneiYokenBean.setSbuktnmkn4(uketorinin.getUktnmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj4(uketorinin.getUktnmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setSbuktnmkj4("");
            }
        }

        uketorinin = pSyoriCTL.getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);
        if (uketorinin != null) {

            pBzKykNaiyouHaneiYokenBean.setStdrsknmkn(uketorinin.getUktnmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setStdrsknmkj(uketorinin.getUktnmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setStdrsknmkj("");
            }
        }

        BzGetTuukeiBunwari bzGetTuukeiBunwari = getTuukeiBunwari(pSyoriCTL);

        mosDairiten = pSyoriCTL.getMosDairitenByRenno(1);
        if (mosDairiten != null) {

            pBzKykNaiyouHaneiYokenBean.setDairitencd1(bzGetTuukeiBunwari.getDrtencd1());
            pBzKykNaiyouHaneiYokenBean.setBunwari1(bzGetTuukeiBunwari.getBuntanWariai1());
            if (!BizUtil.isBlank(pBzKykNaiyouHaneiYokenBean.getDairitencd1())) {
                pBzKykNaiyouHaneiYokenBean.setKanrisosikicd1(mosDairiten.getDrtenkanrisosikicd());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setKanrisosikicd1("");
            }
        }

        mosDairiten = pSyoriCTL.getMosDairitenByRenno(2);
        if (mosDairiten != null) {

            pBzKykNaiyouHaneiYokenBean.setDairitencd2(bzGetTuukeiBunwari.getDrtencd2());
            pBzKykNaiyouHaneiYokenBean.setBunwari2(bzGetTuukeiBunwari.getBuntanWariai2());
            if (!BizUtil.isBlank(pBzKykNaiyouHaneiYokenBean.getDairitencd2())) {
                pBzKykNaiyouHaneiYokenBean.setKanrisosikicd2(mosDairiten.getDrtenkanrisosikicd());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setKanrisosikicd2("");
            }

        }

        List<HT_MosTrkKzk> mosTrkKzkList = pSyoriCTL.getMosTrkKzks();

        for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                mosTrkKzk1 = mosTrkKzk;
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                mosTrkKzk2 = mosTrkKzk;
            }
        }

        if (mosTrkKzk1 != null) {
            pBzKykNaiyouHaneiYokenBean.setKzktourokunmkn1(mosTrkKzk1.getTrkkzknmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk1.getTrkkzknmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setKzktourokunmkj1(mosTrkKzk1.getTrkkzknmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("");
            }
        }

        if (mosTrkKzk2 != null) {
            pBzKykNaiyouHaneiYokenBean.setKzktourokunmkn2(mosTrkKzk2.getTrkkzknmkn());
            if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk2.getTrkkzknmkjkhukakbn())) {
                pBzKykNaiyouHaneiYokenBean.setKzktourokunmkj2(mosTrkKzk2.getTrkkzknmkj());
            }
            else {
                pBzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("");
            }
        }

        if (C_SeirituKbn.SEIRITU.eq(pSyoriCTL.getSeiritukbn())) {

            mossyoumetuKbn = C_MossyoumetuKbn.SEIRITU;
        }

        if (C_SeirituKbn.HUSEIRITU.eq(pSyoriCTL.getSeiritukbn())) {

            List<HT_DakuhiKettei> dakuhiKetteiLst = pSyoriCTL.getDakuhiKetteis();

            if (dakuhiKetteiLst != null && dakuhiKetteiLst.size() > 0) {

                SortHT_DakuhiKettei sortHT_DakuhiKettei = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);

                dakuhiKetteiLst = sortHT_DakuhiKettei.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);

                dakuhiKettei = dakuhiKetteiLst.get(0);

                if (C_Ketkekkacd.MIAWASE.eq(dakuhiKettei.getKetkekkacd())) {

                    mossyoumetuKbn = C_MossyoumetuKbn.MIAWASE;
                }

                else if (C_Ketkekkacd.ENKI_SIJINASI.eq(dakuhiKettei.getKetkekkacd())
                    || C_Ketkekkacd.ENKI_SUUNENGOSAISIN.eq(dakuhiKettei.getKetkekkacd())) {

                    mossyoumetuKbn = C_MossyoumetuKbn.ENKI;
                }

                else if (C_Ketkekkacd.MOS_TORIKESI.eq(dakuhiKettei.getKetkekkacd())) {

                    mossyoumetuKbn = C_MossyoumetuKbn.MOSTRKS;
                }

                else if (C_Ketkekkacd.YUUKOUKKNKKA.eq(dakuhiKettei.getKetkekkacd())) {

                    mossyoumetuKbn = C_MossyoumetuKbn.YUUKOUKIKANKEIKA;
                }
            }
        }
        List<HT_DakuhiKettei> dakuhiKetteiLst = pSyoriCTL.getDakuhiKetteis();
        if (dakuhiKetteiLst != null && dakuhiKetteiLst.size() > 0) {

            if (dakuhiKetteiLst.size() > 1) {
                SortHT_DakuhiKettei sortHT_DakuhiKettei = SWAKInjector.getInstance(SortHT_DakuhiKettei.class);
                dakuhiKetteiLst = sortHT_DakuhiKettei.OrderHT_DakuhiKetteiByPkDesc(dakuhiKetteiLst);
            }
            EditPalRenkeiKoumoku palRenkeiKoumoku =  SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
            mossyoumetuKbn = C_MossyoumetuKbn.valueOf(palRenkeiKoumoku.editMosSyoumetuKbn(pSyoriCTL.getSeiritukbn(),
                dakuhiKetteiLst.get(0).getKetkekkacd()));
        }

        pBzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(mossyoumetuKbn);

        if (mosSyouhnLst.size() != 0) {
            C_Tuukasyu tsnyTuukasyu = getTsnyouTuukasyu(mosSyouhnLst.get(0).getSyouhncd(), mosKihon);

            pBzKykNaiyouHaneiYokenBean.setSktsntuukasyu(tsnyTuukasyu);
        }

        if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro()) && C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
            HT_KouzaJyouhou kouzaJyouhou = pSyoriCTL.getKouzaJyouhou();

            if (kouzaJyouhou != null) {
                pBzKykNaiyouHaneiYokenBean.setBankcd(kouzaJyouhou.getBankcd());
                pBzKykNaiyouHaneiYokenBean.setSitencd(kouzaJyouhou.getSitencd());
                pBzKykNaiyouHaneiYokenBean.setYokinkbn(kouzaJyouhou.getYokinkbn());
                pBzKykNaiyouHaneiYokenBean.setKouzano(kouzaJyouhou.getKouzano());
                String kzmeigiNmKn = "";
                if (C_KzkykdouKbn.DOUITU.eq(kouzaJyouhou.getKzkykdoukbn())) {
                    if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {
                        kzmeigiNmKn = mosKihon.getHhknnmkn();
                    }
                    else {
                        kzmeigiNmKn = mosKihon.getKyknmkn();
                    }
                }
                else {
                    kzmeigiNmKn = kouzaJyouhou.getKzmeiginmkn();
                }
                pBzKykNaiyouHaneiYokenBean.setKzmeiginmkn(kzmeigiNmKn);
                pBzKykNaiyouHaneiYokenBean.setKzkykdoukbn(kouzaJyouhou.getKzkykdoukbn());
            }
        }

        return 0;
    }

    private BizCurrency getTuusanyouSibouS(HT_SyoriCTL pSyoriCTL) {

        BM_SyouhnZokusei syouhnZokusei = null;
        List<HT_MosSyouhn> syuMosSyouhnLst = null;
        List<HT_MosSyouhn> tkMosSyouhnLst = null;
        HT_SyoriCTL syoriCTL = pSyoriCTL;
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }

        tkMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn mosSyouhn = syuMosSyouhnLst.get(0);
        syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        C_Tuukasyu tsnyTuukasyu = getTsnyouTuukasyu(syuMosSyouhnLst.get(0).getSyouhncd(), mosKihon);

        BizCurrency tsnyouSibouS = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));

        BizCurrency syuSbS;

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getStsnumu())) {

            syuSbS = syuMosSyouhnLst.get(0).getSeitoukihons();
        }
        else {

            syuSbS = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));
        }

        if (tkMosSyouhnLst != null && tkMosSyouhnLst.size() > 0) {

            BizCurrency tkSbS = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));

            for (HT_MosSyouhn tkMosSyouhn : tkMosSyouhnLst ) {

                HT_MosSyouhn mosSyouhnTK = tkMosSyouhn;
                syouhnZokusei = mosSyouhnTK.getSyouhnZokusei();

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getStsnumu())) {

                    tkSbS = tkSbS.add(tkMosSyouhn.getSeitoukihons());
                }
            }

            tsnyouSibouS = syuSbS.add(tkSbS);
        }

        else {

            tsnyouSibouS = syuSbS;
        }

        return tsnyouSibouS;

    }

    private BizCurrency getTuusanyouItijibaraiP(HT_SyoriCTL pSyoriCTL) {

        BM_SyouhnZokusei syouhnZokusei = null;
        List<HT_MosSyouhn> syuMosSyouhnLst = null;
        List<HT_MosSyouhn> tkMosSyouhnLst = null;
        HT_SyoriCTL syoriCTL = pSyoriCTL;
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }

        tkMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        HT_MosSyouhn mosSyouhn = syuMosSyouhnLst.get(0);
        syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        C_Tuukasyu tsnyTuukasyu = getTsnyouTuukasyu(syuMosSyouhnLst.get(0).getSyouhncd(), mosKihon);

        BizCurrency tsnyouItijiP = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));

        BizCurrency syuItijiP;

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getItijibrptsnumu())) {

            syuItijiP = syuMosSyouhnLst.get(0).getSyutkp();
        }
        else {

            syuItijiP = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));
        }

        if (tkMosSyouhnLst != null && tkMosSyouhnLst.size() > 0) {

            BizCurrency tkItijiP = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));

            for (HT_MosSyouhn tkMosSyouhn : tkMosSyouhnLst ) {

                HT_MosSyouhn mosSyouhnTK = tkMosSyouhn;
                syouhnZokusei = mosSyouhnTK.getSyouhnZokusei();

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getItijibrptsnumu())) {

                    tkItijiP = tkItijiP.add(tkMosSyouhn.getSyutkp());
                }
            }

            tsnyouItijiP = syuItijiP.add(tkItijiP);
        }

        else {

            tsnyouItijiP = syuItijiP;
        }

        return tsnyouItijiP;
    }

    private BizCurrency getTuusanyouNenkingns(HT_SyoriCTL pSyoriCTL) {

        BM_SyouhnZokusei syouhnZokusei = null;
        List<HT_MosSyouhn> syuMosSyouhnLst = null;
        HT_SyoriCTL syoriCTL = pSyoriCTL;
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        BizCurrency tsnyouNkGns;

        syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }

        HT_MosSyouhn mosSyouhn = syuMosSyouhnLst.get(0);
        syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        C_Tuukasyu tsnyTuukasyu = getTsnyouTuukasyu(syuMosSyouhnLst.get(0).getSyouhncd(), mosKihon);

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkgnstuusanumu())) {
            EditNenkinKoumokuUtil editNenkinKoumokuUtil = SWAKInjector.getInstance(EditNenkinKoumokuUtil.class);

            editNenkinKoumokuUtil.getSkNkgnsKijyunGk(syouhnZokusei, mosKihon, mosSyouhn);
            tsnyouNkGns = editNenkinKoumokuUtil.getNkgnsKijyunGk();
        }
        else {

            tsnyouNkGns = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(tsnyTuukasyu));
        }

        return tsnyouNkGns;
    }

    private BizCurrency getTsnyouYenNyknkGk(HT_SyoriCTL pSyoriCTL) {

        BM_SyouhnZokusei syouhnZokusei = null;
        List<HT_MosSyouhn> syuMosSyouhnLst = null;
        HT_SyoriCTL syoriCTL = pSyoriCTL;
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BizCurrency tsnyouYenNyknkGk = BizCurrency.valueOf(0);

        syuMosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (syuMosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }

        HT_MosSyouhn mosSyouhn = syuMosSyouhnLst.get(0);
        syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());

        if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {
            if( C_UmuKbn.ARI.eq(syouhnZokusei.getYenhrkgktuusansiyouumu())){
                tsnyouYenNyknkGk = mosKihon.getFstphrkgk();
            }
        }
        return tsnyouYenNyknkGk;
    }

    private BzGetTuukeiBunwari getTuukeiBunwari(HT_SyoriCTL pSyoriCTL) {

        BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);
        HT_SyoriCTL syoriCTL = pSyoriCTL;
        HT_MosKihon mosKhon = null;
        HT_MosDairiten mosDairiten1 = null;
        HT_MosDairiten mosDairiten2 = null;
        HT_MosSyouhn mosSyouhn = null;
        BM_SyouhnZokusei syouhnZokusei = null;

        mosKhon = syoriCTL.getMosKihon();

        mosDairiten1= syoriCTL.getMosDairitenByRenno(1);
        mosDairiten2= syoriCTL.getMosDairitenByRenno(2);

        List<HT_MosSyouhn> mosSyouhnList = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnList.size() != 1) {
            throw new CommonBizAppException("主契約申込商品件数異常 申込番号：" + syoriCTL.getMosno());
        }

        mosSyouhn = mosSyouhnList.get(0);

        syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhn.getSyouhncd(), mosSyouhn.getSyouhnsdno());


        String dairitenCd1 = "";
        String oyaDairitenCd1 = "";
        BizNumber bunwari1 = null;

        String dairitenCd2 = "";
        String oyaDairitenCd2 = "";
        BizNumber bunwari2 = null;

        BizDateYM kijyunYm = null;
        C_DrtSyouhinSikibetuKbn drtSyouhinSikibetuKbn = null;
        C_Hrkkaisuu hrkkaisuu = null;
        C_DiritenplannmKbn diritenplannmKbn = null;

        if (mosKhon != null) {
            hrkkaisuu = mosKhon.getHrkkaisuu();
        }

        if (mosDairiten1 != null) {

            dairitenCd1 = mosDairiten1.getTratkiagcd();
            oyaDairitenCd1 = mosDairiten1.getOyadrtencd();
            bunwari1 = mosDairiten1.getBunwari();
        }

        if (mosDairiten2 != null) {

            dairitenCd2 = mosDairiten2.getTratkiagcd();
            oyaDairitenCd2 = mosDairiten2.getOyadrtencd();
            bunwari2 = mosDairiten2.getBunwari();
        }

        if (syouhnZokusei != null) {
            drtSyouhinSikibetuKbn = syouhnZokusei.getDrtsyouhinsikibetukbn();
        }

        if (C_KinouKbn.BATCH.eq(kinou.getKinouKbn()) || C_KinouKbn.ONLINEBATCH.eq(kinou.getKinouKbn())){
            BzBatchParam bzBatchParam = SWAKInjector.getInstance(BzBatchParam.class);
            kijyunYm = bzBatchParam.getSyoriYmd().getBizDateYM();
        }
        else {
            kijyunYm = BizDate.getSysDate().getBizDateYM();
        }

        diritenplannmKbn = C_DiritenplannmKbn.BLNK;

        bzGetTuukeiBunwari.exec(dairitenCd1, oyaDairitenCd1, bunwari1, dairitenCd2, oyaDairitenCd2, bunwari2,
            kijyunYm, drtSyouhinSikibetuKbn, hrkkaisuu, diritenplannmKbn);

        return bzGetTuukeiBunwari;
    }

    private C_Tuukasyu getTsnyouTuukasyu(String pSyouhnCd, HT_MosKihon pMosKihon) {

        C_Tuukasyu tsnyTuukasyu = pMosKihon.getKyktuukasyu();

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnCd);
        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn){
            tsnyTuukasyu = pMosKihon.getHrktuukasyu();
        }

        return tsnyTuukasyu;
    }

}
