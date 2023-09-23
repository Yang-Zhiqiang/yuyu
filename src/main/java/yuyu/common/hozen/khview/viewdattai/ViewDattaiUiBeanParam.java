package yuyu.common.hozen.khview.viewdattai;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全画面部品 脱退情報表示 <br />
 */
public interface ViewDattaiUiBeanParam extends CommonViewUiBeanParam {

    public BizDate getVdtdattaisyoriymd();

    public C_DattairiyuuKbn getVdtdattairiyuukbn();

    public String getVdtcomment();

    public C_UmuKbn getVdtumukbn();

}
