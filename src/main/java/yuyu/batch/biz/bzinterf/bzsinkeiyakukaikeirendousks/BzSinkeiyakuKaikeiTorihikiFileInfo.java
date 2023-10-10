package yuyu.batch.biz.bzinterf.bzsinkeiyakukaikeirendousks;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;

/**
 * 業務共通 インターフェイス 新契約会計取引ファイル情報クラス
 */
public class BzSinkeiyakuKaikeiTorihikiFileInfo {

    private C_KeirisysKbn keiriSysKbn;

    private String torihikiNo;

    private String huriDenateSakiCd;

    private BizDate denYmd;

    private List<BzSinkeiyakuSiwakeKoumokuInfo> bzSinkeiyakuSiwakeKoumokuInfoList;

    public BzSinkeiyakuKaikeiTorihikiFileInfo() {
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

    public BizDate getDenymd() {
        return denYmd;
    }

    public void setDenymd(BizDate pDenymd) {
        denYmd = pDenymd;
    }

    public List<BzSinkeiyakuSiwakeKoumokuInfo> getBzSinkeiyakuSiwakeKoumokuInfoList() {
        return bzSinkeiyakuSiwakeKoumokuInfoList;
    }

    public void setBzSinkeiyakuSiwakeKoumokuInfoList(List<BzSinkeiyakuSiwakeKoumokuInfo> pBzSinkeiyakuSiwakeKoumokuInfoList) {
        bzSinkeiyakuSiwakeKoumokuInfoList = pBzSinkeiyakuSiwakeKoumokuInfoList;
    }

    public void siwakeMeisaiAdd(BT_SinkeiyakuHurikaeDen pSinkeiyakuHurikaeDen) {

        for (BzSinkeiyakuSiwakeKoumokuInfo bzSinkeiyakuSiwakeKoumokuInfo : bzSinkeiyakuSiwakeKoumokuInfoList) {

            if (bzSinkeiyakuSiwakeKoumokuInfo.getTaisyakukbn().eq(pSinkeiyakuHurikaeDen.getTaisyakukbn()) &&
                bzSinkeiyakuSiwakeKoumokuInfo.getDenkanjokamokucd()
                .equals(pSinkeiyakuHurikaeDen.getKanjyouKamoku().getDenkanjokamokucd()) &&
                bzSinkeiyakuSiwakeKoumokuInfo.getNaibukeiyakukbn().eq(pSinkeiyakuHurikaeDen.getNaibukeiyakukbn()) &&
                bzSinkeiyakuSiwakeKoumokuInfo.getTekiyoukbn().eq(pSinkeiyakuHurikaeDen.getTekiyoukbn())){

                bzSinkeiyakuSiwakeKoumokuInfo.setDenyenkagk(bzSinkeiyakuSiwakeKoumokuInfo.getDenyenkagk().add(
                    pSinkeiyakuHurikaeDen.getDenyenkagk()));

                return;
            }
        }

        BzSinkeiyakuSiwakeKoumokuInfo bzSinkeiyakuSiwakeKoumokuInfo = SWAKInjector.getInstance(
            BzSinkeiyakuSiwakeKoumokuInfo.class);

        bzSinkeiyakuSiwakeKoumokuInfo.setTaisyakukbn(pSinkeiyakuHurikaeDen.getTaisyakukbn());
        bzSinkeiyakuSiwakeKoumokuInfo.setDenkanjokamokucd(pSinkeiyakuHurikaeDen.getDenkanjokamokucd());
        bzSinkeiyakuSiwakeKoumokuInfo.setNaibukeiyakukbn(pSinkeiyakuHurikaeDen.getNaibukeiyakukbn());
        bzSinkeiyakuSiwakeKoumokuInfo.setTekiyoukbn(pSinkeiyakuHurikaeDen.getTekiyoukbn());
        bzSinkeiyakuSiwakeKoumokuInfo.setTekiyoucd(pSinkeiyakuHurikaeDen.getTekiyoucd());
        bzSinkeiyakuSiwakeKoumokuInfo.setDenyenkagk(pSinkeiyakuHurikaeDen.getDenyenkagk());
        bzSinkeiyakuSiwakeKoumokuInfo.setSuitoubumonCd(pSinkeiyakuHurikaeDen.getSuitoubumoncd());

        bzSinkeiyakuSiwakeKoumokuInfoList.add(bzSinkeiyakuSiwakeKoumokuInfo);
    }
}
