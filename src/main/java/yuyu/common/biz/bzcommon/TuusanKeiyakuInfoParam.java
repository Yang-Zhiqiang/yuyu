package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SkeikikeiyakuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 共通 通算用契約情報パラメータ
 */
public class TuusanKeiyakuInfoParam {

    private C_SkeikikeiyakuKbn skeiKikeiyakuKbn;
    private C_SntkhouKbn sntkhouKbn;
    private BizDate kijyunYmd;
    private BizDate kykYmd;
    private int hhknNen;
    private C_Hrkkaisuu hrkKaisuu;
    private BizCurrency kihonS;
    private BizCurrency tkhKihonS;
    private BizCurrency itijibrp;
    private BizCurrency jituHsgk;
    private BizCurrency nkgnsgk;
    private C_UmuKbn syuusinhknUmu;
    private C_UmuKbn stsnUmu;
    private C_UmuKbn nkgnsTuusanUmu;
    private C_UmuKbn nenbtSouSbusTuusanUmu;
    private C_UmuKbn souKktJituHsgkTuusanUmu;
    private C_UmuKbn msnyNenbtSbusTuusanUmu;
    private C_UmuKbn kktJituHsgk1TuusanUmu;
    private C_UmuKbn kktJituHsgk2TuusanUmu;
    private C_UmuKbn kykDrtenTuusanUmuKbn;
    private C_UmuKbn itijibrpTsnUmu;
    private C_TkthknsyruitsnKbn tktHknsyruiTsnKbn;

    public TuusanKeiyakuInfoParam() {
        super();
    }

    public C_SkeikikeiyakuKbn getSkeiKikeiyakuKbn() {
        return skeiKikeiyakuKbn;
    }

    public void setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn pSkeiKikeiyakuKbn) {
        skeiKikeiyakuKbn = pSkeiKikeiyakuKbn;
    }

    public C_SntkhouKbn getSntkhouKbn() {
        return sntkhouKbn;
    }

    public void setSntkhouKbn(C_SntkhouKbn pSntkhouKbn) {
        sntkhouKbn = pSntkhouKbn;
    }

    public BizDate getKijyunYmd() {
        return kijyunYmd;
    }

    public void setKijyunYmd(BizDate pKijyunYmd) {
        kijyunYmd = pKijyunYmd;
    }

    public BizDate getKykYmd() {
        return kykYmd;
    }

    public void setKykYmd(BizDate pKykYmd) {
        kykYmd = pKykYmd;
    }

    public int getHhknNen() {
        return hhknNen;
    }

    public void setHhknNen(int pHhknNen) {
        hhknNen = pHhknNen;
    }

    public C_Hrkkaisuu getHrkKaisuu() {
        return hrkKaisuu;
    }

    public void setHrkKaisuu(C_Hrkkaisuu pHrkKaisuu) {
        hrkKaisuu = pHrkKaisuu;
    }

    public BizCurrency getKihonS() {
        return kihonS;
    }

    public void setKihonS(BizCurrency pKihonS) {
        kihonS = pKihonS;
    }

    public BizCurrency getTkhKihonS() {
        return tkhKihonS;
    }

    public void setTkhKihonS(BizCurrency pTkhKihonS) {
        tkhKihonS = pTkhKihonS;
    }

    public BizCurrency getItijibrp() {
        return itijibrp;
    }

    public void setItijibrp(BizCurrency pItijibrp) {
        itijibrp = pItijibrp;
    }

    public BizCurrency getJituHsgk() {
        return jituHsgk;
    }

    public void setJituHsgk(BizCurrency pJituHsgk) {
        jituHsgk = pJituHsgk;
    }

    public BizCurrency getNkgnsgk() {
        return nkgnsgk;
    }

    public void setNkgnsgk(BizCurrency pNkgnsgk) {
        nkgnsgk = pNkgnsgk;
    }

    public C_UmuKbn getSyuusinhknUmu() {
        return syuusinhknUmu;
    }

    public void setSyuusinhknUmu(C_UmuKbn pSyuusinhknUmu) {
        syuusinhknUmu = pSyuusinhknUmu;
    }

    public C_UmuKbn getStsnUmu() {
        return stsnUmu;
    }

    public void setStsnUmu(C_UmuKbn pStsnUmu) {
        stsnUmu = pStsnUmu;
    }

    public C_UmuKbn getNkgnsTuusanUmu() {
        return nkgnsTuusanUmu;
    }

    public void setNkgnsTuusanUmu(C_UmuKbn pNkgnsTuusanUmu) {
        nkgnsTuusanUmu = pNkgnsTuusanUmu;
    }

    public C_UmuKbn getNenbtSouSbusTuusanUmu() {
        return nenbtSouSbusTuusanUmu;
    }

    public void setNenbtSouSbusTuusanUmu(C_UmuKbn pNenbtSouSbusTuusanUmu) {
        nenbtSouSbusTuusanUmu = pNenbtSouSbusTuusanUmu;
    }

    public C_UmuKbn getSouKktJituHsgkTuusanUmu() {
        return souKktJituHsgkTuusanUmu;
    }

    public void setSouKktJituHsgkTuusanUmu(C_UmuKbn pSouKktJituHsgkTuusanUmu) {
        souKktJituHsgkTuusanUmu = pSouKktJituHsgkTuusanUmu;
    }

    public C_UmuKbn getMsnyNenbtSbusTuusanUmu() {
        return msnyNenbtSbusTuusanUmu;
    }

    public void setMsnyNenbtSbusTuusanUmu(C_UmuKbn pMsnyNenbtSbusTuusanUmu) {
        msnyNenbtSbusTuusanUmu = pMsnyNenbtSbusTuusanUmu;
    }

    public C_UmuKbn getKktJituHsgk1TuusanUmu() {
        return kktJituHsgk1TuusanUmu;
    }

    public void setKktJituHsgk1TuusanUmu(C_UmuKbn pKktJituHsgk1TuusanUmu) {
        kktJituHsgk1TuusanUmu = pKktJituHsgk1TuusanUmu;
    }

    public C_UmuKbn getKktJituHsgk2TuusanUmu() {
        return kktJituHsgk2TuusanUmu;
    }

    public void setKktJituHsgk2TuusanUmu(C_UmuKbn pKktJituHsgk2TuusanUmu) {
        kktJituHsgk2TuusanUmu = pKktJituHsgk2TuusanUmu;
    }

    public C_UmuKbn getKykDrtenTuusanUmuKbn() {
        return kykDrtenTuusanUmuKbn;
    }

    public void setKykDrtenTuusanUmuKbn(C_UmuKbn pKykDrtenTuusanUmuKbn) {
        kykDrtenTuusanUmuKbn = pKykDrtenTuusanUmuKbn;
    }

    public C_UmuKbn getItijibrpTsnUmu() {
        return itijibrpTsnUmu;
    }

    public void setItijibrpTsnUmu(C_UmuKbn pItijibrpTsnUmu) {
        itijibrpTsnUmu = pItijibrpTsnUmu;
    }

    public C_TkthknsyruitsnKbn getTktHknsyruiTsnKbn() {
        return tktHknsyruiTsnKbn;
    }

    public void setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn pTktHknsyruiTsnKbn) {
        tktHknsyruiTsnKbn = pTktHknsyruiTsnKbn;
    }
}
