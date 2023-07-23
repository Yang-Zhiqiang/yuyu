package yuyu.infrext.encrypt;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;

import yuyu.infr.report.EncryptKeyGenerator;
import zh.services.encrypt.impl.ZHENAES128EncryptModule;

/**
 * 暗号キーの生成をするクラスです。<br/>
 */
public class EncryptKeyGeneratorImpl extends RayAbstractEcryptor implements EncryptKeyGenerator {

    private static Logger logger = LoggerFactory.getLogger(EncryptKeyGeneratorImpl.class);

    ZHENAES128EncryptModule module;

    @Override
    public String gerenateKey() {
        try{
            logger.debug("▽ 暗号キー生成 開始");

            module = getKeyModule();

            String encrypt = Base64.encodeBase64String(module.getKey());

            logger.debug("△ 暗号キー生成 終了");

            return encrypt;

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

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