package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_UketoriKouza;

/**
 * 契約保全 UiBean設定 定期支払金支払先口座情報設定
 */
public class SetKhTkshrSiharaiKouza {

    private static final String BLANK = "";

    public boolean exec(KhozenCommonParam pKhCParm, SetKhTkshrSiharaiKouzaExecUiBeanParam pUiBean) {

        IT_KykSonotaTkyk kykSonotaTkyk = pKhCParm.getSonotaTokuyaku(pUiBean.getSyono());

        IT_UketoriKouza uketoriKouza = pKhCParm.getTeikiShrUketoriKouza(pUiBean.getSyono());

        init(pUiBean);

        pUiBean.setTeikishrtkykhukaumu(kykSonotaTkyk.getTeikishrtkykhukaumu());

        if (uketoriKouza != null) {
            GetBankSitenNm getBankSitenNm = SWAKInjector.getInstance(GetBankSitenNm.class);
            getBankSitenNm.exec(uketoriKouza.getBankcd(), uketoriKouza.getSitencd());

            pUiBean.setVktikskzkzsyuruikbn(uketoriKouza.getKzsyuruikbn());
            pUiBean.setVktikskzbankcd(uketoriKouza.getBankcd());
            pUiBean.setVktikskzbanknmkj(getBankSitenNm.getBankNmKj());
            pUiBean.setVktikskzsitencd(uketoriKouza.getSitencd());
            pUiBean.setVktikskzsitennmkj(getBankSitenNm.getSitenNmKj());
            pUiBean.setVktikskzyokinkbn(uketoriKouza.getYokinkbn());
            pUiBean.setVktikskzkouzano(uketoriKouza.getKouzano());
            pUiBean.setVktikskzkzmeiginmkn(uketoriKouza.getKzmeiginmkn());
        }

        return true;
    }

    public static void init(SetKhTkshrSiharaiKouzaExecUiBeanParam pUiBean) {
        pUiBean.setVktikskzkzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        pUiBean.setVktikskzbankcd(BLANK);
        pUiBean.setVktikskzbanknmkj(BLANK);
        pUiBean.setVktikskzsitencd(BLANK);
        pUiBean.setVktikskzsitennmkj(BLANK);
        pUiBean.setVktikskzyokinkbn(C_YokinKbn.BLNK);
        pUiBean.setVktikskzkouzano(BLANK);
        pUiBean.setVktikskzkzmeiginmkn(BLANK);
        pUiBean.setTeikishrtkykhukaumu(C_UmuKbn.NONE);
    }
}
