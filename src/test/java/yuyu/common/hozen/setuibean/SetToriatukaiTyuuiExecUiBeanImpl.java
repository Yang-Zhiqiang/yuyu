package yuyu.common.hozen.setuibean;

/**
 * 契約保全 UiBean設定 取扱注意設定UiBeanパラメータ
 */
public class SetToriatukaiTyuuiExecUiBeanImpl implements SetToriatukaiTyuuiExecUiBeanParam{


    private String syono = null;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }
}
