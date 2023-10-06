package yuyu.batch.biz.bzinterf.bzkaikeirendousks;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BT_HuriDenpyou;

/**
 * 業務共通 インターフェイス 会計取引ファイル情報クラス
 */
public class BzKaikeiTorihikiFileInfo {

    private C_KeirisysKbn keiriSysKbn;

    private String torihikiNo;

    private String huriDenateSakiCd;

    private C_TantouCdKbn tantoCd;

    private BizDate denYmd;

    private C_HuridensksKbn huriDenSksKbn;

    private List<BzSiwakeKoumokuInfo> bzSiwakeKoumokuInfoList;

    public BzKaikeiTorihikiFileInfo() {
        super();
    }

    public C_KeirisysKbn getKeirisyskbn() {
        return keiriSysKbn;
    }

    public void setKeirisyskbn(C_KeirisysKbn pKeirisyskbn) {
        keiriSysKbn = pKeirisyskbn;
    }

    public String getTorihikino() {
        return torihikiNo;
    }

    public void setTorihikino(String pTorihikino) {
        torihikiNo = pTorihikino;
    }

    public String getHuridenatesakicd() {
        return huriDenateSakiCd;
    }

    public void setHuridenatesakicd(String pHuridenatesakicd) {
        huriDenateSakiCd = pHuridenatesakicd;
    }

    public C_TantouCdKbn getTantocd() {
        return tantoCd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantoCd = pTantocd;
    }

    public BizDate getDenymd() {
        return denYmd;
    }

    public void setDenymd(BizDate pDenymd) {
        denYmd = pDenymd;
    }

    public C_HuridensksKbn getHuridenskskbn() {
        return huriDenSksKbn;
    }

    public void setHuridenskskbn(C_HuridensksKbn pHuridenskskbn) {
        huriDenSksKbn = pHuridenskskbn;
    }

    public List<BzSiwakeKoumokuInfo> getBzSiwakeKoumokuInfoList() {
        return bzSiwakeKoumokuInfoList;
    }

    public void setBzSiwakeKoumokuInfoList(List<BzSiwakeKoumokuInfo> pBzSiwakeKoumokuInfoList) {
        bzSiwakeKoumokuInfoList = pBzSiwakeKoumokuInfoList;
    }

    public void siwakeMeisaiAdd(BT_HuriDenpyou pHuriDenpyou) {

        for (BzSiwakeKoumokuInfo bzSiwakeKoumokuInfo : bzSiwakeKoumokuInfoList) {

            if (bzSiwakeKoumokuInfo.getTaisyakukbn().eq(pHuriDenpyou.getTaisyakukbn()) &&
                bzSiwakeKoumokuInfo.getDenkanjokamokucd().equals(
                    pHuriDenpyou.getKanjyouKamoku().getDenkanjokamokucd()) &&
                    bzSiwakeKoumokuInfo.getJigyouhiutiwakecd().equals(pHuriDenpyou.getJigyouhiutiwakecd())) {

                bzSiwakeKoumokuInfo.setDenyenkagk(bzSiwakeKoumokuInfo.getDenyenkagk().add(
                    pHuriDenpyou.getDenyenkagk()));

                return;
            }
        }

        BzSiwakeKoumokuInfo bzSiwakeKoumokuInfo = SWAKInjector.getInstance(BzSiwakeKoumokuInfo.class);

        bzSiwakeKoumokuInfo.setTaisyakukbn(pHuriDenpyou.getTaisyakukbn());
        bzSiwakeKoumokuInfo.setDenkanjokamokucd(pHuriDenpyou.getDenkanjokamokucd());
        bzSiwakeKoumokuInfo.setJigyouhiutiwakecd(pHuriDenpyou.getJigyouhiutiwakecd());
        bzSiwakeKoumokuInfo.setSuitoubumoncd(pHuriDenpyou.getSuitoubumoncd());
        bzSiwakeKoumokuInfo.setTekiyoucd(pHuriDenpyou.getTekiyoucd());
        bzSiwakeKoumokuInfo.setDenyenkagk(pHuriDenpyou.getDenyenkagk());

        bzSiwakeKoumokuInfoList.add(bzSiwakeKoumokuInfo);
    }
}
