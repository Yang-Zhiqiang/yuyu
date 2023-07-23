package yuyu.infrext.encrypt;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import yuyu.def.YuyuStandardCharsets;
import zh.services.encrypt.impl.ZHENAES128EncryptModule;

public abstract class RayAbstractEcryptor {

    private SecretKeySpec   keySpec;
    private IvParameterSpec paramSpec;
    private Cipher          encryptor;
    private Cipher          decryptor;

    private static final String ALGORITHM     = "AES/CBC/PKCS5Padding";

    private static final String INITIAL_VALUE = "EncryptServiceIV";

    private static final Charset ENCRYPT_CHARSET = YuyuStandardCharsets.SHIFT_JIS;

    public RayAbstractEcryptor(){
        try{

            ZHENAES128EncryptModule module = getKeyModule();

            keySpec   = new SecretKeySpec(module.getKey(), "AES");
            paramSpec = new IvParameterSpec(INITIAL_VALUE.getBytes(ENCRYPT_CHARSET));

            encryptor = Cipher.getInstance(ALGORITHM);
            decryptor = Cipher.getInstance(ALGORITHM);

            encryptor.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
            decryptor.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public byte[] encrypt(byte[] data){
        try {
            return encryptor.doFinal(data);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public byte[] decrypt(byte[] data){
        try {
            return decryptor.doFinal(data);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    protected abstract ZHENAES128EncryptModule getKeyModule();
}
