package yuyu.def.dsweb.bean.webservice;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;

/**
 * （ＤＳＷｅｂ）電話解約受付入力BEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class WsDwDenwaKaiyakuUketukeInputBean extends GenWsDwDenwaKaiyakuUketukeInputBean {

    private static final long serialVersionUID = 1L;

    public WsDwDenwaKaiyakuUketukeInputBean() {
    }

    public boolean chkHissuMInput() {

        if (BizUtil.isBlank(getIwsGyoumucd())) {
            return false;
        }

        if (BizUtil.isBlank(getIwsSyorinaiyou())) {
            return false;
        }

        return true;
    }

    public boolean chkHissuInput() {

        if (BizUtil.isBlank(getIwsTtdkskbt())) {
            return false;
        }

        if (C_DsSyoriNaiyouKbn.SYONOINPUT.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou())) ||
            C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou())) ||
            C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou())) ||
            C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou()))) {

            if (BizUtil.isBlank(getIwsSyono())) {
                return false;
            }
        }

        if (C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou())) ||
            C_DsSyoriNaiyouKbn.KAIYAKUINFOSYUTOKU.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou())) ||
            C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou()))) {

            if (BizUtil.isBlank(getIwsDskokno())) {
                return false;
            }
        }

        if (C_DsSyoriNaiyouKbn.TOKUTEIANSYONOINPUT.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou()))) {

            if (BizUtil.isBlank(getIwsTokuteitrhkansyono())) {
                return false;
            }
        }

        if (C_DsSyoriNaiyouKbn.KAIYAKUSAISYUUKAKUNIN.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou()))) {

            if (BizUtil.isBlank(getIwsTtdkis())) {
                return false;
            }

            if (BizUtil.isBlank(getIwsKouzaVersion())) {
                return false;
            }
        }

        if (C_DsSyoriNaiyouKbn.SYUURYOUSYORI.eq(C_DsSyoriNaiyouKbn.valueOf(getIwsSyorinaiyou()))) {

            if (BizUtil.isBlank(getIwsTyakusintime())) {
                return false;
            }

            if (BizUtil.isBlank(getIwsCallid())) {
                return false;
            }

            if (BizUtil.isBlank(getIwsSyorikekka())) {
                return false;
            }

            if (BizUtil.isBlank(getIwsStdnkasyo())) {
                return false;
            }

            if (BizUtil.isBlank(getIwsStdnriyuu())) {
                return false;
            }

            if (BizUtil.isBlank(getIwsTuuwatime())) {
                return false;
            }
        }
        return true;
    }
}
