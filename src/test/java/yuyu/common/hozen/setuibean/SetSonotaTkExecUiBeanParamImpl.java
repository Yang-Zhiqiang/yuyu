package yuyu.common.hozen.setuibean;
/**
 * 契約保全 UiBean設定 その他特約特則設定UiBean
 */
public class SetSonotaTkExecUiBeanParamImpl implements SetSonotaTkExecUiBeanParam{

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private String vsntkdisptkhukainfo;

    public String getVsntkdisptkhukainfo() {
        return vsntkdisptkhukainfo;
    }

    @Override
    public void setVsntkdisptkhukainfo(String pVsntkdisptkhukainfo) {
        this.vsntkdisptkhukainfo = pVsntkdisptkhukainfo;
    }

}
