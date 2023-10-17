package yuyu.app.base.log.batchjyoukyousyoukai;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BatchJyoutaiKbn;
import yuyu.def.classification.C_BatchKidouKbn;
import yuyu.def.classification.C_LogLevelKbn;

public class SeleniumBatchJyoukyouSyoukaiConstants {

    public static final String ALREADYBATCHJOBID                 = "Selenium";
    public static final String ALREADYBATCHID                    = "addressmasterhanei";
    public static final C_BatchKidouKbn ALREADYBATCHKIDOUKBN     = C_BatchKidouKbn.GAMEN;
    public static final C_BatchJyoutaiKbn ALREADYBATCHJYOUTAIKBN = C_BatchJyoutaiKbn.SYORI;
    public static final BizDate ALREADYBATCHSYORIYMD             = BizDate.getSysDate();

    public static final int ALREADYBATCHLOGEDANO                 = 1;
    public static final C_LogLevelKbn ALREADYBATCHLOGLEVELKBN    = C_LogLevelKbn.INFO;
    public static final String ALREADYBATCHLOGNAIYOU             = "セレニウムテストバッチログ内容";

    public static final String ALREADYTYOUHYOUKEY                = "SeleniumTestTyouhyou";

    public static final String FUNCTIONNAME                      = "functionName";
    public static final String TYOUHYOULINK                      = "batchJobList[0].tyouhyouSyuturyokuLink";
    public static final String GAIYOUPAGELINK_NO                 = "batchJobListDataSource[6]";
    public static final String GAIYOUPAGELINK_R                  = "batchJobListDataSource[12]";
    public static final String GAIYOUPAGELINK_L                  = "batchJobListDataSource[6]";
    public static final String GAIYOUPAGELINK_RR                 = "batchJobListDataSource[24]";
    public static final String GAIYOUPAGELINK_LL                 = "batchJobListDataSource[1]";
    public static final String SYOUSAILINK                       = "batchJobList[0].syousaiLink";
    public static final String LOGPAGELINK_NO                    = "batchLogListDataSource[6]";
    public static final String LOGPAGELINK_R                     = "batchLogListDataSource[12]";
    public static final String LOGPAGELINK_L                     = "batchLogListDataSource[6]";
    public static final String LOGPAGELINK_RR                    = "batchLogListDataSource[35]";
    public static final String LOGPAGELINK_LL                    = "batchLogListDataSource[1]";
}
