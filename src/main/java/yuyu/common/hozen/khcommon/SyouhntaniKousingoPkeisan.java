package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 契約保全 契約保全共通 商品単位更新後保険料計算
 */
public class SyouhntaniKousingoPkeisan {

    private String syouhnCd;

    private int syouhnSdNo;

    private BizDate keiyakuBi;

    private C_KataKbn kataKbn;

    private C_KyhgndkataKbn kyhgndKataKbn;

    private C_SyukyhkinkataKbn syukyhkinKataKbn;

    private C_KhnkyhkgbairituKbn khnkyhkgbairituKbn;

    private C_6daiLdKbn daisktsyknTuikakyhKataKbn;

    private C_PmnjtkKbn pmnjtkhukaKbn;

    private C_HknkknsmnKbn hknkknSmnKbn;

    private int hknKkn;

    private C_HrkkknsmnKbn hrkkknSmnKbn;

    private int hrkKkn;

    private int hhknNen;

    private C_Hhknsei hhknSei;

    private C_Hrkkaisuu hrkKaisuu;

    private C_Hrkkeiro hrkKeiro;

    private C_Sdpd sdPdKbn;

    private BizCurrency hosen;

    private KousinBean[] kosnaiyMeisKmks;

    private int kosKaisuu;

    @Inject
    private SetManryoubi setManryoubi;

    @Inject
    private BizDomManager bizDomManager;

    public SyouhntaniKousingoPkeisan() {
        super();
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    public void setSyouhnSdno(int pSyouhnSdno) {
        syouhnSdNo = pSyouhnSdno;
    }

    public void setKeiyakubi(BizDate pKeiyakubi) {
        keiyakuBi = pKeiyakubi;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        kataKbn = pKatakbn;
    }

    public void setKyhgndKatakbn(C_KyhgndkataKbn pKyhgndKatakbn) {
        kyhgndKataKbn = pKyhgndKatakbn;
    }

    public void setSyukyhkinKatakbn(C_SyukyhkinkataKbn pSyukyhkinKatakbn) {
        syukyhkinKataKbn = pSyukyhkinKatakbn;
    }

    public void setKhnkyhkgbairituKbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairituKbn) {
        khnkyhkgbairituKbn = pKhnkyhkgbairituKbn;
    }

    public void set6DaisktsyknTuikakyhKatakbn(C_6daiLdKbn p6DaisktsyknTuikakyhKatakbn) {
        daisktsyknTuikakyhKataKbn = p6DaisktsyknTuikakyhKatakbn;
    }

    public void setPmnjtkhukaKbn(C_PmnjtkKbn pPmnjtkhukaKbn) {
        pmnjtkhukaKbn = pPmnjtkhukaKbn;
    }

    public void setHknkknSmnkbn(C_HknkknsmnKbn pHknkknSmnkbn) {
        hknkknSmnKbn = pHknkknSmnkbn;
    }

    public void setHknkkn(int pHknkkn) {
        hknKkn = pHknkkn;
    }

    public void setHrkkknSmnkbn(C_HrkkknsmnKbn pHrkkknSmnkbn) {
        hrkkknSmnKbn = pHrkkknSmnkbn;
    }

    public void setHrkkkn(int pHrkkkn) {
        hrkKkn = pHrkkkn;
    }

    public void setHhknNen(int pHhknNen) {
        hhknNen = pHhknNen;
    }

    public void setHhknSei(C_Hhknsei pHhknSei) {
        hhknSei = pHhknSei;
    }

    public void setHrkKaisuu(C_Hrkkaisuu pHrkKaisuu) {
        hrkKaisuu = pHrkKaisuu;
    }

    public void setHrkKeiro(C_Hrkkeiro pHrkKeiro) {
        hrkKeiro = pHrkKeiro;
    }

    public void setSdPdKbn(C_Sdpd pSdPdKbn) {
        sdPdKbn = pSdPdKbn;
    }

    public void setS(BizCurrency pS) {
        hosen = pS;
    }

    public KousinBean[] getKosnaiymeiskmk() {
        return kosnaiyMeisKmks;
    }

    public int getKoskaisu() {
        return kosKaisuu;
    }

    public C_ErrorKbn exec() {

        this.kosnaiyMeisKmks = null;
        this.kosKaisuu = 0;

        BM_SyouhnZokusei syouhinZokusei = bizDomManager.getSyouhnZokusei(this.syouhnCd, this.syouhnSdNo);

        if (syouhinZokusei == null) {
            throw new CommonBizAppException("商品属性MSTにデータが存在しません。");
        }

        if (C_UmuKbn.NONE.eq(syouhinZokusei.getKostratkiumu())) {
            return C_ErrorKbn.ERROR;
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(this.hknkknSmnKbn)) {
            return C_ErrorKbn.OK;
        }

        int jkksjHhknNen = this.hhknNen + this.hknKkn;
        int kosmnryNen = syouhinZokusei.getKosmnrynen();
        if (kosmnryNen <= jkksjHhknNen) {
            return C_ErrorKbn.OK;
        }

        boolean kosFlg = false;
        int hkKk = this.hknKkn;
        int kshkKk = this.hknKkn;
        int hrkmKk = this.hrkKkn;
        int kosjiNenl = this.hhknNen;
        BizDate kosBi = this.keiyakuBi;
        int kosKaisu = 0;
        int kosgoManryoNenl = 0;

        List<KousinBean> kousinBeanLst = new ArrayList<>();

        do {
            kosBi = setManryoubi.exec(this.keiyakuBi, this.hhknNen, kshkKk, C_KknsmnKbn.NEN);
            kosjiNenl = kosjiNenl + hkKk;
            kosgoManryoNenl = kosjiNenl + hkKk;

            if (kosmnryNen == kosgoManryoNenl) {
                kosFlg = true;
            }
            else if (kosmnryNen < kosgoManryoNenl) {
                kosFlg = true;
                hkKk = kosmnryNen - kosjiNenl;
                hrkmKk = kosmnryNen - kosjiNenl;
            }

            kshkKk += hkKk;

            List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.
                getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(this.syouhnCd, kosBi);

            if (syouhnZokuseiLst == null || syouhnZokuseiLst.size() == 0) {
                throw new CommonBizAppException("商品属性MSTにデータが存在しません。");
            }

            kosKaisu += 1;

            KousinBean kbCur = new KousinBean();

            kbCur.setKoushinbi(kosBi);
            kbCur.setHknry(BizCurrency.valueOf(0));
            kbCur.setSyouhncd(this.syouhnCd);
            kbCur.setSyouhnSdno(syouhnZokuseiLst.get(0).getSyouhnsdno());
            kbCur.setHknkkn(hkKk);
            kbCur.setHrkkkn(hrkmKk);
            kbCur.setHhknNen(kosjiNenl);

            kousinBeanLst.add(kbCur);

        } while (kosFlg == false);

        this.kosKaisuu = kosKaisu;
        this.kosnaiyMeisKmks = kousinBeanLst.toArray(new KousinBean[kousinBeanLst.size()]);
        return C_ErrorKbn.OK;
    }
}
