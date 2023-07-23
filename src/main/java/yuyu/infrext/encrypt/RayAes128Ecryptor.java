package yuyu.infrext.encrypt;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import zh.services.encrypt.impl.ZHENAES128EncryptModule;

public class RayAes128Ecryptor extends RayAbstractEcryptor {

    @Override
    protected ZHENAES128EncryptModule getKeyModule() {
        return SWAKInjector.getInstance(ZHENAES128EncryptModule.class);
    }
}
