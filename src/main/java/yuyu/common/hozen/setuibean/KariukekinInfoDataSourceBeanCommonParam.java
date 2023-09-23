package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 契約保全 UiBean設定 仮受金情報データソースBeanパラメータインターフェース
 */
public interface KariukekinInfoDataSourceBeanCommonParam {

    public Integer getVkukkrkno();

    public void setVkukkrkno(Integer pVkukkrkno);

    public BizDate getVkukkrkkeijyoymd();

    public void setVkukkrkkeijyoymd(BizDate pVkukkrkkeijyoymd);

    public C_KrkriyuuKbn getVkukkrkriyuukbn();

    public void setVkukkrkriyuukbn(C_KrkriyuuKbn pVkukkrkriyuukbn);

    public C_Hrkkaisuu getVkukhrkkaisuu();

    public void setVkukhrkkaisuu(C_Hrkkaisuu pVkukhrkkaisuu);

    public C_Nykkeiro getVkuknykkeiro();

    public void setVkuknykkeiro(C_Nykkeiro pVkuknykkeiro);

    public C_NyknaiyouKbn getVkuknyknaiyoukbn();

    public void setVkuknyknaiyoukbn(C_NyknaiyouKbn pVkuknyknaiyoukbn);

    public BizDateYM getVkukjyuutouym();

    public void setVkukjyuutouym(BizDateYM pVkukjyuutouym);

    public String getVkukjyutoukaisuu();

    public void setVkukjyutoukaisuu(String pVkukjyutoukaisuu);

    public BizDate getVkukryosyuymd();

    public void setVkukryosyuymd(BizDate pVkukryosyuymd);

    public BizCurrency getVkukkrkgk();

    public void setVkukkrkgk(BizCurrency pVkukkrkgk);
}
