package yuyu.common.biz.bznayose;

import java.io.Serializable;
import java.util.List;

import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;

/**
 * 業務共通 名寄せ 別口契約情報取得結果Beanクラス <br>
 * 当機能で必要な任意のオブジェクトを保持するBeanクラス
 */
public class BetukutiKeiyakuInfoResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<BetukutiKeiyakuInfoBean> betukutiKeiyakuInfoBeanLst;

    private C_MQSyorikekkaKbn mqsyorikekkakbn ;

    private C_PalSyoukaiJissiumuKbn palsyoukaijissiumukbn;

    private C_MQSyoukaiErrorKbn sakuininfosyoukaierrkbn;

    private C_BlnktkumuKbn kykensuutyoukaumu;

    private C_BlnktkumuKbn nkkensuutyoukaumu ;

    private C_BlnktkumuKbn kykmfkensuutyoukaumu ;

    private C_BlnktkumuKbn nkfkensuutyoukaumu ;

    private C_BlnktkumuKbn sueokifkensuutyoukaumu;

    public BetukutiKeiyakuInfoResultBean() {
    }

    public List<BetukutiKeiyakuInfoBean> getBetukutiKeiyakuInfoBeanLst() {
        return betukutiKeiyakuInfoBeanLst;
    }

    public void setBetukutiKeiyakuInfoBeanLst(List<BetukutiKeiyakuInfoBean> pBetukutiKeiyakuInfoBeanLst) {
        betukutiKeiyakuInfoBeanLst = pBetukutiKeiyakuInfoBeanLst;
    }

    public C_MQSyorikekkaKbn getMqsyorikekkakbn () {
        return mqsyorikekkakbn ;
    }

    public void setMqsyorikekkakbn (C_MQSyorikekkaKbn pMqsyorikekkakbn ) {
        mqsyorikekkakbn  = pMqsyorikekkakbn ;
    }

    public C_PalSyoukaiJissiumuKbn getPalsyoukaijissiumukbn() {
        return palsyoukaijissiumukbn;
    }

    public void setPalsyoukaijissiumukbn(C_PalSyoukaiJissiumuKbn pPalsyoukaijissiumukbn) {
        palsyoukaijissiumukbn = pPalsyoukaijissiumukbn;
    }

    public C_MQSyoukaiErrorKbn getSakuininfosyoukaierrkbn() {
        return sakuininfosyoukaierrkbn;
    }

    public void setSakuininfosyoukaierrkbn(C_MQSyoukaiErrorKbn pSakuininfosyoukaierrkbn) {
        sakuininfosyoukaierrkbn = pSakuininfosyoukaierrkbn;
    }

    public C_BlnktkumuKbn getKykensuutyoukaumu() {
        return kykensuutyoukaumu;
    }

    public void setKykensuutyoukaumu(C_BlnktkumuKbn pKykensuutyoukaumu) {
        kykensuutyoukaumu = pKykensuutyoukaumu;
    }

    public C_BlnktkumuKbn getNkkensuutyoukaumu () {
        return nkkensuutyoukaumu ;
    }

    public void setNkkensuutyoukaumu (C_BlnktkumuKbn pNkkensuutyoukaumu ) {
        nkkensuutyoukaumu  = pNkkensuutyoukaumu ;
    }

    public C_BlnktkumuKbn getKykmfkensuutyoukaumu () {
        return kykmfkensuutyoukaumu ;
    }

    public void setKykmfkensuutyoukaumu (C_BlnktkumuKbn pKykmfkensuutyoukaumu ) {
        kykmfkensuutyoukaumu  = pKykmfkensuutyoukaumu ;
    }

    public C_BlnktkumuKbn getNkfkensuutyoukaumu () {
        return nkfkensuutyoukaumu ;
    }

    public void setNkfkensuutyoukaumu (C_BlnktkumuKbn pNkfkensuutyoukaumu ) {
        nkfkensuutyoukaumu  = pNkfkensuutyoukaumu ;
    }

    public C_BlnktkumuKbn getSueokifkensuutyoukaumu() {
        return sueokifkensuutyoukaumu;
    }

    public void setSueokifkensuutyoukaumu(C_BlnktkumuKbn pSueokifkensuutyoukaumu) {
        sueokifkensuutyoukaumu = pSueokifkensuutyoukaumu;
    }

}
