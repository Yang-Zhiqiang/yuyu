package yuyu.common.biz.bzcommon;

import static yuyu.def.YuyuStandardCharsets.*;

import java.math.BigDecimal;
import java.nio.charset.Charset;

/**
 * 文字コードを保持するためのクラスです。<br />
 * 比較するときには、内部保持している全バイトをチェックし、全て一致している場合のみ一致とみなします。
 */
public class CharByteHolder {

    private byte[] charByte;

    public CharByteHolder(char c){
        String s = String.valueOf(c);
        charByte = s.getBytes(WINDOWS_31J);
    }

    public CharByteHolder(byte[] pByte,Charset pCharset){
        this(new String(pByte,pCharset).charAt(0));
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof CharByteHolder){
            CharByteHolder pCharByteHolder = (CharByteHolder)o;
            if(charByte.length == pCharByteHolder.charByte.length){
                for(int i=0; i< charByte.length ;i++){
                    if(charByte[i] != pCharByteHolder.charByte[i]){
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode(){
        int i = 0;
        for(int idx=0; idx<charByte.length; idx++){
            int ml = new BigDecimal(1000).pow(idx).intValue();
            i += (charByte[idx] + 128) * ml;
        }
        return i;
    }

}
