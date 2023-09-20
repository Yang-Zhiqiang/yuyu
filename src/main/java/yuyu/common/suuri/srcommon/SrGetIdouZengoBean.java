package yuyu.common.suuri.srcommon;

/**
 *  異動前後取得Beanクラス
 */
public class SrGetIdouZengoBean {

    private String idouZengoGetKekkaMae;

    private String idouZengoGetKekkaAto;

    SrGetIdouZengoBean() {
        super();

        idouZengoGetKekkaMae = "";
        idouZengoGetKekkaAto = "";
    }

    public String getIdouZengoGetKekkaMae() {
        return idouZengoGetKekkaMae;
    }

    public void setIdouZengoGetKekkaMae(String pIdouZengoGetKekkaMae) {
        this.idouZengoGetKekkaMae = pIdouZengoGetKekkaMae;
    }

    public String getIdouZengoGetKekkaAto() {
        return idouZengoGetKekkaAto;
    }

    public void setIdouZengoGetKekkaAto(String pIdouZengoGetKekkaAto) {
        this.idouZengoGetKekkaAto = pIdouZengoGetKekkaAto;
    }

}
