package yuyu.app.base.system.tokuteibikadoutimetouroku;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KadouTimeSiteiKbn;

public class SeleniumTokuteibiKadouTimeTourokuConstants {

    public static final BizDate NEWSYORIYMD                           = BizDate.getSysDate();
    public static final C_KadouTimeSiteiKbn NEWSITEIKBN               = C_KadouTimeSiteiKbn.ZENJITURIYOU_KA;

    public static final C_KadouTimeSiteiKbn MODIFIEDSITEIKBN          = C_KadouTimeSiteiKbn.ZENJITURIYOU_HUKA;

    public static final BizDate ALREADYSYORIYMD                       = BizDate.getSysDate();
    public static final C_KadouTimeSiteiKbn ALREADYSITEIKBN           = C_KadouTimeSiteiKbn.ZENJITURIYOU_KA;

    public static final String ALREADYKADOUTIMEGROUPCD                = "Selenium";
    public static final String ALREADYKADOUTIMEGROUPNM                = "セレニウム名";
    public static final String ALREADYKADOUTIMEGROUP_HOLIDAYGROUPCD   = "BankHolidays";
    public static final String ALREADYKADOUTIMEGROUPBIKOU             = "セレニウム備考";

    public static final String FUNCTIONNAME                           = "functionName";
    public static final String HENKOULINK                             = "tokuteibiKadouTimeSelectList[0].henkouLink";
    public static final String SAKUJYOLINK                            = "tokuteibiKadouTimeSelectList[0].sakujyoLink";

}
