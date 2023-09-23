package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;

/**
 * 契約保全 契約保全共通 特条保険金削減内容計算
 */
public class TokujoSSakugenNaiyouKeisan {

    private String syouhnCd;

    private int syouhnSdNo;

    private BizDate kykBi;

    private BizDate sknnKaisiBi;

    private C_Tkjyskgnkkn tkjSkgnKkn;

    private BizCurrency hknGk;

    private SsakugenBean[] sSakugenBeans;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SetOutoubi setOutoubi;

    public TokujoSSakugenNaiyouKeisan() {
        super();
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    public void setSyouhnSdno(int pSyouhnSdno) {
        syouhnSdNo = pSyouhnSdno;
    }

    public void setKykbi(BizDate pKykbi) {
        kykBi = pKykbi;
    }

    public void setSknnKaisibi(BizDate pSknnKaisibi) {
        sknnKaisiBi = pSknnKaisibi;
    }

    public void setTkjSkgnKkn(C_Tkjyskgnkkn pTkjSkgnKkn) {
        tkjSkgnKkn = pTkjSkgnKkn;
    }

    public void setS(BizCurrency pdHkngk) {
        hknGk = pdHkngk;
    }

    public SsakugenBean[] getSsakugenBeans() {
        return sSakugenBeans;
    }

    public C_ErrorKbn exec() {

        sSakugenBeans = new SsakugenBean[0];

        BM_TokujyouSakugenRate tokuJyouSakugenRate =null;
        if (tokuJyouSakugenRate == null) {
            return C_ErrorKbn.OK;
        }

        List<BizNumber> hknNNdSkgnSRatesLst = new ArrayList<>();

        hknNNdSkgnSRatesLst.add(tokuJyouSakugenRate.getDai1hknnndskgnsrate());
        hknNNdSkgnSRatesLst.add(tokuJyouSakugenRate.getDai2hknnndskgnsrate());
        hknNNdSkgnSRatesLst.add(tokuJyouSakugenRate.getDai3hknnndskgnsrate());
        hknNNdSkgnSRatesLst.add(tokuJyouSakugenRate.getDai4hknnndskgnsrate());
        hknNNdSkgnSRatesLst.add(tokuJyouSakugenRate.getDai5hknnndskgnsrate());

        int hknNendo = 1;
        BizDate startNendoYmd = sknnKaisiBi;
        BizDate kykbi = kykBi;
        BizDate nenTanniOutouBi = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO, kykbi, C_Hrkkaisuu.NEN, kykbi);
        BizDate endNendoYmd = nenTanniOutouBi;
        endNendoYmd = endNendoYmd.getPreviousDay();

        SsakugenBean[] ssakugenBeans = new SsakugenBean[Integer.parseInt(tkjSkgnKkn.getValue())];
        for (int cnt = 1; cnt <= Integer.parseInt(tkjSkgnKkn.getValue()); cnt++) {
            BizNumber skgnRitu = hknNNdSkgnSRatesLst.get(cnt - 1);
            BizCurrency hkngk = hknGk.multiply(skgnRitu);

            SsakugenBean ssakugenBean = new SsakugenBean();
            ssakugenBean.setHknNendo(hknNendo);
            ssakugenBean.setStartNendoYmd(startNendoYmd);
            ssakugenBean.setEndNendoYmd(endNendoYmd);
            ssakugenBean.setSkgnRitu(skgnRitu);
            ssakugenBean.setS(hkngk);
            ssakugenBeans[cnt - 1] = ssakugenBean;

            hknNendo++;
            startNendoYmd = nenTanniOutouBi;

            nenTanniOutouBi = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO, kykbi, C_Hrkkaisuu.NEN, nenTanniOutouBi);

            endNendoYmd = nenTanniOutouBi;
            endNendoYmd = endNendoYmd.getPreviousDay();
        }
        sSakugenBeans = ssakugenBeans;

        return C_ErrorKbn.OK;
    }

}
