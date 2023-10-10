package yuyu.app.hozen.khansyuu.khnyuukintorikesi;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 入金取消 - ●仮受金情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKariukekinInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer vkukkrkno;

    public Integer getVkukkrkno() {
        return vkukkrkno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVkukkrkno(Integer pVkukkrkno) {
        vkukkrkno = pVkukkrkno;
    }


    private BizDate vkukkrkkeijyoymd;

    public BizDate getVkukkrkkeijyoymd() {
        return vkukkrkkeijyoymd;
    }

    @Trim("both")
    public void setVkukkrkkeijyoymd(BizDate pVkukkrkkeijyoymd) {
        vkukkrkkeijyoymd = pVkukkrkkeijyoymd;
    }


    private C_KrkriyuuKbn vkukkrkriyuukbn;

    public C_KrkriyuuKbn getVkukkrkriyuukbn() {
        return vkukkrkriyuukbn;
    }

    public void setVkukkrkriyuukbn(C_KrkriyuuKbn pVkukkrkriyuukbn) {
        vkukkrkriyuukbn = pVkukkrkriyuukbn;
    }


    private C_Hrkkaisuu vkukhrkkaisuu;

    public C_Hrkkaisuu getVkukhrkkaisuu() {
        return vkukhrkkaisuu;
    }

    public void setVkukhrkkaisuu(C_Hrkkaisuu pVkukhrkkaisuu) {
        vkukhrkkaisuu = pVkukhrkkaisuu;
    }


    private C_Nykkeiro vkuknykkeiro;

    public C_Nykkeiro getVkuknykkeiro() {
        return vkuknykkeiro;
    }

    public void setVkuknykkeiro(C_Nykkeiro pVkuknykkeiro) {
        vkuknykkeiro = pVkuknykkeiro;
    }


    private C_NyknaiyouKbn vkuknyknaiyoukbn;

    public C_NyknaiyouKbn getVkuknyknaiyoukbn() {
        return vkuknyknaiyoukbn;
    }

    public void setVkuknyknaiyoukbn(C_NyknaiyouKbn pVkuknyknaiyoukbn) {
        vkuknyknaiyoukbn = pVkuknyknaiyoukbn;
    }


    private BizDateYM vkukjyuutouym;

    public BizDateYM getVkukjyuutouym() {
        return vkukjyuutouym;
    }

    @Trim("both")
    public void setVkukjyuutouym(BizDateYM pVkukjyuutouym) {
        vkukjyuutouym = pVkukjyuutouym;
    }


    private String vkukjyutoukaisuu;

    public String getVkukjyutoukaisuu() {
        return vkukjyutoukaisuu;
    }

    @DataConvert("toMultiByte")
    public void setVkukjyutoukaisuu(String pVkukjyutoukaisuu) {
        vkukjyutoukaisuu = pVkukjyutoukaisuu;
    }


    private BizDate vkukryosyuymd;

    public BizDate getVkukryosyuymd() {
        return vkukryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVkukryosyuymd(BizDate pVkukryosyuymd) {
        vkukryosyuymd = pVkukryosyuymd;
    }


    private BizCurrency vkukkrkgk;

    public BizCurrency getVkukkrkgk() {
        return vkukkrkgk;
    }

    public void setVkukkrkgk(BizCurrency pVkukkrkgk) {
        vkukkrkgk = pVkukkrkgk;
    }

}
