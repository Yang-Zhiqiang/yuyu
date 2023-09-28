package yuyu.common.biz.koutei;

import java.io.Serializable;

/**
 * 業務共通 工程 処理中親工程情報取得出力Bean
 */
public class GetSyoriOyakouteiInfoOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriOyaKouteikanriId;

    private String syoriOyaKouteiJimutetuzukiCd;

    public String getSyoriOyaKouteikanriId(){
        return syoriOyaKouteikanriId;
    }

    public void setSyoriOyaKouteikanriId(String pSyoriOyaKouteikanriId){
        syoriOyaKouteikanriId = pSyoriOyaKouteikanriId;
    }

    public String getSyoriOyaKouteiJimutetuzukiCd(){
        return syoriOyaKouteiJimutetuzukiCd;
    }

    public void setSyoriOyaKouteiJimutetuzukiCd(String pSyoriOyaKouteiJimutetuzukiCd){
        syoriOyaKouteiJimutetuzukiCd = pSyoriOyaKouteiJimutetuzukiCd;
    }
}
