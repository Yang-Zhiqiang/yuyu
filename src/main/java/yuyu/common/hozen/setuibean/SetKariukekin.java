package yuyu.common.hozen.setuibean;

import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.hozen.manager.HozenDomManager;


/**
 * 契約保全 UiBean設定 仮受金情報設定
 */
public class SetKariukekin {

    @Inject
    private HozenDomManager hozenDomManager;

    public boolean exec(KhozenCommonParam pKhCParm, SetKariukekinExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();


        List<IT_Kariukekin> kariukekinLst = hozenDomManager.getKariukekinsBySyono(syoNo);

        List<KariukekinInfoDataSourceBeanCommonParam> kariukekinInfoLst = Lists.newArrayList();

        if (kariukekinLst.size() == 0) {
            pUiBean.convertKariukekinInfoForCommonParam(kariukekinInfoLst);
        }
        else {
            String year = MessageUtil.getMessage(MessageId.IIW1010);
            String month = MessageUtil.getMessage(MessageId.IIW1011);
            for (IT_Kariukekin kariukekin : kariukekinLst) {
                KariukekinInfoDataSourceBeanCommonParam kariukekinInfoDataSourceBean = pUiBean
                    .createKariukekinInfoDataSourceBean();
                kariukekinInfoDataSourceBean.setVkukkrkno(kariukekin.getKrkno());
                kariukekinInfoDataSourceBean.setVkukkrkkeijyoymd(kariukekin.getKrkkeijyoymd());
                kariukekinInfoDataSourceBean.setVkukkrkriyuukbn(kariukekin.getKrkriyuukbn());
                kariukekinInfoDataSourceBean.setVkukhrkkaisuu(kariukekin.getHrkkaisuu());
                kariukekinInfoDataSourceBean.setVkuknykkeiro(kariukekin.getNykkeiro());
                kariukekinInfoDataSourceBean.setVkuknyknaiyoukbn(kariukekin.getNyknaiyoukbn());
                kariukekinInfoDataSourceBean.setVkukjyuutouym(kariukekin.getJyuutouym());
                String vkukjyutoukaisuu = "";
                if (kariukekin.getJyutoukaisuuy() != 0) {
                    vkukjyutoukaisuu = ConvertUtil.toZenNumeric(kariukekin.getJyutoukaisuuy().toString()) + year + "　";
                }
                else if (kariukekin.getJyutoukaisuum() != 0) {
                    vkukjyutoukaisuu = ConvertUtil.toZenNumeric(kariukekin.getJyutoukaisuum().toString()) + month;

                }
                kariukekinInfoDataSourceBean.setVkukjyutoukaisuu(vkukjyutoukaisuu);
                kariukekinInfoDataSourceBean.setVkukryosyuymd(kariukekin.getRyosyuymd());
                kariukekinInfoDataSourceBean.setVkukkrkgk(kariukekin.getKrkgk());

                kariukekinInfoLst.add(kariukekinInfoDataSourceBean);
            }

            pUiBean.convertKariukekinInfoForCommonParam(kariukekinInfoLst);
        }

        return true;
    }

    public void init (SetKariukekinExecUiBeanParam pUiBean) {
        List<KariukekinInfoDataSourceBeanCommonParam> kariukekinInfoLst = Lists.newArrayList();
        pUiBean.convertKariukekinInfoForCommonParam(kariukekinInfoLst);
    }
}
