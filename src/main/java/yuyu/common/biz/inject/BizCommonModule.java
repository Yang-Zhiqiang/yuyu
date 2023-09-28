package yuyu.common.biz.inject;

import iwf.callback.arriveimage.ImportImageTerminator;
import iwf.callback.arriveimage.ToutyakuYoteiNotFound;
import jp.co.slcs.swak.core.inject.AbstractSWAKModule;
import yuyu.common.biz.prereport.CommonPreReport;
import yuyu.common.biz.syoruitoutyaku.ExecGetSyoruitoutyakuInfo;
import yuyu.common.biz.syoruitoutyaku.ExecSyoruitoutyakuOperateProcess;
import yuyu.common.biz.validation.RayHostInvalidCharacterCallback;
import yuyu.common.biz.validation.RayInvalidCharacterCallback;
import yuyu.common.biz.validation.RayMousikomiNoCallback;
import yuyu.common.biz.validation.RayNenkinSyousyoNoCallback;
import yuyu.common.biz.validation.RaySyoukenNoCallback;
import yuyu.common.biz.workflow.IwfCommonClient;
import yuyu.common.biz.workflow.impl.IwfCommonClientImpl;
import yuyu.infr.report.PreCreateReport;
import yuyu.infr.validation.constraintvalidators.callback.HostInvalidCharacterCallback;
import yuyu.infr.validation.constraintvalidators.callback.InvalidCharacterCallback;
import yuyu.infr.validation.constraintvalidators.callback.MousikomiNoCallback;
import yuyu.infr.validation.constraintvalidators.callback.NenkinSyousyoNoCallback;
import yuyu.infr.validation.constraintvalidators.callback.SyoukenNoCallback;

/**
 * Web・バッチ共通部品をバインドするための Module です。<br />
 * Web用Module・バッチ用Module の中で、この Module を install() してください。
 */
public class BizCommonModule extends AbstractSWAKModule {

    @Override
    protected void configure() {

        bind(IwfCommonClient .class).to(IwfCommonClientImpl .class);
        bind(PreCreateReport .class).to(CommonPreReport     .class);
        bind(ImportImageTerminator .class).to(ExecSyoruitoutyakuOperateProcess     .class);
        bind(ToutyakuYoteiNotFound .class).to(ExecGetSyoruitoutyakuInfo.class);

        bind(InvalidCharacterCallback.class).to(RayInvalidCharacterCallback.class);
        bind(HostInvalidCharacterCallback.class).to(RayHostInvalidCharacterCallback.class);

        bind(SyoukenNoCallback.class).to(RaySyoukenNoCallback.class);
        bind(MousikomiNoCallback.class).to(RayMousikomiNoCallback.class);
        bind(NenkinSyousyoNoCallback.class).to(RayNenkinSyousyoNoCallback.class);
    }
}
