package yuyu.common.hozen.khcommon;

/**
 * 契約保全 契約保全共通 有効状態チェックUiBean
 */
public class CheckYuukouJyoutaiExecUiBeanParamImpl implements CheckYuukouJyoutaiExecUiBeanParam {

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono (String syono) {
        this.syono = syono;
    }

}
