package yuyu.common.biz.koutei;

import java.io.Serializable;

import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 工程 処理中子工程情報取得出力Bean
 */
public class GetSyoriKokouteiInfoOutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoriKokouteikanriId;

    private String syoriKokouteiJimutetuzukiCd;

    private C_UmuKbn douJimutetuzukicdUmuKbn;

    public GetSyoriKokouteiInfoOutBean() {
        super();
    }

    public String getSyoriKokouteikanriId(){
        return syoriKokouteikanriId;
    }

    public void setSyoriKokouteikanriId(String pSyoriKokouteikanriId){
        syoriKokouteikanriId = pSyoriKokouteikanriId;
    }

    public String getSyoriKokouteiJimutetuzukiCd(){
        return syoriKokouteiJimutetuzukiCd;
    }

    public void setSyoriKokouteiJimutetuzukiCd(String pSyoriKokouteiJimutetuzukiCd){
        syoriKokouteiJimutetuzukiCd = pSyoriKokouteiJimutetuzukiCd;
    }

    public C_UmuKbn getDouJimutetuzukicdUmuKbn(){
        return douJimutetuzukicdUmuKbn;
    }

    public void setDouJimutetuzukicdUmuKbn(C_UmuKbn pDouJimutetuzukicdUmuKbn){
        douJimutetuzukicdUmuKbn = pDouJimutetuzukicdUmuKbn;
    }
}
