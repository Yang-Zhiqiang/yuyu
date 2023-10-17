package yuyu.app.base.system.kinouteigitouroku;

import yuyu.def.classification.C_BatchKyouseiSyuuryouFlag;
import yuyu.def.classification.C_BatchLogHyoujiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukouKbn;

public class SeleniumKinouTeigiTourokuConstants {

    public static final String ALREADYROLECD                                       = "Selenium";
    public static final String ALREADYROLENM                                       = "セレニウム名";
    public static final String ALREADYROLESETUMEI                                  = "セレニウム説明";
    public static final C_SysSiyouKbn ALREADYROLESYSSIYOUKBN                       = C_SysSiyouKbn.TUUJYOU;

    public static final String FUNCTIONNAME                                        = "functionName";
    public static final String HENKOULINK                                          = "kinouModeInfoList[0].henkouLink";

    public static final String ALREADYKINOUID                                      = "testkinou";
    public static final String ALREADYSUBSYSTEMID                                  = "base";
    public static final String ALREADYCATEGORYID                                   = "system";
    public static final String ALREADYKINOUNM                                      = "テスト機能";
    public static final String ALREADYSORTNO                                       = "1";
    public static final C_KinouKbn ALREADYKINOUKBN                                 = C_KinouKbn.ONLINE;
    public static final C_BatchKyouseiSyuuryouFlag ALREADYBATCHKYOUSEISYUURYOUFLAG = C_BatchKyouseiSyuuryouFlag.NONE;
    public static final C_KahiKbn ALREADYMENUHYOUJIKBN                             = C_KahiKbn.KA;
    public static final C_BatchLogHyoujiKbn ALREADYBATCHLOGHYOUJIKBN               = C_BatchLogHyoujiKbn.TAISYOUGAI;
    public static final C_YouhiKbn ALREADYKINOUGENKENHANTEIYOUHIKBN                = C_YouhiKbn.YOU;
    public static final C_TaisyouKbn ALREADYKINOUTEIGITAISYOUKBN                   = C_TaisyouKbn.TAISYOU;

    public static final String ALREADYKINOUMODEID                                  = "default";
    public static final String ALREADYKINOUMODENM                                  = "デフォルトモード";
    public static final String ALREADYKINOUMODESORTNO                              = "1";
    public static final C_YuukouKbn ALREADYYUUKOUKBN                               = C_YuukouKbn.ENABLE;
    public static final String ALREADYKADOUTIMEGROUPCD                             = "Default";
    public static final C_KahiKbn ALREADYBATCHHEISOUKAHIKBN                        = C_KahiKbn.KA;

    public static final String ALREADYKINOUMODESIBORIKOMIID1                       = "testid1";
    public static final String ALREADYKINOUMODESIBORIKOMINM1                       = "テスト絞込み１";
    public static final String ALREADYKINOUMODESIBORIKOMIID2                       = "testid2";
    public static final String ALREADYKINOUMODESIBORIKOMINM2                       = "テスト絞込み２";

    public static final String ALREADYKINOUKENGENROLECD                            = "Administrators";

}