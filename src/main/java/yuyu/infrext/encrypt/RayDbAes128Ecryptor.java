package yuyu.infrext.encrypt;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import zh.services.encrypt.impl.ZHENAES128EncryptModule;

/**
 * このクラスは南港提供のクラス「slit.security.Fuho2DbEncrypt」に依存しています。
 * 当該クラスが正しく配置されていない状態で呼び出すと、ClassNotFoundExceptionが発生します。
 */
public class RayDbAes128Ecryptor extends RayAbstractEcryptor {

    private static Logger logger = LoggerFactory.getLogger(RayAes128Ecryptor.class);

    @Override
    protected ZHENAES128EncryptModule getKeyModule() {

        try {
            return (ZHENAES128EncryptModule)Class.forName("slit.security.Fuho2DbEncrypt").newInstance();
        } catch (Exception e) {
            logger.error("南港提供の暗号化キー提供クラス「slit.security.Fuho2DbEncrypt」のロードに失敗しました");
            throw new RuntimeException(e);
        }
    }
}
