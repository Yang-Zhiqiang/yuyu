package yuyu.common.siharai.edittbl;

/**
 * 結果入力Paramインターフェース実現クラス
 */

public class SiKekkaInputParamImpl implements SiKekkaInputParam {

    private String syanaicomment;

    @Override
    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Override
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }
}