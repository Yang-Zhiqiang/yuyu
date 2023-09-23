package yuyu.common.hozen.khcommon;

/**
 * 契約保全 契約保全共通 有効状態チェックパラメータ
 */
public class CheckYuukouJyoutaiParam implements CheckYuukouJyoutaiExecUiBeanParam{

    private String syono;

    public CheckYuukouJyoutaiParam() {
        super();
    }

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}
