package yuyu.infr.inject;

import jp.co.slcs.swak.bizinfr.configuration.BizInfrConfig;
import jp.co.slcs.swak.core.inject.AbstractSWAKModule;
import jp.co.slcs.swak.objstorage.ObjStorageManager;
import jp.co.slcs.swak.sequence.PersistenceManager;
import jp.co.slcs.swak.webservice.config.WebServiceConfig;
import slit.security.PplsEncrypt;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.base.manager.impl.BaseDomManagerImpl;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.manager.impl.BizDomManagerImpl;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.direct.manager.impl.DirectDomManagerImpl;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.manager.impl.HozenDomManagerImpl;
import yuyu.def.nenkin.manager.NenkinDomManager;
import yuyu.def.nenkin.manager.impl.NenkinDomManagerImpl;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.manager.impl.SiharaiDomManagerImpl;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.manager.impl.SinkeiyakuDomManagerImpl;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.manager.impl.SuuriDomManagerImpl;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.manager.impl.WorkflowDomManagerImpl;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.def.zdb.manager.impl.ZdbDomManagerImpl;
import yuyu.infr.objstorage.YuyuObjStorageManager;
import yuyu.infr.processor.OnlineKadouCheck;
import yuyu.infr.report.EncryptKeyGenerator;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;
import yuyu.infr.report.swakreport.config.ReportConfig;
import yuyu.infr.report.swakreport.reader.SyoruiZokuseiMstReader;
import yuyu.infr.sequence.YuyuPersistenceManager;
import yuyu.infrext.encrypt.EncryptKeyGeneratorImpl;
import yuyu.infrext.processor.OperatingStatusCheck;
import zh.services.encrypt.impl.ZHENAES128EncryptModule;


/**
 * Web・バッチ共通部品をバインドするための Module です。<br />
 * Web用Module・バッチ用Module の中で、この Module を install() してください。
 */
public class YuyuCommonModule extends AbstractSWAKModule {

    @Override
    protected void configure() {
        bindInstance(BizInfrConfig .instance);
        bindInstance(YuyuBaseConfig.getInstance());
        bindInstance(ReportConfig  .getInstance());
        bindInstance(WebServiceConfig.getInstance());

        bind(PersistenceManager.class).to(YuyuPersistenceManager.class);
        bind(ObjStorageManager .class).to(YuyuObjStorageManager .class);
        bind(SyoruiZokuseiReader .class).to(SyoruiZokuseiMstReader .class);
        bind(ZHENAES128EncryptModule.class).to(PplsEncrypt .class);
        bind(EncryptKeyGenerator.class).to(EncryptKeyGeneratorImpl.class);

        bind(BaseDomManager    .class).to(BaseDomManagerImpl    .class);
        bind(BizDomManager    .class).to(BizDomManagerImpl        .class);
        bind(HozenDomManager    .class).to(HozenDomManagerImpl        .class);
        bind(SiharaiDomManager    .class).to(SiharaiDomManagerImpl        .class);
        bind(SinkeiyakuDomManager    .class).to(SinkeiyakuDomManagerImpl        .class);
        bind(NenkinDomManager    .class).to(NenkinDomManagerImpl        .class);
        bind(WorkflowDomManager    .class).to(WorkflowDomManagerImpl        .class);
        bind(ZdbDomManager    .class).to(ZdbDomManagerImpl        .class);
        bind(DirectDomManager    .class).to(DirectDomManagerImpl        .class);
        bind(SuuriDomManager    .class).to(SuuriDomManagerImpl        .class);
        bind(OnlineKadouCheck       .class).to(OperatingStatusCheck          .class);

    }
}
