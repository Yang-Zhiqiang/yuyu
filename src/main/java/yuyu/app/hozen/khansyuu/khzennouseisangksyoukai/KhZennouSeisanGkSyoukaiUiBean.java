package yuyu.app.hozen.khansyuu.khzennouseisangksyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoExecUiBeanParam;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 前納精算額照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhZennouSeisanGkSyoukaiUiBean extends GenKhZennouSeisanGkSyoukaiUiBean implements
CheckYuukouJyoutaiExecUiBeanParam,SetHaraikomiInfoExecUiBeanParam, ViewHaraikomiInfoUiBeanParam {

    private static final long serialVersionUID = 1L;

    public KhZennouSeisanGkSyoukaiUiBean() {
    }

    private C_UmuKbn nextkosumu;

    private C_UmuKbn yennykntkhkumu;

    private  boolean haraimanflag;

    private C_Tuukasyu calcTuukasyu;

    @Override
    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu) {
        nextkosumu = pNextkosumu;
    }

    @Override
    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    @Override
    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        yennykntkhkumu = pYennykntkhkumu;
    }

    public boolean getHaraimanflag() {
        return haraimanflag;
    }

    public void setHaraimanflag(boolean pHaraimanflag) {
        haraimanflag = pHaraimanflag;
    }

    public C_Tuukasyu getCalcTuukasyu() {
        return calcTuukasyu;
    }

    public void setCalcTuukasyu(C_Tuukasyu pCalcTuukasyu) {
        this.calcTuukasyu = pCalcTuukasyu;
    }
}
