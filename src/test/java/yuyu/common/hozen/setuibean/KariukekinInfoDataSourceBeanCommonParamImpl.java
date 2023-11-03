package yuyu.common.hozen.setuibean;

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
 * 契約保全 UiBean設定 仮受金情報 のデータソースのデータ
 */
public class KariukekinInfoDataSourceBeanCommonParamImpl implements KariukekinInfoDataSourceBeanCommonParam {

    private Integer vkukkrkno;

    @Override
    public Integer getVkukkrkno() {
        return vkukkrkno;
    }

    @Override
    public void setVkukkrkno(Integer pVkukkrkno) {
        vkukkrkno = pVkukkrkno;
    }

    private BizDate vkukkrkkeijyoymd;

    @Override
    public BizDate getVkukkrkkeijyoymd() {
        return vkukkrkkeijyoymd;
    }

    @Override
    public void setVkukkrkkeijyoymd(BizDate pVkukkrkkeijyoymd) {
        vkukkrkkeijyoymd = pVkukkrkkeijyoymd;
    }

    private C_KrkriyuuKbn vkukkrkriyuukbn;

    @Override
    public C_KrkriyuuKbn getVkukkrkriyuukbn() {
        return vkukkrkriyuukbn;
    }

    @Override
    public void setVkukkrkriyuukbn(C_KrkriyuuKbn pVkukkrkriyuukbn) {
        vkukkrkriyuukbn = pVkukkrkriyuukbn;
    }


    private C_Hrkkaisuu vkukhrkkaisuu;

    @Override
    public C_Hrkkaisuu getVkukhrkkaisuu() {
        return vkukhrkkaisuu;
    }

    @Override
    public void setVkukhrkkaisuu(C_Hrkkaisuu pVkukhrkkaisuu) {
        vkukhrkkaisuu = pVkukhrkkaisuu;
    }


    private C_Nykkeiro vkuknykkeiro;

    @Override
    public C_Nykkeiro getVkuknykkeiro() {
        return vkuknykkeiro;
    }

    @Override
    public void setVkuknykkeiro(C_Nykkeiro pVkuknykkeiro) {
        vkuknykkeiro = pVkuknykkeiro;
    }

    private C_NyknaiyouKbn vkuknyknaiyoukbn;

    @Override
    public C_NyknaiyouKbn getVkuknyknaiyoukbn() {
        return vkuknyknaiyoukbn;
    }

    @Override
    public void setVkuknyknaiyoukbn(C_NyknaiyouKbn pVkuknyknaiyoukbn) {
        vkuknyknaiyoukbn = pVkuknyknaiyoukbn;
    }

    private BizDateYM vkukjyuutouym;

    @Override
    public BizDateYM getVkukjyuutouym() {
        return vkukjyuutouym;
    }

    @Override
    @Trim("both")
    public void setVkukjyuutouym(BizDateYM pVkukjyuutouym) {
        vkukjyuutouym = pVkukjyuutouym;
    }

    private String vkukjyutoukaisuu;

    @Override
    public String getVkukjyutoukaisuu() {
        return vkukjyutoukaisuu;
    }

    @Override
    @DataConvert("toMultiByte")
    public void setVkukjyutoukaisuu(String pVkukjyutoukaisuu) {
        vkukjyutoukaisuu = pVkukjyutoukaisuu;
    }

    private BizDate vkukryosyuymd;

    @Override
    public BizDate getVkukryosyuymd() {
        return vkukryosyuymd;
    }

    @Override
    public void setVkukryosyuymd(BizDate pVkukryosyuymd) {
        vkukryosyuymd = pVkukryosyuymd;
    }

    private BizCurrency vkukkrkgk;

    @Override
    public BizCurrency getVkukkrkgk() {
        return vkukkrkgk;
    }

    @Override
    public void setVkukkrkgk(BizCurrency pVkukkrkgk) {
        vkukkrkgk = pVkukkrkgk;
    }
}
