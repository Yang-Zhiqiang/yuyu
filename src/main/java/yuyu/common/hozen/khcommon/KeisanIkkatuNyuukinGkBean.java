package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約保全 契約保全共通 一括入金額計算用Bean
 */
public class KeisanIkkatuNyuukinGkBean {

    private List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst;

    private Integer jyuutoutuKisuu;

    private C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn;

    private C_Tuukasyu rstuukasyu;

    private BizDate syokaiprsYmd;

    private BizDateYM jyutoustartYm;

    private C_NyknaiyouKbn nyknaiyouKbn;

    private C_Nykkeiro nykkeiro;

    public List<KeisanIkkatuNyuukinGkSyouhnBean> getKeisanIkkatuNyuukinGkSyouhnBeanLst() {
        return keisanIkkatuNyuukinGkSyouhnBeanLst;
    }

    public void setKeisanIkkatuNyuukinGkSyouhnBeanLst(
        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanLst) {
        this.keisanIkkatuNyuukinGkSyouhnBeanLst = pKeisanIkkatuNyuukinGkSyouhnBeanLst;
    }

    public Integer getJyuutoutuKisuu() {
        return jyuutoutuKisuu;
    }

    public void setJyuutoutuKisuu(Integer pJyuutoutuKisuu) {
        this.jyuutoutuKisuu = pJyuutoutuKisuu;
    }

    public C_TkiktbrisyuruiKbn getTkiktbrisyuruiKbn() {
        return tkiktbrisyuruiKbn;
    }

    public void setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn) {
        this.tkiktbrisyuruiKbn = pTkiktbrisyuruiKbn;
    }

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        this.rstuukasyu = pRstuukasyu;
    }

    public BizDate getSyokaiprsYmd() {
        return syokaiprsYmd;
    }

    public void setSyokaiprsYmd(BizDate pSyokaiprsYmd) {
        this.syokaiprsYmd = pSyokaiprsYmd;
    }

    public BizDateYM getJyutoustartYm() {
        return jyutoustartYm;
    }

    public void setJyutoustartYm(BizDateYM pJyutoustartYm) {
        this.jyutoustartYm = pJyutoustartYm;
    }

    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyouKbn;
    }

    public void setNyknaiyouKbn(C_NyknaiyouKbn pNyknaiyouKbn) {
        this.nyknaiyouKbn = pNyknaiyouKbn;
    }

    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        this.nykkeiro = pNykkeiro;
    }
}
